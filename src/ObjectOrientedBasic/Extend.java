package ObjectOrientedBasic;

/*
继承是面向对象编程的一种强大的代码复用方式；

Java只允许单继承，所有类最终的根类是Object；

protected允许子类访问父类的字段和方法；*

子类的构造方法可以通过super()调用父类的构造方法；

可以安全地向上转型为更抽象的类型；

可以强制向下转型，最好借助instanceof判断；*

子类和父类的关系是is，has关系不能用继承。
 */
public class Extend {

    public static void main(String[] args) {
        /*
        Person类型p1实际指向Student实例，Person类型变量p2实际指向Person实例。
        在向下转型的时候，把p1转型为Student会成功，因为p1确实指向Student实例，
        把p2转型为Student会失败，因为p2的实际类型是Person，不能把父类变为子类，
        因为子类功能比父类多，多的功能无法凭空变出来。
         */
        Person p1 = new Student(); // upcasting, ok
        Person p2 = new Person();
        Student s1 = (Student) p1; // ok
        Student s2 = (Student) p2; // runtime error! ClassCastException!

        /*
        instanceof实际上判断一个变量所指向的实例是否是指定类型，或者这个类型的子类。
        如果一个引用变量为null，那么对任何instanceof的判断都为false
         */
        Person p = new Person();
        System.out.println(p instanceof Person); // true
        System.out.println(p instanceof Student); // false

        Student s = new Student();
        System.out.println(s instanceof Person); // true
        System.out.println(s instanceof Student); // true

        Student n = null;
        System.out.println(n instanceof Student); // false
    }

}

class Student extends Person {
    protected int score;

    public Student() {

    }

    public Student(String name, int age, int score) {
        this.score = score;
    }
}


