package cn.chinatelecom.online_class.controller;

import cn.chinatelecom.online_class.model.request.VideoOrderRequest;
import cn.chinatelecom.online_class.service.VideoOrderService;
import cn.chinatelecom.online_class.utils.JsonData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1/pri/video_order")
public class VideoOrderController {
    @Autowired
    private VideoOrderService videoOrderService;
    @PostMapping("save")
    public JsonData save(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){
        Integer userId = (Integer)request.getAttribute("id");
        int row = videoOrderService.save(userId,videoOrderRequest.getVideo_id());
        if(row>0)
            return JsonData.buildSuccess("","Order success");
        return JsonData.buildError(-1,"Order failure");
    }

    @GetMapping("getOrderList")
    public JsonData getOrderList(HttpServletRequest request){
        Integer userId = (Integer)request.getAttribute("id");
        return JsonData.buildSuccess(videoOrderService.findVideoList(userId));
    }
}
