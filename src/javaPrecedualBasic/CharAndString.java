package javaPrecedualBasic;

/**
 * Java的字符类型char是基本类型，字符串类型String是引用类型；
 *
 * 基本类型的变量是“持有”某个数值，引用类型的变量是“指向”某个对象；
 *
 * 引用类型的变量可以是空值null；
 *
 * 要区分空值null和空字符串""。
 */
public class CharAndString {

    public static void main(String[] args) {
        /*
        Java在内存中总是使用Unicode表示字符，所以，一个英文字符和一个中文字符都用一个char类型表示，
        它们都占用两个字节。要显示一个字符的Unicode编码，只需将char类型直接赋值给int类型即可：
         */
        char c1 = 'A';
        char c2 = '中';

        int n1 = 'A';
        int n2 = '中';
        System.out.println(n1);//65
        System.out.println(n2);//20013

        //还可以直接用转义字符反斜杠u+Unicode编码来表示一个字符：
        char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
        char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013

        /**
            常见的转义字符包括：
            \" 表示字符"
            \' 表示字符'
            \\ 表示字符\
            \n 表示换行符
            \r 表示回车符
            \t 表示Tab
         */
        String s = "abc\"xyz";// 包含7个字符: a, b, c, ", x, y, z
        String s2 = "ABC\n\u4e2d\u6587";//// 包含6个字符: A, B, C, 换行符, 中, 文

        //将一组int值视为字符的Unicode编码，然后将它们拼成一个字符串：
        int a = 72;
        int b = 105;
        int c = 65281;
        // FIXME:
        String abc = "" + (char)a + (char)b + (char)c;
        System.out.println(abc);
    }

}
