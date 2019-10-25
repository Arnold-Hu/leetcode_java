public class GoogleWatering2 {
    public int solution(int[] plants, int capacity1, int capacity2) {
        if (plants.length <= 0) {
            return 0;
        }
        int water1 = 0;
        int water2 = 0;
        int refill = 0;
        for (int i = 0; i < plants.length / 2; i++) {
            if (water1 < plants[i]) {
                refill++;
                water1 = capacity1;
            }
            water1 -= plants[i];
            if (water2 < plants[plants.length - 1 - i]) {
                refill++;
                water2 = capacity2;
            }
            water2 -= plants[plants.length - 1 -i];
        }
        if (water1 + water2 < plants[plants.length / 2]) {
                refill++;
        }
        return refill;
    }

    public static void main(String[] args) {
        GoogleWatering2 googleWatering2 = new GoogleWatering2();
        System.out.println(googleWatering2.solution(new int[]{2,4,5,1,2}, 5, 7));
        System.out.println(googleWatering2.solution(new int[]{2}, 5, 7));
        System.out.println(googleWatering2.solution(new int[]{}, 5, 7));
    }
}
