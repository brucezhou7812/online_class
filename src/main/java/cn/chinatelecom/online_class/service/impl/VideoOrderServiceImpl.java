package cn.chinatelecom.online_class.service.impl;

import cn.chinatelecom.online_class.config.KeyManager;
import cn.chinatelecom.online_class.dao.VideoDao;
import cn.chinatelecom.online_class.dao.VideoOrderRequestDao;
import cn.chinatelecom.online_class.model.entity.Video;
import cn.chinatelecom.online_class.model.entity.VideoOrder;
import cn.chinatelecom.online_class.service.VideoOrderService;
import cn.chinatelecom.online_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements VideoOrderService {
    @Autowired
    private VideoOrderRequestDao videoOrderRequestDao;
    @Autowired
    private VideoDao videoDao;
    @Autowired
    BaseCache baseCache;
    @Override
    public int save(Integer userId, Integer videoId) {
        VideoOrder videoOrder = videoOrderRequestDao.findVideoOrderByUserIdAndVideoIdAndState(userId,videoId,1);
        if(videoOrder !=null)
            return -1;
        VideoOrder newVideoOrder = new VideoOrder();
        String key = String.format(KeyManager.VIDEO,videoId);
        Video video = null;
        try {
            Object baseObj = baseCache.getOneHourCache().get(key, () -> {
                return videoDao.findVideoById(videoId);
            });
            if(baseObj instanceof Video){
                video =(Video) baseObj;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(video == null)
            return -2;
        newVideoOrder.setCreate_time(new Date());
        newVideoOrder.setOut_trade_no(UUID.randomUUID().toString());
        newVideoOrder.setUser_id(userId);
        newVideoOrder.setState(1);
        newVideoOrder.setTotal_fee(video.getPrice());
        newVideoOrder.setVideo_id(videoId);
        newVideoOrder.setVideo_img(video.getCover_img());
        newVideoOrder.setVideo_title(video.getTitle());
        return videoOrderRequestDao.save(newVideoOrder);

    }

    @Override
    public List<VideoOrder> findVideoList(Integer userId) {
        return videoOrderRequestDao.findVideoOrderList(userId);
    }
}
