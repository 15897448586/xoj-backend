package com.zlx.xoj_backend.judge.strategy;

import com.zlx.xoj_backend.model.dto.questionsubmit.JudgeInfo;

/**
 * @Author zlx
 * @Date 2024/4/26 14:52
 */
public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
