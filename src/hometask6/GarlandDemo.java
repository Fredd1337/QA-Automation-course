package hometask6;

import java.util.ArrayList;
import java.util.List;

public class GarlandDemo {
    public static void main(String[] args) {

        System.out.println("Простая гирлянда: ");
        SimpleGarland sg = new SimpleGarland();
        sg.printState();

        System.out.println("Цветная гирлянда: ");
        ColorGarland cg = new ColorGarland();
        cg.printState();
    }
}


abstract class Garland {
    public List<Lamp> lamps = new ArrayList<>();
    int lampsCount = 10;

    public void printState() {
        for (Lamp lamp : lamps)
            System.out.println(lamp);
    }
}

class SimpleGarland extends Garland {

    public SimpleGarland() {
        for (int i = 0; i < lampsCount; i++)
            lamps.add(new Lamp() {
                LightState[] State = LightState.values(); //не понятно как присвоить enum значение каждому элементу массива
            });
    }
}

class ColorGarland extends Garland {

    public ColorGarland() {
        for (int i = 0; i < lampsCount; i++)
            lamps.add(new ColorLamp() {
                LightState[] State = LightState.values(); //не понятно как присвоить enum значение каждому элементу массива
                LightColor[] Color = LightColor.values(); //не понятно как присвоить enum значение каждому элементу массива
                    });
    }
}

class Lamp {
    public LightState State;

    @Override
    public String toString() {
        return "Lamp{" +
                "State=" + State +
                '}';
    }
}

class ColorLamp extends Lamp {
    public LightColor Color;

    @Override
    public String toString() {
        return "ColorLamp{" +
                "Color=" + Color +
                '}';
    }
}

enum LightColor { Green, Red, Yellow, Blue };
enum LightState { Off, On };