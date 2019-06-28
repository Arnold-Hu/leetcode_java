public class P152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];

        int maxPos = 0;
        int maxNeg = 0;

        if (nums[0] > 0) {
            maxPos = nums[0];
        } else if (nums[0] < 0){
            maxNeg = nums[0];
        }



        for (int i = 1; i<nums.length; i++) {

            int num = nums[i];
            System.out.println(num + "," + max + "," + maxNeg + ", "+ maxPos);
            if (num == 0) {
                maxPos = 0;
                maxNeg = 0;
            } else if (num > 0) {
                if (maxNeg == 0 && maxPos == 0) {
                    maxPos = num;
                } else if (maxNeg == 0 && maxPos != 0) {
                    maxPos *= num;
                } else if (maxNeg != 0 && maxPos == 0) {
                    maxPos = num;
                    maxNeg *= num;
                } else {
                    maxNeg *= num;
                    maxPos *= num;
                }
                max = Math.max(max, maxPos);
            } else {
                if (maxNeg == 0 && maxPos == 0) {
                    maxNeg = num;
                } else if (maxNeg == 0 && maxPos != 0) {
                    maxNeg = maxPos * num;
                    maxPos = 0;
                } else if (maxNeg != 0 && maxPos == 0) {
                    maxPos = maxNeg * num;
                    maxNeg = num;
                } else {
                    int temp = maxNeg;
                    maxNeg = maxPos * num;
                    maxPos = temp * num;
                }
                max = Math.max(max, maxPos);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        P152 p152 = new P152();
        System.out.println(p152.maxProduct(new int[]{7 , -2, -4}));
    }

}
