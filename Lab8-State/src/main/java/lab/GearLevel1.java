package lab;

public class GearLevel1 implements GearState{
    private Car car;

    public GearLevel1(Car car) {
        this.car = car;
    }

    @Override
    public int getGear() {
        return 1;
    }
}
