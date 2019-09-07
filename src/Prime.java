// Kevin Chen, 23365285

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prime {
    public static void main (String[] arg){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an Integer");
        System.out.println("Numbers Below 0 Stops The Program");
        StringBuilder PrimeFactors = new StringBuilder();
        Set<Integer> SetPrimeFactors = new HashSet<Integer>();
        int number;
        while ( (number = input.nextInt()) > 0) {
            boolean prime = PrimeTest(number);
            if (prime == true || number == 1) {
                System.out.printf("%d is a Prime Number \n",number);
                PrimeFactors.append(1);
                PrimeFactors.append(" ");
                PrimeFactors.append(number);
                SetPrimeFactors.add(1);
                SetPrimeFactors.add(number);
            }
            else{
                int divide = number;
                int factors = 2;
                while (!PrimeTest(divide)){
                    if (divide % factors == 0){
                        PrimeFactors.append(factors);
                        PrimeFactors.append(" ");
                        SetPrimeFactors.add(factors);
                        divide = divide / factors;
                        factors = 2;
                    }
                    else{
                        factors++;
                    }
                }
                PrimeFactors.append(divide);
                SetPrimeFactors.add(divide);
            }
            System.out.printf("The Prime Factors for %d are: %s \n", number, PrimeFactors);
            System.out.printf("The Set of Prime Factors for %d are: %s \n", number, SetPrimeFactors);
            PrimeFactors.setLength(0);
            SetPrimeFactors.clear();
        }
    }
    public static boolean PrimeTest (int number)
    {
        boolean prime = true;
        for (int i = number - 1; i > 1; i--) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }
        return prime;
    }
}
