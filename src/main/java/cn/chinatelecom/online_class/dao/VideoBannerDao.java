package cn.chinatelecom.online_class.dao;

import cn.chinatelecom.online_class.model.entity.VideoBanner;

import java.util.List;

public interface VideoBannerDao {
    List<VideoBanner> findAllVideoBanners();
}
