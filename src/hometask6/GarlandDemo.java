package hometask6;

import java.util.*;

public class GarlandDemo {
    public static void main(String[] args) {

        System.out.println("Простая гирлянда: ");
        SimpleGarland sg = new SimpleGarland();
        sg.printState();
        System.out.println();

        System.out.println("Цветная гирлянда: ");
        ColorGarland cg = new ColorGarland();
        cg.printState();
    }
}

abstract class Garland {
    public List<Lamp> lamps = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    int lampsCount = sc.nextInt();

    public void printState() {
        for (Lamp lamp : lamps)
            System.out.println(lamp);
    }
}

class SimpleGarland extends Garland {

    public SimpleGarland() {
        for (int i = 0; i < lampsCount; i++) {
            lamps.add(new Lamp(Helper.setLightState(lampsCount)));
        }
    }
}

class ColorGarland extends Garland {

    public ColorGarland() {

        for (int i = 0; i < lampsCount; i++) {
            lamps.add(new ColorLamp(Helper.setLightState(lampsCount),
                    Helper.setColor(lampsCount)));
        }
    }
}

class Lamp {
    public LightState state;

    public Lamp(LightState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Lamp state = " + state.name();
    }
}

class ColorLamp extends Lamp {

    public LightColor color;

    public ColorLamp(LightState state, LightColor color) {
        super(state);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Lamp state = " + state.name() + " , Color = " + color.name();
    }
}

class Helper {
    public static LightState setLightState(int lampsCount) {

        Calendar calendar = new GregorianCalendar();
        int date = calendar.get(Calendar.MINUTE);

        if (date % 2 == 0) {
            return LightState.ON;
        }
        else {
            return LightState.OFF;
        }
    }

    public static LightColor setColor(int lampsCount) {
            switch (lampsCount){
                case 1:
                    return LightColor.RED;
                case 2:
                    return LightColor.YELLOW;
                case 3:
                    return LightColor.GREEN;
                case 4:
                    return LightColor.BLUE;
            }
        return null;
    }
}
enum LightColor {RED, YELLOW, GREEN, BLUE}
enum LightState {ON, OFF}