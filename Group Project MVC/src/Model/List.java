package Model;

public interface List<POI>
{

    public boolean insert(POI value);

    // insert a value before another value
    // if there are multiple searchValue, the first one (from the left) is used
    // if searchValue doesn't exist, return false
    // return true in other cases

    public boolean removeAt(int index);

    // remove a value in the list
    // if there are multiple value, remove the first one (from the left)
    // if value doesn't exist, return false
    // return true in other cases
    public boolean remove(POI value);

    // return the number of elements in the list
    public int size();

    // return a value at a specific index
    // return null if index is invalid
    public POI get(int index);

    // return whether a value exist in the list
    public boolean contains(POI value);
}