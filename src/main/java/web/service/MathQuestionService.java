package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 result (addition).
     * @param number1
     * @param number2
     * @return
     */
    public static Double q1Addition(String number1, String number2) {
        validateInputs(number1, number2);
        try {
            return Double.valueOf(number1) + Double.valueOf(number2);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid number format");
        }
    }

    /**
     * Calculate Q2 result (subtraction).
     * @param number1
     * @param number2
     * @return
     */
    public static Double q2Subtraction(String number1, String number2) {
        validateInputs(number1, number2);
        try {
            return Double.valueOf(number1) - Double.valueOf(number2);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid number format");
        }
    }

    /**
     * Calculate Q3 result (multiplication).
     * @param number1
     * @param number2
     * @return
     */
    public static Double q3Multiplication(String number1, String number2) {
        validateInputs(number1, number2);
        try {
            return Double.valueOf(number1) * Double.valueOf(number2);
        } catch (NumberFormatException e) {
            throw new ValidationException("Invalid number format");
        }
    }

    private static void validateInputs(String number1, String number2) {
        if (number1 == null || number2 == null || number1.isEmpty() || number2.isEmpty()) {
            throw new ValidationException("Input numbers must not be null or empty");
        }
    }
}