package com.zlx.xoj_backend.judge.codesandbox;

import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeRequest;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Author zlx
 * @Date 2024/4/26 14:40
 */
public interface CodeSandbox {
    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);

}
