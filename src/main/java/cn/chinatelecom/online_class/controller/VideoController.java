package cn.chinatelecom.online_class.controller;

import cn.chinatelecom.online_class.model.entity.Video;
import cn.chinatelecom.online_class.service.VideoService;
import cn.chinatelecom.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video/")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @RequestMapping("findAllVideos")
    public JsonData findAllVideos(){
        List<Video>videoList = videoService.findAllVideos();
        JsonData jsonData = JsonData.buildSuccess(videoList,"succeed to list all videos.");
        return jsonData;
    }

    @RequestMapping("findVideoDetailById")
    public JsonData findVideoDetailById(@RequestParam("video_id")Integer video_id){
        Video video = videoService.findVideoDetailById(video_id);
        JsonData jsonData = JsonData.buildSuccess(video,"succeed to list video detail.");
        return jsonData;
    }
}
