package com.zlx.xoj_backend.common;

import java.io.Serializable;
import lombok.Data;

/**
 * 删除请求
 *
 * @author zlx
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}