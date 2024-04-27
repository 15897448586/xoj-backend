package com.zlx.xoj_backend.judge;

import com.zlx.xoj_backend.model.entity.QuestionSubmit;

/**
 * @Author zlx
 * @Date 2024/4/26 14:36
 */
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);

}
