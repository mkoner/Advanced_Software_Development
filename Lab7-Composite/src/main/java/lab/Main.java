package lab;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Hire ceo = new Manager("CEO", 12, 3);
        Hire salesManager = new Manager("SalesManager", 10, 2);
        Hire salesMan = new Employee("salesMan", 8);
        ceo.addHire(salesManager);
        salesManager.addHire(salesMan);
        Consumer<Hire> printHire = Hire::print;
        ceo.accept(printHire);
        System.out.println();
        System.out.println();
        HireCounterConsumer hireCounter = new HireCounterConsumer();
        ceo.accept(hireCounter);
        System.out.println("Number of employees: " + hireCounter.getCounter());
        CalculateSalaryConsumer calculateSalary = new CalculateSalaryConsumer();
        ceo.accept(calculateSalary);
        System.out.println("Total Salary: " + calculateSalary.getTotalSalary());
    }
}