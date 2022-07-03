package cn.chinatelecom.online_class.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 *   `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
 *   `pwd` varchar(124) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
 *   `head_img` varchar(524) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
 *   `phone` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号',
 *   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
 *   PRIMARY KEY (`id`) USING BTREE
 */
public class User {
    private Integer id;
    private String name;
  //  @JsonIgnore
    private String pwd;
    private String head_img;
    private String phone;
    private Date create_time;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHead_img() {
        return head_img;
    }

    public void setHead_img(String head_img) {
        this.head_img = head_img;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", head_img='" + head_img + '\'' +
                ", phone='" + phone + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
