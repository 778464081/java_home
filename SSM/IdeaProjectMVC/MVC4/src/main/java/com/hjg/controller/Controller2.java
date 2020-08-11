package com.hjg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hjg
 * @date 2020/8/11 10:20
 */
@Controller
public class Controller2 {

    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg","这是第二个");
        return "test";
    }
        //restFul风格传参
    @RequestMapping("/t3/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b, Model model){
        int res = a+b;
        model.addAttribute("msg","结果为"+res);
        return "test";
    }
}
