package cn.chinatelecom.online_class.service;

import cn.chinatelecom.online_class.model.entity.VideoOrder;

import java.util.List;

public interface VideoOrderService {
    int save(Integer userId,Integer videoId);
    List<VideoOrder> findVideoList(Integer UserId);
}
