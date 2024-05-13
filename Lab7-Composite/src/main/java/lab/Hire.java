package lab;

import java.util.function.Consumer;

public abstract class Hire{
    private String name;
    private double baseSalary;
    public Hire(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }


    public void print() {
        System.out.println("==================Hire info==========");
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
    }

    public abstract void accept(Consumer<Hire> action);
    public void addHire(Hire hire) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void removeHire(Hire hire) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public double getSalary(){
        return baseSalary;
    }

}
