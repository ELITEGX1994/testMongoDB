package test.gx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.gx.dao.UserDao;
import test.gx.model.User;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author zhangguoxian
 * @Date 2019/8/2 9:50
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/license")
    public String license(String loginName, String passWord, Model model){
        User user = userDao.findUser(loginName, passWord);
        if(user != null){
            model.addAttribute("userName" ,user.getLocalName());
            model.addAttribute("userEmail" ,user.getEmail());
            return "hello";
        }else{
            model.addAttribute("userLoginName" ,loginName);
            return "error";
        }
    }
}
