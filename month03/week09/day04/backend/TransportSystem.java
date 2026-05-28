import java.util.Scanner;

class Transport {
    private String name;
    private int speed;
    private int capacity;
    int distance = 100;

    Transport(String name, int speed, int capacity) {
        this.name = name;
        this.speed = speed;
        this.capacity = capacity;
    }

    void move() {
        System.out.println(name + " is moving.");
    }

    void showInfo() {
        System.out.println(getClass().getSimpleName() + " : " + name);
        System.out.println("Speed: " + speed);
        System.out.println("Capacity: " + capacity);
    }

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    int getCapacity() {
        return capacity;
    }

    double tripTime(double distance) {
        return distance / speed;
    }

}

class Car extends Transport {
    String fuel;

    Car(String name, int speed, int capacity, String fuel) {
        super(name, speed, capacity);
        this.fuel = fuel;
    }

    @Override
    void move() {
        System.out.println(getName() + " departed using " + fuel);
    }
}

class Bus extends Transport {
    int routeNumber;

    Bus(String name, int speed, int capacity, int routeNumber) {
        super(name, speed, capacity);
        this.routeNumber = routeNumber;
    }

    @Override
    void move() {
        System.out.println("Bus on " + getName() + " route " + routeNumber + " departed.");
    }
}

class Train extends Transport {
    int carriages;

    Train(String name, int speed, int capacity, int carriages) {
        super(name, speed, capacity);
        this.carriages = carriages;
    }

    @Override
    void move() {
        System.out.println("Train on " + getName() + " line with " + carriages + " carriages departed.");
    }
}

public class TransportSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Transport[] list = new Transport[100];
        int sel;
        int i = 0;

        do {
            System.out.println("======================");
            System.out.println("1. Create Car");
            System.out.println("2. Create Bus");
            System.out.println("3. Create Train");
            System.out.println("4. All Transport Information");
            System.out.println("0. Exit");
            System.out.println("=====================");

            System.out.println("Input number pls: ");
            sel = sc.nextInt();
            sc.nextLine();

            switch (sel) {
                case 0:
                    break;

                case 1:
                    System.out.println("Input Car Name: ");
                    String carName = sc.nextLine();

                    System.out.println("Input Speed: ");
                    int carSpeed = sc.nextInt();

                    System.out.println("Input Capacity: ");
                    int carCapacity = sc.nextInt();

                    System.out.println("Input Fuel: ");
                    sc.nextLine();
                    String fuel = sc.nextLine();

                    Car c = new Car(carName, carSpeed, carCapacity, fuel);
                    list[i] = c;
                    i++;

                    break;

                case 2:
                    System.out.println("Input Bus Name: ");
                    String busName = sc.nextLine();

                    System.out.println("Input Speed: ");
                    int busSpeed = sc.nextInt();

                    System.out.println("Input Capacity: ");
                    int busCapacity = sc.nextInt();

                    System.out.println("Input Route: ");
                    int routeNumber = sc.nextInt();

                    Bus b = new Bus(busName, busSpeed, busCapacity, routeNumber);
                    list[i] = b;
                    i++;

                    break;

                case 3:
                    System.out.println("Input Train Name: ");
                    String trainName = sc.nextLine();

                    System.out.println("Input Speed: ");
                    int trainSpeed = sc.nextInt();

                    System.out.println("Input Capacity: ");
                    int trainCapacity = sc.nextInt();

                    System.out.println("Input Carriages: ");
                    int carriages = sc.nextInt();

                    Train t = new Train(trainName, trainSpeed, trainCapacity, carriages);
                    list[i] = t;
                    i++;

                    break;

                case 4:
                    if (i == 0) {
                        System.out.println("No data found");
                        break;
                    } else {
                        for (int j = 0; j < i; j++) {
                            list[j].showInfo();
                            list[j].move();
                            System.out.println("---------------------");
                        }
                    }

                    Transport fastest = list[0];
                    for (int j = 1; j < i; j++) {
                        if (list[j].getSpeed() > fastest.getSpeed()) {
                            fastest = list[j];
                        }
                    }

                    System.out.println("Speedest car: " + fastest.getName() + " (" + fastest.getSpeed() + " kilo)"
                            + 100 / fastest.getSpeed());

                    break;

                default:
                    System.out.println("Invalid number");
            }

        } while (sel != 0);

        sc.close();
    }
}