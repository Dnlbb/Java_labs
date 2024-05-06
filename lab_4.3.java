import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        int[] inputNumbers = {3, 4, 5, 6, 8, 10};
        PythagoreanTriplets pythagoreanTriplets = new PythagoreanTriplets(inputNumbers);

        for (int[] triplet : pythagoreanTriplets) {
            System.out.println(Arrays.toString(triplet));
        }


        String[] w = {"pre", "fiks", "cikl", "post"};
        Words words = new Words(w);
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
