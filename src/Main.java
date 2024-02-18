import java.util.Arrays;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        String input = "61";
        System.out.println(kaprekar(input));
    }

    private static int kaprekar(String kapInput) {

        while (kapInput.length() < 4) {
            kapInput = kapInput + "0";
        }

        char[] iterArray = new char[4];
        char[] maxArray = new char[4];
        char[] minArray = new char[4];
        iterArray = kapInput.toCharArray();

        String checkArray = "";
        int iterCount = 0;
        int iterValue = 0;

        while (true) {

            if (Arrays.toString(iterArray).equals("[6, 1, 7, 4]")) {
                // System.out.println(iterCount + "| EXIT | " + Arrays.toString(iterArray));
                return iterCount;
            }

            for (int i = 0; i < 3; i++) {
                checkArray = checkArray + (iterArray[i]);
            }
            // System.out.println(iterCount + "| DEBUG iteArray | " + Arrays.toString(iterArray));

            minArray = iterArray;
            sort(minArray);

            for (int i = 0; i <= 3; i++) {
                maxArray[i] = minArray[3-i];
            }

            // System.out.println(iterCount + "| DEBUG maxArray | " + Arrays.toString(maxArray));
            // System.out.println(iterCount + "| DEBUG minArray | " + Arrays.toString(minArray));

            int minValue = 0;
            int maxValue = 0;

            for (int i = 0; i < 4; i++) {
                int base = (int) Math.pow(10, 3 - i);

                maxValue += base * Character.getNumericValue(maxArray[i]);
                minValue += base * Character.getNumericValue(minArray[i]);
                
                iterValue = maxValue - minValue;
            }

            iterArray = Integer.toString(iterValue).toCharArray();

            iterCount++;
        }
    }
}