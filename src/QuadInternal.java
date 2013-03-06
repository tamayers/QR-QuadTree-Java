
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
public class QuadInternal<T> extends QuadNode<T>
{
    /**
     * north west child node
     */
    private QuadNode<T> nw;
    /**
     * north east child node
     */
    private QuadNode<T> ne;
    /**
     * south west child node
     */
    private QuadNode<T> sw;
    /**
     * south east child node
     */
    private QuadNode<T> se;


    // ----------------------------------------------------------
    /**
     * Create a new QuadLeaf object.
     * @param NW node
     * @param NE node
     * @param SW node
     * @param SE node

     */
    QuadInternal(QuadNode<T> NW, QuadNode<T> NE, QuadNode<T> SW, QuadNode<T> SE)
    {
       nw = NW;
       ne = NE;
       sw = SW;
       se = SE;
    }

    // ----------------------------------------------------------
    /**
     * Get the NW child of this node.
     * @return a reference to the NW child.
     */
    public QuadNode<T> getNW()
    {
        return nw;
    }

    // ----------------------------------------------------------
    /**
     * Get the NE child of this node.
     * @return a reference to the NE child.
     */
    public QuadNode<T> getNE()
    {
        return ne;
    }
    // ----------------------------------------------------------
    /**
     * Get the SW child of this node.
     * @return a reference to the SW child.
     */
    public QuadNode<T> getSW()
    {
        return sw;
    }
    // ----------------------------------------------------------
    /**
     * Get the SE child of this node.
     * @return a reference to the SE child.
     */
    public QuadNode<T> getSE()
    {
        return se;
    }
    // ----------------------------------------------------------


    // ----------------------------------------------------------
    /**
     * Set the NW child of this node.
     * @param value is the nw Quadnode that you want to set.
     */
    public void setNW(QuadNode<T> value)
    {
        nw = value;
    }

    // ----------------------------------------------------------
    /**
     * Set the NE child of this node.
     * @param value is the ne Quadnode that you want to set.
     */
    public void setNE(QuadNode<T> value)
    {
        ne = value;
    }

    // ----------------------------------------------------------
    /**
     * Set the SW child of this node.
     * @param value is the SW Quadnode that you want to set.
     */
    public void setSW(QuadNode<T> value)
    {
        sw = value;
    }

    // ----------------------------------------------------------
    /**
     * Set the SE child of this node.
     * @param value is the SE Quadnode that you want to set.
     */
    public void setSE(QuadNode<T> value)
    {
        se = value;
    }

    @Override
    public T getElement()
    {
        // TODO Auto-generated method stub
        return null;
    }


}
