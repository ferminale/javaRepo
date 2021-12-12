public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println("Результат > " + checkSumm(10,0));
        System.out.println("_______________________");

        resultNumbers (99);
        System.out.println("_______________________");

        String result = (resultPositive(-20)) ? "Число положительное" : "Число отрицательное";
        System.out.println(result);
        System.out.println("_______________________");

        printString ("Строка", 5);
        System.out.println("_______________________");

        int thisYear = 2000;
        System.out.println("Год " + thisYear + " високосный? >" + leapYear(thisYear));
    }

    public static boolean checkSumm(int a, int b) {
        int summ = a + b;
        return (summ <= 20) && (summ >= 10);
    }
    public static void resultNumbers(int var) {
        if (var >= 0) {
            System.out.println(var + " положительное");
        } else  {
            System.out.println(var + " отрицательное");
        }
    }
    public static boolean resultPositive( int var1) {
        return var1 >=0;
    }

    public static void printString(String value, int var2) {
        for (int i = 1; i <= var2; i++) {
            System.out.println("Строка №" + i + " " + value);
        }
    }

    public static boolean leapYear (int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }
}