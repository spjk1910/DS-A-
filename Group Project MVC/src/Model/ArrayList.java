package Model;

public class ArrayList<POI> implements List<POI>
{
    private int size;
    private static int CAPACITY = 11;
    private POI[] items;

    public ArrayList()
    {
        size = 0;
        items = (POI[])new Object[CAPACITY];
    }

    // shift all elements from index one position to the right

    // shift all elements from the end one position to the left
    // until index
    private void shiftLeft(int index)
    {
        for (int i = index + 1; i < size; i++)
        {
            items[i - 1] = items[i];
        }
    }

    @Override
    public boolean contains(POI value)
    {
        for (int i = 0; i < size; i++)
        {
            if (items[i].equals(value))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(POI value)
    {
        if (size >= items.length)
        {
            return false;
        }
        items[size] = value;
        size++;
        return true;
    }

    @Override
    public boolean removeAt(int index)
    {
        if (index >= size)
        {
            return false;
        }
        shiftLeft(index);
        size--;
        return true;
    }

    @Override
    public boolean remove(POI value)
    {
        for (int i = 0; i < size; i++)
        {
            if (items[i].equals(value))
            {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        String result = "(";
        for (int i = 0; i < size; i++)
        {
            result += items[i];
            if (i < size - 1)
            {
                result += ", ";
            }
        }
        result += ")";
        return result;
    }
    @Override
    public int size()
    {
        return size;
    }

    @Override
    public POI get(int index)
    {
        if (index >= size)
        {
            return null;
        }
        return items[index];
    }
}