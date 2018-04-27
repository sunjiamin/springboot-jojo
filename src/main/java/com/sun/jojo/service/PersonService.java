package com.sun.jojo.service;

import com.sun.jojo.model.Person;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * description:
 *
 * @author sunjiamin
 * @date 2018-04-25 17:30
 */
@Service
@CacheConfig(cacheNames = "users")
public class PersonService {
    @Cacheable
    public List<Person> list()
    {
        return Arrays.asList(new Person("jojo",18),new Person("sun",26));
    }
}
