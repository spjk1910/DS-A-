package Model;

public class POI implements Comparable<POI>
{
    double x;
    double y;
    ArrayList <String> services;

    public POI(double x, double y, ArrayList<String> services)
    {
        this.x = x;
        this.y = y;
        this.services = services;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public ArrayList<String> getServices()
    {
        return services;
    }

    @Override
    public int compareTo(POI other)
    {
        int xCompare = Double.compare(this.x, other.x);
        if (xCompare != 0)
        {
            return xCompare;
        }
        return Double.compare(this.y, other.y);
    }

    @Override
    public String toString()
    {
        return  "x=" + x +
                ", y=" + y +
                ", services=" + services;
    }
}
