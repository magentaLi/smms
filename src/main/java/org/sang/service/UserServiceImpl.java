package org.sang.service;

import org.sang.bean.User;
import org.sang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author magentaLi
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
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
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Long userId) {
        return userMapper.deleteUser(userId);
    }

    @Override
    public int countUserByUserName(String userName) {
        return userMapper.countUserByUsername(userName);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }


}
