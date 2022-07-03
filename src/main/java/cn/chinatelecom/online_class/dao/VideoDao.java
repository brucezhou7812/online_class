package cn.chinatelecom.online_class.dao;

import cn.chinatelecom.online_class.model.entity.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoDao {
    List<Video> findAllVideos();
    Video findVideoDetailById(@Param("video_id")Integer video_id);

    Video findVideoById(@Param("video_id")Integer videoId);
}
