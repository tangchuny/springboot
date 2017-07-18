package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {
	   @RequestMapping("/getDemo")

	    public User getDemo(){
		   User demo = new User();
	       demo.setId(1);
	       demo.setUserName("tangcy");
	       return demo;//返回的数据已经是json格式的，不需要重新处理

	    }
	   
	   @RequestMapping(value="/getData", method = RequestMethod.POST)    
	   @ResponseBody  
	      public User getData(@RequestBody User user){  
		   System.out.print("接收的参数哦:"+user.getUserName());
		   User u = new User();  
	       u.setId(user.getId());  
	       u.setUserName(user.getUserName());  
	       return u;  
	      }  
	   
	   @Autowired
	    private CityService cityService;

	    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
	   //这种get的方法需要在url路径上传递参数
	    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
	    	System.out.print("1234");
	    	return cityService.findCityByName(cityName);
	    }

}
