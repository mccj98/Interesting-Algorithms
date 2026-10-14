import java.util.Scanner;
public class the_sieve_of_eratosthenes_prime_number_algorithm
{
    public static void main(String[] args) 
    {      
        Scanner u_input = new Scanner(System.in);
        System.out.print("Please enter a value n for which you want the list of prime numbers up to that number: ");
        int n = u_input.nextInt();
        u_input.close();
        boolean[] primes_list = sieve(n);
        System.err.println("The primes number up to " + n + " are :");
        for(int i = 0; i < primes_list.length;i++)
        {
            if (primes_list[i])
            {
                System.out.print(i + ",");
            }
        }   
    }                                                
        public static boolean[] sieve(int n) /*remember the syntax to define a function in java and python are different */
        {
            boolean[] primes = new boolean[n+1];
            primes[0] = false;
            primes[1] = false; /*as 0 and 1 are always false as they are not primes */
            for(int i = 2; i < primes.length; i++) /*sets all values within the array to true - assuming that all elements in the array are primes */
            {
                primes[i] = true;
            }

            for(int p = 2; p <= n; p++) /*increment from 2 (first prime always) to total n */
            {
                if(primes[p])  /*when reached first prime, find its multiples and set them to false */
                {
                    for(int i = 2*p; i <= n; i += p)
                    {
                        primes[i] = false; /*marking all of p's multiples to be false / not prime as the algorithm says */
                    }
                }
            }
            return primes;
        }
}


















