public class ProductControl {
    public static void main(String[] args) {
        String[] items = { "Алим", "Банан", "Усан үзэм", "Жүрж", "Тавлай" };
        double[] prices = { 1200.0, 800.0, 2500.0, 1500.0, 3000.0 };
        int[] quantities = { 50, 30, 0, 25, 10 };

        int[] intPrices = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            intPrices[i] = (int) prices[i];
        }

        int[] eachPrices = new int[items.length];
        int maxIndex = 0;

        int max = intPrices[0];
        for (int i = 0; i < items.length; i++) {
            if (intPrices[i] > max) {
                max = intPrices[i];
                maxIndex = i;
            }
            eachPrices[i] = (int) intPrices[i] * quantities[i];
        }

        System.out.println("========= Барааны Тайлан =========");
        System.out.println("Бараа   Үнэ  Тоо    Нийт       Нөөц");

        for (int i = 0; i < items.length; i++) {
            int n = quantities[i] / 10;
            String inventory = switch (n) {
                case 0 -> "Дууссан";
                case 1 -> "Бага үлдсэн";
                case 2, 3 -> "Хэвийн";
                default -> "Их нөөцтэй";
            };
            System.out.printf("%s | %d | %d | %d₮ | %s\n", items[i], intPrices[i], quantities[i], eachPrices[i],
                    inventory);
        }

        System.out.println("===================================");

        int count = 0;
        int totalPrice = 0;
        for (int i = 0; i < eachPrices.length; i++) {
            totalPrice += eachPrices[i];
            if (quantities[i] == 0) {
                count++;
            }
        }
        System.out.printf("Нийт өртөг: %d\n", totalPrice);
        System.out.printf("Дууссан барааны тоо: %d\n", count);
        System.out.printf("Хамгийн үнэтэй: %s (%d₮)", items[maxIndex], intPrices[maxIndex]);
    }
}
