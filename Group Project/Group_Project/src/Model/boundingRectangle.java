package Model;

public class boundingRectangle
{
    double x, y, width, height;

    public boundingRectangle(double x, double y, double width, double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(POI poi)
    {
        return poi.getX() >= x && poi.getX() <= x + width && poi.getY() >= y && poi.getY() <= y + height;
    }
}
