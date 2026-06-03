import java.util.Scanner;

public class MonthName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Сар (1-12): ");
        int month = scanner.nextInt();
        switch (month) {
            case 1:
                System.out.println("Нэгдүгээр сар"); break;
            case 2:
                System.out.println("Хоёрдугаар сар"); break;
            case 3:
                System.out.println("Гуравдугаар сар"); break;
            case 4:
                System.out.println("Дөрөвдүгээр сар"); break;
            case 5:
                System.out.println("Тавдугаар сар"); break;
            case 6:
                System.out.println("Зургадугаар сар"); break;
            case 7:
                System.out.println("Долоодугаар сар"); break;
            case 8:
                System.out.println("Наймдугаар сар"); break;
            case 9:
                System.out.println("Есдүгээр сар"); break;
            case 10:
                System.out.println("Аравдугаар сар"); break;
            case 11:
                System.out.println("Арван нэгдүгээр сар"); break;
            case 12:
                System.out.println("Арван хоёрдугаар сар"); break;
            default: 
                System.out.println("Буруу оролт");
        }
        scanner.close();
    }
}
