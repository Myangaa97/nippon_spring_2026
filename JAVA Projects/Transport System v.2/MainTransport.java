import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transport {
    private int id;
    private String name;
    private int speed;
    private int capacity;

    public Transport(int id, String name, int speed, int capacity) {
        this.id = id;
        this.name = name;
        this.speed = speed;
        this.capacity = capacity;
    }

    public void move() {
        System.out.println(name + " departed.");
    }

    public void showInfo() {
        System.out.println("ID: " + id);
        System.out.println("Type : " + getClass().getSimpleName());
        System.out.println("Name : " + name);
        System.out.println("Speed : " + speed);
        System.out.println("Capacity : " + capacity);
    }

    public double tripTime(double distance) {
        if (speed <= 0) {
            return 0;
        }
        return distance / speed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Car extends Transport {
    private String fuel;

    public Car(int id, String name, int speed, int capacity, String fuel) {
        super(id, name, speed, capacity);
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Fuel: " + fuel);
    }

    @Override
    public void move() {
        System.out.println(getName() + " departed using " + fuel);
    }
}

class Bus extends Transport {
    private int routeNumber;

    public Bus(int id, String name, int speed, int capacity, int routeNumber) {
        super(id, name, speed, capacity);
        this.routeNumber = routeNumber;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Route: " + routeNumber);
    }

    @Override
    public void move() {
        System.out.println("Bus on " + getName() + " route " + routeNumber + " departed.");
    }
}

class Train extends Transport {
    private int carriages;

    public Train(int id, String name, int speed, int capacity, int carriages) {
        super(id, name, speed, capacity);
        this.carriages = carriages;
    }

    public int getCarriages() {
        return carriages;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Carriages: " + carriages);
    }

    @Override
    public void move() {
        System.out.println("Train on " + getName() + " line with " + carriages + " carriages departed.");
    }
}

public class MainTransport {

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause(Scanner sc) {
        System.out.println("Press Enter to continue...");
        sc.nextLine();
    }

    static void line() {
        System.out.println("========================================");
    }

    public static void main(String[] args) {

        List<Transport> transports = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sel;

        do {
            clearScreen();

            System.out.println("============ TRANSPORT SYSTEM ==========");
            System.out.println("1. Create Car");
            System.out.println("2. Create Bus");
            System.out.println("3. Create Train");
            System.out.println("4. All Transport Information");
            System.out.println("5. Search");
            System.out.println("6. Delete");
            System.out.println("7. Update");
            System.out.println("0. Exit");
            line();

            System.out.printf("Input number pls: ");
            sel = Integer.parseInt(sc.nextLine());

            switch (sel) {
                case 0:
                    break;

                case 1:
                    line();
                    System.out.printf("Input ID: ");
                    int carId = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Name: ");
                    String carName = sc.nextLine();

                    System.out.printf("Input Speed: ");
                    int carSpeed = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Capacity: ");
                    int carCapacity = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Fuel: ");
                    String carFuel = sc.nextLine();

                    Car c = new Car(carId, carName, carSpeed, carCapacity, carFuel);
                    transports.add(c);

                    line();
                    System.out.println("Inserted Successfuly....");
                    line();
                    pause(sc);
                    break;

                case 2:
                    line();
                    System.out.printf("Input ID: ");
                    int busId = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Name: ");
                    String busName = sc.nextLine();

                    System.out.printf("Input Speed: ");
                    int busSpeed = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Capacity: ");
                    int busCapacity = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input RouteNumber: ");
                    int busRouteNumber = Integer.parseInt(sc.nextLine());

                    Bus b = new Bus(busId, busName, busSpeed, busCapacity, busRouteNumber);
                    transports.add(b);

                    line();
                    System.out.println("Inserted Successfuly....");
                    line();
                    pause(sc);
                    break;

                case 3:
                    line();
                    System.out.printf("Input ID: ");
                    int trainId = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Name: ");
                    String trainName = sc.nextLine();

                    System.out.printf("Input Speed: ");
                    int trainSpeed = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Capacity: ");
                    int trainCapacity = Integer.parseInt(sc.nextLine());

                    System.out.printf("Input Carriages: ");
                    int trainCarriages = Integer.parseInt(sc.nextLine());

                    Train t = new Train(trainId, trainName, trainSpeed, trainCapacity, trainCarriages);
                    transports.add(t);

                    line();
                    System.out.println("Inserted Successfuly....");
                    line();
                    pause(sc);
                    break;

                case 4:
                    if (transports.isEmpty()) {
                        line();
                        System.out.println("No transport found");
                        line();
                        pause(sc);
                        break;

                    } else {
                        System.out.println();
                        System.out.println("************** Information *************");
                        for (Transport tr : transports) {
                            tr.showInfo();
                            tr.move();
                            line();
                        }
                    }

                    Transport fastest = transports.get(0);

                    for (int i = 1; i < transports.size(); i++) {
                        if (transports.get(i).getSpeed() > fastest.getSpeed()) {
                            fastest = transports.get(i);
                        }
                    }

                    System.out
                            .println("Fastest transport: " + fastest.getName() + " (" + fastest.getSpeed() + " km/h)");

                    System.out.printf("Trip Time: %.2f hours%n", fastest.tripTime(100));
                    pause(sc);
                    break;

                case 5:
                    if (transports.isEmpty()) {
                        line();
                        System.out.println("No transport found");
                        line();
                        pause(sc);
                        break;
                    } else {
                        line();
                        System.out.printf("Enter ID to search: ");
                        int searchId = Integer.parseInt(sc.nextLine());
                        boolean found = false;
                        line();
                        for (int i = 0; i < transports.size(); i++) {
                            if (transports.get(i).getId() == (searchId)) {
                                Transport tr = transports.get(i);
                                tr.showInfo();
                                tr.move();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("No transport found");
                            line();
                        }
                    }
                    pause(sc);
                    break;

                case 6:
                    if (transports.isEmpty()) {
                        line();
                        System.out.println("No transport found");
                        line();
                        pause(sc);
                        break;
                    } else {
                        line();
                        System.out.printf("Enter ID to delete: ");
                        int deleteId = Integer.parseInt(sc.nextLine());
                        boolean delete = false;
                        for (int i = 0; i < transports.size(); i++) {
                            if (transports.get(i).getId() == (deleteId)) {
                                transports.remove(i);
                                delete = true;
                                break;
                            }
                        }

                        if (!delete) {
                            line();
                            System.out.println("ID not found");
                            line();
                        } else {
                            line();
                            System.out.println("Deleted Successfully....");
                            line();
                        }
                    }
                    pause(sc);
                    break;

                case 7:
                    if (transports.isEmpty()) {
                        line();
                        System.out.println("No transport found");
                        line();
                        pause(sc);
                        break;
                    } else {
                        line();
                        System.out.printf("Enter ID to update: ");
                        int updateId = Integer.parseInt(sc.nextLine());
                        boolean updated = false;

                        for (int i = 0; i < transports.size(); i++) {
                            if (transports.get(i).getId() == updateId) {

                                System.out.printf("New Name: ");
                                String newName = sc.nextLine();

                                System.out.printf("New Speed: ");
                                int newSpeed = Integer.parseInt(sc.nextLine());

                                System.out.printf("New Capacity: ");
                                int newCapacity = Integer.parseInt(sc.nextLine());

                                Transport old = transports.get(i);

                                if (old instanceof Car) {
                                    System.out.printf("New Fuel: ");
                                    String fuel = sc.nextLine();
                                    transports.set(i, new Car(updateId, newName, newSpeed, newCapacity, fuel));

                                } else if (old instanceof Bus) {
                                    System.out.printf("New Route Number: ");
                                    int routeNumber = Integer.parseInt(sc.nextLine());
                                    transports.set(i, new Bus(updateId, newName, newSpeed, newCapacity, routeNumber));

                                } else if (old instanceof Train) {
                                    System.out.printf("New Carriages: ");
                                    int carriages = Integer.parseInt(sc.nextLine());
                                    transports.set(i, new Train(updateId, newName, newSpeed, newCapacity, carriages));
                                }
                                updated = true;
                                break;
                            }
                        }
                        if (!updated) {
                            line();
                            System.out.println("ID not found");
                            line();
                        } else {
                            line();
                            System.out.println("Updated Successfully....");
                            line();
                        }
                    }

                    pause(sc);
                    break;

                default:
                    line();
                    System.out.println("Invalid number");
                    line();
            }

        } while (sel != 0);

        sc.close();
    }
}