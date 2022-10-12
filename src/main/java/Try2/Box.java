package Try2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Box<T extends Fruit>{
    private int weight;
    private ArrayList<T> box = new ArrayList<>();

    public boolean compare(Box<? extends Fruit> e) {
        return this.weight==e.weight;
    }

    public void moveFruit(Box<T> boxIn,Box<T> boxOut) {
        for (T t : boxIn.box) {
            boxOut.addFruit(t);
        }
        boxIn.weight=0;
        boxIn.box.clear();
    }

    private void addFruit(T b) {
        weight+=b.getWeight();
        box.add(b);
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Box<Apple> box1 = new Box<>();
        box1.addFruit(apple1);
        box1.addFruit(apple2);


        Box<Orange> box2 = new Box<>();
        box2.addFruit(new Orange());

        System.out.println(box1.weight);
        System.out.println(box2.weight);
        System.out.println(box1.compare(box2));

        Box<Apple> box3 = new Box<>();
        box3.addFruit(new Apple());
        box3.addFruit(new Apple());
        box3.addFruit(new Apple());

        box1.moveFruit(box1, box3);

        System.out.println(box1.weight);
        System.out.println(box3.weight);

    }
}
