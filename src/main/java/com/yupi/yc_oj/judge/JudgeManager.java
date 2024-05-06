package com.yupi.yc_oj.judge;

import com.yupi.yc_oj.judge.strategy.*;
import com.yupi.yc_oj.model.dto.questionsubmit.JudgeInfo;
import com.yupi.yc_oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
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
//        if ("java".equals(language)) {
//            judgeStrategy = new JavaLanguageJudgeStrategy();
//        } else if ("c".equals(language)) {
//
//        } else if ("cpp".equals(language)) {
//
//        }
        switch (language){
            case "java":
                judgeStrategy = new JavaLanguageJudgeStrategy();
                break;
            case "c":
                judgeStrategy = new CLanguageJudgeStrategy();
                break;
            case "cpp":
                judgeStrategy = new CppLanguageJudgeStrategy();
                break;
            case "python":
                judgeStrategy = new PythonLanguageJudgeStrategy();
                break;
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
