package com.zlx.xoj_backend.model.dto.search;

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
public class SearchRequest extends PageRequest implements Serializable {


    /**
     * 搜索词
     */
    private String searchText;
    /**
     * 类型
     */
    private String type;

    private static final long serialVersionUID = 1L;
}