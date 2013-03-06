import java.util.Comparator;


// -------------------------------------------------------------------------
/**.
 *  this is just an interface that talks about
 *  @author tamayers
 *  @version Feb 9, 2012
 * @param <T> object type
 */
public interface DistanceComparator<T> extends Comparator<T>
{
    // ----------------------------------------------------------
    /**
     * get the distance between to objects
     * @param item1
     * @param item2
     * @return int value of the distance
     */
    public int getDistance(T item1, T item2);
}
