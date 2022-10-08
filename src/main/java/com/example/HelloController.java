package com.example;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

/**
 * @description:
 * @author: zhangjianqiang05
 * @create: 2022-10-08 12:35
 **/
@RestController
public class HelloController {


    @GetMapping(value = "/index")
    public ModelAndView index() {

        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }


    @GetMapping(value = "/")
    public String index1() {
        return "Welcome " + SecurityContextHolder.getContext().getAuthentication();
    }


    @RequestMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {

        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}