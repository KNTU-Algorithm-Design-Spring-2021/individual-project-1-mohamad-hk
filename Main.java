import java.util.Scanner;
public class Main {
    //baraye negahdari zoje moratab (minimum, maximum)
    static class Pair {
        int min;
        int max;
    }
    //jostoju min o max be raveshe Tournament
    static class MinMax {
            static Pair getMM(int array[], int lowest, int highest) {
            Pair mm = new Pair();
            Pair mml = new Pair();
            Pair mmr = new Pair();
            int mid;
     
            // tanha yek ozv dar majmue bashad
            if (lowest == highest) {
                mm.max = array[lowest];
                mm.min = array[lowest];
                return mm;
            }
     
            //2 ozv dar majmue bashad
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
     
            //tedad ozv bishtar az 2 ta
            mid = (lowest + highest) / 2;
            mml = getMM(array, lowest, mid);
            mmr = getMM(array, mid + 1, highest);
     
            //moghayese minimum 2 ghesmat
            if (mml.min < mmr.min) {
                mm.min = mml.min;
            } else {
                mm.min = mmr.min;
            }
     
            //moghayese maximum 2 ghesmat
            if (mml.max > mmr.max) {
                mm.max = mml.max;
            } else {
                mm.max = mmr.max;
            }
     
            return mm;
        }
    }
 
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many points do you want to enter?:");
        int n = scanner.nextInt();
        //array baraye negahdari x noghat
        int[] x = new int[n];
        //array baraye negahdari y noghat
        int[] y = new int[n];
        for(int i=0; i< n ; i++){
            System.out.println("\nPoint "+(i+1)+":");
            System.out.println("Enter X:");
            x[i] = scanner.nextInt();
            System.out.println("Enter Y:");
            y[i] = scanner.nextInt();
        }
        MinMax compare = new MinMax();
        Pair minmaxX = compare.getMM(x, 0, x.length-1);
        Pair minmaxY = compare.getMM(y, 0, y.length-1);
        System.out.println("\nRectangle:\n"+minmaxX.min+" , "+minmaxY.min+"\n"+minmaxX.min+" , "+minmaxY.max);
        System.out.println(minmaxX.max+" , "+minmaxY.min+"\n"+minmaxX.max+" , "+minmaxY.max);
 
    }
}