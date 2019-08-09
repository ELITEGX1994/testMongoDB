package test.gx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/2 9:49
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(){return "login";}

}
