//There are N children standing in a line. Each child is assigned a rating value.
//
//    You are giving candies to these children subjected to the following requirements:
//
//    Each child must have at least one candy.
//    Children with a higher rating get more candies than their neighbors.
//    What is the minimum candies you must give?
//
//    Example 1:
//
//    Input: [1,0,2]
//    Output: 5
//    Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
//    Example 2:
//
//    Input: [1,2,2]
//    Output: 4
//    Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
//    The third child gets 1 candy because it satisfies the above two conditions.

import java.util.Arrays;

public class P135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int[] candies = new int[ratings.length];
        for (int i=0; i<ratings.length; i++) {
            fill(ratings, candies, i);
        }
        int sum = 0;
        for (int i=0; i<ratings.length; i++) {
            sum+=candies[i];
        }

        return sum;

    }

    public void fill(int[] ratings, int[] candies, int index) {
        if (candies[index] > 0) {
            return;
        }

        if (index == 0) {
            if (ratings[0] > ratings[1]) {
                fill(ratings, candies, 1);
                candies[0] = candies[1] + 1;
            } else {
                candies[0] = 1;
            }
            return;
        }
        if (index == ratings.length - 1) {
            if (ratings[index] > ratings[index-1]) {
                candies[index] = candies[index-1] + 1;
            } else {
                candies[index] = 1;
            }
            return;
        }

        if (ratings[index] <= ratings[index+1]) {
            if (ratings[index] <= ratings[index-1]) {
                candies[index] = 1;
            } else {
                candies[index] = candies[index-1] + 1;
            }
        } else {
            fill(ratings, candies, index+1);
            if (ratings[index] <= ratings[index-1]) {
                candies[index] = candies[index+1] + 1;
            } else {
                candies[index] = Math.max(candies[index-1], candies[index+1]) + 1;
            }
        }

    }


}
