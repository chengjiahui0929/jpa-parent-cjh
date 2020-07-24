package com.cjh.jpa.service;

import com.cjh.jpa.entity.*;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
public interface UserService {
    MyPageImpl list(UserVo userVo);

    boolean delete(int id);

    boolean add(User user);

    List<Depart> listDeparts();

    List<Favourite> listFavourites();
}
