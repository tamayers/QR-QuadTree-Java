
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *  @param <T>
 *
 *  @author tamayers
 *  @version Feb 29, 2012
 */
public class QuadLeaf<T> extends QuadNode<T>
{
    /**
     * element for the leaf to store
     */
    @SuppressWarnings("hiding")
    public T element;

    // ----------------------------------------------------------
    /**
     * Create a new QuadLeaf object.
     * @param theElement

     */
    public QuadLeaf(T theElement)
    {
        element = theElement;
    }

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

    @Override
    public QuadNode<T> getNW()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QuadNode<T> getNE()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QuadNode<T> getSW()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public QuadNode<T> getSE()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setNW(QuadNode<T> value)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNE(QuadNode<T> value)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSW(QuadNode<T> value)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setSE(QuadNode<T> value)
    {
        // TODO Auto-generated method stub

    }


}
