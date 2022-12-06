package hw;

import java.util.Scanner;

// James Ding
public class Ship {

    public final String name;
    public final int size;
    public final int[] locations;

    public Ship(String name, int size, int[] locations) {
        this.name = name;
        this.size = size;
        this.locations = locations;
    }

    private static String getName(char c) {
        switch (c) {
            case 'B':
                return "Battleship";
            case 'C':
                return "Carrier";
            case 'S':
                return "Submarine";
            case 'P':
                return "Patrol";
            default:
                return "Unknown";
        }
    }

    private static int getSize(char c) {
        switch (c) {
            case 'B':
                return 4;
            case 'C':
                return 5;
            case 'S':
                return 3;
            case 'P':
                return 2;
            default:
                return 0;
        }
    }

    private static int[] decodeCoordinate(String s) {
        int row = Integer.parseInt(s.charAt(0) + "");
        int col = Integer.parseInt(s.charAt(1) + "");
        return new int[] {row, col};
    }

    private static int[] getLocationFromOrientation(char orientation, int size, int[] location) {
        switch (orientation) {
            case 'H':
                return new int[] {location[0], location[1] + size - 1};
            case 'V':
                return new int[] {location[0] + size - 1, location[1]};
            default:
                throw new IllegalArgumentException("Invalid orientation");
        }
    }

    private static int serializeLocation(int[] location) {
        return location[0] * 10 + location[1];
    }

    public Ship(String data) {
        char nameChar = data.charAt(0);
        this.name = getName(nameChar);

        this.size = getSize(nameChar);
        char orientation = data.charAt(3);
        int[] loc1 = decodeCoordinate(data.substring(1, 3));
        int[] loc2 = getLocationFromOrientation(orientation, getSize(nameChar), loc1);
        this.locations = new int[] {serializeLocation(loc1), serializeLocation(loc2)};
    }

    public int[] getCoordinate(int index) {
        return new int[] {locations[index] / 10, locations[index] % 10};
    }

    public static String coordinateToString(int[] coordinate) {
        return "(" + coordinate[0] + ", " + coordinate[1] + ")";
    }

    @Override
    public String toString() {
        return name + " is at " + coordinateToString(getCoordinate(0)) + " " + coordinateToString(getCoordinate(1));
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter ship data: ");
            Ship s = new Ship(kb.nextLine());
            System.out.println(s);
        }
    }

}
