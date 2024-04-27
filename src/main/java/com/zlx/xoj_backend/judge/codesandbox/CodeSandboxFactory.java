package com.zlx.xoj_backend.judge.codesandbox;

import com.zlx.xoj_backend.judge.codesandbox.impl.ExampleCodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.impl.RemoteCodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * @Author zlx
 * @Date 2024/4/26 14:41
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱示例
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}

