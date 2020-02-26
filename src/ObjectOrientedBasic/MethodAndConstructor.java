package ObjectOrientedBasic;

/*
    方法可以让外部代码安全地访问实例字段；

    方法是一组执行语句，并且可以执行任意逻辑；

    方法内部遇到return时返回，void表示不返回任何值（注意和返回null不同）；

    外部代码通过public方法操作实例，内部代码可以调用private方法；

    理解方法的参数绑定。
 */
public class MethodAndConstructor {

    public static void main(String[] args) {
        Person p = new Person();
        //p.age = 11;
        p.name = "ss";
    }
}


//私有属性private yield
class Person {
    public String name;
    private int age;
}

//私有方法private method
class Person2 {
    private String name;
    private int birth;

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getAge() {
        return calcAge(2019); // 调用private方法
    }

    // private方法:
    private int calcAge(int currentYear) {
        return currentYear - this.birth;
    }

}

//可变参数
class Group {
    private String[] names;

    //可变参数可以保证无法传入null，因为传入0个参数时，接收到的实际值是一个空数组而不是null
    public void setNames(String... names) {
        this.names = names;
    }

    public static void test(){

    }

    /*
    只能在方法中对实例的方法进行调用
     */
    public static void main(String[] args) {
        Group.test();
        Group g = new Group();
        g.setNames(new String[] {"Xiao Ming", "Xiao Hong", "Xiao Jun"}); // 传入1个String[]
        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
        g.setNames("Xiao Ming", "Xiao Hong"); // 传入2个String
        g.setNames("Xiao Ming"); // 传入1个String
        g.setNames(); // 传入0个String
    }

    /*
    关于值的传递：
    1.基本类型参数的传递，是调用方值的复制。双方各自的后续修改，互不影响。
    2.引用类型参数的传递，调用方的变量，和接收方的参数变量，指向的是同一个对象。双方任意一方对这个对象的修改，都会影响对方（因为指向同一个对象嘛）
     */

}
