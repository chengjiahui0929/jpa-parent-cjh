package com.cjh.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author cjh
 * @date 2020/7/22
 */
@Data
@Entity
@Table(name = "hg_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String telephone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String sex;
    private int state;
    private String code;

    //一对一
    @OneToOne(targetEntity = DriverCard.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id",referencedColumnName = "id",insertable = true,updatable = false,nullable = true)
    private DriverCard driverCard;

    //多对一
    @ManyToOne(targetEntity = Depart.class,cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinColumn(name = "depart_id",referencedColumnName = "id",insertable = true,updatable = true,nullable = true,
                foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT)
    )
    public Depart depart;

    //一对多
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "uid",insertable = true,updatable = true,nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Room> roomList;
    //多对多
    @ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    @JoinTable(name = "hg_user_favourite",
            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "uid",
                    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            inverseJoinColumns = {@JoinColumn(name = "favourite_id",referencedColumnName = "id",
                    foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))},
            uniqueConstraints = {@UniqueConstraint(name = "unit",columnNames = {"user_id","favourite_id"})}
        )
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Favourite> favouriteList;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                ", driverCard=" + driverCard +
                ", depart=" + depart +
                ", roomList=" + roomList +
                ", favouriteList=" + favouriteList +
                '}';
    }
}
