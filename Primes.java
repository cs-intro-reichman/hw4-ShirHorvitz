import java.util.Arrays;

public class Primes {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Try another number");
            return;
        }
        int n = Integer.parseInt(args[0]);
        if (n < 2) {
            System.out.println("There are no prime numbers less than 2.");
            return;
        }
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= n; i++){
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i){
                    prime[j] = false;
                }
            }
        }
        System.out.println("Prime numbers up to " + n + ":");
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }
        System.out.println("There are " + primeCount + " primes between 2 and " + n +
                           " (" + (primeCount * 100 / (double)n) + "% are primes).");
    }
}