package cn.chinatelecom.online_class.service;

import cn.chinatelecom.online_class.model.entity.Video;

import java.util.List;

public interface VideoService {
    List<Video> findAllVideos();
    Video findVideoDetailById(Integer video_id);

}
