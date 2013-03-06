//-------------------------------------------------------------------------
/**
 * This is a basic quadtree node. It is the generic type T
 *

 *
 * @author Tam Ayers
 * @version 2010.04.28
 * @param <T> generic type
 */
public abstract class QuadNode<T>
{
    //~ Instance/static variables .............................................

    /**
     * element in the node
     */
    public T element = null;



    // ----------------------------------------------------------
    /**
     * getter method for the element
     * @return the element in the node
     */
    public abstract T getElement();

    // ----------------------------------------------------------
    /**
     * Getting method for the NW Child
     * @return a referent to the NW node
     */
    public abstract QuadNode<T> getNW();


    // ----------------------------------------------------------
    /**
     * Get the NE child of this node.
     * @return a reference to the NE child.
     */
    public abstract QuadNode<T> getNE();

    // ----------------------------------------------------------
    /**
     * Get the SW child of this node.
     * @return a reference to the SW child.
     */
    public abstract QuadNode<T> getSW();

    // ----------------------------------------------------------
    /**
     * Get the SE child of this node.
     * @return a reference to the SE child.
     */
    public abstract QuadNode<T> getSE();
    // ----------------------------------------------------------


    // ----------------------------------------------------------
    /**
     * Set the NW child of this node.
     * @param value is the nw Quadnode that you want to set.
     */
    public abstract void setNW(QuadNode<T> value);

    // ----------------------------------------------------------
    /**
     * Set the NE child of this node.
     * @param value is the ne Quadnode that you want to set.
     */
    public abstract void setNE(QuadNode<T> value);

    // ----------------------------------------------------------
    /**
     * Set the SW child of this node.
     * @param value is the SW Quadnode that you want to set.
     */
    public abstract void setSW(QuadNode<T> value);

    // ----------------------------------------------------------
    /**
     * Set the SE child of this node.
     * @param value is the SE Quadnode that you want to set.
     */
    public abstract void setSE(QuadNode<T> value);

    //~ Constructor ...........................................................

//    // ----------------------------------------------------------
//    /**
//     * Creates a node with no children.
//     * @param theElement the element to store in this node.
//     * @param x the x value location
//     * @param y the y value location
//     */
//    QuadNode(Record theElement)
//    {
//        element = theElement;
//        nw = null;
//        ne = null;
//        sw = null;
//        se = null;
//    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
//    /**
//     * Get the current data value stored in this node.
//     * @return the element
//     */
//    public Record getElement()
//    {
//        return element;
//    }
//
//
//    // ----------------------------------------------------------
//    /**
//     * Set the data value stored in this node.
//     * @param value the new data value to set
//     */
//    public void setElement(Record value)
//    {
//        element = value;
//    }





}
