public class Main {
    public static void main(String[] args) {
      Point point1 = new Point(5,6);
      Point point2 = new Point(6,7);
      Point point3 = new Point(7,8);
      Universe uni = new Universe();
      uni.AddP(point1);
      uni.AddP(point2);
      uni.AddP(point3);
      System.out.println(uni.TotalKIN());
    }
}
