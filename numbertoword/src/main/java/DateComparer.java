import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.*;

/**
 * Created by savneet on 06-06-2019.
 */
public class DateComparer {
    public static void main(String[] args) {
        /*DateComparator comparator = new DateComparator();
        String[] dates = new String[]{ "24 Jul 2017", "25 Jul 2017", "11 Jun 1996","01 Jan 2019", "12 Aug 2005", "01 Jan 1997" };
        Arrays.sort(dates,comparator);
        System.out.println(Arrays.toString(dates));*/
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);

        ExecutorService es = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            es.execute(() -> {
                try {
                    if (cyclicBarrier.getNumberWaiting() <= 0) {
                        System.out.println("Count updated");
                    }
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    System.out.println(e);
                }
            });
        }
        es.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"SomeName");
        return t;
    }
}

class DateComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        String[] dateArray1 = o1.split(" ");
        String[] dateArray2 = o2.split(" ");
        int day1 = Integer.parseInt(dateArray1[0]);
        MonthE month1 = MonthE.valueOf(dateArray1[1].toUpperCase());
        int year1 = Integer.parseInt(dateArray1[2]);

        int day2 = Integer.parseInt(dateArray2[0]);
        MonthE month2 = MonthE.valueOf(dateArray2[1].toUpperCase());
        int year2 = Integer.parseInt(dateArray2[2]);

        if (year1 > year2){
            return 1;
        } else if (year2 > year1 ) {
            return -1;
        } else {
            if(month1.getVal() > month2.getVal()){
                return 1;
            }
            else if(month2.getVal() > month1.getVal()){
                return -1;
            } else {
                if (day1 > day2){
                    return 1;
                } else if (day2 > day1 ) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

    }

    private enum MonthE{
        JAN(1),FEB(2),MAR(3),APR(4),MAY(5),JUN(6),JUL(7),AUG(8),SEP(9),OCT(10),NOV(11),DEC(12);
        MonthE(int value){
            this.value = value;
        }
        private int value;
        public int getVal(){
            return value;
        }
    }
}
