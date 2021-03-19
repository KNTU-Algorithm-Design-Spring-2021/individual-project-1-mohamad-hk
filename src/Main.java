/**
 *Bounding Box with algorithm Tournament
 *
 * @author  mohammad-hk
 * @version 1.0.5
 * @since   2021-03-5
 */
import java.util.Scanner;
public class Main {

    static class Pair {
        int min;
        int max;
    }
    static class MinMax {
        /**
         *
         * @param array A َarray for comparison operations after each division
         * @param lowest  This is the first paramter for start index
         * @param highest This is the second paramter to end index
         * @return min and max each part of array
         */
        static Pair getMM(int array[], int lowest, int highest) {
            Pair mm = new Pair();
            Pair mml = new Pair();
            Pair mmr = new Pair();
            int mid;
/**
 * Only one member in the collection
 */
            if (lowest == highest) {
                mm.max = array[lowest];
                mm.min = array[lowest];
                return mm;
            }
/**
 * There are two members in the collection
 */
            if (highest == lowest + 1) {
                if (array[lowest] > array[highest]) {
                    mm.max = array[lowest];
                    mm.min = array[highest];
                } else {
                    mm.max = array[highest];
                    mm.min = array[lowest];
                }
                return mm;
            }
/**
 * @param mml and mmr use for find min and max on each part of array
 */
            mid = (lowest + highest) / 2;
            mml = getMM(array, lowest, mid);
            mmr = getMM(array, mid + 1, highest);
/**
 * Compare a minimum of two parts
 */
            if (mml.min < mmr.min) {
                mm.min = mml.min;
            } else {
                mm.min = mmr.min;
            }
/**
 * Compare a maximum of two parts
 */
            if (mml.max > mmr.max) {
                mm.max = mml.max;
            } else {
                mm.max = mmr.max;
            }
/**
 * @return min and max
 */
            return mm;
        }
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points:");
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i< n ; i++){
            System.out.println("\nPoint "+(i+1)+":");
            System.out.println("Enter x:");
            x[i] = scanner.nextInt();
            System.out.println("Enter y:");
            y[i] = scanner.nextInt();
        }
        MinMax compare = new MinMax();
        Pair minmaxX = compare.getMM(x, 0, x.length-1);
        Pair minmaxY = compare.getMM(y, 0, y.length-1);
        System.out.println("\nRectangle:\n"+minmaxX.min+" , "+minmaxY.min+"\n"+minmaxX.min+" , "+minmaxY.max);
        System.out.println(minmaxX.max+" , "+minmaxY.min+"\n"+minmaxX.max+" , "+minmaxY.max);

    }
}