import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiSearch {
    // 重复，找插入位置
    // 重复插入最后面
//    static int search(List<Integer> integers, int target) {
//        return search(integers, target, 0, integers.size()-1);
//    }

    // find first larger position
    static int searchFindFirstBiggerPosition(List<Integer> integers, int target, int startIndex, int endIndex) {
        if (integers.size() == 0) {
            return 0;
        }
        if (integers.get(startIndex) > target) {
            return startIndex;
        }
        if (integers.get(endIndex) <= target) {
            return endIndex + 1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (integers.get(mid) <= target) {
            return searchFindFirstBiggerPosition(integers, target, mid + 1, endIndex);
        } else {
            return searchFindFirstBiggerPosition(integers, target, startIndex, mid);
        }
    }

    static int findExactPosition(List<Integer> integers, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (integers.get(mid) == target) {
            return mid;
        } else if (integers.get(mid) > target) {
            return findExactPosition(integers, target, startIndex, mid - 1);
        } else {
            return findExactPosition(integers, target, mid + 1, endIndex);
        }

    }

    static int findFirstExactPosition(List<Integer> integers, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int mid = (startIndex + endIndex) / 2;
        if (integers.get(mid) == target) {
            while (mid - 1 >= 0 && integers.get(mid - 1) == target) {
                mid--;
            }
            return mid;
        } else if (integers.get(mid) > target) {
            return findFirstExactPosition(integers, target, startIndex, mid - 1);
        } else {
            return findFirstExactPosition(integers, target, mid + 1, endIndex);
        }

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(0,0,0,1,1,1,1,4,5,6,6,6,6,7));
        System.out.println(findFirstExactPosition(list, 0, 0, list.size() - 1));
        System.out.println(findFirstExactPosition(list, 1, 0, list.size() - 1));
        System.out.println(findFirstExactPosition(list, 6, 0, list.size() - 1));
        System.out.println(findFirstExactPosition(list, 4, 0, list.size() - 1));
        System.out.println(findFirstExactPosition(list, 11, 0, list.size() - 1));
    }


}
