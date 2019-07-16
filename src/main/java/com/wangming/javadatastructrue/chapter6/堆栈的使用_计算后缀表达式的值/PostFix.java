package com.wangming.javadatastructrue.chapter6.堆栈的使用_计算后缀表达式的值;

import java.util.Scanner;

/**
 * @Author: ming.wang
 * @Date: 2019/7/16 10:10
 * @Description:
 */
public class PostFix {
    public static void main(String[] args) {
        String exp, again;
        int result = 0;
        try {
            Scanner scanner = new Scanner(System.in);

            do {
                PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
                System.out.println("Enter a valid postfix expression: ");
                exp = scanner.nextLine();

                result = postfixEvaluator.evaluate(exp);

                System.out.println();
                System.out.println("That expression equas " + result);

                System.out.println("Evaluate other expression [Y/N]?");
                again = scanner.nextLine();
                System.out.println();
            } while (again.equals("y"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
