package com.zlx.xoj_backend.judge.codesandbox.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zlx.xoj_backend.common.ErrorCode;
import com.zlx.xoj_backend.exception.BusinessException;
import com.zlx.xoj_backend.judge.codesandbox.CodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeRequest;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author zlx
 * @Date 2024/4/26 14:45
 */
@Component
public class RemoteCodeSandbox implements CodeSandbox {

    @Value("${code-sandbox.url}")
    private String codeSandboxUrl;
    @Value("${code-sandbox.port}")
    private String codeSandboxPort;

    private static final String AUTH_REQUEST_HEADER = "accessKey";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        String url = "http://"+ codeSandboxUrl +":"+codeSandboxPort+"/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StrUtil.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }

}
