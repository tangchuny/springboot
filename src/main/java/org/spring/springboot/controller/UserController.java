package org.spring.springboot.controller;
import org.spring.springboot.model.User;


import org.spring.springboot.query.UserQueryObject;
import org.spring.springboot.service.IUserService;
import org.spring.springboot.config.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<User> list(UserQueryObject qo){
        List<User> list = userService.list(qo);
        return list;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User get(@PathVariable Long id){
       User user = userService.get(id);
        logger.info("username:"+user.getUsername()+" password:"+user.getPassword());
        return user;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public AjaxResult update(@PathVariable Long id, @ModelAttribute User user){
        userService.update(user);
        return new AjaxResult(true,"编辑成功");
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public AjaxResult add( @RequestBody User user){
    	logger.info("添加的数据："+user);
        userService.save(user);
        return new AjaxResult(true,"添加成功");
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResult delete( @PathVariable Long id){
    	logger.info("delete id:"+id);
        userService.delete(id);
        return new AjaxResult(true,"添加成功");
    }
    
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public User findByUsername( @RequestBody String  username){
    	logger.info("username===="+username);
    	User user = userService.findByUsername(username);
    	return  user;
    }

}
