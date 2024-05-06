import java.util.Iterator;

public class Words {
    private String[] sl;

    public Words(String[] sl) {
        this.sl = sl;
    }

    public Iterator<String> iterator() {
        return new WordsIterator();
    }

    private class WordsIterator implements Iterator<String> {
        private int current = 0;
        private final int max = (1 << sl.length) - 1;

        public boolean hasNext() {
            return current <= max;
        }

        public String next() {
            StringBuilder wordBuilder = new StringBuilder();
            for (int i = 0; i < sl.length; i++) {
                if ((current & (1 << i)) != 0) {
                    wordBuilder.append(sl[i]);
                }
            }
            current++;
            return wordBuilder.toString();
        }
    }
}
