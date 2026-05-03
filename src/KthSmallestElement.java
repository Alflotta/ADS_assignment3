import java.util.Scanner;

public class KthSmallestElement {


    public static void sortArrayAscending(int[] numbers) {
        int size = numbers.length;

        for (int outerIndex = 0; outerIndex < size - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < size - outerIndex - 1; innerIndex++) {
                if (numbers[innerIndex] > numbers[innerIndex + 1]) {
                    int temporaryValue = numbers[innerIndex];
                    numbers[innerIndex] = numbers[innerIndex + 1];
                    numbers[innerIndex + 1] = temporaryValue;
                }
            }
        }
    }
    public static int findKthSmallest(int[] numbers, int kPosition) {
        return numbers[kPosition - 1];
    }

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);


        int arraySize = inputReader.nextInt();

        int[] numbers = new int[arraySize];


        for (int index = 0; index < arraySize; index++) {
            numbers[index] = inputReader.nextInt();
        }


        int kPosition = inputReader.nextInt();


        sortArrayAscending(numbers);


        int kthSmallestValue = findKthSmallest(numbers, kPosition);


        System.out.println(kthSmallestValue);
    }
}
