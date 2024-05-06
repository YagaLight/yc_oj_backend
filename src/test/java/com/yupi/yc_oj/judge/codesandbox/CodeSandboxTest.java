package com.yupi.yc_oj.judge.codesandbox;


import com.yupi.yc_oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.yupi.yc_oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.yupi.yc_oj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CodeSandboxTest {

    @Value("${codesandbox.type:example}")
    private String type;


    @Test
    void executeJAVACodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "import java.util.Scanner;\n" +
                "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Scanner cin=new Scanner(System.in);\n" +
                "        int a = cin.nextInt();\n" +
                "        int b = cin.nextInt();\n" +
                "        System.out.println(\"结果是：\"+(a + b));\n" +
                "    }\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }


    @Test
    void executeCCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int a,b;\n" +
                "    scanf(\"%d %d\",&a, &b);\n" +
                "    printf(\"%d\\n\",a+b);\n" +
                "    return 0;\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.C.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }


    @Test
    void executeCPLUSPLUSCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "#include <iostream>\n" +
                "using namespace std;\n" +
                "int main()\n" +
                "{\n" +
                "    int a,b;\n" +
                "    cin >> a >> b;\n" +
                "    cout << a+b << endl;\n" +
                "    return 0;\n" +
                "}";
        String language = QuestionSubmitLanguageEnum.CPLUSPLUS.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }


    @Test
    void executePythonCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String code = "# 读取输入的两个整数\n" +
                "a, b = map(int, input().split())\n" +
                "# 输出它们的和\n" +
                "print(a + b)";
        String language = QuestionSubmitLanguageEnum.PYTHON.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }

}
