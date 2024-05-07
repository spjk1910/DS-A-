package Model;

public class AVL<T extends Comparable<T>> extends BST<T>
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
    public BinaryTreeNode<T> add(T value)
    {
        BinaryTreeNode<T> newNode = super.add(value);
        rebalanceUp(newNode);
        return newNode;
    }

    @Override
    public BinaryTreeNode<T> remove(T value)
    {
        BinaryTreeNode<T> removeParent = super.remove(value);
        rebalanceUp(removeParent);
        return removeParent;
    }

    // rebalance a node upward the tree
    // until root is reached or no more step needed
    // update heights of sub-trees at the same time
    private void rebalanceUp(BinaryTreeNode<T> node)
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
    private BinaryTreeNode<T> balanceNode(BinaryTreeNode<T> node)
    {
        int bf = node.getBalanceFactor();
        if (bf < -1)
        {
            BinaryTreeNode<T> leftChild = node.left;
            int bf2 = leftChild.getBalanceFactor();
            if (bf2 < 0) {
                return rotateRight(node);
            } else
            {
                rotateLeft(leftChild);
                return rotateRight(node);
            }
        } else if (bf > 1)
        {
            BinaryTreeNode<T> rightChild = node.right;
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
    public BinaryTreeNode<T> rotateRight(BinaryTreeNode<T> node)
    {
        BinaryTreeNode<T> parent = node.parent;
        BinaryTreeNode<T> leftChild = node.left;
        BinaryTreeNode<T> rightOfLeftChild = leftChild.right;

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
    public BinaryTreeNode<T> rotateLeft(BinaryTreeNode<T> node)
    {
        BinaryTreeNode<T> parent = node.parent;
        BinaryTreeNode<T> rightChild = node.right;
        BinaryTreeNode<T> leftOfRightChild = rightChild.left;

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



