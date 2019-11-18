package com.zyc.controller;

import com.zyc.bean.Person;
import com.zyc.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController //相当于  @Controller +@ResponseBody
@RequestMapping("user")
//前面的  都是 springmvc的注解不是  springboot的
public class UserController {

    @Autowired
    private Person person;
    @RequestMapping(path = "hello/{city_id}/{user_id}", method = RequestMethod.GET)
    public  Map<Object, Object> hello(@PathVariable String city_id, @PathVariable String user_id){
        Map<Object, Object> map = new HashMap<>();
        map.put("a","zyc");
        map.put("b","1");
        map.put("c","2");
        map.put("d","3");
        map.put("city_id",city_id);
        map.put("user_id",user_id);
        return map;
    }
    @GetMapping(path = "/getHello/{city_id}/{user_id}")
    public  Map<Object, Object> getHello(@PathVariable String city_id,@PathVariable String user_id){
        Map<Object, Object> map = new HashMap<>();
        map.put("a","zyc");
        map.put("b","1");
        map.put("c","2");
        map.put("d","3");
        map.put("city_id1",city_id);
        map.put("user_id1",user_id);
        return map;
    }
    //默认值
    @GetMapping(path = "/defHello")
    public  Map<Object, Object> defHello(@RequestParam(defaultValue = "0",name = "city") String city_id,String user_id){
        Map<Object, Object> map = new HashMap<>();
        map.put("a","zyc");
        map.put("b","1");
        map.put("c","2");
        map.put("d","3");
        map.put("city_id1",city_id);
        map.put("user_id1",user_id);
        return map;
    }
    //json作为参数
    @RequestMapping(path = "/bodyHello")
    public  Map<Object, Object> bodyHello(@RequestBody User user,@RequestHeader("Content-Type") String type){
        Map<Object, Object> map = new HashMap<>();
        map.put("a","zyc");
        map.put("b","1");
        map.put("c","2");
        map.put("d","3");
        map.put("age",user.getAge());
        map.put("name",user.getName());
        map.put("header",type);
        return map;
    }


    @RequestMapping(path = "/jsonHello")
    public  User jsonHello(){
        User user = new User(1,"zyc",12,new Date());

        return user;
    }

    @RequestMapping("text")
    public Object text(){

        return person;
    }

}
