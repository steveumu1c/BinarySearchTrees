package project3cmsc350;
/*The third class required for this project is one that defines fractions. It should have a constructor
that accepts a string representation of a fraction and a toString method. It must implement the
Comparable interface, which means a compareTo method is also required.*/
/*Note that fractions are to be written with a slash separating the numerator and denominator with
no spaces on either side of the slash.*/
public class Fraction implements Comparable<Fraction>{
    private String fraction;
    private double key;

    // Fraction constructor
    public Fraction(String fraction) {
        this.fraction = fraction;
        String[] fractionArray = this.fraction.split("/");
        key = Double.parseDouble(fractionArray[0])/Double.parseDouble(fractionArray[1]);
        if (Integer.parseInt(fractionArray[1]) == 0) {
            // throw exception for denominator of 0
            throw new ArithmeticException();
        } // end if
        if (fractionArray.length > 2) {
            // throw exception for non numeric input
            throw new NumberFormatException();
        } // end if
        // TODO modify so that it doesn't allow fractions like "1/3/"
    } // end method

    
    //Return the value of the fraction as a double for the comparison
    public double getValue() {
        return key;
    }

    @Override
    public int compareTo(Fraction comparable) {
        double result = getValue() - comparable.getValue();
        if (result < 0){return 0;}
        if (result > 0){return 1;}
        else {return 0;}

    }
    @Override
    public String toString() {
        return fraction;
    } 

}
