import javafx.util.Pair;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
//Given an array containing the radii of circular
// cakes and the number of guests, determine the largest piece
// that can be cut from the cakes such that every guest gets a piece
// of the cake with the same area. It is not possible that a single piece
// has some part of one cake and some part of another cake and each guest
// is served only one piece of cake.
//
//        Example 1.
//        Radii = [ 1, 1, 1, 2, 2, 3] numberOfGuests = 6.
//        Output: 7.0686
//
//        Reason being you can take the area of the cake with a radius of 3, and divide by 4. (Area 28.743 / 4 = 7.0686)
//        Use a similary sized piece from the remaining cakes of radius 2 because total area of cakes with radius 2 are > 7.0686
//
//        Example 2.
//        Radii [4, 3, 3] numberOfGuests = 3
//        Output: 28.2743
//
//        Example 3.
//        Radi [6, 7] numberOfGuests = 12
//        Output: 21.9911

public class GoogleSplitPie {
    public double count(int[] radius, int guests) {
        double totalArea = 0;
        for (int radiu : radius) {
            totalArea += getArea(radiu);
        }
        double maxPie = totalArea / guests;

        // [radiu, slices, pieArea]
        Set<Integer> usedRadiu = new HashSet<>();
        PriorityQueue<Pair<int[], Double>> queue = new PriorityQueue<>((x, y) -> {
            if (y.getValue() - x.getValue() > 0) {
                return 1;
            } else if (y.getValue() - x.getValue() == 0) {
                return 0;
            } else {
                return -1;
            }
        });

        for (int radiu : radius) {
            if (usedRadiu.contains(radiu)) {
                continue;
            }
            double area = getArea(radiu);
            int slice = 1;
            while (area / slice > maxPie) {
                slice++;
            }
            queue.add(new Pair<>(new int[]{radiu, slice}, getArea(radiu) / slice));
            usedRadiu.add(radiu);
        }
        double pArea;
        while (true) {
            Pair<int[], Double> plan = queue.poll();
//            System.out.println(plan);
            int count = calPieCount(radius, plan.getValue());
            if (count >= guests) {
                pArea = plan.getValue();
                break;
            }
            queue.add(new Pair<>(new int[]{plan.getKey()[0], plan.getKey()[1] + 1}, getArea(plan.getKey()[0]) / plan.getKey()[1]));
        }
        return pArea;
    }

    private int calPieCount(int[] radius, double pieArea) {
        int count = 0;
        for (int radiu : radius) {
            count += getArea(radiu) / pieArea;
        }
        return count;
    }



    private double getArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        GoogleSplitPie gp = new GoogleSplitPie();
        System.out.println(gp.count(new int[]{1, 1, 1, 2, 2, 3}, 6));
        System.out.println(gp.count(new int[]{4, 3, 3}, 3));
        System.out.println(gp.count(new int[]{6, 7}, 12));

    }
}
