import java.util.Arrays;
import java.util.Scanner;

public class myReader {

    public double[] takeInputs() {

        Scanner reader = new Scanner(System.in);
        // inititalize list of size 0 because we don't know how many inputs user might want to enter
        double[] list = new double[0];
        int index = 0;

        System.out.println("Enter number or 0 to stop");
        double input = reader.nextDouble();
        // takes inputs until user enters 0
        while (input != 0) {

            // not efficient but takes copy of previous array + 1 size to add next input to end of new array
            list = Arrays.copyOf(list, list.length + 1);
            list[list.length - 1] = input;


            System.out.println("Enter number or 0 to stop");
            input = reader.nextDouble();
            // makes sure no other calls are made once 0 is entered
            if (input == 0) {
                break;
            }
        }

        reader.close();

        return list;
    }



}
