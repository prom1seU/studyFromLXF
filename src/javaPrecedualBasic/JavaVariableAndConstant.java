package javaPrecedualBasic;

/**
 * 变量与常量
 */
public class JavaVariableAndConstant {

    public static void main(String[] args) {
        /*
         对于整型变量，java只定义了带符号的整型，因此，最高位的bit表示符号位（0表示正，1表示负）
         byte: -128 ~ 127 (-2^7 ~ 2^7 -1)
         short: -32768 ~ 32767 (-2^15 ~ 2^15 - 1
         int: -2147483648 ~ 2147483647
         long: -9223372036854775808 ~ 9223372036854775807
         */
        int i = 2147483647;
        int i2 = -2147483648;
        int i3 = 2_000_000_000; // 加下划线更容易识别
        int i4 = 0xff0000; // 十六进制表示的16711680
        int i5 = 0b1000000000; // 二进制表示的512
        long l = 9000000000000000000L; // long型的结尾需要加L
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println(i5);
        System.out.println(l);

        /*
        对于float类型，需要加上f后缀。
        浮点数可表示的范围非常大，float类型可最大表示3.4x1038，而double类型可最大表示1.79x10308
         */
        float f1 = 3.14f;
        float f2 = 3.14e38f;//科学计数法 表示3.14*10^38
        double d = 1.79e308;
        double d2 = -1.79e308;
        double d3 = 4.9e-324;
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(d);
        System.out.println(d2);
        System.out.println(d3);

        /*
        Java语言对布尔类型的存储并没有做规定，因为理论上存储布尔类型只需要1 bit，
        但是通常JVM内部会把boolean表示为4字节整数
         */
        boolean b1 = true;
        boolean b2 = false;
        boolean isGreater = 5 > 3; // 计算结果为true
        int age = 12;
        boolean isAdult = age >= 18; // 计算结果为false

        /*
        字符类型char表示一个字符。Java的char类型除了可表示标准的ASCII外，
        还可以表示一个Unicode字符
         */
        char a = 'A';
        char zh = '中';
        System.out.println(a);
        System.out.println(zh);

        /*
        定义变量的时候，如果加上final修饰符，这个变量就会变成常量
        常量在定义时进行初始化后就不可再次赋值，再次赋值会导致编译错误。
         */
        final double PI = 3.14;
        double r = 5.0;
        double area = PI * r * r;

        /*
        要特别注意，整数由于存在范围限制，如果计算结果超出了范围，就会产生溢出，
        而溢出不会出错，却会得到一个奇怪的结果
         */
        int x = 2147483640;
        int y = 15;
        int sum = x + y;
        System.out.println(sum); // -2147483641

        /*
        位运算是按位进行与、或、非和异或的运算。
        与运算的规则是，必须两个数同时为1，结果才为1
        或运算的规则是，只要任意一个为1，结果就为
        非运算的规则是，0和1互换：
        异或运算的规则是，如果两个数不同，结果为1，否则为0：
         */
        int n1 = 0 & 0; // 0
        int n2 = 0 & 1; // 0
        int n3 = 1 & 0; // 0
        int n4 = 1 & 1; // 1

        int n5 = 0 | 0; // 0
        int n6 = 0 | 1; // 1
        int n7 = 1 | 0; // 1
        int n8 = 1 | 1; // 1

        int n9 = ~0; // 1
        int n10 = ~1; // 0

        int n11 = 0 ^ 0; // 0
        int n12 = 0 ^ 1; // 1
        int n13 = 1 ^ 0; // 1
        int n14 = 1 ^ 1; // 0

        //通过与运算，可以快速判断一个IP是否在给定的网段内。
        int ip1 = 167776589; // 00001010 00000000 00010001 01001101
        int ip2 = 167776512; // 00001010 00000000 00010001 00000000
        System.out.println(ip1 & ip2); // 167776512

        /*
        计算前n个自然数的和
        n = 100
         */
        int summ = 0;
        for(int j = 1; j <= 100; j++){
            summ = summ + j;
        }
        System.out.println(summ);
    }
}
