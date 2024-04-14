package com.yupi.yc_oj.service;

import com.yupi.yc_oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.yc_oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yc_oj.model.entity.User;

/**
* @author chaoyue
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-04-12 18:00:26
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 点赞
     *
     * @param questionId
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

//    /**
//     * 帖子点赞（内部服务）
//     *
//     * @param userId
//     * @param postId
//     * @return
//     */
//    int doQuestionSubmitInner(long userId, long postId);
}
