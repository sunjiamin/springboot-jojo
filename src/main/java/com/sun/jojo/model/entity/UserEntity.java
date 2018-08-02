package com.sun.jojo.model.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 11:07
 */
@Entity
@Table(name = "users")
//public class UserEntity implements Serializable,UserDetails{
    public class UserEntity implements Serializable{



    @Id
    @Column(name = "u_id")
    private Long id;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "ur_user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ur_role_id")
            }
    )
    private List<RoleEntity> roles;


    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> auths = new ArrayList<>();
//        List<RoleEntity> roles = this.getRoles();
//        for (RoleEntity role : roles) {
//            auths.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return auths;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.password;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }

    //@Override
    public boolean isEnabled() {
        return true;
    }
}
