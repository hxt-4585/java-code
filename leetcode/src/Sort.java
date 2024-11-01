public class Sort {
    public static void swap(int[] arr, int i, int j){
        // 使用异或 前提i!=j
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];

        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] nums, int left, int right){
        if(left == right)
            return;

        int mid = left + (right - left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }
    public static void merge(int[] nums, int left, int mid, int right){
        int[] help = new int[right - left + 1];
        int i = left, j = mid + 1, p = 0;
        while (i <= mid && j <= right){
            help[p++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid){
            help[p++] = nums[i++];
        }
        while (j <= right){
            help[p++] = nums[j++];
        }

        for(i = left; i <= right; i++){
            nums[i] = help[i-left];
        }
    }

    public static void quickSort(int[] nums, int L, int R){
        if (L >= R)
            return;
        swap(nums, L + (int)Math.random() * (R-L+1), R);
        int[] separate = partition(nums, L, R);
        quickSort(nums, L, separate[0] - 1);
        quickSort(nums, separate[1] + 1, R);

    }

    public static int[] partition(int[] nums, int L, int R){
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

    public static void heapInsert(int[] nums, int index){
        while (nums[index] > nums[(index - 1)/2]){
            swap(nums, index, index - 1);
            index = (index - 1)/2;
        }
    }

    public static void heapify(int[] nums, int index, int heapSize){
        int left = index * 2 + 1, largest;
        while (left < heapSize){
            largest = left + 1 < heapSize && nums[left] > nums[left + 1] ? left : left + 1;

            if (nums[largest] > nums[index]){
                swap(nums, largest, index);
            }else break;

            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapSort(int[] nums){
        if (nums == null || nums.length < 2)
            return;
//          第一种
//        for (int i = 0; i < nums.length; i++){
//            heapInsert(nums, i);
//        }

        // 第二种
        for (int i = nums.length - 1; i >= 0; i--){
            heapify(nums, i, nums.length);
        }

        int heapSize = nums.length;
        while (heapSize > 0){
            swap(nums, --heapSize, 0);
            heapify(nums, 0, heapSize);
        }
    }


}
