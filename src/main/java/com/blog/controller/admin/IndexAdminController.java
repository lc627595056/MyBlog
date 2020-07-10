package com.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台博主登录
 */
@Controller
@RequestMapping ("/admin")
public class IndexAdminController {

    @RequestMapping("/index")
    public String index(){
        return "admin/home";
    }
}
