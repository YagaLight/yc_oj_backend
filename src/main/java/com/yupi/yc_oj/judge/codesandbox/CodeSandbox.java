package com.yupi.yc_oj.judge.codesandbox;


import com.yupi.yc_oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.yc_oj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);


    /**
     * 查看代码沙箱状态
     */
}
