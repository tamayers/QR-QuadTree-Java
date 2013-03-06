
// -------------------------------------------------------------------------
/**
 * Class of record object. This is an object the has a city name and population
 * int.
 *  @author tamayers
 *  @version Feb 9, 2012
 */
public class Record implements Compare2D
{
    private String name;
    private int population;
    private int xValue;
    private int yValue;

    // ----------------------------------------------------------
    /**
     * Create a new Record object.
     * @param theName city name
     * @param theValue city population
     * @param x the x coor for the record
     * @param y the y coor for the record
     */
    public Record(String theName, int theValue, int x, int y)
    {
        name = theName;
        population= theValue;
        xValue = x;
        yValue = y;
    }

    // ----------------------------------------------------------
    /**
     * gets the name of the city
     * @return city name
     */
    public String getName()
    {
        return name;
    }

    // ----------------------------------------------------------
    /**
     * get the population of city record
     * @return the population
     */
    public int getPop()
    {
        return population;
    }

    /**
     * prints out the name and city
     */
    public String toString()
    {
        return (name + " " + population + " " + xValue + " " + yValue);

    }
    // ----------------------------------------------------------
    /**
     * Getter method fot the x coordinate for the record
     * @return xValue the x coordinate location
     */
    public int getXValue()
    {
        return xValue;
    }

    /**
     * Getter method fot the y coordinate for the record
     * @return yValue the y coordinate location
     */
    public int getYValue()
    {
        return yValue;
    }

    // ----------------------------------------------------------
    /**
     * Sets the x coordinate of a record to the value provided
     * @param x the new value for x in your quadnode
     */
    public void setXValue(int x)
    {
        xValue = x;
    }
    /**
     * Sets the y coordinate of a record to the value provided
     * @param y the new value for y in your quadnode
     */
    public void setYValue(int y)
    {
        yValue = y;
    }


}
