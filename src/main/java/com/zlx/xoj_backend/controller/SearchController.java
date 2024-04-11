package com.zlx.xoj_backend.controller;

import com.zlx.xoj_backend.common.BaseResponse;
import com.zlx.xoj_backend.common.ResultUtils;
import com.zlx.xoj_backend.manager.SearchFacede;
import com.zlx.xoj_backend.model.dto.search.SearchRequest;
import com.zlx.xoj_backend.model.vo.SearchVO;
import com.zlx.xoj_backend.service.PictureService;
import com.zlx.xoj_backend.service.PostService;
import com.zlx.xoj_backend.service.UserService;
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
