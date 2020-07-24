package com.cjh.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author cjh
 * @date 2020/7/24
 */
@Data
@Entity
@Table(name = "hg_depart")
public class Depart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    @Override
    public String toString() {
        return "Depart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
