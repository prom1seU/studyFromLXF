package javaPrecedualBasic;

public class WhileAndDowhile {

    //java的int类型有最大值，达到最大值后，再加1会变成负数，结果，意外退出了while循环
    public static void main(String[] args) {
        int sum = 0;
        int n = 1;
        while (n > 0) {
            sum = sum + n;
            n ++;
        }
        System.out.println(n); // -2147483648
        System.out.println(sum);
        WhileAndDowhile.sum();
    }

    //do-while实现1到100求和
    public static int sum(){
        int sum = 0;
        int n = 1;
        do {
            sum = sum + n;
            n ++;
        } while (n <= 100);
        System.out.println(sum);
        return sum;
    }
}
