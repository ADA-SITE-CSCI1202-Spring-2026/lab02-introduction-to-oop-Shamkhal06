package week03.geometry;

public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2){
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    public Segment(float x1, float y1, float x2, float y2){
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Point getP1(){
        return this.p1;
    }

    public void setP1(Point p){
        this.p1 = p;
    }

    public Point getP2(){
        return this.p2;
    }

    public void setP2(Point p){
        this.p2 = p;
    }

    public void translate(float dX, float dY){
        p1.translate(dX, dY);
        p2.translate(dX, dY);
    }

    public float length(){
        return p1.distance(p2);
    }

    public boolean equals(Segment s){
        return p1.equals(s.p1) && p2.equals(s.p2);
    }

    public float getSlope(){
        float dx = p2.getX() - p1.getX();
        float dy = p2.getY() - p1.getY();

        if (dx == 0)
            throw new ArithmeticException("Vertical line - slope undefined");

        return dy / dx;
    }

    public float getIntercept(){
        float slope = getSlope();
        return p1.getY() - slope * p1.getX();
    }

    public boolean isOnLine(Point p){
        if (p2.getX() - p1.getX() == 0) {
            return p.getX() == p1.getX();
        }

        float slope = getSlope();
        float intercept = getIntercept();

        return p.getY() == slope * p.getX() + intercept;
    }


    public boolean isOnSegment(Point p){
        if (!isOnLine(p))
            return false;

        return p.getX() >= Math.min(p1.getX(), p2.getX()) &&
               p.getX() <= Math.max(p1.getX(), p2.getX()) &&
               p.getY() >= Math.min(p1.getY(), p2.getY()) &&
               p.getY() <= Math.max(p1.getY(), p2.getY());
    }
}
