public class P275 {
    // has same numbers the first asending then desending array find peak
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;
        while (left <= right) {
            if (left == right) {
                return calHIndex(citations, left);
            }
            if (left == right - 1) {
                return Math.max(calHIndex(citations, left) , calHIndex(citations, right));
            }
            int mid = (left+right) / 2;
            int midH = calHIndex(citations, mid);
            int rightNeibor = mid + 1;
            int leftNeibor = mid - 1;
            while (rightNeibor <= right && calHIndex(citations, rightNeibor) == midH) {
                rightNeibor++;
            }
            while (leftNeibor >= left && calHIndex(citations, leftNeibor) == midH) {
                leftNeibor--;
            }
            if (rightNeibor == right + 1 && leftNeibor == left - 1) {
                return midH;
            }
            if (rightNeibor == right + 1) {
                if (calHIndex(citations, leftNeibor) > midH) {
                    right = leftNeibor;
                } else {
                    return midH;
                }
            } else if (leftNeibor == left - 1) {
                if (calHIndex(citations, rightNeibor) > midH) {
                    left = rightNeibor;
                } else {
                    return midH;
                }
            } else {
                if (calHIndex(citations, leftNeibor) < midH && calHIndex(citations, rightNeibor) < midH) {
                    return midH;
                } else if (calHIndex(citations, leftNeibor) < midH){
                    left = rightNeibor;
                } else {
                    right = leftNeibor;
                }
            }

        }
        return calHIndex(citations, left);

    }


    private int calHIndex(int[] citations, int index) {
        return Math.min(citations[index], citations.length - index);
    }
}
