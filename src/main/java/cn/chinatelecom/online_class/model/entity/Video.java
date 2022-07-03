package cn.chinatelecom.online_class.model.entity;

import java.util.Date;
import java.util.List;

/**
 *  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `title` varchar(524) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频标题',
 *   `summary` varchar(1026) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '概述',
 *   `cover_img` varchar(524) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图',
 *   `price` int(0) NULL DEFAULT NULL COMMENT '价格,分',
 *   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
 *   `c_id` int(0) NULL DEFAULT NULL COMMENT '子分类id',
 *   `point` double(11, 2) NULL DEFAULT 8.70 COMMENT '默认8.7，最高10分',
 *   PRIMARY KEY (`id`) USING BTREE
 */
public class Video {
    private Integer id;
    private String title;
    private String summary;
    private String cover_img;
    private Integer price;
    private Date create_time;
    private Integer c_id;
    private Double point;
    private List<Chapter> chapterList;


    public Video() {
    }

    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", cover_img='" + cover_img + '\'' +
                ", price=" + price +
                ", create_time=" + create_time +
                ", c_id=" + c_id +
                ", point=" + point +
                '}';
    }
}
