package javaPrecedualBasic;

public class ForLoop {

    public static void main(String[] args) {
        //错误用法
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=0; i<ns.length; i++) {
            System.out.println(ns[i]);
            i = i + 1;
        }

        //正确用法
        for (int i=0; i<ns.length; i=i+2) {
            System.out.println(ns[i]);
        }

        /*
        灵活使用for loop
         */
        // 不设置结束条件:
        for (int i=0; ; i++) {

        }
    }
}
