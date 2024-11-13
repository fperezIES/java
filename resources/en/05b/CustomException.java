/**
 * This example defines a custom exception to deal with negative substractions
 */

class NegativeSubtractException extends Exception {
    public NegativeSubtractException(int n1, int n2) {
        super("NegativeSubtractException: '" + n1 + " - " +
                n2 + "' result is negative");
    }
}

public class CustomException {
    public static int positiveSubtract(int n1, int n2)
            throws NegativeSubtractException {
        if (n1 < n2) {
            throw new NegativeSubtractException(n1, n2);
        }
        return n1 - n2;
    }

    public static void main(String[] args) {
        try {
            int result = positiveSubtract(4, 12);
        } catch (NegativeSubtractException e) {
            System.err.println(e.getMessage());
        }
    }
}
