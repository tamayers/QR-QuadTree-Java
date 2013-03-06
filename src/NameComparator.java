import java.util.Comparator;


// -------------------------------------------------------------------------
/**
 * This is a comparator class that is used for comparing items in the name
 * database.
 *
 *  @author tamayers
 *  @version Feb 10, 2012
 */
@SuppressWarnings("unused")
public class NameComparator implements DistanceComparator<Record>
{

    /**
     * compare method that takes two record objects
     */
    public int compare(Record rec1, Record rec2)
    {
        return rec1.getName().compareTo(rec2.getName());
    }

    /**
     * finds the distance between two characters in a string
     */
    public int getDistance(Record item1, Record item2)
    {
        int char1 = item1.getName().charAt(0);
        int char2 = item2.getName().charAt(0);
        return (char1-char2);
    }

}
