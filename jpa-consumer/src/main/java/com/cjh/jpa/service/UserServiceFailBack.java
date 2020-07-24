package com.cjh.jpa.service;

import com.cjh.jpa.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
@Component
public class UserServiceFailBack implements UserService {

    @Override
    public MyPageImpl<User> list(UserVo userVo) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<Depart> departs() {
        return null;
    }

    @Override
    public List<Favourite> listFavourites() {
        return null;
    }
}
