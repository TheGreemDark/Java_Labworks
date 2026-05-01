package java_core_2026.timus.lr6;

import java.util.Scanner;
import java.math.BigInteger;
public class timus_1243 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNext()) {
            String nStr = in.next();
            BigInteger n = new BigInteger(nStr);
            BigInteger seven = new BigInteger("7");
            BigInteger result = n.remainder(seven);
            System.out.println(result.toString());
        } 
        in.close();
    }
}