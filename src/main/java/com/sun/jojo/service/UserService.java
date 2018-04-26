package com.sun.jojo.service;

import com.sun.jojo.model.SysRole;
import com.sun.jojo.model.SysUser;
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
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setPassword("123");
        sysUser.setUsername("jojo");
        sysUser.setRoles(Arrays.asList(new SysRole(1L,"admin")));
        return sysUser;
    }
}
