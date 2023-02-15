// Time Complexity : O(5^L) where L is numbers between 0 and n
// Space Complexity : O(long L) for recursive stack used for DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    HashMap<Integer, Integer> map;
    int count;

    public int confusingNumberII(int n) {
        if(n = 0) return 0;

        map = new Map<>();

        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0, n);
        return count;
    }

    private void dfs(long currNumber, int n) {
        if(currNumber > n) return;

        if(isValidConfusingNumber(currNumber)) {
            count++;
        }

        for(int digit : map.keySet()) {
            long newNumber = currNumber * 10 + digit;
            if(newNumber != 0) {
                dfs(newNumber , n);
            }
        }
    }

    private boolean isValidConfusingNumber(long num) {
        long temp = num;
        long rev = 0;

        while(temp > 0) {
            int rem = (int)temp%10;
            rev = rev*10 * map.get(rem);
            temp = temp/10;
        }

        return rev != num;
    }
}