import java.util.Iterator;


public class PythagoreanTriplets implements Iterable<int[]> {
    private int[] numbers;

    public PythagoreanTriplets(int[] numbers) {
        this.numbers = numbers;
    }


    public Iterator<int[]> iterator() {
        return new PythagoreanIterator();
    }

    private class PythagoreanIterator implements Iterator<int[]> {
        private int i = 0, j = 1, k = 2;

        public boolean hasNext() {
            return findNextTriplet();
        }

        public int[] next() {


            int[] triplet = {numbers[i], numbers[j], numbers[k]};

            k++;
            return triplet;
        }

        private boolean findNextTriplet() {
            while (i < numbers.length - 2) {
                while (j < numbers.length - 1) {
                    while (k < numbers.length) {
                        if (isValidTriplet(numbers[i], numbers[j], numbers[k])) {
                            return true;
                        }
                        k++;
                    }
                    j++;
                    k = j + 1;
                }
                i++;
                j = i + 1;
                k = j + 1;
            }
            return false;
        }

        private boolean isValidTriplet(int a, int b, int c) {
            return a * a + b * b == c * c;
        }
    }
}
