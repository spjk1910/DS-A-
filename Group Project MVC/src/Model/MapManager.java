package Model;

public class MapManager
{
    private AVL<POI> poiTree;

    // Setter for poiTree - using to update the AVL tree after changing
    public void setPoiTree(AVL<POI> newPoiTree)
    {
        this.poiTree = newPoiTree;
    }

    // Method to add a new place to the AVL tree
    public void addPlace(AVL <POI> poiTree,POI poi)
    {
        poiTree.add(poi);
    }

    // Method to remove a place from the AVL tree
    public void removePlace(AVL <POI> poiTree,POI poi)
    {
        poiTree.remove(poi);
    }

    // Method to search for a list of places in bounding rectangle in the AVL tree
    public void searchPlace(AVL <POI> poiTree,String service, boundingRectangle rectangle)
    {
        poiTree.search(service, rectangle);
    }

    // Method to search for a place in the AVL tree and edit the services of it
    public POI searchPlace(AVL <POI> poiTree,double x, double y)
    {
        return poiTree.search(x, y);
    }
}
