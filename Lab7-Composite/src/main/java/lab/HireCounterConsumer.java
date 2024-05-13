package lab;

import java.util.function.Consumer;

public class HireCounterConsumer implements Consumer<Hire> {
    private int counter = 0;
    @Override
    public void accept(Hire hire) {
        counter++;
    }
    public int getCounter() {
        return counter;
    }
}
