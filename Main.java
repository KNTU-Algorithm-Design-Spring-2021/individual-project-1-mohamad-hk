package pkg3dclosest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
      Util t = new Util();
      Vector<Point> v = new Vector<Point>();
      Scanner scanner = new Scanner(System.in);
      
      // Read values and write into a vector.
      System.out.println("Number of points:");
      int n = Integer.parseInt(scanner.nextLine());
      Point tempPoint = new Point();
      for(int i = 0 ; i<n ; i++){
          tempPoint = new Point();
           System.out.println( (i+1) + ":(Enter three values seperated by space)");
          String[] input = scanner.nextLine().split(" ");
          for(int j =0 ; j<n ; j++){
              tempPoint.x = Integer.parseInt(input[0]);
              tempPoint.y = Integer.parseInt(input[1]);
              tempPoint.z = Integer.parseInt(input[2]);
          }
          v.add(tempPoint);
      }
      
      Vector<Point> vx = new Vector<Point>(v);
      Collections.copy(vx, v);
      Vector<Point> vy = new Vector<Point>(v);
      Collections.copy(vy, v);
      
      Comparator<Point> compare_x = new Comparator<Point>() {
      @Override
        public int compare(Point fst, Point snd) {
          if(fst.x <= snd.x)
              return 1;
          else 
              return 0;
        }
      };
      Collections.sort(vx, compare_x);  // Sort vx in terms of x coordinates. O(nlogn) sorting complexity.
      
     Comparator<Point> compare_y = new Comparator<Point>() {
      @Override
        public int compare(Point fst, Point snd) {
            if(fst.y <= snd.y)
                return 1;
            else 
                return 0;
          }
      };
      Collections.sort(vy, compare_y);
      // Initialize "va" array to copy vector and use it in recursive calls.
      Object[] objArray = v.toArray();
      Point[] va = Arrays.copyOf(objArray, 
                                       objArray.length, 
                                       Point[].class); 

      // Initialize "vax" array to copy vector and use it in recursive calls.
      Object[] objArray2 = vx.toArray();
      Point[] vax = Arrays.copyOf(objArray2, 
                                       objArray2.length, 
                                       Point[].class); 

       // Initialize "vay" array to copy vector and use it in recursive calls.
      Object[] objArray3 = vy.toArray();
      Point[] vay = Arrays.copyOf(objArray3, 
                                       objArray3.length, 
                                       Point[].class); 
      t.distance_calc = 0;

      System.out.println("The distance is (Divide & Conquer): " + t.divideandConquer(vax, vay, v.size()));
      System.out.println( "Number of total distance calculations is (Divide & Conquer): "+ t.distance_calc); 
    }
}