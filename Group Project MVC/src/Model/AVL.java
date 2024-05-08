package Model;

public class AVL<POI extends Comparable<POI>> extends BST<POI>
{
    // return the height of the tree
    public int treeHeight()
    {
        if (root == null)
        {
            return 0;
        }
        return root.height;
    }

    @Override
    public BinaryTreeNode<POI> add(POI value)
    {
        BinaryTreeNode<POI> newNode = super.add(value);
        rebalanceUp(newNode);
        return newNode;
    }

    @Override
    public BinaryTreeNode<POI> remove(POI value)
    {
        BinaryTreeNode<POI> removeParent = super.remove(value);
        rebalanceUp(removeParent);
        return removeParent;
    }

    // rebalance a node upward the tree
    // until root is reached or no more step needed
    // update heights of sub-trees at the same time
    private void rebalanceUp(BinaryTreeNode<POI> node)
    {
        // recursively rebalance upward
        while (node != null)
        {
            node.updateHeight();
            node = balanceNode(node);
            node = node.parent;
        }
    }

    // balance around a given node
    // and return the new node at that location
    private BinaryTreeNode<POI> balanceNode(BinaryTreeNode<POI> node)
    {
        int bf = node.getBalanceFactor();
        if (bf < -1)
        {
            BinaryTreeNode<POI> leftChild = node.left;
            int bf2 = leftChild.getBalanceFactor();
            if (bf2 < 0)
            {
                return rotateRight(node);
            } else
            {
                rotateLeft(leftChild);
                return rotateRight(node);
            }
        } else if (bf > 1)
        {
            BinaryTreeNode<POI> rightChild = node.right;
            int bf2 = rightChild.getBalanceFactor();
            if (bf2 > 0)
            {
                return rotateLeft(node);
            } else
            {
                rotateRight(rightChild);
                return rotateLeft(node);
            }
        }
        return node;
    }

    // rotate right around the sub-stree rooted at node
    // and return the new root
    public BinaryTreeNode<POI> rotateRight(BinaryTreeNode<POI> node)
    {
        BinaryTreeNode<POI> parent = node.parent;
        BinaryTreeNode<POI> leftChild = node.left;
        BinaryTreeNode<POI> rightOfLeftChild = leftChild.right;

        leftChild.right = node;
        node.parent = leftChild;

        node.left = rightOfLeftChild;
        if (rightOfLeftChild != null)
        {
            rightOfLeftChild.parent = node;
        }

        if (parent != null)
        {
            if (node == parent.left)
            {
                parent.left = leftChild;
            } else
            {
                parent.right = leftChild;
            }
            leftChild.parent = parent;
        } else
        {
            leftChild.parent = null;
            root = leftChild;
        }
        node.updateHeight();
        leftChild.updateHeight();
        return leftChild;
    }

    // rotate left around the sub-stree rooted at node
    // and return the new root
    public BinaryTreeNode<POI> rotateLeft(BinaryTreeNode<POI> node)
    {
        BinaryTreeNode<POI> parent = node.parent;
        BinaryTreeNode<POI> rightChild = node.right;
        BinaryTreeNode<POI> leftOfRightChild = rightChild.left;

        rightChild.left = node;
        node.parent = rightChild;

        node.right = leftOfRightChild;
        if (leftOfRightChild != null)
        {
            leftOfRightChild.parent = node;
        }

        if (parent != null)
        {
            if (node == parent.left)
            {
                parent.left = rightChild;
            } else
            {
                parent.right = rightChild;
            }
            rightChild.parent = parent;
        } else
        {
            rightChild.parent = null;
            root = rightChild;
        }
        node.updateHeight();
        rightChild.updateHeight();
        return rightChild;
    }
}



