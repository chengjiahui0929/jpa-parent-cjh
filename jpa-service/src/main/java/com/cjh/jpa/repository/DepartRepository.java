package com.cjh.jpa.repository;

import com.cjh.jpa.entity.Depart;
import com.cjh.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cjh
 * @date 2020/7/24
 */
public interface DepartRepository extends JpaRepository<Depart,Integer>, JpaSpecificationExecutor<Depart> {
}
