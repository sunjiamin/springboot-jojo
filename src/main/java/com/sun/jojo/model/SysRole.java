package com.sun.jojo.model;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 11:09
 */
public class SysRole {
    private Long id;
    private String name;

    public SysRole() {
    }

    public SysRole(Long id, String name) {
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


}
