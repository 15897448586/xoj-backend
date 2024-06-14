package com.zlx.xoj_backend.judge.codesandbox.impl;

import com.zlx.xoj_backend.judge.codesandbox.CodeSandbox;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeRequest;
import com.zlx.xoj_backend.judge.codesandbox.model.ExecuteCodeResponse;
import com.zlx.xoj_backend.judge.codesandbox.model.JudgeInfo;
import com.zlx.xoj_backend.model.enums.JudgeInfoMessageEnum;
import com.zlx.xoj_backend.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/26 14:44
 */
@Slf4j
@Component
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}

