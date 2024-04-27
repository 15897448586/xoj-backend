package com.zlx.xoj_backend.judge;

import com.zlx.xoj_backend.judge.strategy.DefaultJudgeStrategy;
import com.zlx.xoj_backend.judge.strategy.JavaLanguageJudgeStrategy;
import com.zlx.xoj_backend.judge.strategy.JudgeContext;
import com.zlx.xoj_backend.judge.strategy.JudgeStrategy;
import com.zlx.xoj_backend.model.dto.questionsubmit.JudgeInfo;
import com.zlx.xoj_backend.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理
 * @Author zlx
 * @Date 2024/4/26 14:34
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}

