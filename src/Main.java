import java.util.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        double[] numberCurrent = {0};
        double[] input = {0, 0};

        numberCurrent[0] = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter your start number."));

        for (int index=0; index==0; index=0) {
            input = inputPhase(input, numberCurrent);
            numberCurrent = calcPhase(input, numberCurrent);
        }




    }

    static double[] inputPhase(double[] input, double[] numberCurrent) {
        String[] typeOptions = {"Done","+","-","*","/","\u221A","^"};
        input[0] = JOptionPane.showOptionDialog(null, "Your current Number is: "+numberCurrent[0]+"\n Please choose your next Action.", "Worlds worst Calculator", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, typeOptions, 0);
        if (input[0] ==0 || input[0] == 5) {
            return input;
        }
        else {
            input[1] = Double.parseDouble(JOptionPane.showInputDialog(null, "Your current Number is: "+numberCurrent[0]+"\n Please enter your next Number."));
            return input;
        }

    }

    static double[] calcPhase(double[] input, double[] numberCurrent) {
        switch((int) input[0]) {
            case 0:
                System.exit(0);
                break;
            case 1:
                numberCurrent[0] = numberCurrent[0]+input[1];
                break;
            case 2:
                numberCurrent[0] = numberCurrent[0]-input[1];
                break;
            case 3:
                numberCurrent[0] = numberCurrent[0]*input[1];
                break;
            case 4:
                numberCurrent[0] = numberCurrent[0]/input[1];
                break;
            case 5:
                numberCurrent[0] = Math.sqrt(numberCurrent[0]);
                break;
            case 6:
                numberCurrent[0] = Math.pow(numberCurrent[0],input[1]);
                break;
            default:
                System.out.println("[DEBUG] how tf.");
                break;
        }
        return numberCurrent;
    }

}
