package cn.chinatelecom.online_class.controller;

import cn.chinatelecom.online_class.exception.CustomException;
import cn.chinatelecom.online_class.model.entity.User;
import cn.chinatelecom.online_class.model.request.LoginRequest;
import cn.chinatelecom.online_class.service.UserService;
import cn.chinatelecom.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/api/v1/pri/user/login")
    //public JsonData Login(@RequestBody LoginRequest loginRequest){
    public JsonData Login(@RequestHeader("phone")String phone,@RequestHeader("pwd")String pwd){
       /*
        if(loginRequest == null) {
            return JsonData.buildError(-1,"Login failure, please try again.");
        }
        */
        String token = userService.findUserByPhoneAndPwd(phone, pwd);
        if(null == token){
            return JsonData.buildError(-1,"Login failure, please try again.");
        }else{
            return JsonData.buildSuccess(token,"Login success.");
        }

    }
    @GetMapping("/api/v1/pri/user/findUserByToken")
    public JsonData findUserByToken(HttpServletRequest request){
        Integer id = (Integer)request.getAttribute("id");
        if(id == null){
            return JsonData.buildError(-1,"Login failure");
        }
        User user = userService.findUserById(id);
        if(user == null){
            return JsonData.buildError(-1,"Login failure");
        }
        return JsonData.buildSuccess(user);
    }
    @PostMapping("/api/v1/pub/user/register")
    public JsonData register(@RequestBody User user){
        if(userService.findUserByPhone(user.getPhone())!=null){
            CustomException ex = new CustomException(-1,"Register failure:Invalid User");
            throw ex;
        }
        if(userService.save(user)==1){
            return JsonData.buildSuccess(user,"Register success");
        }else{
            return JsonData.buildError(user,-1,"Register failure.");
        }
    }
}
