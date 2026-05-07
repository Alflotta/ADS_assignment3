import java.util.Scanner;

public class MedianElement {
    public static void sortNumbersAscending(int[] values) {
        int length = values.length;

        for (int outerIndex = 0; outerIndex < length - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < length - outerIndex - 1; innerIndex++) {
                if (values[innerIndex] > values[innerIndex + 1]) {
                    int temporaryValue = values[innerIndex];
                    values[innerIndex] = values[innerIndex + 1];
                    values[innerIndex + 1] = temporaryValue;
                }
            }
        }
    }
    public static double calculateMedian(int[] sortedValues) {
        int size = sortedValues.length;

        if (size % 2 == 1) {

            int middleIndex = size / 2;
            return sortedValues[middleIndex];
        } else {

            int rightMiddleIndex = size / 2;
            int leftMiddleIndex = rightMiddleIndex - 1;
            return (sortedValues[leftMiddleIndex] + sortedValues[rightMiddleIndex]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);


        int numberOfElements = inputReader.nextInt();

        int[] values = new int[numberOfElements];


        for (int index = 0; index < numberOfElements; index++) {
            values[index] = inputReader.nextInt();
        }


        sortNumbersAscending(values);


        double medianValue = calculateMedian(values);


        if (medianValue == (int) medianValue) {
            System.out.println((int) medianValue);
        } else {
            System.out.println(medianValue);
        }
    }
}
