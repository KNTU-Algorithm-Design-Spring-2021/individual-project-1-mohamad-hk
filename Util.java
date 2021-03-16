
package pkg3dclosest;

public class Util {
    int distance_calc = 0;
    
    double closest(Point p[],int n ){
      double closestDist = calculate(p[0], p[1]); // Give a very big number to find minimum distances.
      for (int x = 0; x < n; x++) {
      for (int y = x + 1; y < n; y++) {
        if (calculate(p[x], p[y]) < closestDist)
          closestDist = calculate(p[x], p[y]);
        }  
       }
      return closestDist;
    }
    
    double divideandConquer (Point px[], Point py[], int size)
    {
        if (size <= 3)
            return closest(px, size);
        int intermediate = size / 2;
        Point midPoint = px[intermediate];

        Point[] leftpart = new Point[intermediate + 1];
        Point[] rightpart = new Point[size - intermediate +1];

        int left = 0, right = 0;

        for (int a = 0; a < size; a++)
        {
          if (py[a].x <= midPoint.x)
             leftpart[left++] = py[a];
          else
             rightpart[right++] = py[a];
        }
        
        double lengthl = divideandConquer(px, leftpart, intermediate);
        double lengthr = divideandConquer(px, rightpart, size - intermediate);

        double smallest = Math.min(lengthl, lengthr);

        Point[] midlane = new Point[size];
        int midlength = 0;
        for (int a = 0; a < size; a++)
            if (Math.abs(py[a].x - midPoint.x) < smallest){
                midlane[midlength] = py[a];
                midlength++;
            }

        return Math.min(smallest, midlaneClosest(midlane, midlength, smallest));
    }
    double calculate (Point a, Point b) {
        distance_calc++;  // Calculating total calculation times.
        return Math.sqrt(Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z));
    }
    
    double midlaneClosest (Point[] p, int length, double currentMin)
    {
        double newMin = currentMin;

        for (int a = 0; a < length; ++a)
            for (int b = a + 1; (b < length) && ((p[b].y - p[a].y) < newMin); ++b)
                if (calculate(p[a],p[b]) < newMin)
                    newMin = calculate(p[a], p[b]);

        return newMin;
    }

    
}
