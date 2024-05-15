package lab;

public class Car{
    GearState gearLevel1;
    GearState gearLevel2;
    GearState gearLevel3;
    GearState gearLevel4;
    GearState gearLevel5;

    GearState currentGearLevel;

    public Car(){
        gearLevel1 = new GearLevel1(this);
        gearLevel2 = new GearLevel2(this);
        gearLevel3 = new GearLevel3(this);
        gearLevel4 = new GearLevel4(this);
        gearLevel5 = new GearLevel5(this);
        currentGearLevel = gearLevel1;
    }
    public int changeSpeed(int speed){
        if (speed == 0) {
            return 0;
        } else {
            if (speed > 0 && speed < 5) {
                return 1;
            } else {
                if (speed > 5 && speed < 10) {
                    return 2;
                } else {
                    if (speed > 10 && speed < 30) {
                        return 3;
                    } else {
                        if (speed > 30 && speed < 55) {
                            return 4;
                        } else {
                            if (speed > 55 ) {
                                return 5;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
