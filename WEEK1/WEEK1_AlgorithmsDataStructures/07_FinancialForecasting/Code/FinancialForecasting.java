public class FinancialForecasting {
    public static double future_val(double present_val, double growthRate, int periods) {
        if (periods == 0) {
            return present_val;
        }
        return future_val(present_val * (1 + growthRate), growthRate, periods - 1);
    }
    public static void main(String[] args) {
        double present_val = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10;
        double futureValue = future_val(present_val, growthRate, periods);
        System.out.println("Predicted Future Value: Rs." + futureValue);
    }
} 