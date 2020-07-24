package com.cjh.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author cjh
 * @date 2020/7/24
 */
@Data
@Entity
@Table(name = "hg_favourite")
public class Favourite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "Favourite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
