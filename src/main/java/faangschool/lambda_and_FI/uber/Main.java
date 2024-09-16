package faangschool.lambda_and_FI.uber;

import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        FareCalculator fareCalculator = new FareCalculator();

        BiFunction<Double, Double, Double> economyFare = (range, time) -> (range * 0.8) * (time * 0.5);
        BiFunction<Double, Double, Double> comfortFare = (range, time) -> (range * 1.2) * (time * 1.0);
        BiFunction<Double, Double, Double> premiumFare = (range, time) -> (range * 2.0) * (time * 1.5);


        double economyTripCost = fareCalculator.calculateFare(100, 5, economyFare);
        double comfortTripCost = fareCalculator.calculateFare(112, 12, comfortFare);
        double premiumTripCost = fareCalculator.calculateFare(118, 9, premiumFare);

        System.out.println("Стоимость поездки на тарифе Economy: " + roundNumber(economyTripCost));
        System.out.println("Стоимость поездки на тарифе Comfort: " + roundNumber(comfortTripCost));
        System.out.println("Стоимость поездки на тарифе Premium: " + roundNumber(premiumTripCost));
    }

    public static double roundNumber(double number) {
        return (double) Math.round(number * 100) / 100;
    }
}
