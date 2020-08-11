package com.hjg.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hjg
 * @date 2020/8/11 10:11
 */

//只要实现了Controller接口的类就是控制器了
public class Controller1 implements Controller {
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        mv.addObject("msg","这是第一个");
        mv.setViewName("test");


        return mv;
    }
}
