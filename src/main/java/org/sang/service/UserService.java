package org.sang.service;

import org.sang.bean.User;

import java.util.ArrayList;

/**
 * @author magentaLi
 */
public interface UserService {

    ArrayList<User> getUsers(int index, int size, String name, String username, String phone);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Long userId);

    int countUserByUserName(String userName);

    User getUserByName(String name);

    User getUserById(Long id);

//    int countUserSize();

}
