package cn.chinatelecom.online_class.service.impl;

import cn.chinatelecom.online_class.dao.LoginRequestDao;
import cn.chinatelecom.online_class.dao.UserDao;
import cn.chinatelecom.online_class.model.entity.User;
import cn.chinatelecom.online_class.service.UserService;
import cn.chinatelecom.online_class.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginRequestDao loginRequestDao;
    @Override
    public int save(User user) {

        //user.setPwd(CommonUtils.MD5(pwd));

        user.setHead_img(randomImg());
        Date create_time = new Date();
        user.setCreate_time(create_time);
        return userDao.save(user);
    }

    @Override
    public User findUserByPhone(String phone) {
        return userDao.findUserByPhone(phone);
    }

    @Override
    public String findUserByPhoneAndPwd(String phone, String pwd) {
        String token = null;
        System.out.println("phone:"+phone+" pwd:"+pwd);
        String encodePwd = pwd;//CommonUtils.MD5(pwd);
        User user = loginRequestDao.findUserByPhoneAndPwd(phone,encodePwd);
        if(user == null) return null;
        token = CommonUtils.generateJWT(user);
        return token;
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    private static final String[] headImg={
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/21.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/20.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/19.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/18.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/17.jpeg",
            "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/16.jpeg"
    };
    private String randomImg(){
        int size = headImg.length;
        Random random = new Random();
        int index = random.nextInt(size);
        return headImg[index];
    }
}
