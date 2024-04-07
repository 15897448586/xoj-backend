package com.zlx.ai_charts.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlx.ai_charts.common.BaseResponse;
import com.zlx.ai_charts.common.ErrorCode;
import com.zlx.ai_charts.common.ResultUtils;
import com.zlx.ai_charts.exception.ThrowUtils;
import com.zlx.ai_charts.model.dto.picture.PictureQueryRequest;
import com.zlx.ai_charts.model.entity.Picture;
import com.zlx.ai_charts.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子接口
 *
 * @author zlx
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Resource
    private PictureService pictureService;

    /**
     * 分页获取图片（封装类）
     *
     * @param pictureQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<Picture>> listPictureVOByPage(@RequestBody PictureQueryRequest pictureQueryRequest,
                                                        HttpServletRequest request) {
        long current = pictureQueryRequest.getCurrent();
        long size = pictureQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        String searchText = pictureQueryRequest.getSearchText();
        Page<Picture> picturePage = pictureService.searchPicture(searchText, current, size);
        return ResultUtils.success(picturePage);
    }

}
