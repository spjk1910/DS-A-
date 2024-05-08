package Model;

public class POI implements Comparable<POI>
{
    double x;
    double y;
    ArrayList <String> services;

    // Constructor
    public POI(double x, double y, ArrayList <String> services)
    {
        this.x = x;
        this.y = y;
        this.services = services;
    }

    // Getter for x coordinate
    public double getX()
    {
        return x;
    }

    // Getter for y coordinate
    public double getY()
    {
        return y;
    }

    // Getter for list of services
    public ArrayList<String> getServices()
    {
        return services;
    }

    // Comparable interface method implementation to compare POIs - first by x coordinate, then by y coordinate
    // Used for sorting POIs in AVL tree
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

    // Override toString method to provide a string representation of the POI
    @Override
    public String toString()
    {
        return  "x = " + x +
                ", y = " + y +
                ", services = " + services;
    }
}
