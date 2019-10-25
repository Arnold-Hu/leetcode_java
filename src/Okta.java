import javax.swing.*;
import java.util.*;

public class Okta {
    /**
     * @param customers
     * Customer arrival data (array of strings) sorted by arrival timestamp
     * Format of each entry - "<arrivalTimestamp>,<serviceTime>,<toleranceTime>"
     *
     * @param numWindows
     * Number of windows for serving customers
     *
     * @param queueSize
     * Size of the DMV queue
     *
     * @return an array of integers of size `numWindows+1` where the 0-th index represents the total number of customers served by the DMV and indexes 1 to `numWindows` represent the number of customers served at each window.
     */



    public int[] solution(String[] customers, int numWindows, int queueSize) {
        // build windows
        PriorityQueue<Window> windows = new PriorityQueue<Window>((x, y) -> {
            if (x.getAvaTime() != y.getAvaTime()) {
                return x.getAvaTime() - y.getAvaTime();
            } else {
                return x.getWindowIndex() - y.getWindowIndex();
            }
        });

        for (int i = 0; i < numWindows; i++) {
            windows.add(new Window(i));
        }

        // build customer list
        List<Customer> customersList = new LinkedList<>();
        for (String c : customers) {
            String[] line = c.split(",");
            customersList.add(new Customer(
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2])
            ));
        }

        // build queue
        List<Customer> queue = new LinkedList<>();

        int leastTime = -1;
        for (Customer customer : customersList) {
            simulate(windows, leastTime, queue, customer.getArrivalTimestamp());
            leastTime = customer.getArrivalTimestamp();
            if (queue.size() < queueSize) {
                queue.add(customer);
                System.out.println("push custumer " + customer);
                System.out.println(queue);
            } else {
                System.out.println("queue full, remove custumer " + customer);
            }
        }

        // process the left people in queue
        simulate(windows, leastTime, queue, Integer.MAX_VALUE);

        int[] ret = new int[numWindows+1];
        int sum = 0;
        for (Window window : windows) {
            ret[window.getWindowIndex() + 1] = window.getServedPeople();
            sum += window.getServedPeople();
        }
        ret[0] = sum;
        return ret;
        // write your code in Java
    }

    // simulate when next customer in
    // leastTime the minimal time windows start work, maybe larger than window avaTime
    private void simulate(PriorityQueue<Window> windows, int leastTime, List<Customer> queue, int time) {
        System.out.println("start simulate until " + time);
        System.out.println(queue);
        Iterator<Customer> iter = queue.iterator();
        while (windows.peek().getAvaTime() <= time) {
            if (!iter.hasNext()) {
                break;
            }
            Customer customer = iter.next();
            //
            if (customer.getArrivalTimestamp() + customer.getToleranceTime() >= windows.peek().getAvaTime()) {
                Window window = windows.poll();
                System.out.println("ava window " + window);
                int startTime = leastTime;
                if (window.getAvaTime() > startTime) {
                    startTime = window.getAvaTime();
                }
                window.serve(customer, startTime);
                windows.add(window);
            } else {
                System.out.println("customer out of tolerance " + customer);
            }

            iter.remove();
        }
        System.out.println("end queue " + queue);
        queue.removeIf(c -> c.getArrivalTimestamp() + c.getToleranceTime() <= time);
    }

    public static void main(String[] args) {
        Okta okta = new Okta();
        System.out.println(Arrays.toString(okta.solution(
                new String[]{"1,5,10", "2,5,10", "3,5,10", "4,5,10"},
                2,
                10)));
    }
}
class Customer {
    public int getArrivalTimestamp() {
        return arrivalTimestamp;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getToleranceTime() {
        return toleranceTime;
    }

    private int arrivalTimestamp;
    private int serviceTime;
    private int toleranceTime;
    public Customer(int aT, int sT, int tT) {
        this.arrivalTimestamp = aT;
        this.serviceTime = sT;
        this.toleranceTime = tT;
    }

    @Override
    public String toString() {
        return this.arrivalTimestamp + " " + this.serviceTime + " " + this.toleranceTime;
    }
}

class Window {
    public int getAvaTime() {
        return avaTime;
    }

    public int getWindowIndex() {
        return windowIndex;
    }

    public void serve(Customer customer, int time) {
        this.avaTime = time + customer.getServiceTime();
        servedPeople++;
        System.out.println("serve costumer " + customer);
        System.out.println("serve start time " + time);
    }

    public int getServedPeople() {
        return servedPeople;
    }

    private int avaTime;
    private int windowIndex;
    private int servedPeople;

    public Window(int index) {
        this.windowIndex = index;
        this.avaTime = -1;
        this.servedPeople = 0;
    }
    @Override
    public String toString() {
        return this.getWindowIndex() + " " + this.getAvaTime() + " " + this.getServedPeople();
    }
}

