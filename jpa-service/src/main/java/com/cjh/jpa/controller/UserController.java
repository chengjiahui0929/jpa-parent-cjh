package com.cjh.jpa.controller;

import com.cjh.jpa.entity.*;
import com.cjh.jpa.repository.UserRepository;
import com.cjh.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
@Api(
        value = "没什么意义"
)
@RestController
@RequestMapping("user")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @RequestMapping("test")
    public String test(){
        return "this hello";
    }

    /*@RequestMapping("add")
    public String testAdd(){
        User user = new User();
        user.setUsername("小白");
        user.setPassword("123456");
        user.setName("xiaobai");
        user.setEmail("@qq.com");
        user.setTelephone("12345678912");
        user.setSex("男");
        user.setState(1);
        user.setCode("26");

        userRepository.save(user);
        return "ok";
    }*/

    @ApiOperation(value = "获取用户列表",notes = "获取用户列表，里面主要包含的信息",
            response = MyPageImpl.class,httpMethod = "GET"
    )
    @RequestMapping("list")
    @ApiResponse(code = 200,message = "返回的分页对象")
    public MyPageImpl<User> list(@ApiParam(name = "userVo",value = "查询的对象")
                                     @RequestBody UserVo userVo){
        System.out.print(" 服务提供者  参数是  " + userVo);

        MyPageImpl<User> userPage = userService.list(userVo);
        log.info(" 已经获取数据了。。。。。。。。。。。。");
        userPage.getContent().iterator().forEachRemaining(x->{System.out.println("x is " + x);});
        log.info("page.class is " + userPage.getClass());
        return userPage;
    }

    @RequestMapping("delete")
    public boolean delete(@RequestParam("id")int id){
        return userService.delete(id);
    }

    @RequestMapping("add")
    public boolean add(@RequestBody User user){
        System.out.println("添加user： "+user);
        return userService.add(user);
    }

    @RequestMapping("departs")
    public List<Depart> getDeparts(){
        List<Depart> departs = userService.listDeparts();

        return departs;
    }

    @RequestMapping("favourites")
    public List<Favourite> getFavourites(){
        List<Favourite> favourites = userService.listFavourites();

        return favourites;
    }
}
