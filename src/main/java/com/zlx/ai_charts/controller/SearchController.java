package com.zlx.ai_charts.controller;

import com.zlx.ai_charts.common.BaseResponse;
import com.zlx.ai_charts.common.ResultUtils;
import com.zlx.ai_charts.manager.SearchFacede;
import com.zlx.ai_charts.model.dto.search.SearchRequest;
import com.zlx.ai_charts.model.vo.SearchVO;
import com.zlx.ai_charts.service.PictureService;
import com.zlx.ai_charts.service.PostService;
import com.zlx.ai_charts.service.UserService;
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
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacede searchFacede;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacede.searchAll(searchRequest, request));
    }
}
