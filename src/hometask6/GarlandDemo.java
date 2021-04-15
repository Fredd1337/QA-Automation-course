package hometask6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
            lamps.add(new Lamp(LightState.values()[new Random().nextInt(LightState.values().length)]) {
            });
    }
}

class ColorGarland extends Garland {

    public ColorGarland() {
        for (int i = 0; i < lampsCount; i++)
            lamps.add(new ColorLamp(LightState.values()[new Random().nextInt(LightState.values().length)],
                    LightColor.values()[new Random().nextInt(LightColor.values().length)]) {
            });
    }
}

class Lamp {
    public LightState state;

    public Lamp(LightState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Lamp " + "State = " + state;
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
        return "Color = " + color + " , State = " + state;
    }
}

enum LightColor {Red, Yellow, Green, Blue}
enum LightState {On, Off}