package cn.chinatelecom.online_class;

import cn.chinatelecom.online_class.model.entity.User;
import cn.chinatelecom.online_class.utils.CommonUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OnlineClassApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenerateJWT(){
        User user = new User();
        user.setName("bruce");
        user.setPhone("18911717812");
        user.setHead_img("brucezhou");
        String token = CommonUtils.generateJWT(user);
        System.out.println(token);
        Claims claims = CommonUtils.checkJWT(token);
        System.out.println(claims);

    }

}
