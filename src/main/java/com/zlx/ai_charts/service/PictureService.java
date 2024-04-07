package com.zlx.ai_charts.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlx.ai_charts.model.entity.Picture;

/**
 * 图片服务
 *
 * @author zlx
 */
public interface PictureService {
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}
