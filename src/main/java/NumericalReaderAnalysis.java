import java.util.*;

public class NumericalReaderAnalysis {

    public static void main(String args[]) {
        //Initialize reader to take inputs
        myReader theReader = new myReader();
        double[] inputs = theReader.takeInputs();

        //initialize Analyzer to deal with data
            Anazlyzer theAnalyzer = new Anazlyzer(inputs);
            //if user give one or 0 number data set, no calculations can be done.
            if (inputs.length == 1 || inputs.length == 0){
                System.out.println("Please enter 2 or more numbers when creating data set");
            }
            else{
                //print out results of each analyzer method
                System.out.println("The set is: " + Arrays.toString(inputs));
            System.out.println("The median is " + theAnalyzer.median());
            System.out.println("The mean is " + theAnalyzer.mean());
            System.out.println("The mode set is " + Arrays.toString(theAnalyzer.mode()));
            System.out.println("The variance of the list is: " + theAnalyzer.variance());
            System.out.println("The standard deviation is: " + theAnalyzer.standardDeviation());
            System.out.println("The max is: " + theAnalyzer.getMax());
            System.out.println("Most Occurring " + theAnalyzer.maxOcurring());
        }
    }
}
