package ObjectOrientedBasic;

/**
 * 子类可以覆写父类的方法（Override），覆写在子类中改变了父类方法的行为；
 *
 * Java的方法调用总是作用于运行期对象的实际类型，这种行为称为多态；
 *      多态即对父类进行初始化时，将父类对象指向子类对象，这时对父类对象调用方法会默认调用子类的方法，
 *      能允许添加更多类型的子类实现功能扩展，不缺不需要修改基于父类的代码
 *
 * final修饰符有多种作用：
 *
 * final修饰的方法可以阻止被覆写；
 *
 * final修饰的class可以阻止被继承；
 *
 * final修饰的field必须在创建对象时初始化，随后不可修改。
 */
public class Polymorphic {

    public static void main(String[] args) {
        Income[] incomes = new Income[] {
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));

    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }

}

class Income {
    protected double income;

    public Income(double income) {
        this.income = income;
    }

    public double getTax(){
        return income * 0.1;
    }
}

class Salary extends Income {
    public Salary(double income) {
        super(income);
    }

    @Override
    public double getTax(){
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }

    //public abstract  void test();compile error :abstact method should be in abstract class

}

class StateCouncilSpecialAllowance extends Income {
    public StateCouncilSpecialAllowance(double income) {
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}
