package org.spring.springboot.service;


import org.spring.springboot.model.User;


import java.util.List;
import java.util.Set;

import org.spring.springboot.query.UserQueryObject;

/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/6/30
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService {

    User get(Long id);

    void save(User user);
    void update(User user);
    List<User> list(UserQueryObject qo);
    void delete(Long id);
    User findByUsername(String username);
    Set<String> getRoleNamesByUserId(Long userId);
    Set<String> getPermissionsNameByRoleNames(Set<String> roleNames);
}
