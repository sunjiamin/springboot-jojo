package com.sun.jojo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 11:09
 */
@Entity
@Table(name = "roles")
public class RoleEntity implements Serializable {
    @Id
    @Column(name = "r_id")
    private Long id;

    @Column(name = "r_name")
    private String name;

    @Column(name = "r_flag")
    private String flag;

    public RoleEntity() {
    }

    public RoleEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
