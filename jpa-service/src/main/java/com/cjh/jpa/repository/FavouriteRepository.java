package com.cjh.jpa.repository;

import com.cjh.jpa.entity.Depart;
import com.cjh.jpa.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author cjh
 * @date 2020/7/24
 */
public interface FavouriteRepository extends JpaRepository<Favourite,Integer>, JpaSpecificationExecutor<Favourite> {
}
