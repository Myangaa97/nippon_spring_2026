import java.util.Scanner;

public class DayType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Udur ner oruul (monday, wednesday etc..): ");
        String day = scanner.next();

        switch (day) {
            case "monday":
                System.out.println("Ажлын өдөр");
                break;
            case "tuesday":
                System.out.println("Ажлын өдөр");
                break;
            case "wednesday":
                System.out.println("Ажлын өдөр");
                break;
            case "thursday":
                System.out.println("Ажлын өдөр");
                break;
            case "friday":
                System.out.println("Ажлын өдөр");
                break;
            case "Satarday":
                System.out.println("Амралтын өдөр");
                break;
            case "sunday":
                System.out.println("Амралтын өдөр");
                break;
            default:
                System.out.println("Тодорхойгүй");
        }

        scanner.close();
    }
}
