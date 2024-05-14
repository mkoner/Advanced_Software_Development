package lab;

import java.util.function.Consumer;

public class Employee extends Hire{
    public Employee(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public void accept(Consumer<Hire> action) {
        action.accept(this);
    }
}
