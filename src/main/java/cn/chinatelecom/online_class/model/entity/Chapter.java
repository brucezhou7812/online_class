package cn.chinatelecom.online_class.model.entity;

import java.util.Date;
import java.util.List;

/**
 * CREATE TABLE `chapter`  (
 *   `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
 *   `video_id` int(0) NULL DEFAULT NULL COMMENT '视频主键',
 *   `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节名称',
 *   `ordered` int(0) NULL DEFAULT NULL COMMENT '章节顺序',
 *   `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
 *   PRIMARY KEY (`id`) USING BTREE
 * ) ENGINE = MyISAM AUTO_INCREMENT = 716 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
 */
public class Chapter {
    private Integer id;
    private Integer video_id;
    private String title;
    private Integer ordered;
    private Date create_time;
    private List<Episode> episodeList;

    public Chapter() {
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", video_id=" + video_id +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", create_time=" + create_time +
                '}';
    }
}
