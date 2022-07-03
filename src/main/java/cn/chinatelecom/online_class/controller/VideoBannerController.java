package cn.chinatelecom.online_class.controller;

import cn.chinatelecom.online_class.model.entity.VideoBanner;
import cn.chinatelecom.online_class.service.VideoBannerService;
import cn.chinatelecom.online_class.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video_banner/")
public class VideoBannerController {
    @Autowired
    private VideoBannerService videoBannerService;
    @GetMapping("findAllVideoBanners")
    public JsonData findAllVideoBanners(){
        List<VideoBanner> videoBannerList = videoBannerService.findAllVideoBanner();
        return JsonData.buildSuccess(videoBannerList,"succeed to find all video banners");
    }

    @GetMapping("index")
    public JsonData index(){
        int i = 1/0;
        return null;
    }

}
