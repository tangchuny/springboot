package org.spring.springboot.controller;


import org.spring.springboot.domain.User;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class UserRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
   
    public Object list(String data) throws Exception {
    	Object obj = CityService.list(data);
        return  obj;
    }
    
}
