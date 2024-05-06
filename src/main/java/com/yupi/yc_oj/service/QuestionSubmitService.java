package com.yupi.yc_oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.yc_oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.yc_oj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.yupi.yc_oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.yc_oj.model.entity.User;
import com.yupi.yc_oj.model.vo.QuestionSubmitVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author chaoyue
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-04-12 18:00:26
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 点赞
     *
     * @param
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

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param
     * @return
     */


    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);


}
