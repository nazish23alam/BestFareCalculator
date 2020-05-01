import java.util.Arrays;

public class TransitCalculator {

    String[] fareOptions = { "Pay-per-ride", "7-day Unlimited Rides", "30-day Unlimited Rides" };
    double[] fares = { 2.75, 33.00, 127.00 };
    int days;
    int rides;

    public TransitCalculator(int numDays, int numRides) {
        days = numDays;
        rides = numRides;
    }

    public double unlimited7Price() {
         double numOfWeeks = Math.ceil(days / 7.0);
        double total7DayCost = numOfWeeks * fares[1];

        return total7DayCost / rides;
    }

    public double[] getRidePrices() {
        double payPerRide = fares[0];
         double priceForSevenDay = unlimited7Price();
         double priceForThirtyDay = fares[2] / rides;
        double[] prices = { payPerRide, priceForSevenDay, priceForThirtyDay };
        return prices;
    }

    public String getBestFare() {

        double[] ridePrices = getRidePrices();
        int winningIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {

            if (ridePrices[i] < ridePrices[winningIndex]) {

                winningIndex = i;
            }
        }

        return "You should get the " + fareOptions[winningIndex] + " option at $"
                + Math.round(ridePrices[winningIndex] * 100.0) / 100.0 + " per ride.";
    }

    public static void main(String[] args) {
        TransitCalculator myRide = new TransitCalculator(26, 54);
        System.out.println(myRide.getBestFare());
    }
}