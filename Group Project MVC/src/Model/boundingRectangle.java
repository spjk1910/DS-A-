package Model;

public class boundingRectangle
{
    double x, y, width, height;

    // Constructor
    public boundingRectangle(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Method to check if a POI is contained within this bounding rectangle
    public boolean contains(POI poi)
    {
        // Check if the coordinates of the POI fall within the boundaries of this rectangle
        return poi.getX() >= x && poi.getX() <= x + width && poi.getY() >= y && poi.getY() <= y + height;
    }
}
