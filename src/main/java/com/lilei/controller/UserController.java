package com.lilei.controller;

import com.lilei.base.BaseController;
import com.lilei.base.ResponseBase;
import com.lilei.pojo.User;
import com.lilei.service.PlayerService;
import com.lilei.service.UserService;
import com.lilei.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private PlayerService playerService;

    /**
     * 登录
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseBase login(String username, String password) throws IOException {
        User user = userService.findByModel(username,password);
        //没有 账号或密码错误
        if (user==null&& Objects.isNull(user)){
            return setResultError("账号或密码错误");
        }
        else {
            return setResultSuccess("登录成功");
        }

    }

    @RequestMapping(value = "toindex",method = RequestMethod.GET)
    public String toindex(HttpSession session){
        //User user = redisUtils.get()
        return "index";
    }

}
