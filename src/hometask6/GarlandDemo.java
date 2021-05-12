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
        for (int i = 0; i < lampsCount; i++)
            lamps.add(new Lamp(Helper.setLightState()));
    }
}

class ColorGarland extends Garland {

    public ColorGarland() {

        for (int i = 0; i < lampsCount; i++)
            lamps.add(new ColorLamp(Helper.setLightState(),
                    Helper.setColor()));

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
    public static Enum lightColor;
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

    public static LightState setLightState() {

        Calendar calendar = new GregorianCalendar();
        int date = calendar.get(Calendar.MINUTE);

        String lightState;
        if (date % 2 == 0) {
            lightState = "ON";
            return LightState.valueOf(lightState);
        }
        lightState = "OFF";
        return LightState.valueOf(lightState);
    }

    public static LightColor setColor() {
            switch (ColorLamp.lightColor) {
                case RED:
                    return LightColor.RED;
                case BLUE:
                    return LightColor.BLUE;
                case GREEN:
                    return LightColor.GREEN;
                case YELLOW:
                    return LightColor.YELLOW;
            }

    }
}

enum LightColor {RED, YELLOW, GREEN, BLUE}
enum LightState {ON, OFF}