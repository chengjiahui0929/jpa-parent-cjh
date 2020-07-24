package com.cjh.jpa.controller;

import com.cjh.jpa.entity.*;
import com.cjh.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("list")
    public MyPageImpl<User> list(UserVo userVo){
        System.out.print(" 消费者参数是  " + userVo);
        MyPageImpl<User> page = userService.list(userVo);

        System.out.println ("  消费者 ========== 已经获取数据了。。。。。。。。。。。。");
        page.getContent().iterator().forEachRemaining(x->{System.out.println("消费者  x is " + x);});

        return page;
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam("id")int id){
        return userService.delete(id);
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        return userService.add(user);
    }

    @RequestMapping("departs")
    public List<Depart> departs(){
        return userService.departs();
    }

    @RequestMapping("favourites")
    public List<Favourite> getFavourites(){
        List<Favourite> favourites = userService.listFavourites();

        return favourites;
    }
}
