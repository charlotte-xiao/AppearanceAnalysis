package cn.xiaostudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author charlotte xiao
 * @date 2021/10/1
 * @description
 */
@RestController
public class VerifyController {

    private static String USERNAME = "root";

    private static String PASSWORD = "mirror";

    @GetMapping("/verify/{username}/{password}")
    public Boolean verify(@PathVariable("username") String username,@PathVariable("password") String password){
        if(USERNAME.equals(username)&&PASSWORD.equals(password)){
            return true;
        }else{
            return false;
        }
    }
}
