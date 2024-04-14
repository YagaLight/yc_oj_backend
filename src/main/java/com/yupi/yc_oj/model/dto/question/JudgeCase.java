package com.yupi.yc_oj.model.dto.question;

import lombok.Data;

/**
 * @author yang chao
 * @version 1.0
 * @date 2024/4/14 4:38
 **/
@Data
public class JudgeCase {

    /**
     * 题目用例
     */
    private String input;

    /**
     * 输出时间
     */
    private String output;
}
