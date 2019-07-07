package org.sang.service;

import org.sang.bean.User;
import org.sang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author magentaLi
 */

@Service
//@CacheConfig(keyGenerator = "myKeyGenerator")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
//    @Cacheable(value = "users", unless = "#result == null")
    public ArrayList<User> getUsers(int index, int size, String name, String username, String phone) {
        int currentPage = (index - 1) * size;
        ArrayList<User> users = userMapper.getUserByNamePhoneUsername(currentPage, size, name, username, phone);
        return users;
    }


    @Override
    public int addUser(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPhone().trim()));
        return userMapper.addUser(user);
    }

    @Override
//    @CachePut(value = "user")
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
//    @CacheEvict(value = "user")
    public int deleteUser(Long userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int countUserByUserName(String userName) {
        return userMapper.countUserByUsername(userName);
    }

    @Override
//    @Cacheable(value = "user", unless = "#result == null")
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
//    @Cacheable(value = "user", unless = "#result == null")
    public User getUserById(Long id) {
        return userMapper.getHrById(id);
    }

//    @Override
//    public int countUserSize() {
//        return userMapper.getUserSize();
//    }


}
