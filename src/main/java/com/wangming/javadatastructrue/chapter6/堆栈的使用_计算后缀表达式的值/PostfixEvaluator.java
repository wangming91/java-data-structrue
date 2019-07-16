package com.wangming.javadatastructrue.chapter6.堆栈的使用_计算后缀表达式的值;

import com.wangming.javadatastructrue.chapter6.链接实现.LinkedStack;

import java.util.StringTokenizer;

/**
 * @Author: ming.wang
 * @Date: 2019/7/15 17:34
 * @Description:
 */
public class PostfixEvaluator {
    private final char ADD = '+', SUB = '-', MUL = '*', DIV = '/';

    private LinkedStack<Integer> stack;

    public PostfixEvaluator() {
        this.stack = new LinkedStack<>();
    }

    public int evaluate(String exp) {
        int op1, op2, result = 0;

        String token;
        StringTokenizer tokenizer = new StringTokenizer(exp);

        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            if (isOprator(token)) {
                op2 = stack.pop();
                op1 = stack.pop();
                result = evaSingleOp(token.charAt(0), op1, op2);
                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return result;
    }

    private boolean isOprator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private int evaSingleOp(char opration, int op1, int op2) {
        int result = 0;
        switch (opration) {
            case ADD:
                result = op1 + op2;
                break;
            case SUB:
                result = op1 - op2;
                break;
            case MUL:
                result = op1 * op2;
                break;
            case DIV:
                result = op1 / op2;
                break;
        }
        return result;
    }
}
