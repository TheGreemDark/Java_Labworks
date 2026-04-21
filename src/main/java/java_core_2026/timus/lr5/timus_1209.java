package java_core_2026.timus.lr5;
import java.util.Scanner;
public class timus_1209 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 

        StringBuilder results = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long k = scanner.nextLong();
            scanner.nextLine(); 

            long blockNumber = findBlockNumber(k);
            long previousCount = (blockNumber - 1) * blockNumber / 2;
            long positionInBlock = k - previousCount;

            if (positionInBlock == 1) {
                results.append("1");
            } else {
                results.append("0");
            }

            if (i < n - 1) {
                results.append(" ");
            }
        }

        System.out.println(results.toString());
        scanner.close();
    }

    private static long findBlockNumber(long k) {
        long low = 1;
        long high = 65536; 
        long blockNumber = 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long numbersUpToMidBlock = mid * (mid + 1) / 2;

            if (numbersUpToMidBlock >= k) {
                blockNumber = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return blockNumber;
    }
}