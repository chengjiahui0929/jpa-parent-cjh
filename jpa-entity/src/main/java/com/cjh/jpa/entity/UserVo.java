package com.cjh.jpa.entity;

import lombok.Data;

/**
 * @author cjh
 * @date 2020/7/22
 */
@Data
//从前台往后传
public class UserVo extends User {
    int page=1;
    int pageSize=3;

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }
}
