package com.cjh.jpa.entity;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Data
//从后台往前台传
public class MyPageImpl<T> {

    //总条数
    private  long lotalElements=0;
    //返回的数据
    private  List<T> content=null;
    //总页数
    private  int totalPages=0;
    //当前页
    private  int number=0;
    //每页有几条数
    private  int size=3;

    public MyPageImpl(Page<T> pil) {
        lotalElements = pil.getTotalElements();
        content =pil.getContent();
        totalPages =pil.getTotalPages();
        number =pil.getNumber()+1;
        size = pil.getSize();
    }

    public MyPageImpl() {

    }



}
