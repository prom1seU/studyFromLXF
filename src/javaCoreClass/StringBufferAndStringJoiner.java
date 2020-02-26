package javaCoreClass;

import java.util.StringJoiner;

/**
 * StringBuilder是可变对象，可用来高效拼接字符串；
 * StringBuilder可以支持链式操作，实现链式操作的关键是返回自身；
 * StringBuffer是StringBuilder的线程安全版本，现在很少用
 */
public class StringBufferAndStringJoiner {

    /*
    StringBuilder:
        对于普通的字符串+操作，并不需要我们将其改写为StringBuilder，
        因为Java编译器在编译时就自动把多个连续的+操作编码为StringConcatFactory的操作。
        在运行期，StringConcatFactory会自动把字符串连接操作优化为数组复制或者StringBuilder操作。
     */
    public static void main(String[] args) {

        /*
        为了能高效拼接字符串，Java标准库提供了StringBuilder，它是一个可变对象，可以预分配缓冲区，
        这样，往StringBuilder中新增字符时，不会创建新的临时对象
         */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(",");
            sb.append(i);
        }
        String s = sb.toString();

        //StringBuilder还可以进行链式操作：
        StringBuilder sb2 = new StringBuilder(1024);
        sb2.append("Mr ")
                .append("Bob")
                .append("!")
                .insert(0, "Hello, ");
        System.out.println(sb2.toString());

        Adder adder = new Adder();
        adder.add(3)
                .add(5)
                .inc()
                .add(10);
        System.out.println(adder.value());


        /*
        StringJoiner:
            类似用分隔符拼接数组的需求很常见，所以Java标准库还提供了一个StringJoiner来干这个事：
            用StringJoiner的结果少了前面的"Hello "和结尾的"!"！遇到这种情况，需要给StringJoiner指定“开头”和“结尾”
         */
        String[] names = {"Bob", "Alice", "Grace"};
        StringJoiner sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        /*
        String还提供了一个静态方法join()，这个方法在内部使用了StringJoiner来拼接字符串，
        在不需要指定“开头”和“结尾”的时候，用String.join()更方便：
         */
        String[] names2 = {"Bob", "Alice", "Grace"};
        String s2 = String.join(", ", names);
    }

}

class Adder {
    private int sum = 0;

    public Adder add(int n) {
        sum += n;
        return this;
    }

    public Adder inc() {
        sum ++;
        return this;
    }

    public int value() {
        return sum;
    }
}
