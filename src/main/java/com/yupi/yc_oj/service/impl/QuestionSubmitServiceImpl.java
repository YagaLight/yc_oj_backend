package com.yupi.yc_oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.yc_oj.config.common.ErrorCode;
import com.yupi.yc_oj.exception.BusinessException;
import com.yupi.yc_oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.yupi.yc_oj.model.entity.Question;
import com.yupi.yc_oj.model.entity.QuestionSubmit;
import com.yupi.yc_oj.model.entity.QuestionSubmit;
import com.yupi.yc_oj.model.entity.User;
import com.yupi.yc_oj.model.enums.QuestionSubmitLanguageEnum;
import com.yupi.yc_oj.model.enums.QuestionSubmitStatusEnum;
import com.yupi.yc_oj.service.QuestionService;
import com.yupi.yc_oj.service.QuestionSubmitService;
import com.yupi.yc_oj.service.QuestionSubmitService;
import com.yupi.yc_oj.mapper.QuestionSubmitMapper;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
* @author chaoyue
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-04-12 18:00:26
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{

    @Resource
    private QuestionService questionService;

    /**
     * 点赞
     *
     * @param
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        //校验编程语言是否合法
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"编程语言错误");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交题目
        long userId = loginUser.getId();
        // 每个用户串行点赞
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setLanguage(language);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setUserId(userId);
        //设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save) {
            throw  new BusinessException(ErrorCode.SYSTEM_ERROR,"数据插入失败");
        }
        return questionSubmit.getId();
//        // 锁必须要包裹住事务方法
//        QuestionSubmitService questionThumbService = (QuestionSubmitService) AopContext.currentProxy();
//        synchronized (String.valueOf(userId).intern()) {
//            return questionThumbService.doQuestionSubmitInner(userId, questionId);
//        }
    }

//    /**
//     * 封装了事务的方法
//     *
//     * @param userId
//     * @param questionId
//     * @return
//     */
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int doQuestionSubmitInner(long userId, long questionId) {
//        QuestionSubmit questionThumb = new QuestionSubmit();
//        questionThumb.setUserId(userId);
//        questionThumb.setQuestionId(questionId);
//        QueryWrapper<QuestionSubmit> thumbQueryWrapper = new QueryWrapper<>(questionThumb);
//        QuestionSubmit oldQuestionSubmit = this.getOne(thumbQueryWrapper);
//        boolean result;
//        // 已点赞
//        if (oldQuestionSubmit != null) {
//            result = this.remove(thumbQueryWrapper);
//            if (result) {
//                // 点赞数 - 1
//                result = questionService.update()
//                        .eq("id", questionId)
//                        .gt("thumbNum", 0)
//                        .setSql("thumbNum = thumbNum - 1")
//                        .update();
//                return result ? -1 : 0;
//            } else {
//                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
//            }
//        } else {
//            // 未点赞
//            result = this.save(questionThumb);
//            if (result) {
//                // 点赞数 + 1
//                result = questionService.update()
//                        .eq("id", questionId)
//                        .setSql("thumbNum = thumbNum + 1")
//                        .update();
//                return result ? 1 : 0;
//            } else {
//                throw new BusinessException(ErrorCode.SYSTEM_ERROR);
//            }
//        }
//    }
}




