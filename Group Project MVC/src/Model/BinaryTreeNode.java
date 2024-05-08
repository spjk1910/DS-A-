package Model;

public class BinaryTreeNode<POI extends Comparable<POI>> {
    public POI data = null;
    public BinaryTreeNode<POI> parent = null;
    public BinaryTreeNode<POI> left = null;
    public BinaryTreeNode<POI> right = null;
    public int subtreeNodes;
    int height;

    public BinaryTreeNode(BinaryTreeNode<POI> parent, POI data)
    {
        this.parent = parent;
        this.data = data;
        subtreeNodes = 1;
        height = 0;
    }

    public int getHeight()
    {
        return height;
    }

    // update and return the updated height
    public int updateHeight()
    {
        int leftHeight = 0;
        if (left != null)
        {
            leftHeight = left.getHeight();
        }
        int rightHeight = 0;
        if (right != null)
        {
            rightHeight = right.getHeight();
        }
        height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    // get balance factor, to check if tree rotation is needed
    public int getBalanceFactor()
    {
        int leftHeight = 0;
        if (left != null)
        {
            leftHeight = left.getHeight();
        }
        int rightHeight = 0;
        if (right != null)
        {
            rightHeight = right.getHeight();
        }
        return rightHeight - leftHeight;
    }
}