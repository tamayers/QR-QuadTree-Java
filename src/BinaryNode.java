//-------------------------------------------------------------------------
/**
 * A basic node stored in an unbalanced binary search tree.
 * This class is not accessible outside of this package.Used in 2114
 *
 * @param <T> The type of data element contained in the node.
 *
 * @author Tam Ayers
 * @version 2010.04.28
 */
class BinaryNode<T>
{
    //~ Instance/static variables .............................................

    /**
     * element in the node
     */
    private T element;
    /**
     * number of nodes in the left subtree used for size and findKth
     */
    public int leftSize;
    /**
     * left child node
     */
    private BinaryNode<T> left;
    /**
     * right child node
     */
    private BinaryNode<T> right;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Creates a node with no children.
     * @param theElement the element to store in this node.
     */
    BinaryNode(T theElement)
    {
        element = theElement;
        leftSize = 0;
        left = null;
        right = null;
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Get the current data value stored in this node.
     * @return the element
     */
    public T getElement()
    {
        return element;
    }


    // ----------------------------------------------------------
    /**
     * Set the data value stored in this node.
     * @param value the new data value to set
     */
    public void setElement(T value)
    {
        element = value;
    }


    // ----------------------------------------------------------
    /**
     * Get the left child of this node.
     * @return a reference to the left child.
     */
    public BinaryNode<T> getLeft()
    {
        return left;
    }

    // ----------------------------------------------------------
    /**
     * Getter Method of the Size of the left sub tree
     * @return the leftSize
     */
    public int getLeftSize()
    {
        return leftSize;
    }


    // ----------------------------------------------------------
    /**
     * Set this node's left child.
     * @param value the node to point to as the left child.
     */
    public void setLeft(BinaryNode<T> value)
    {
        left = value;
    }


    // ----------------------------------------------------------
    /**
     * Get the right child of this node.
     * @return a reference to the right child.
     */
    public BinaryNode<T> getRight()
    {
        return right;
    }


    // ----------------------------------------------------------
    /**
     * Set this node's right child.
     * @param value the node to point to as the right child.
     */
    public void setRight(BinaryNode<T> value)
    {
        right = value;
    }

}
