// -------------------------------------------------------------------------
/**
 * this is a controller method that interacts with my two databases, nameDB and
 * popBD, that are currently binary search tree.
 *
 *  @author tamayers
 *  @version Feb 7, 2012
 */
public class Controller
{
    /**
     * a database of records origanized by name. currently implemented as a
     * binary search tree of type record.
     */
    public BinarySearchTree<Record> nameDB;
    /**
     * a database of records origanized by population. currently implemented as a
     * binary search tree of type record.
     */
    public BinarySearchTree<Record> popDB;

    /**
     * the quad tree to store all of the city records
     */
    public QuadTree<Record> map;
    // ----------------------------------------------------------
    /**
     * Create a new Controller object.
     */
    public Controller()
    {
      PopComparator pc = new PopComparator();
      //used for finding and searching in pop database
      NameComparator nc = new NameComparator();
      //used for finding and searching in name database
      nameDB = new BinarySearchTree<Record>(nc);
      popDB = new BinarySearchTree<Record>(pc);
      map = new QuadTree<Record>(16, 0, 16, 0);

    }

    // ----------------------------------------------------------
    /**
     * Inserts items into both databases. first makes a record and checks to
     * make sure that it is not already in the database
     * @param name
     * @param population
     * @param x coor
     * @param y coor
     */
    public void insert(String name, int population, int x, int y)
    {
        Record theRecord = new Record(name, population, x, y);
        //makes a new record
        //checks to make sure the record does not already in the data base
        if (nameDB.find(theRecord) == null && popDB.find(theRecord) == null &&
                map.find(x, y) == null)
        {
                nameDB.insert(theRecord);
                popDB.insert(theRecord);
                map.insert(theRecord);
                return;
        }
        else
        {
            System.out.println("Dupilcate Error");
            return;
        }



    }

    // ----------------------------------------------------------
    /**
     * finds an element in the database. This method is the find method for
     * the population database.
     * @param field
     * @param value
     */
    public void find(String field, String value)
    {
        if (field.equals("name"))
        {
            Record fakeRec = new Record(value, 0, 0, 0);
            //fake record used for searching
            Record toPrint = nameDB.find(fakeRec);
            System.out.println(toPrint);
        }
        else
        {
            System.out.println("Error");
        }
    }
    // ----------------------------------------------------------
    /**
     * finds an element in the database. This method is the find method for
     * the population database.
     * @param field
     * @param value
     */
    public void find(String field, int value)
    {
        if (field.equals("population"))
        {
            Record fakeRec = new Record("null", value, 0, 0);
            //fake record used for searching
            Record toPrint = popDB.find(fakeRec);
            System.out.println(toPrint);
        }
        else
        {
            System.out.println("Error");
        }
    }
    /**
     * method to find in a pr quad tree
     * @param x coor
     * @param y coor
     */
    public void find(int x, int y)
    {
        if (map.find(x, y) != null)
        {
            Record theFind = (map.find(x, y).getElement());
            if (theFind.getXValue() == x && theFind.getYValue() == y)
                {
                    System.out.println(theFind.toString());
                }
            else
            {
                System.out.println("Item Not Found");

            }
        }
        else
        {
            System.out.println("Item Not Found");

        }
    }

    // ----------------------------------------------------------
    /**
     * This method finds the kth largest element in the database
     *
     * @param field
     * @param k
     */
    public void findKth(String field, int k)
    {
        if (field.equals("name"))
        {
            System.out.println(nameDB.findKth(k));
        }
        else
        {
            System.out.println(popDB.findKth(k));
        }
    }

    /**
     * this prints and finds all records in a certian range in the quad tree
     * @param x x coor
     * @param y y coor
     * @param w width
     * @param h height
     */
    public void rfind(int x, int y, int w, int h)
    {
       // System.out.println(map.rfind(x, y, w, h));
    }

    // ----------------------------------------------------------
    /**
     * This method finds the element in a database closest to the one requested
     * This is used for the name database
     * @param field
     * @param value
     */
    public void findNearest(String field, String value)
    {
        if (field.equals("name"))
        {
            Record fakeRec = new Record(value,0,0,0);//record used for searching
            System.out.println(nameDB.findNearest(fakeRec));
        }
        else
        {
            System.out.println("Error");
        }
    }

    // ----------------------------------------------------------
    /**
     * This method finds the element in a database closest to the one requested
     * This is used for the population database
     * @param field
     * @param value
     */
    public void findNearest(String field, int value)
    {
        if (field.equals("population"))
        {
            Record fakeRec = new Record("null",value,0,0);//fake record used for
            //searching
            System.out.println(nameDB.findNearest(fakeRec));
        }
        else
        {
            System.out.println("Error");
        }
    }

    // ----------------------------------------------------------
    /**
     * remove an element from a database. prints out error if the record is
     * not in the data base. This is the one for the name database
     * @param field
     * @param value
     */
    public void remove(String field, String value)
    {
        if (field.equals("name"))
        {
            Record fakeRec = new Record(value,0,0,0);//record used to compare
            //and search for.
            Record fakeRec2 = nameDB.find(fakeRec);
            //this record is used for removing the same element from both
            //databases
            nameDB.remove(fakeRec2);
            popDB.remove(fakeRec2);
            map.remove(fakeRec2.getXValue(), fakeRec.getYValue());
        }
        else
        {
            System.out.println("Error");
        }
    }

    // ----------------------------------------------------------
    /**
     * remove an element from a database. prints out error if the record is
     * not in the data base. This is the one for the population database
     * @param field
     * @param value
     */
    public void remove(String field, int value)
    {
        if (field.equals("name"))
        {
            //fake record used for searching thepop database
            Record fakeRec = new Record("null",value,0,0);
            //fake record to make sure that I am deleting the same record
            //from both databases
            Record fakeRec2 = nameDB.find(fakeRec);
            nameDB.remove(fakeRec2);
            popDB.remove(fakeRec2);
            map.remove(fakeRec2.getXValue(), fakeRec2.getYValue());
        }
        else
        {
            System.out.println("Error - Wrong Field");
        }
    }
    /**
     * remove the element frim the database. this is used to remove the city
     * record from the PR quadtree
     * @param x coor
     * @param y coor
     */
    public void remove(int x, int y)
    {
        if (map.find(x,y) != null)
        {
            Record fakeRec = map.find(x, y).getElement();
            map.remove(fakeRec.getXValue(), fakeRec.getYValue());
            nameDB.remove(fakeRec);
            popDB.remove(fakeRec);
        }
        else
        {
            System.out.println("Record Location not Valid");
        }
    }

    // ----------------------------------------------------------
    /**
     * prints out all of the values in the tree
     * @param field
     */
    public void list(String field)
    {
        if (field.equals("name"))
        {
            nameDB.list();
        }
        else if (field.equals("population"))
        {
            popDB.list();
        }
        else if (field.equals("location"))
        {
            map.list();
        }
        else
        {
            System.out.println("Error");
        }
    }

    // ----------------------------------------------------------
    /**
     * this clears out the tree by re-intializing the controller object.
     */
    public void makenull()
    {
        PopComparator pc = new PopComparator();
        NameComparator nc = new NameComparator();
        nameDB = new BinarySearchTree<Record>(nc);
        popDB = new BinarySearchTree<Record>(pc);
        map = new QuadTree<Record>(1024, 0, 1024 ,0);
    }

}
