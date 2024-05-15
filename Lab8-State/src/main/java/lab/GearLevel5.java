package lab;

public class GearLevel5 implements GearState{
    private Car car;

    public GearLevel5(Car car) {
        this.car = car;
    }

    @Override
    public int getGear() {
        return 5;
    }
}
