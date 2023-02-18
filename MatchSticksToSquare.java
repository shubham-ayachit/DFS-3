// Time Complexity : O(2^n)
// Space Complexity : O(n) stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks == null || matchsticks.length == 0) return false;

        int sum = 0;
        for(int match : matchsticks) {
            sum = sum + match;
        }

        if(sum%4 != 0) {
            return false;
        }

        int side = sum/4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return backtracking(matchsticks, 0, side, new int[4]);

    }

    private boolean backtracking(int[] matchsticks, int index, int side, int[] sides) {
        //base
        if(index == matchsticks.length) {
            if(sides[0] == side && sides[1] == side && sides[2] == side){
                return true;
            }
            return false;
        }

        //logic
        for(int i = 0; i<4; i++) {
            if(matchsticks[index] + sides[i] <= side) {
                //action
                sides[i] = sides[i] + matchsticks[index];
                //recurrsion
                if(backtracking(matchsticks, index + 1, side, sides)) {
                    return true;
                }

                //backtrack
                sides[i] = sides[i] - matchsticks[index];
            }
        }

        return false;
    }

    private void reverse(int[] matchsticks) {
        int left = 0, right = matchsticks.length-1;

        while(left <= right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;

            left++;
            right--;
        }
    }
}