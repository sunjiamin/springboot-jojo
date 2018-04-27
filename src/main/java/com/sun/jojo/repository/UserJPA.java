package com.sun.jojo.repository;

import com.sun.jojo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-27 09:18
 */
public interface UserJPA extends JpaRepository<UserEntity,Long>
{
    /**
     * 使用SpringDataJPA方法定义查询
     * @param username
     * @return
     */
    public UserEntity findByUsername(String username);
}