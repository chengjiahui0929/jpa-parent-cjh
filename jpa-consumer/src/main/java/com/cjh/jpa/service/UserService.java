package com.cjh.jpa.service;

import com.cjh.jpa.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
//,fallback = UserServiceFailBack.class
@FeignClient(value = "jpa-service")
public interface UserService {

    @RequestMapping("/user/list")
    MyPageImpl<User> list(@RequestBody UserVo userVo);

    @RequestMapping("/user/delete")
    boolean delete(@RequestParam("id") int id);

    @RequestMapping("/user/add")
    boolean add(@RequestBody User user);

    @RequestMapping("/user/departs")
    List<Depart> departs();

    @RequestMapping("/user/favourites")
    List<Favourite> listFavourites();
}
