package hw;

import java.util.ArrayList;
import java.util.List;

public class Hero implements Comparable {

    int power;

    public Hero(int power) {
        this.power = power;
    }

    public void powerUp(int n) {
        power += n;
    }

    @Override
    public int compareTo(Object o) {
        Hero h = (Hero) o;
        return this.power - h.power;
    }

    @Override
    public String toString() {
        return "Hero{" + "power=" + power + '}';
    }

    public static void main(String[] args) {
        Hero h1 = new Hero(5);
        Hero h2 = new Hero(3);
        List<Hero> heroes = new ArrayList<>();
        heroes.add(h1);
        heroes.add(h2);
        heroes.sort(null);
        System.out.println(heroes);
    }

}
