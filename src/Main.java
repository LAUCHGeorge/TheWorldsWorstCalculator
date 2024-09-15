import javax.swing.*;

public class Main {

    static double currentNumber = 0;

    public static void main(String[] args) {

        double input = 0;
        int inputType = 0;
        String[] typeOptions = {"Done", "+", "-", "*", "/", "\u221A", "^", "!"};

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Exception occurred: "+e.getMessage());
        }

        boolean success = false;
        while (!success) {
            try {
                currentNumber = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter your start number."));
                success = true;
            }
            catch (NumberFormatException e) {
                System.err.println("The user was too stupid to enter a number, which is why an exception was thrown: "+e.getMessage());
                JOptionPane.showMessageDialog(null,"Please enter a valid number.");
            }
            catch (NullPointerException e) {
                System.exit(420);
            }
        }

        while (true) {
            inputType = JOptionPane.showOptionDialog(null, "Your current Number is: " + currentNumber + "\n Please choose your next Action.", "The worlds worst Calculator", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, typeOptions, 0);
            if (inputType == -1) {System.exit(420);}
            calculate(inputType,input);
        }
    }

    static double input() {

        double input = 0;
        boolean success = false;
        while (!success) {
            try {
                input = Double.parseDouble(JOptionPane.showInputDialog(null, "Your current Number is: " + currentNumber + "\n Please enter your next Number."));
                success = true;
            }
            catch (NumberFormatException e) {
                System.err.println("The user was too stupid to enter a number, which is why an exception was thrown: "+e.getMessage());
                JOptionPane.showMessageDialog(null,"Please enter a valid number.");
            }
            catch (NullPointerException e) {
                System.exit(420);
            }
        }
        return input;
    }

    static void calculate(int inputType, double input) {
        double result = -1;
        switch(inputType) {
            case 0:
                System.exit(0);
                break;
            case 1:
                result = currentNumber +input();
                break;
            case 2:
                result = currentNumber -input();
                break;
            case 3:
                result = currentNumber *input();
                break;
            case 4:
                result = currentNumber /input();
                break;
            case 5:
                result = Math.sqrt(currentNumber);
                break;
            case 6:
                result = Math.pow(currentNumber,input());
                break;
            case 7:
                if (currentNumber <= 720) {
                    result = 1;
                    for (int factor = 2; factor <= currentNumber; factor++) {
                        result *= factor;
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"This number is too high.");
                    result = currentNumber;
                }
                break;
            default:
                JOptionPane.showMessageDialog(null,"ERROR: The specified inputType was not found.");
                break;
        }
        System.out.println("test");
        if (result != Double.POSITIVE_INFINITY && result != Double.NEGATIVE_INFINITY) {currentNumber = result;}
        else {JOptionPane.showMessageDialog(null,"This number is too high.");}
    }

}
