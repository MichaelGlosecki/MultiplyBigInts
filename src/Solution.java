class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder number1 = new StringBuilder(num1).reverse();
        StringBuilder number2 = new StringBuilder(num2).reverse();
        int number1Length = num1.length();
        int number2Length = num2.length();

        int[] multipliedValues = new int[number1Length + number2Length];
        for (int i = 0; i < number1Length; i++) {
            for (int j = 0; j < number2Length; j++) {
                multipliedValues[i + j] += (number1.charAt(i) - '0') * (number2.charAt(j) - '0');
            }
        }

        StringBuilder completedMultiplication = new StringBuilder();
        for (int i = 0; i < multipliedValues.length; i++) {
            int multipliedValue = multipliedValues[i];
            int mod = multipliedValue % 10;
            int carry = multipliedValue / 10;
            if (i + 1 < multipliedValues.length) {
                multipliedValues[i+1] += carry;
            }
            completedMultiplication.insert(0, mod);
        }

        //Remove leading zeroes.
        while (completedMultiplication.charAt(0) == '0' && completedMultiplication.length() > 1) {
            completedMultiplication.deleteCharAt(0);
        }

        return completedMultiplication.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Correct Answer=81545528423323707382561529481396220151362923133605466364906339543226195240");
        System.out.println(solution.multiply("6547896321456987789654123021582069704502", "12453698778965825214162502350202620"));
    }
}
