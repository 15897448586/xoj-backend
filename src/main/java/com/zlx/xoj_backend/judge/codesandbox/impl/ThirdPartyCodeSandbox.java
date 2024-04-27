package com.zlx.xoj_backend.judge.codesandbox.impl;

import com.zlx.xoj_backend.judge.codesandbox.CodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeRequest;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @Author zlx
 * @Date 2024/4/26 14:46
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}

