package com.zlx.ai_charts.model.vo;

import com.google.gson.Gson;
import com.zlx.ai_charts.model.entity.Picture;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 帖子视图
 *
 * @author zlx
 */
@Data
public class SearchVO implements Serializable {

    private final static Gson GSON = new Gson();

    private List<UserVO> userList;
    private List<PostVO> postList;
    private List<Picture> pictureList;
    private List<?> dataList;
}
