package javaPrecedualBasic;

import java.util.Scanner;


public class InputAndOutput {

    public static void main(String[] args) {
        //control + enter = 生成constructor getter setter
        //option + enter = 生成local variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your name");
        String name = scanner.nextLine();
        System.out.println("input your age");
        int age = scanner.nextInt();
        System.out.printf("Hi, %s, you are %d\n", name, age);


        /*
        Java的格式化功能提供了多种占位符，可以把各种数据类型“格式化”成指定的字符串：

        占位符	说明
        %d	格式化输出整数
        %x	格式化输出十六进制整数
        %f	格式化输出浮点数
        %e	格式化输出科学计数法表示的浮点数
        %s	格式化字符串
        注意，由于%表示占位符，因此，连续两个%%表示一个%字符本身。
         */
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数
    }
}
