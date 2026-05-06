public class Array01 {
    public static void main(String[] args) {
        int a = 6;

        //arrey
        int [] buhelToo = {2, 34, 5, 7, 19};
        boolean [] unen = {true};
        String [] pro = {"Java", "CSS", "HTML"};
        char [] temdegt = {'a', 'b', 'c'};
        System.out.println(pro);
        double [] prices = {2.4, 4.5, 3.5};

        // Busaad ele hewleh
        System.out.println(pro[0]);

        System.out.println(prices[1]);
        prices[1] = 66;
        System.out.println(prices[1]);

        //Array elent urt
        System.out.println("Heden elent bgaag " + pro.length);

        double [] myNumbers = {1.22, 2.03, 3.33, 4.55, 5.12, 6.04, 7.6, 8.9, 9.1, 10.2};
        System.out.println("5 dahi. elem" + myNumbers[4] + 1);
        myNumbers[0] = 0;
        myNumbers[myNumbers.length - 1] = myNumbers[myNumbers.length - 1] + 8;
        System.out.println("Ehnii element " + myNumbers[0]);
        for (int i = 0; i < myNumbers.length; i++) {
            System.out.println(myNumbers[i]);
        }
    }
}
