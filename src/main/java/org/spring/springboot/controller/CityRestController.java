package org.spring.springboot.controller;

import org.spring.springboot.model.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by bysocket on 07/02/2017.
 */
@RestController
@ResponseBody
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
   
    public City findOneCity(@RequestParam(value = "cityName", required = true) String cityName) {
    	System.out.print("1234");
    	return cityService.findCityByName(cityName);
    }
    
    //city列表
    @RequestMapping(value = "/api/getCityList", method = RequestMethod.GET)
    
    public City getCityList(@RequestParam(value = "description", required = true) String description) {
    	return cityService.findByDes(description);
    }
    

}
