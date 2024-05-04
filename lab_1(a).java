public class BitSet {
    private long bitmask;
    public BitSet() {
        bitmask = 0;
    }
    public void add(int number) {
        if (number >= 0 && number <= 63) {
            bitmask |= 1L << number;
        }
    }
    public void remove(int number) {
        if (number >= 0 && number <= 63) {
            bitmask &= ~(1L << number);
        }
    }
    public boolean contains(int number) {
        if (number >= 0 && number <= 63)  {
            return (bitmask & (1L << number)) != 0;
        }
        return false;
    }
    public void union(BitSet other) {
        bitmask |= other.bitmask;
    }
    public void intersect(BitSet other) {
        bitmask &= other.bitmask;
    }
    public void printSet() {
        System.out.print("{");
        boolean isFirst = true;
        for (int i = 0; i <= 63; i++) {
            if (contains(i)) {
                if (!isFirst) {
                    System.out.print(", ");
                } else {
                    isFirst = false;
                }
                System.out.print(i);
            }
        }
        System.out.println("}");
    }
}

public class Main {
    public static void main(String[] args) {
        BitSet set1 = new BitSet();
        BitSet set2 = new BitSet();
        BitSet set3 = new BitSet();
        set3.add(0);
        set1.add(5);
        set1.add(7);
        set1.add(8);
        set2.add(9);
        set2.add(7);
        set2.add(10);
        System.out.println(set1.contains(7));
        System.out.println(set1.contains(1));
        set1.union(set2);
        set3.intersect(set2);
        set3.printSet();
        set1.printSet();
    }

}
