package javaPrecedualBasic;

import java.util.Scanner;

public class BreakAndContinue {

    public static void main(String[] args) {
        /*
        在循环过程中，可以使用break语句跳出当前循环。
         */
        int sum = 0;
        for (int i=1; ; i++) {
            sum = sum + i;
            if (i == 100) {
                break;
            }
        }
        System.out.println(sum);

        //要特别注意，break语句总是跳出自己所在的那一层循环
        for (int i=1; i<=10; i++) {
            System.out.println("i = " + i);
            for (int j=1; j<=10; j++) {
                System.out.println("j = " + j);
                if (j >= i) {
                    break;
                }
            }
            // break跳到这里
            System.out.println("breaked");
        }

        /*
        break会跳出当前循环，continue则是提前结束本次循环，直接执行下次循环
         */
        int sum2 = 0;
        for (int i=1; i<=10; i++) {
            System.out.println("begin i = " + i);
            if (i % 2 == 0) {
                continue; // continue语句会结束本次循环
            }
            sum2 = sum2 + i;
            System.out.println("end i = " + i);
        }
        System.out.println(sum2); // 25

        /*
        当我们需要跳出或结束多重循环时，除了在每一个循环体后面加一个break（continue）外，还可以通过label（标号）跳出多重循环（有点类似与goto语句）
         */
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        //使用label（标号）跳出多重循环
        /*
        关键点：1.amount / *的结果是整数
               2.每次进入内层循环会重新复制变量，即变量归零
         */
        OUT:
        for (int one = 0; one <= amount; ++one) {
            System.out.println(one);
            for (int five = 0; five <= amount / 5; ++five) {
                System.out.println(five);
                for (int ten = 0; ten <= amount / 10; ++ten) {
                    System.out.println(ten);
                    for (int twenty = 0; twenty <= amount / 20; ++twenty) {
                        System.out.println(twenty);
                        if (one + five * 5 + ten * 10 + twenty * 20 == amount) {
                            System.out.println(one + "张1元，" + five + "张5元，" + ten + "张10元，" + twenty + "张20元。");
                            break OUT;  //此break可以跳出整个多重循环
                        }
                    }
                }
            }
        }

        System.out.println("---------------------------");
        int amount2 = 5;
        for (int one = 0; one <= amount2; ++one) {
            System.out.println("one = " + one);
            for (int five = 0; five <= amount2 / 5; ++five) {
                System.out.println("five =" + five);
            }
        }
    }
}
