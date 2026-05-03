import java.util.Scanner;

public class AnagramSortChecker {

    public static void sortCharacters(char[] characters) {
        int length = characters.length;

        for (int outerIndex = 0; outerIndex < length - 1; outerIndex++) {
            for (int innerIndex = 0; innerIndex < length - outerIndex - 1; innerIndex++) {
                if (characters[innerIndex] > characters[innerIndex + 1]) {
                    // swap
                    char temp = characters[innerIndex];
                    characters[innerIndex] = characters[innerIndex + 1];
                    characters[innerIndex + 1] = temp;
                }
            }
        }
    }

    public static boolean compareCharacterArrays(char[] firstWordChars, char[] secondWordChars) {
        for (int index = 0; index < firstWordChars.length; index++) {
            if (firstWordChars[index] != secondWordChars[index]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        String firstWord = inputReader.nextLine();
        String secondWord = inputReader.nextLine();

        firstWord = firstWord.toLowerCase();
        secondWord = secondWord.toLowerCase();

        if (firstWord.length() != secondWord.length()) {
            System.out.println("NO");
            return;
        }

        // Convert to char arrays
        char[] firstWordCharacters = firstWord.toCharArray();
        char[] secondWordCharacters = secondWord.toCharArray();

        sortCharacters(firstWordCharacters);
        sortCharacters(secondWordCharacters);

        boolean areAnagrams = compareCharacterArrays(firstWordCharacters, secondWordCharacters);

        if (areAnagrams) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}