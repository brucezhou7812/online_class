package cn.chinatelecom.online_class.model.entity;

import java.util.Date;

/**
 * CREATE TABLE `video_order`  (
 *   `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `out_trade_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单唯一标识',
 *   `state` int(0) NULL DEFAULT NULL COMMENT '0表示未支付，1表示已支付',
 *   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '订单生成时间',
 *   `total_fee` int(0) NULL DEFAULT NULL COMMENT '支付金额，单位分',
 *   `video_id` int(0) NULL DEFAULT NULL COMMENT '视频主键',
 *   `video_title` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频标题',
 *   `video_img` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频图片',
 *   `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 */
public class VideoOrder {
    private Integer id;
    private String out_trade_no;
    private Integer state;
    private Date create_time;
    private Integer total_fee;
    private Integer video_id;
    private String video_title;
    private String video_img;
    private Integer user_id;

    public VideoOrder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_img() {
        return video_img;
    }

    public void setVideo_img(String video_img) {
        this.video_img = video_img;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id=" + id +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", state=" + state +
                ", create_time=" + create_time +
                ", total_fee=" + total_fee +
                ", video_id=" + video_id +
                ", video_title='" + video_title + '\'' +
                ", video_img='" + video_img + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
