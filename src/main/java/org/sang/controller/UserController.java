package org.sang.controller;


import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.Role;
import org.sang.bean.User;
import org.sang.service.UserRoleService;
import org.sang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author magentaLi
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/api/get/user")
    public HashMap getUsers(int index, int size, String name, String username, String phone) {
        HashMap<Object, Object> map = new HashMap<>();
        List<User> users = userService.getUsers(index, size, name.trim(), username.trim(), phone.trim());
        int usersSize = users.size();
        int pages;
        if (usersSize <= size) {
            pages = 1;
        } else {
            pages = usersSize / size + 1;
        }
        map.put("currentPage", index);
        map.put("dataSize", usersSize);
        map.put("countOfPage", pages);
        map.put("allUsers", users);
        return map;
    }

    @PutMapping("/api/put/user")
    public Map updateUser(User u) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = userService.updateUser(u);
        Boolean isOK = true;
        String info = "添加成功";
        if (res == 0) {
            isOK = false;
            info = "添加失败";
        }
        map.put("isOK", isOK);
        map.put("info", info);
        return map;
    }

    @DeleteMapping("/api/delete/user")
    public Map deleteUser(Long userId) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = userService.deleteUser(userId);
        String info = "删除成功";
        Boolean isOK = true;
        if (res == 0) {
            isOK = false;
            info = "删除失败";
        }
        map.put("isOK", isOK);
        map.put("info", info);
        return map;
    }

    @GetMapping("/api/get/user/{userId}")
    public Map getUserRoles(@PathVariable("userId") int userId) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Role> roles = userRoleService.getRolesByUId(userId);
        map.put("roles", roles);
        return map;
    }

    @PutMapping("/api/put/userRole")
    public Map putUserRole(int uId, String roles) {
        HashMap<String, Object> map = new HashMap<>();
        userRoleService.updateUserRoles(uId, roles);
        map.put("isOK", true);
        map.put("info", "更新成功");
        return map;
    }

    @PostMapping("/api/post/user")
    public Map insertUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        int i = userService.countUserByUserName(user.getUsername());
        if (i == 0) {
            userService.addUser(user);
            map.put("isOK", true);
            map.put("info", "添加成功");
        } else {
            map.put("isOK", false);
            map.put("info", "账号已存在！");
        }
        return map;
    }


}


