package pkg;

public class Util {

    /**
     * This method is similar to brute force
     * @param p An array of point class
     * @param n length of array
     * @return closest distance
     */
    double closest(Point[] p, int n ){
        double closestDist = calculate(p[0], p[1]);
        for (int x = 0; x < n; x++) {
            for (int y = x + 1; y < n; y++) {
                if (calculate(p[x], p[y]) < closestDist)
                    closestDist = calculate(p[x], p[y]);
            }
        }
        return closestDist;
    }

    /**
     *
     * @param px array of x
     * @param py array of y
     * @param size length of array
     * @return minimum distance
     */
    double divide(Point[] px, Point[] py, int size)
    {
        if (size <= 3)
            return closest(px, size);
        int intermediate = size / 2;
        Point midPoint = px[intermediate];

        Point[] left_part = new Point[intermediate + 1];
        Point[] right_part = new Point[size - intermediate +1];

        int left = 0, right = 0;

        for (int a = 0; a < size; a++)
        {
            if (py[a].x <= midPoint.x)
                left_part[left++] = py[a];
            else
                right_part[right++] = py[a];
        }

        double length_l = divide(px, left_part, intermediate);
        double length_r = divide(px, right_part, size - intermediate);

        double smallest = Math.min(length_l, length_r);

        Point[] mid = new Point[size];
        int mid_length = 0;
        for (int a = 0; a < size; a++)
            if (Math.abs(py[a].x - midPoint.x) < smallest){
                mid[mid_length] = py[a];
                mid_length++;
            }

        return Math.min(smallest, Mid_closest(mid, mid_length, smallest));
    }

    /**
     * this method is calculate distance between points
     * @param a a point
     * @param b a point
     * @return Output based on Euclidean algorithm
     */
    double calculate (Point a, Point b) {
        return Math.sqrt(Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z));
    }

    /**
     * this method is Finds the shortest distance
     * @param p array of points
     * @param length length of array
     * @param currentMin The smallest current value of the distance
     * @return new minimum
     */
    double Mid_closest (Point[] p, int length, double currentMin)
    {
        double newMin = currentMin;

        for (int a = 0; a < length; ++a)
            for (int b = a + 1; (b < length) && ((p[b].y - p[a].y) < newMin); ++b)
                if (calculate(p[a],p[b]) < newMin)
                    newMin = calculate(p[a], p[b]);

        return newMin;
    }


}
