package com.wangli.springsecurity.controller;

import com.wangli.springsecurity.pojo.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangli
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        Message msg = new Message("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute("msg", msg);
        return "index";
    }
}
