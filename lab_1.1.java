public class Point {

    private double m;
    private double v;

    public Point(double  v, double m) {
        this.m = m;
        this.v = v;
    }

    public double getM() {
        return m;
    }

    public void setM(float m) {
        this.m = m;
    }

    public double getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    public double KIN() {
        return (this.m * this.v * this.v) / 2;
    }


}

