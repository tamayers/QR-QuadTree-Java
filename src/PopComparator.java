import java.util.Comparator;


// -------------------------------------------------------------------------
/**
 *  This is a comparator used population comparing in my database.
 *
 *  @author tamayers
 *  @version Feb 10, 2012
 *  @version mac os x 10.7
 */
@SuppressWarnings("unused")
public class PopComparator implements DistanceComparator<Record>
{

    /**
     * compares records
     */
    public int compare(Record rec1, Record rec2)
    {
        return rec1.getPop()-rec2.getPop();
    }

    /**
     * find the distance between to objects
     */
    public int getDistance(Record item1, Record item2)
    {
        return compare(item1, item2);
    }

}
