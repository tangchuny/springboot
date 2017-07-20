package org.spring.springboot.service.impl;/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/6/30
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */

import org.spring.springboot.dao.UserMapper;
import org.spring.springboot.model.User;
import org.spring.springboot.service.IUserService;

import org.spring.springboot.query.UserQueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User get(Long id) {
        return userMapper.get(id);
    }

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public List<User> list(UserQueryObject qo) {
        return userMapper.list(qo);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Set<String> getRoleNamesByUserId(Long userId) {
        return userMapper.getRoleNamesByUserId(userId);
    }

    @Override
    public Set<String> getPermissionsNameByRoleNames(Set<String> roleNames) {
        return userMapper.getPermissionsNameByRoleNames(roleNames);
    }

}
