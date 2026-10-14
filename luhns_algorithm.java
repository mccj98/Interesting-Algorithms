import java.util.Scanner;
/*import java.util.ArrayList;*/

public class luhns_algorithm { /*Used to validate credit card numbers and IMEI'S */
    public static Scanner u_input = new Scanner(System.in);

    public static void main(String args[]) {
        /*
         * I was going to use this ArrayList to keep track of the values to be sumed,
         * however i realised that record of  values is not
         * necessary, hence sum operation with each iteration
         */
        System.out.println("Please enter the number you wish to test for validility with Luhns Algorithm: ");
        String input = u_input.nextLine(); /* String for length calculation, easy to convert char to int */
        u_input.close();
        Long input_int = Long.parseLong(input); /*integer max value of 10 digits, so must we long */ 
        int sum = 0;
        for (int i = input.length() - 1; i >= 0; i = i - 2) /* start at second digit from right */
        {
            sum = sum + (int)(input_int % 10); /*need to cast type int on the long operation as an operation involving a long and a int will result in the int being 'promoted' to a long, resulting in trying to assign a long value into int, causes error */
            input_int = input_int / 10; /*gets rid of processed element*/
            int cal = (int)(input_int % 10) * 2; /*Extracts digit and doubles */
            if (cal > 9) {
                int second = cal % 10; /* to get the rightmost digit */
                cal = cal / 10; /* to get rid of the rightmost digit */
                /*list.add(second+cal); */
                sum = sum + second + cal;
            } else {
                /*list.add(cal); */
                sum = sum + cal;
            }
            input_int = input_int / 10;
        }
        /*System.out.println(sum);*/
        if(sum % 10 == 0) /*if a multiple of 10 */
        {
            System.out.println("Number is valid");
        }
        else
        {
            System.out.println("Number is not valid");
        }
    }
}
