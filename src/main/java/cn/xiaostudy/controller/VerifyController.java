package cn.xiaostudy.controller;

import cn.xiaostudy.constant.AuthCode;
import cn.xiaostudy.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台登录身份验证
 * @author charlotte xiao
 * @date 2021/10/1
 * @description
 */
@RestController
public class VerifyController {

    @GetMapping("/verify/{username}/{password}")
    public Result<Object> verify(@PathVariable("username") String username, @PathVariable("password") String password){
        if(AuthCode.AUTH_USERNAME.equals(username)&&AuthCode.AUTH_PASSWORD.equals(password)){
            return Result.ok("登录成功！");
        }else{
            return Result.fail("登录失败！");
        }
    }
}
