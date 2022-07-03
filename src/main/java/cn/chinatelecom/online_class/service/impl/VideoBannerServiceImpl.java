package cn.chinatelecom.online_class.service.impl;

import cn.chinatelecom.online_class.config.KeyManager;
import cn.chinatelecom.online_class.dao.VideoBannerDao;
import cn.chinatelecom.online_class.model.entity.VideoBanner;
import cn.chinatelecom.online_class.service.VideoBannerService;
import cn.chinatelecom.online_class.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class VideoBannerServiceImpl implements VideoBannerService {
    @Autowired
    private VideoBannerDao videoBannerDao;
    @Autowired
    private BaseCache baseCache;
//    @Override
//    public List<VideoBanner> findAllVideoBanner() {
//        List<VideoBanner> videoBannerList = videoBannerDao.findAllVideoBanners();
//                return videoBannerList;
////        try{
////            Object cacheObj = baseCache.getTenMiniutesCache().get(KeyManager.VIDEO_BANNER_KEY,()->{
////                // System.out.println("Get video banner from database");
////                List<VideoBanner> videoBannerList = videoBannerDao.findAllVideoBanners();
////                return videoBannerList;
////            });
////            if(cacheObj instanceof List){
////                return (List<VideoBanner> )cacheObj;
////            }
////        }catch (Exception e){
////            e.printStackTrace();
////        }
////        return null;
//    }
   @Override
    public List<VideoBanner> findAllVideoBanner() {
        try{
            Object cacheObj = baseCache.getTenMiniutesCache().get(KeyManager.INDEX_VIDEO_BANNER_LIST,()->{
               // System.out.println("Get video banner from database");
                List<VideoBanner> videoBannerList = videoBannerDao.findAllVideoBanners();
                return videoBannerList;
            });
            if(cacheObj instanceof List){
                return (List<VideoBanner> )cacheObj;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
