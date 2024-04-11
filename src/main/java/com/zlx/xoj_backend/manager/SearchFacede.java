package com.zlx.xoj_backend.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlx.xoj_backend.common.ErrorCode;
import com.zlx.xoj_backend.datasourse.*;
import com.zlx.xoj_backend.exception.BusinessException;
import com.zlx.xoj_backend.exception.ThrowUtils;
import com.zlx.xoj_backend.model.dto.post.PostQueryRequest;
import com.zlx.xoj_backend.model.dto.search.SearchRequest;
import com.zlx.xoj_backend.model.dto.user.UserQueryRequest;
import com.zlx.xoj_backend.model.entity.Picture;
import com.zlx.xoj_backend.model.enums.SearchTypeEnum;
import com.zlx.xoj_backend.model.vo.PostVO;
import com.zlx.xoj_backend.model.vo.SearchVO;
import com.zlx.xoj_backend.model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class SearchFacede {

    @Resource
    private UserDataSource userDataSource;

    @Resource
    private PostDataSource postDataSource;

    @Resource
    private PictureDataSource pictureDataSource;

    @Resource
    private DataSourceRegistry dataSourceRegistry;

    public SearchVO searchAll(SearchRequest searchRequest, HttpServletRequest request) {
        String type = searchRequest.getType();
        SearchTypeEnum enumByValue = SearchTypeEnum.getEnumByValue(type);
        ThrowUtils.throwIf(StringUtils.isBlank(type), ErrorCode.PARAMS_ERROR);
        ThrowUtils.throwIf(enumByValue == null, ErrorCode.PARAMS_ERROR);
        String searchText = searchRequest.getSearchText();
        long current = searchRequest.getCurrent();
        long pageSize = searchRequest.getPageSize();
        if (enumByValue == null) {
            CompletableFuture<Page<Picture>> pictureTask = CompletableFuture.supplyAsync(() -> {
                return pictureDataSource.doSearch(searchText, current, pageSize);
            });
            CompletableFuture<Page<UserVO>> userTask = CompletableFuture.supplyAsync(() -> {
                UserQueryRequest userQueryRequest = new UserQueryRequest();
                userQueryRequest.setUserName(searchText);
                return userDataSource.doSearch(searchText, current, pageSize);
            });
            CompletableFuture<Page<PostVO>> postTask = CompletableFuture.supplyAsync(() -> {
                PostQueryRequest postQueryRequest = new PostQueryRequest();
                postQueryRequest.setSearchText(searchText);
                return postDataSource.doSearch(searchText, current, pageSize);
            });

            CompletableFuture.allOf(postTask, userTask, pictureTask).join();
            try {
                Page<PostVO> postVOPage = postTask.get();
                Page<Picture> picturePage = pictureTask.get();
                Page<UserVO> userVOPage = userTask.get();
                SearchVO searchVO = new SearchVO();
                searchVO.setPictureList(picturePage.getRecords());
                searchVO.setUserList(userVOPage.getRecords());
                searchVO.setPostList(postVOPage.getRecords());
                return searchVO;
            } catch (Exception e) {
                log.error("查询异常", e);
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "查询异常");
            }
        } else {
            SearchVO searchVO = new SearchVO();

            DataSource<?> dataSource = dataSourceRegistry.getDataSourceByType(type);
            Page<?> page = dataSource.doSearch(searchText, current, pageSize);
            searchVO.setDataList(page.getRecords());

            return searchVO;

        }
    }
}
