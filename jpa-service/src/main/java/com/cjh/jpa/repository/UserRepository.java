package com.cjh.jpa.repository;

import com.cjh.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cjh
 * @date 2020/7/22
 */
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

}
