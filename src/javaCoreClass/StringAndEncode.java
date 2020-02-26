package javaCoreClass;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Java字符串String是不可变对象；
 * 字符串操作不改变原字符串内容，而是返回新字符串
 * 常用的字符串操作：提取子串substract、查找indexof、替换replace、大小写转换
 * Java使用Unicode编码表示String和char
 * 转换编码就是将String和byte[]转换，需要制定编码格式
 * 转换为byte[]时，始终优先考虑UTF-8编码
 */
public class StringAndEncode {

    public static void main(String[] args) throws UnsupportedEncodingException {

        /*
        从表面上看，两个字符串用==和equals()比较都为true，但实际上那只是Java编译器在编译期，
        会自动把所有相同的字符串当作一个对象放入常量池，自然s1和s2的引用就是相同的。
        所以，这种==比较返回true纯属巧合。
         */
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        "Hello".contains("ll");
        "Hello".indexOf("l");//找l的位置
        "Hello".lastIndexOf("l");//找最后一个l的位置
        "Hello".startsWith("He");
        "Hello".endsWith("lo");

        //索引号从0开始
        "Hello".substring(2);// llo
        "Hello".substring(2, 4);// ll

        //使用trim()移除字符串首尾空白字符，空白字符包括空格，\t,\r,\n
        System.out.println("  \tHello\r\n ".trim());

        //strip()也可以移除字符串首尾空白字符，但是类似中文的空格字符\u3000也会被移除
        //System.out.println("\u3000Hello\u3000".strip());

        //isEmpty和isBlank来判断字符串是否为空和空白字符串
        "".isEmpty();//true,因为字符串长度为0
        "  ".isEmpty();//false,因为长度不为0

        //isBlank()在java11中引入
        //"  \n".isBlank();//true,因为只包含空白字符
        //" Hello".isBlank();//false,因为包含非空白字符

        /*
        替换子串，要在字符串中替换子串，有两种方法。
        一种是根据字符或字符串替换：
        另一种是通过正则表达式替换：
         */
        String s11 = "hello";
        s11.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s11.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"

        String s12 = "A,,B;C ,D";
        s12.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

        /*
        分割字符串：使用split()方法，并且传入的也是正则表达式：
         */
        String s13 = "A,B,C,D";
        String[] ss = s13.split("\\,"); // {"A", "B", "C", "D"}

        /*
        类型转换：要把任意基本类型或引用类型转换为字符串，可以使用静态方法valueOf()。
        这是一个重载方法，编译器会根据参数自动选择合适的方法：

        要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为int类型：
         */
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255

        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false

        //要特别注意，Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        Integer.getInteger("java.version"); // 版本号，11


        /*
        String与char[]的互相转换,如果修改了char[]数组，String并不会改变：
         */
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s = new String(cs); // char[] -> String


        /*
        关于UTF-8:
        因为英文字符的Unicode编码高字节总是00，包含大量英文的文本会浪费空间，
        所以，出现了UTF-8编码，它是一种变长编码，用来把固定长度的Unicode编码变成1～4字节的变长编码。
        通过UTF-8编码，英文字符'A'的UTF-8编码变为0x41，正好和ASCII码一致，而中文'中'的UTF-8编码为3字节0xe4b8ad。

        UTF-8编码的另一个好处是容错能力强。如果传输过程中某些字符出错，不会影响后续字符，
        因为UTF-8编码依靠高字节位来确定一个字符究竟是几个字节，它经常用来作为传输编码。
         */
        byte[] b11 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b12 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b13 = "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] b14 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换

        byte[] b15 = {1,2,3};
        String s15 = new String(b15, "GBK"); // 按GBK转换
        String s26 = new String(b15, StandardCharsets.UTF_8); // 按UTF-8转换

        //始终牢记：Java的String和char在内存中总是以Unicode编码表示。
    }
}
