package cn.chinatelecom.online_class.dao;

import cn.chinatelecom.online_class.model.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;


public interface UserDao {
    int save(User user);
    User findUserByPhone(@Param("phone")String phone );
    User findUserById(@Param("id")Integer id);
}
