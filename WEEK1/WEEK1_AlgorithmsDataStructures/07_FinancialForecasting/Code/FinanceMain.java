import java.util.*;

public class FinanceMain {
    static double futureValue(double present, double rate, int years) {
        if (years == 0) return present;
        return futureValue(present * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {
        double present = 10000;
        double rate = 0.08;
        int years = 5;
        double result = futureValue(present, rate, years);
        System.out.println("Present value: Rs." + present);
        System.out.println("Annual growth rate: " + (rate * 100) + "%");
        System.out.println("Years: " + years);
        System.out.println("Future value after " + years + " years: Rs." + result);
    }
} 