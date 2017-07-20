package org.spring.springboot.dao;

import org.spring.springboot.model.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.query.UserQueryObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


/**
 * Created with IntelliJ IDEA.
 * User: zhumeilu
 * Date: 2017/6/30
 * Time: 12:34
 * To change this template use File | Settings | File Templates.
 */
@Component  //为了消除Controller里面的红线警告
@Mapper
public interface UserMapper {

    User get(Long id);

    void insert(User user);
    void update(User user);
    List<User> list(UserQueryObject qo);
    void delete(Long id);
    User findByUsername(String username);
    Set<String> getRoleNamesByUserId(Long userId);
    Set<String> getPermissionsNameByRoleNames(@Param("roleNames") Set<String> roleNames);
}
