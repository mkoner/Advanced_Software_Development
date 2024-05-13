package lab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Manager extends Hire{
    private double bonus;
    List<Hire> hires = new ArrayList<>();
    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public void accept(Consumer<Hire> action) {
        action.accept(this);
        for (Hire hire : hires) {
            hire.accept(action);
        }
    }
    public void addHire(Hire hire) {
        hires.add(hire);
    }
    public void removeHire(Hire hire) {
        hires.remove(hire);
    }
    public double getSalary(){
        return bonus + super.getSalary();
    }
    public double getBonus(){
        return bonus;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    public void print() {
        System.out.println("==================Hire info==========");
        System.out.println("Name: " + getName());
        System.out.println("Base Salary: " + getBaseSalary());
        System.out.println("Bonus: " + getBonus());
        System.out.println("Total Salary: " + getSalary());
    }
}
