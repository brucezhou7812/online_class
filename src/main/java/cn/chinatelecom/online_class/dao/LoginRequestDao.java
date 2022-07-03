package cn.chinatelecom.online_class.dao;

import cn.chinatelecom.online_class.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


public interface LoginRequestDao {
    User findUserByPhoneAndPwd(@Param("phone")String phone, @Param("pwd")String pwd);
}
