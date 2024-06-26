package com.zlx.xoj_backend.model.dto.picture;

import com.zlx.xoj_backend.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author zlx
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PictureQueryRequest extends PageRequest implements Serializable {


    /**
     * 搜索词
     */
    private String searchText;

    private static final long serialVersionUID = 1L;
}