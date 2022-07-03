package cn.chinatelecom.online_class.model.entity;

import java.util.Date;

/**
 *  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '跳转地址',
 *   `img` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片地址',
 *   `create_time` datetime(0) NULL DEFAULT NULL,
 *   `weight` int(0) NULL DEFAULT NULL COMMENT '数字越小排越前',
 *   PRIMARY KEY (`id`) USING BTREE
 */
public class VideoBanner {
    private Integer id;
    private String url;
    private String img;
    private Date create_time;
    private Integer weight;

    public VideoBanner() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", create_time=" + create_time +
                ", weight=" + weight +
                '}';
    }
}
