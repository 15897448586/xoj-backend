package com.zlx.xoj_backend.service;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlx.xoj_backend.model.entity.Picture;

/**
 * 图片服务
 *
 * @author zlx
 */
public interface PictureService {
    Page<Picture> searchPicture(String searchText, long pageNum, long pageSize);
}
