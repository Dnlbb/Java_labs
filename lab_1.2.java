public class Universe {
    private static int totalPoints  = 0;

    public Point[] points = new Point[1000];

    public void AddP(Point point) {
        this.points[totalPoints] = point;
        totalPoints++;
    }


   public double TotalKIN(){
        double total = 0;
        for(int i = 0; i < totalPoints; i++){
            total += this.points[i].KIN();
        }
        return total / totalPoints;
   }
}
