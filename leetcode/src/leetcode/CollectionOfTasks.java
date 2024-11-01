package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CollectionOfTasks {
    // 136. 只出现一次的数字 I
    public int singleNumber1(int[] nums) {
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }

        return result;
    }

    //137. 只出现一次的数字 II
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums){
            if( map.containsKey(num) ){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }

        for (int key : map.keySet()){
            if (map.get(key) == 1){
                return key;
            }
        }
        return  0;
    }

    // 260. 只出现一次的数字 III
    public int[] singleNumber3(int[] nums) {
        int result = 0;
        for(int num : nums){
            result = result ^ num;
        }

        int theFirstOne;
        theFirstOne = result & (~result + 1);

        int anotherResult = 0;
        for (int num : nums){
            if((theFirstOne & num) == theFirstOne){
                anotherResult ^= num;
            }
        }

        return new int[]{anotherResult, anotherResult^result};
    }

    // 75. 颜色分类
    public void sortColors(int[] nums) {
        int left, right;
        left = -1;
        right = nums.length;

        int i, temp;
        i = 0;

        while (i < right){
            if(nums[i] == 0){
                temp = nums[left+1];
                nums[left+1] = nums[i];
                nums[i] = temp;

                i++;
                left++;


            }else if (nums[i] == 1){
                i++;
            }else {
                right--;
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
            }
        }

    }

    // LCR 170. 交易逆序对的总数
//    public int reversePairs(int[] record) {
//
//    }


    // 198. 打家劫舍
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = dp[0] > nums[1] ? dp[0] : nums[1];

        for (int i = 2; i < nums.length; i++){
            dp[i] = (dp[i-2] + nums[i]) > dp[i-1] ? (dp[i-2] + nums[i]) : dp[i-1];
        }
        return dp[nums.length-1];
    }

    // 1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }

            if (!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    // 4. 寻找两个正序数组的中位数
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//    }

    // 215. 数组中的第K个最大元素
    public void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] partition(int[] nums, int L, int R){
        swap(nums, L + (int)Math.random() * (R - L + 1), R);
        int left = L - 1, right = R, i = L;
        while (i < right){
            if(nums[i] < nums[R]){
                swap(nums, left + 1, i);
                left++;
                i++;
            }else if (nums[i] == nums[R]){
                i++;
            }else {
                swap(nums, i, right - 1);
                right--;
            }
        }

        swap(nums, R, right);
        return new int[]{left + 1, right};
    }
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0, right = len - 1;
        while (true){
            int[] results = partition(nums, left, right);
            if (results[0] <= target && results[1] >= target)
                return nums[target];
            else if (target < results[0])
                right = results[0] - 1;
            else if (target > results[1])
                left = results[1] + 1;
        }
    }

    // 11. 盛最多水的容器
    public int maxArea(int[] height) {
        int i = 0, j = height.length;
        int max = height[i] > height[j] ? (j - i) * height[j] : (j - i) * height[i];


        while (i < j){
            if (height[i] < height[j]){

            }
        }

        return  0;
    }

    // 55. 跳跃游戏
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int max = nums[0];

        for (int i = 1; i < length - 1; i++){
            if(i <= max){
                max = max < (nums[i] + i) ? (nums[i] + i) : max;
            }
        }

        return max >= length - 1;
    }

    // 45. 跳跃游戏 II
    public int jump(int[] nums) {
        int length = nums.length, max = 0;
        int[] dp = new int[length];
        dp[0] = 0;

        for (int i = 1; i <= nums.length - 1; i++){
            if(i <= max){
                max = max < (nums[i] + i) ? (nums[i] + i) : max;
//                dp[i] =
            }
        }
        return 0;
    }

    public int getMaxOneBorder(int[][] arr) {
        if(arr == null){
            return 0;
        }
        int len = arr.length;
        int[][] width = new int[len][];
        int[][] height = new int[len][];

        for (int i = 0; i < len; i++) {
            width[i] = new int[len]; // 创建新数组
            height[i] = new int[len]; // 创建新数组
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {

                if (j == 0) width[i][j] = arr[i][j];
                else width[i][j] = (arr[i][j] != 0 && arr[i][j - 1] != 0) ? arr[i][j] + arr[i][j - 1] : arr[i][j];

                if (i == 0) height[j][i] = arr[j][i];
                else height[j][i] = (arr[j][i] != 0 && arr[j - 1][i] != 0) ? arr[j][i] + arr[j - 1][i] : arr[j][i];
            }
        }

        for (int i = 0; i < len; i++) {
            System.out.println(width[i]);
        }

        return 0;
    }


    // 206


    public void preOrder(){

    }
}
