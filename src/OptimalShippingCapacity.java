import java.util.Scanner;

public class OptimalShippingCapacity {

    public static int findLargestWeight(int[] packageWeights) {
        int largestWeight = packageWeights[0];

        for (int index = 1; index < packageWeights.length; index++) {
            if (packageWeights[index] > largestWeight) {
                largestWeight = packageWeights[index];
            }
        }

        return largestWeight;
    }

    public static int calculateTotalWeight(int[] packageWeights) {
        int totalWeight = 0;

        for (int weight : packageWeights) {
            totalWeight += weight;
        }

        return totalWeight;
    }

    public static boolean canShipWithinDays(int[] packageWeights, int allowedDays, int truckCapacity) {
        int requiredDays = 1;
        int currentLoad = 0;

        for (int weight : packageWeights) {
            if (currentLoad + weight > truckCapacity) {
                requiredDays++;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }

        return requiredDays <= allowedDays;
    }

    public static int findMinimumCapacity(int[] packageWeights, int allowedDays) {
        int minimumCapacity = findLargestWeight(packageWeights);
        int maximumCapacity = calculateTotalWeight(packageWeights);

        while (minimumCapacity < maximumCapacity) {
            int middleCapacity = minimumCapacity + (maximumCapacity - minimumCapacity) / 2;

            if (canShipWithinDays(packageWeights, allowedDays, middleCapacity)) {
                maximumCapacity = middleCapacity;
            } else {
                minimumCapacity = middleCapacity + 1;
            }
        }

        return minimumCapacity;
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        int numberOfPackages = inputReader.nextInt();

        int[] packageWeights = new int[numberOfPackages];

        for (int index = 0; index < numberOfPackages; index++) {
            packageWeights[index] = inputReader.nextInt();
        }

        int allowedDays = inputReader.nextInt();

        int minimumTruckCapacity = findMinimumCapacity(packageWeights, allowedDays);

        System.out.println(minimumTruckCapacity);
    }
}