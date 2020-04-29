package B_creational.C_prototype;

public class D_Exercise {
    public static void main(String[] args) {
        Line line = new Line(new Point(2, 3), new Point(4, 5));
        Line line2 = line.deepCopy();
        line2.start.x = 6;
        System.out.println(line);
        System.out.println(line2);
    }
}

class Point
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy()
    {
        return new Line(new Point(start), new Point(end));
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

