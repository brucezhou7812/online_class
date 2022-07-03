package cn.chinatelecom.online_class.service.impl;

import cn.chinatelecom.online_class.config.KeyManager;
import cn.chinatelecom.online_class.dao.VideoDao;
import cn.chinatelecom.online_class.model.entity.Video;
import cn.chinatelecom.online_class.service.VideoService;
import cn.chinatelecom.online_class.utils.BaseCache;
import com.google.common.cache.Cache;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;
    @Autowired
    private BaseCache baseCache;
    @Override
    public List<Video> findAllVideos() {
        try {
            Object baseObj = baseCache.getTenMiniutesCache().get(KeyManager.INDEX_VIDEO_LIST, () -> {
                Object o =videoDao.findAllVideos();
                return o;
            });
            if (baseObj instanceof List) {
                return (List<Video>) baseObj;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Video findVideoDetailById(@Param("video_id") Integer video_id) {
        String key = String.format(KeyManager.VIDEO_DETAIL,video_id);
        try{

            Object baseObj = baseCache.getOneHourCache().get(key,()->{
                return videoDao.findVideoDetailById(video_id);
            });
            if(baseObj instanceof Video){
                return (Video)baseObj;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
