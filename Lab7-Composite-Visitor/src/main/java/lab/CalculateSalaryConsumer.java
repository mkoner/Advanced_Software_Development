package lab;

import java.util.function.Consumer;

public class CalculateSalaryConsumer implements Consumer<Hire> {
    private double totalSalary = 0;
    @Override
    public void accept(Hire hire) {
        totalSalary += hire.getSalary();
    }
    public double getTotalSalary() {
        return totalSalary;
    }
}
