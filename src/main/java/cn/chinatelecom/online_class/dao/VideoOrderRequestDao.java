package cn.chinatelecom.online_class.dao;

import cn.chinatelecom.online_class.model.entity.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderRequestDao {
    VideoOrder findVideoOrderByUserIdAndVideoIdAndState(@Param("user_id")Integer userId,@Param("video_id")Integer videoId,@Param("state")Integer state);
    int save(VideoOrder videoOrder);
    List<VideoOrder> findVideoOrderList(@Param("user_id")Integer userId);
}
