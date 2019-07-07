package org.sang.controller;

import org.sang.bean.Role;
import org.sang.bean.User;
import org.sang.logger.SystemControllerLog;
import org.sang.service.UserRoleService;
import org.sang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @SystemControllerLog(description = "分页获取用户列表")
    @GetMapping("/api/get/user")
    public HashMap getUsers(int index, int size, String name, String username, String phone) {
        HashMap<Object, Object> map = new HashMap<>();
        List<User> users = userService.getUsers(index, size, name, username, phone);
        int usersSize = userService.getUsers(1, Integer.MAX_VALUE, name, username, phone).size();
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

    @SystemControllerLog(description = "通过用户名获取用户信息")
    @GetMapping("/api/get/user/{id}")
    public HashMap getUserById(@PathVariable("id") int id) {
        System.out.println(id);
        Long aLong = new Long(id);
        HashMap<Object, Object> map = new HashMap<>();
        User user = userService.getUserById(aLong);
        Boolean isOK = false;
        if (user != null) {
            isOK = true;
        }
        map.put("isOK", isOK);
        map.put("user", user);
        return map;
    }

    @SystemControllerLog(description = "修改用户")
    @PutMapping("/api/put/user")
    public Map updateUser(User u) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = userService.updateUser(u);
        Boolean isOK = true;
        String msg = "修改成功";
        if (res == 0) {
            isOK = false;
            msg = "修改失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }

    @SystemControllerLog(description = "通过用户名删除用户")
    @DeleteMapping("/api/delete/user")
    public Map deleteUser(Long userId) {
        HashMap<Object, Object> map = new HashMap<>();
        int res = userService.deleteUser(userId);
        String msg = "删除成功";
        Boolean isOK = true;
        if (res == 0) {
            isOK = false;
            msg = "删除失败";
        }
        map.put("isOK", isOK);
        map.put("msg", msg);
        return map;
    }

    @SystemControllerLog(description = "通过用户名查询用户拥有的角色")
    @GetMapping("/api/get/role/{userId}")
    public Map getUserRoles(@PathVariable("userId") int userId) {
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Role> roles = userRoleService.getRolesByUId(userId);
        map.put("roles", roles);
        return map;
    }

    @SystemControllerLog(description = "修改用户角色")
    @PutMapping("/api/put/userRole")
    public Map putUserRole(int uId, String roles) {
        HashMap<String, Object> map = new HashMap<>();
        userRoleService.updateUserRoles(uId, roles);
        map.put("isOK", true);
        map.put("msg", "更新成功");
        return map;
    }

    @SystemControllerLog(description = "添加用户")
    @PostMapping("/api/post/user")
    public Map insertUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        int i = userService.countUserByUserName(user.getUsername());
        if (i == 0) {
            userService.addUser(user);
            map.put("isOK", true);
            map.put("msg", "添加成功");
        } else {
            map.put("isOK", false);
            map.put("msg", "账号已存在！");
        }
        return map;
    }

    @SystemControllerLog(description = "修改用户密码")
    @PostMapping("api/update/password")
    public Map updatePwd(int id, String lastPwd, String newPwd) {
        HashMap<String, Object> map = new HashMap<>();
        User userById = userService.getUserById(new Long(id));
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String oldPwd = userById.getPassword();
        if (encoder.matches(lastPwd, oldPwd)) {
            map.put("isOK", true);
            userById.setPassword(encoder.encode(newPwd));
            userService.updateUser(userById);
            map.put("msg", "修改密码成功");
        } else {
            map.put("isOK", false);
            map.put("msg", "原密码错误");
        }
        return map;
    }
}


