package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloController {

    @Value("${person.lastName}")
    private String name;

    @Autowired
    Person person;

    @ResponseBody
    @RequestMapping("/hello")
    public Object sayHello() {
        String n = a();
        String m = h();
        String j = n+m;
        System.out.println(j);
        return person;
    }

    public String a(){
        String c = "dsa";
        String b = "das";
        StringBuffer str = new StringBuffer();
        str.append(c).append(b);
        return str.toString();
    }

    public String h(){
        String c = "dsa";
        String b = "das";
        StringBuffer str = new StringBuffer();
        str.append(c).append(b);
        return str.toString();
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello","你好啊");
        return "success";
    }
}
