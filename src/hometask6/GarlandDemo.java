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
            lamps.add(new ColorLamp(Helper.setLightState()), //в этой строке ошибка
                    Helper.setColor());
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
    private static String lightColor;
    private static String lightState;

    public static LightState setLightState() {

        Calendar calendar = new GregorianCalendar();
        int date = calendar.get(Calendar.MINUTE);
        System.out.println(date);

        if (date%2==0) {
            lightState = "ON";
        }
        else
            lightState = "OFF";

        return LightState.valueOf(lightState);
    }

    public static LightColor setColor () {

        switch (lightColor) {
            case "RED":
                lightColor = "RED";
            case "YELLOW":
                lightColor = "YELLOW";
            case "GREEN":
                lightColor = "GREEN";
            case "BLUE":
                lightColor = "BLUE";
        }
        return LightColor.valueOf(lightColor);
    }
}

enum LightColor {RED, YELLOW, GREEN, BLUE}
enum LightState {ON, OFF}