package com.ilearn.platform.controller;

import com.ilearn.platform.bean.UserInfo;
import com.ilearn.platform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Creator zhuweijun
 * Date 2017/9/6 0006.
 */
@Controller
@RequestMapping("/user")
public class UserController
{
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model)
    {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserInfo userInfo = this.userService.getUserById(userId);
        model.addAttribute("user", userInfo);
        return "showUser";
    }
}
