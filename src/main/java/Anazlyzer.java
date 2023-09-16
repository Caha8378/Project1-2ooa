import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class Anazlyzer {

    double[] list;
    int maxOcurrence;

    public Anazlyzer(double[] listOfInputs) {
        list = listOfInputs;
        Arrays.sort(list);

    }
//takes median of list of inputs from user
    public double median() {
        //if number of elements is even or odd median works differently
        if (list.length/2 % 2 == 1){
            return list[(list.length/2)];
        }
        else {
            return (list[(list.length/2)] + list[list.length/2 - 1]) / 2;
        }
    }
//takes the mean of the list of inputs
    public double mean(){
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum = sum + list[i];
        }
        return sum / list.length;
    }
// takes the mode from list of inputs
    public Double[] mode() {
        // hashmap to store value,occurences
        HashMap<Double,Integer> modeMap = new HashMap<Double, Integer>();
        this.maxOcurrence = 1;
        double test = 0;
        int count = 0;
        // loops through list, adding first time occurring numbers as (value, 1)
        // and n'th time occurring numbers as (value, n+1)
        for (int i =0; i < list.length; i++){
            double temp = list[i];
            if(modeMap.get(temp) != null) {
                count = modeMap.get(list[i]);
                count++;
                modeMap.put(list[i], count);
                if (count > maxOcurrence) {
                    this.maxOcurrence = count;
                    test = list[i];
                }
            }
            else {
                modeMap.put(list[i], 1);
            }
//creates new list of value that occur same number of times
        }
        Double[] pleasework = new Double[list.length];
        int prettyplease =0;
        for (Double i : modeMap.keySet()) {
            if (modeMap.get(i) == this.maxOcurrence) {
                pleasework[prettyplease] = i;
                prettyplease++;
            }
        }
        // clean up list and return the modes, im sorry this took forever
        Double[] officialMode = new Double[prettyplease];
        for(int z = prettyplease; z > 0; z = z - 1) {
            officialMode[z-1] = pleasework[z-1];
        }
        return officialMode;

    }
//function to find sum of squares used in variance and standard deviation methods
    public double sumOfSquares(){

        double theMean = this.mean();
        double sumSquare = 0;
        for (int i = 0; i < list.length; i++) {
            sumSquare = ((list[i] - theMean)*(list[i] - theMean)) + sumSquare;
        }
        return sumSquare;
    }
// calls sum of squares and divides by number of items
    public double variance(){
        //find variance by diving sum of squares by number of items - 1
        double squares = this.sumOfSquares();
        double variance = squares / (list.length-1);
        return variance;
    }
// standard deviation is simply the square root of the variance
    public double standardDeviation() {
        //find stdDev by sqrt of  sumofsqaures/n-1 items , essentially sqrt of variance
        double stdDev = Math.sqrt(this.variance());


        return stdDev;
    }
// since we sorted inputs, max value is the last index
    public double getMax() {
        return list[list.length-1];
    }
// Call mode function and also calls class variable max occuring, (also updated in mode method)
    public String maxOcurring(){
        return ("Value(s): " + Arrays.toString(this.mode()) + " Count: " + this.maxOcurrence);
    }
}






