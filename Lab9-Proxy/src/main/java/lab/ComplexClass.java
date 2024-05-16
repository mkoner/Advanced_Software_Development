package lab;

public class ComplexClass implements ComplexInterface {
    public ComplexClass() throws InterruptedException {

        super();

        Thread.sleep(10000);

    }

    public void veryComplicatedTask() {

        System.out.println("Very complicated task...");

    }
}
