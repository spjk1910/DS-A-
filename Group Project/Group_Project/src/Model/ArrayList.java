package Model;

public class ArrayList<T> implements List<T>
{
    private int size;
    private int pointer;
    private static int CAPACITY = 11;
    private T[] items;

    public ArrayList()
    {
        size = 0;
        pointer = 0;
        items = (T[])new Object[CAPACITY];
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
    public int size()
    {
        return size;
    }

    @Override
    public void reset()
    {
        pointer = 0;
    }

    @Override
    public T get(int index)
    {
        if (index >= size)
        {
            return null;
        }
        return items[index];
    }

    @Override
    public boolean hasNext()
    {
        return (pointer < size);
    }

    @Override
    public T next()
    {
        pointer++;
        return items[pointer - 1];
    }

    @Override
    public boolean contains(T value)
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
    public boolean insert(T value)
    {
        if (size >= items.length) {
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
    public boolean remove(T value)
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
}