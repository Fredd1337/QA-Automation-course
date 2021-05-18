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

    private static String lightColor;
    private static String lightState;

    public static LightState setLightState(int lampsCount) {

        Calendar calendar = new GregorianCalendar();
        int date = calendar.get(Calendar.MINUTE);

        boolean[] array1 = new boolean[lampsCount];

        if (date % 2 == 0) {

            for (int i = 0; i < array1.length; i = i + 2) {
                array1[i] = true;
            }
            for (boolean b : array1) {
                System.out.println(b);
            }
        }
        if (date % 2 != 0) {

            for (int i = 1; i < array1.length; i = i + 2) {
                array1[i] = true;
            }
            for (boolean b : array1) {
                System.out.println(b);
            }
        }
        return LightState.valueOf(lightState);
    }

    public static LightColor setColor(int lampsCount) {
        String[] array2 = new String[lampsCount];
        for (int i = 0; i < array2.length; i++) {
            array2[0] = "RED";
            array2[1] = "YELLOW";
            array2[2] = "GREEN";
            array2[3] = "BLUE";
        }
        for (String c : array2) {
            System.out.println(c);
        }
        return LightColor.valueOf(lightColor);
    }
}
enum LightColor {RED, YELLOW, GREEN, BLUE}
enum LightState {ON, OFF}