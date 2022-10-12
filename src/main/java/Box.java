import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box>{
    private List<T> fruit;
    private double weight;
    private T check;

    public Box() {
        fruit = new ArrayList<>();
    }


    @Override
    public int compareTo(Box o) {
        if(this.weight > o.weight) return 1;
        else if(this.weight<o.weight) return -1;
        else return 0;
    }
    void chageBox(Box<T> boxIn,Box<T> boxOut) {
        boxOut.fruit.addAll((Collection<? extends T>) boxIn); // Тут возможен рантайм эксепшн
    }

    void weightUpdate() {
        if(check instanceof Orange) weight+=Orange.weigth;
        if(check instanceof Apple) weight+= Apple.weigth;
    }

    void addFruit(T fruit) {
        this.fruit.add(fruit);
    }

    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple1);
        appleBox.addFruit(apple2);
        appleBox.weightUpdate();
        System.out.println(appleBox.weight);
        // appleBox.addFruit(orange1); Compile error
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange1);
        orangeBox.weightUpdate();
        System.out.println(orangeBox.weight);
        System.out.println(orangeBox.compareTo(appleBox)); //
    }
}
