package com.cjh.jpa.service.impl;

import com.cjh.jpa.entity.*;
import com.cjh.jpa.repository.DepartRepository;
import com.cjh.jpa.repository.FavouriteRepository;
import com.cjh.jpa.repository.UserRepository;
import com.cjh.jpa.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DepartRepository departRepository;

    @Autowired
    FavouriteRepository favouriteRepository;

    @Override
    public MyPageImpl<User> list(UserVo userVo) {

        Specification specification = new Specification<UserVo>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {

                ArrayList<Predicate> list = new ArrayList<>();

                if(!StringUtils.isEmpty(userVo.getUsername())){
                    Predicate predicate = criteriaBuilder.like(root.get("username"), "%" + userVo.getUsername() + "%");
                    list.add(predicate);
                }

                if (!StringUtils.isEmpty(userVo.getName())){
                    Predicate predicate = criteriaBuilder.like(root.get("name"), "%" + userVo.getName() + "%");
                    list.add(predicate);
                }

                Predicate[] predicates = list.toArray(new Predicate[list.size()]);

                Predicate predicateAll = criteriaBuilder.and(predicates);

                return predicateAll;
            }
        };

        // 生成分页的对象
        Pageable pageable = PageRequest.of(userVo.getPage()-1,userVo.getPageSize(), Sort.Direction.DESC,"uid");
        //Page<User> page = userRepository.findAll(pageable);

        //使用动态sql查询的结果
        Page page = userRepository.findAll(specification, pageable);
        return new MyPageImpl(page);
    }

    @Override
    public boolean delete(int id) {

        try {
            userRepository.deleteById(id);
        }catch (Exception ex){
            ex.printStackTrace();

            return false;
        }


        return true;
    }

    @Override
    public boolean add(User user) {
        User user1 = userRepository.saveAndFlush(user);
        try {
            if (user1.getUid()>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();

            return false;
        }

    }

    @Override
    public List<Depart> listDeparts() {
        return departRepository.findAll();
    }

    @Override
    public List<Favourite> listFavourites() {
        return favouriteRepository.findAll();
    }
}
