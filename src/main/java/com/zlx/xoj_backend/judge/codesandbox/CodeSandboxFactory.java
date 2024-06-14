package com.zlx.xoj_backend.judge.codesandbox;

import com.zlx.xoj_backend.judge.codesandbox.impl.ExampleCodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.impl.RemoteCodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.impl.ThirdPartyCodeSandbox;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author zlx
 * @Date 2024/4/26 14:41
 */
@Component
public class CodeSandboxFactory {

    @Resource
    private ExampleCodeSandbox exampleCodeSandbox;
    @Resource
    private RemoteCodeSandbox remoteCodeSandbox;
    @Resource
    private ThirdPartyCodeSandbox thirdPartyCodeSandbox;
    /**
     * 创建代码沙箱示例
     *
     * @param type 沙箱类型
     * @return
     */
    public CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return exampleCodeSandbox;
            case "remote":
                return remoteCodeSandbox;
            case "thirdParty":
                return thirdPartyCodeSandbox;
            default:
                return exampleCodeSandbox;
        }
    }
}
