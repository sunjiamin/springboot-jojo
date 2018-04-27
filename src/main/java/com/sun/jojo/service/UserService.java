package com.sun.jojo.service;

import com.sun.jojo.model.RoleEntity;
import com.sun.jojo.model.UserEntity;
import com.sun.jojo.repository.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-26 11:13
 */
@CacheConfig(cacheNames = "user")
public class UserService implements UserDetailsService {

    @Autowired
    UserJPA userJPA;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userJPA.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("未查询到用户："+username+"信息！");
        }
        return user;
    }
}
