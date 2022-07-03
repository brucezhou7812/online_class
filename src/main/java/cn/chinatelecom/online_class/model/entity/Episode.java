package cn.chinatelecom.online_class.model.entity;

import java.util.Date;

/**
 * CREATE TABLE `episode`  (
 *   `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `title` varchar(524) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '集标题',
 *   `num` int(0) NULL DEFAULT NULL COMMENT '第几集,全局顺序',
 *   `ordered` int(0) NULL DEFAULT NULL COMMENT '顺序，章里面的顺序',
 *   `play_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '播放地址',
 *   `chapter_id` int(0) NULL DEFAULT NULL COMMENT '章节主键id',
 *   `free` tinyint(0) NULL DEFAULT 0 COMMENT '0表示免费，1表示首付',
 *   `cover_img` varchar(524) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图',
 *   `video_id` int(0) NULL DEFAULT NULL COMMENT '视频id',
 *   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE = MyISAM AUTO_INCREMENT = 12630 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 */
public class Episode {
    private Integer id;
    private String title;
    private Integer num;
    private Integer ordered;
    private String play_url;
    private Integer chapter_id;
    private Integer free;
    private String cover_img;
    private Integer video_id;
    private Date create_time;

    public Episode() {
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getPlay_url() {
        return play_url;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }

    public Integer getChapter_id() {
        return chapter_id;
    }

    public void setChapter_id(Integer chapter_id) {
        this.chapter_id = chapter_id;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public String getCover_img() {
        return cover_img;
    }

    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", ordered=" + ordered +
                ", play_url='" + play_url + '\'' +
                ", chapter_id=" + chapter_id +
                ", free=" + free +
                ", cover_img='" + cover_img + '\'' +
                ", video_id=" + video_id +
                ", create_time=" + create_time +
                '}';
    }
}
