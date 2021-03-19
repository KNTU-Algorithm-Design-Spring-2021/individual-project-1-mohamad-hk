/**
 * @author  mohamad-hk
 * @version 1.0.16
 * @since   2021-03-9
 */
package pkg;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Util t = new Util();
        Vector<Point> v = new Vector<Point>();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter number of points:");
        /**
         * @param n this is use for get number of points
         */
        int n = Integer.parseInt(scanner.nextLine());
        Point tempPoint;
        for(int i = 0 ; i<n ; i++){
            tempPoint = new Point();
            System.out.println("Enter three values seperated by space:");
            String[] input = scanner.nextLine().split(" ");

             //Separate parameters x, y and z

            for(int j =0 ; j<n ; j++){
                tempPoint.x = Integer.parseInt(input[0]);
                tempPoint.y = Integer.parseInt(input[1]);
                tempPoint.z = Integer.parseInt(input[2]);
            }
            v.add(tempPoint);
        }
        System.out.println("End of input");

        //Make two vectors x and y

        Vector<Point> vecX = new Vector<>(v);
        Collections.copy(vecX, v);
        Vector<Point> vecY = new Vector<>(v);
        Collections.copy(vecY, v);

        //compare by x

        Comparator<Point> compare_x = new Comparator<Point>() {
            @Override
            public int compare(Point fst, Point snd) {
                if(fst.x <= snd.x)
                    return 1;
                else
                    return 0;
            }
        };
        Collections.sort(vecX, compare_x);

        //compare by y

        Comparator<Point> compare_y = new Comparator<Point>() {
            @Override
            public int compare(Point fst, Point snd) {
                if(fst.y <= snd.y)
                    return 1;
                else
                    return 0;
            }
        };

         //Pouring vectors into the َArrays of x,y

        Collections.sort(vecY, compare_y);
        Object[] objArray = v.toArray();
        Point[] va = Arrays.copyOf(objArray, objArray.length, Point[].class);

        Object[] objArray2 = vecX.toArray();
        Point[] vax = Arrays.copyOf(objArray2, objArray2.length, Point[].class);

        Object[] objArray3 = vecY.toArray();
        Point[] vay = Arrays.copyOf(objArray3, objArray3.length, Point[].class);


        System.out.println("The distance is: " + t.divide(vax, vay, v.size()));
    }
}