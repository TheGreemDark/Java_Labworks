package java_core_2026.timus.lr8;
import java.io.*;
import java.util.*;
public class timus_1196 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] teacherDates = new int[n];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line != null) {
                teacherDates[i] = Integer.parseInt(line.trim());
            }
        }
        
        String line = br.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = br.readLine();
        }
        int m = Integer.parseInt(line.trim());
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            line = br.readLine();
            while (line != null && line.trim().isEmpty()) {
                line = br.readLine();
            }
            if (line != null) {
                int studentDate = Integer.parseInt(line.trim());
                if (binarySearch(teacherDates, studentDate)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
    
    private static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}