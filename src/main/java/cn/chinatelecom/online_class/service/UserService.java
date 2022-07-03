package cn.chinatelecom.online_class.service;

import cn.chinatelecom.online_class.model.entity.User;

public interface UserService {
    int save(User user);
    User findUserByPhone(String phone);
    String findUserByPhoneAndPwd(String phone,String pwd);
    User findUserById(Integer id);
}
