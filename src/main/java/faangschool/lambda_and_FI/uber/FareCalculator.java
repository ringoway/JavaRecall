package faangschool.lambda_and_FI.uber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double range, double time, BiFunction<Double, Double, Double> function) {
        return function.apply(range, time);
    }
}
