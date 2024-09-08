//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // your code here
   // Base case: If the array has only one element, no jump is needed
        if (arr.length <= 1) {
            return 0;
        }

        // If the first element is 0, we can't move anywhere
        if (arr[0] == 0) {
            return -1;
        }

        int maxReach = arr[0]; // Stores the maximum reachable index
        int steps = arr[0];    // Steps we can take before a jump is needed
        int jumps = 1;         // Number of jumps made

        // Traverse the array from the 2nd element to the end
        for (int i = 1; i < arr.length; i++) {
            // If we reached the last element, return the number of jumps
            if (i == arr.length - 1) {
                return jumps;
            }

            // Update the maximum reach
            maxReach = Math.max(maxReach, i + arr[i]);

            // Use a step to move forward
            steps--;

            // If no more steps are left
            if (steps == 0) {
                // We must jump
                jumps++;

                // Check if the current position is beyond the maximum reach
                if (i >= maxReach) {
                    return -1; // Not possible to reach further
                }

                // Re-initialize the steps to the amount of steps from the new jump point
                steps = maxReach - i;
            }
        }

        return -1; // In case we never reach the last index
    }
}