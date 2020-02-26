package javaPrecedualBasic;

/**
 * 浮点数运算总结：
 *  1、浮点数常常无法精确表示（主要是二进制转换带来的问题），并且浮点数的运算可能有误差
 *  2、比较两个浮点数通常比较他们的绝对值只差是否小于一个特定值
 *  3、整型和浮点型运算时，整型会自动提升为浮点型
 *  4、可以将浮点型强制转化为整型，但超出范围后将返回整型的最大值
 */
public class FloatOperation {

    public static void main(String[] args) {

        /*
        浮点数常常无法精确表示，因此，浮点数运算会产生误差：
        浮点数0.1在计算机中就无法精确表示，因为十进制的0.1换算成二进制是一个无限循环小数
         */
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x);
        System.out.println(y);

        /*
        由于浮点数存在运算误差，所以比较两个浮点数是否相等常常会出现错误的结果。
        正确的比较方法是判断两个浮点数之差的绝对值是否小于一个很小的数
         */
        double r = Math.abs(x - y);
        if(r < 0.00001) {
            System.out.println("is equal");
        } else {
            System.out.println("is not equal");
        }

        /*
        如果参与运算的两个数其中一个是整型，那么整型可以自动提升到浮点型：
         */
        int n = 5;
        double d = 1.2 + 24.0 / n; // 6.0
        System.out.println(d);

        /*
        在一个复杂的四则运算中，两个整数的运算不会出现自动提升的情况
         */
        double d2 = 1.2 + 24 / 5; // 5.2

        /*
        整数运算在除数为0时会报错，而浮点数运算在除数为0时，不会报错，但会返回几个特殊值：
         */
        double d3 = 0.0 / 0; // NaN (not a number)
        double d4 = 1.0 / 0; // Infinity （无穷大）
        double d5 = -1.0 / 0; // -Infinity （负无穷大）

        //强制转型
        int n1 = (int) 12.3; // 12
        int n2 = (int) 12.7; // 12
        int n3 = (int) -12.7; // -12
        int n4 = (int) (12.7 + 0.5); // 13
        int n5 = (int) 1.2e20; // 2147483647

        //如果要进行四舍五入，可以对浮点数加上0.5再强制转型：
        double d6 = 2.6;
        int n6 = (int) (d6 + 0.5);
        System.out.println(n6);

        /*
        计算一元二次方程的两个解
         */
        double a = 1.0;
        double b = 3.0;
        double c = -4.0;
        double r1 = (-b + Math.sqrt(b*b - 4*a*c)) / 2*a;
        double r2 = (-b - Math.sqrt(b*b - 4*a*c)) / 2*a;
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r1 == 1 && r2 == -4 ? "测试通过" : "测试失败");
    }
}
