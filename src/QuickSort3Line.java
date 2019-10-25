import java.util.Arrays;

// 3 way quick sort
// can handle the sort with dup elements
// O(nlogn) time complexity
// O(1) space complexity
public class QuickSort3Line {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int[] positions = partition(arr, left, right);
        sort(arr, left, positions[0]);
        sort(arr, positions[1], right);
    }

    public static int[] partition(int[] arr, int left, int right) {
        int lt = left;
        int gt = right;
        int i = left;
        int mid = (left + right) / 2;
        int midV = arr[mid];
        while (i <= gt) {
            if (arr[i] == midV) {
                i++;
            } else if (arr[i] < midV) {
                swap(arr, i, lt);
                i++;
                lt++;
            } else {
                swap(arr, i, gt);
                gt--;
            }
        }
        return new int[]{lt - 1, gt + 1};
    }

    public static void swap(int[] arr, int p1, int p2) {
        if (p1 == p2) {
            return;
        }
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{6,6,4,6,7,7,8,15,7,9,2,0,1,8,9,8,0,6};
        System.out.println(arr.length);
        QuickSort3Line.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
