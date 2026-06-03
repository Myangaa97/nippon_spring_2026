public class AnimalPark {
    static class Animal {
        String name;
        int age;
        double weight;
        boolean isHealthy;

        Animal(String name, int age, double weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.isHealthy = true;
        }

        void eat(String food) {
            System.out.println(name + " " + food + " идэж байна.");
        }

        void sleep() {
            System.out.println(name + " унтаж байна.");
        }

        void sound() {
            System.out.println(name + " .....");
        }

        void checkup() {
            System.out.println(name + "-ийн эрүүл мэнд: " + (isHealthy ? "Эрүүл" : "Анхааруулга!"));
        }

        String getType() {
            return "Амьтан";
        }

        void showProfile() {
            System.out.println("---------------------");
            System.out.println("Нэр    : " + name);
            System.out.println("Төрөл  : " + getType());
            System.out.println("Нас    : " + age + " жил");
            System.out.printf("Жин    : %.1f кг%n", weight);
            System.out.println("Эрүүл  : " + (isHealthy ? "Тийм" : "Үгүй"));
        }
    }

    static class Lion extends Animal {
        double maneLength;

        Lion(String name, int age, double weight, double maneLength) {
            super(name, age, weight);
            this.maneLength = maneLength;
        }

        @Override
        void sound() {
            System.out.println(name + " Аарр!!");
        }

        @Override
        String getType() {
            return "Арслан";
        }

        void hunt() {
            System.out.println(name + " ан хийж байна.");
        }

        @Override
        void showProfile() {
            super.showProfile();
            System.out.printf("Дэл    : %.1f см%n", maneLength);
        }
    }

    static class Elephant extends Animal {
        double trunkLength;

        Elephant(String name, int age, double weight, double trunkLength) {
            super(name, age, weight);
            this.trunkLength = trunkLength;
        }

        @Override
        void sound() {
            System.out.println(name + " Пүүү!!");
        }

        @Override
        String getType() {
            return "Заан";
        }

        void spray() {
            System.out.println(name + " хошуугаараа ус цацаж байна.");
        }

        @Override
        void showProfile() {
            super.showProfile();
            System.out.printf("Хошуу  : %.1f см%n", trunkLength);
        }
    }

    static class Penguin extends Animal {
        boolean canFly = false;

        Penguin(String name, int age, double weight) {
            super(name, age, weight);
        }

        @Override
        void sound() {
            System.out.println(name + " Хааа хааа!!");
        }

        @Override
        String getType() {
            return "Пингвин";
        }

        void swim() {
            System.out.println(name + " усанд сэлж байна.");
        }
    }

    static class Giraffe extends Animal {
        double neckLength;

        Giraffe(String name, int age, double weight, double neckLength) {
            super(name, age, weight);
            this.neckLength = neckLength;
        }

        @Override
        void sound() {
            System.out.println(name + " чимээгүй байна.");
        }

        @Override
        String getType() {
            return "Гирафф";
        }

        void eatLeaves() {
            System.out.println(name + " өндөр модны навч идэж байна.");
        }

        @Override
        void showProfile() {
            super.showProfile();
            System.out.printf("Хүзүү  : %.1f м%n", neckLength);
        }
    }

    static void feedAll(Animal[] animals, String food) {
        System.out.println("\n=== Бүх амьтдыг хооллож байна: " + food + " ===");
        for (Animal a : animals)
            a.eat(food);
    }

    static void morningRoutine(Animal[] animals) {
        System.out.println("\n=== Өглөөний дэглэм ===");
        for (Animal a : animals) {
            a.sound();
            a.checkup();
        }
    }

    static Animal heaviest(Animal[] animals) {
        Animal best = animals[0];
        for (Animal a : animals)
            if (a.weight > best.weight)
                best = a;
        return best;
    }

    static int countByType(Animal[] animals, String type) {
        int count = 0;
        for (Animal a : animals)
            if (a.getType().equals(type))
                count++;
        return count;
    }

    static void showAllProfiles(Animal[] animals) {
        System.out.println("\n===== АМЬТНЫ ЦЭЦЭРЛЭГИЙН БҮРТГЭЛ =====");
        for (Animal a : animals)
            a.showProfile();
        System.out.println("=====================================");
    }

    static class Keeper {
        String name;
        Animal[] assigned;

        Keeper(String name, Animal[] assigned) {
            this.name = name;
            this.assigned = assigned;
        }

        void feedAssigned(String food) {
            System.out.println("\n=== " + name + " амьтдаа хооллож байна ===");

            for (Animal a : assigned) {
                a.eat(food);
            }
        }

        void checkAllHealth() {
            System.out.println("\n=== " + name + " эрүүл мэнд шалгаж байна ===");

            for (Animal a : assigned) {
                a.checkup();
            }
        }
    }

    static class Enclosure01 {
        String name;
        Animal[] residents;
        int maxCapacity;
        int currentSize;

        Enclosure01(String name, int maxCapacity) {
            this.name = name;
            this.maxCapacity = maxCapacity;
            this.residents = new Animal[maxCapacity];
            this.currentSize = 0;
        }

        boolean addAnimal(Animal a) {
            if (isFull()) {
                System.out.println(name + " парк дүүрсэн тул " + a.name + "-ийг нэмэх боломжгүй!");
                return false;
            }
            residents[currentSize] = a;
            currentSize++;
            System.out.println(a.name + " (" + a.getType() + ") " + name + " паркд орлоо.");
            return true;
        }

        void showResidents() {
            System.out.println("\n=== " + name + " дахь амьтад ===");
            for (int i = 0; i < currentSize; i++) {
                residents[i].showProfile();
            }
        }

        boolean isFull() {
            return currentSize >= maxCapacity;
        }
    }

    public static void main(String[] args) {
        Animal[] park = {
                new Lion("Симба", 5, 180, 25),
                new Lion("Муфаса", 8, 210, 30),
                new Elephant("Думбо", 12, 4500, 180),
                new Penguin("Коваальски", 3, 4.5),
                new Penguin("Рико", 4, 5.2),
                new Giraffe("Джери", 7, 900, 1.8)
        };

        showAllProfiles(park);
        morningRoutine(park);
        feedAll(park, "мах");

        Animal big = heaviest(park);
        System.out.println("\nХамгийн хүнд: " + big.name + " (" + big.weight + " кг)");

        System.out.println("Арсланы тоо: " + countByType(park, "Арслан"));
        System.out.println("Пингвины тоо: " + countByType(park, "Пингвин"));

        // Polymorphism
        System.out.println("\n=== Дуу гаргах ===");
        for (Animal a : park) {
            a.sound();
        }

        // Тусгай үйлдлүүд
        System.out.println("\n=== Тусгай үйлдлүүд ===");
        for (Animal a : park) {
            if (a instanceof Lion l)
                l.hunt();
            if (a instanceof Elephant e)
                e.spray();
            if (a instanceof Penguin p)
                p.swim();
            if (a instanceof Giraffe g)
                g.eatLeaves();
        }

        // Keeper (Асрагч)
        Keeper keepers = new Keeper("Мянгаа", new Animal[] { park[0], park[1] });
        keepers.feedAssigned("мах");
        keepers.checkAllHealth();

        // ENCLOSURE (Тор)

        Enclosure01 enclosure01 = new Enclosure01("Hi", 4);
        for (Animal a : park) {
            enclosure01.addAnimal(a);
        }
        enclosure01.showResidents();
    }

}
