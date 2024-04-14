package com.yupi.yc_oj.model.dto.question;

/**
 * @author yang chao
 * @version 1.0
 * @date 2024/4/14 4:40
 **/

import lombok.Data;

/**
 * 题目配置
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private Long timeLimit;


    /**
     * 内存限制(KB)
     */
    private Long memoryLimit;


    /**
     * 堆栈限制(KB)
     */
    private Long stackLimit;
}
