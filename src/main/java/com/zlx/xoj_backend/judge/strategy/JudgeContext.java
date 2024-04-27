package com.zlx.xoj_backend.judge.strategy;

import com.zlx.xoj_backend.model.dto.question.JudgeCase;
import com.zlx.xoj_backend.model.dto.questionsubmit.JudgeInfo;
import com.zlx.xoj_backend.model.entity.Question;
import com.zlx.xoj_backend.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/26 14:51
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;

}
