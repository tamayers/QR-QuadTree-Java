import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Implements an quad tree using twwo different types of quad nodes. Uses 2D
 * compare for compare those nodes. This, meaning that any generic object must
 * be of type that is knows what Compare2D is.

 *            The type of data element contained in the node.
 * @author Tam Ayers (tamayers)
 * @param <T> generic type for this quad tree
 */
@SuppressWarnings("unused")
public class QuadTree<T extends Compare2D>
{
    // ~ Instance/static variables .............................................

    //root node
    private QuadNode<T> root;

    private int xMin;
    private int xMax;
    private int yMin;
    private int yMax;

    private int i;

    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * makes a new binarysearch tree
     * @param xHi the max x value for the tree
     * @param xLo the min x value for the tree
     * @param yHi the max y value for the tree
     * @param yLo the max y value for the tree
     */
    public QuadTree(int xHi, int xLo, int yHi, int yLo)
    {
        xMax = xHi;
        xMin = xLo;
        yMax = yHi;
        yMin = yLo;
        i = 0;

        root = null;//the root node intialization
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Insert into the tree.
     *
     * @param x
     *            the item to insert.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    public void insert(T x)
    {
            root = insertHelper(x, root, xMax, xMin, yMax, yMin);
    }


    // ----------------------------------------------------------
    /**
     * Remove the specified value from the tree.
     *
     * @param x
     *            the x coor of the item to remove.
     * @param y
     *            the y coor of the item to remove.
     * @return the record, null if not found
     */
    public T remove(int x, int y)
    {
        return remove(x,y,root, xMax, xMin, yMax, yMin).getElement();
    }


//    // ----------------------------------------------------------
//    /**
//     * Find the smallest item in the tree.
//     *
//     * @return The smallest item, or null if the tree is empty.
//     */
//    public Record findMin()
//    {
//        return elementAt(findMin(root));
//    }


//    // ----------------------------------------------------------
//    /**
//     * Find the largest item in the tree.
//     *
//     * @return The largest item in the tree, or null if the tree is empty.
//     */
//    public Record findMax()
//    {
//        return elementAt(findMax(root));
//    }


    // ----------------------------------------------------------
    /**
     * Find an item in the tree given the coor.
     *
     * @param x the x coor of the item
     * @param y the y coor of the item
     * @return the matching item or null if not found.
     */
    public QuadNode<T> find(int x, int y)
    {

        return find(x, y, root, xMax, xMin, yMax, yMin);
    }

    // ----------------------------------------------------------
    /**
     * Find all records in the bound area
     * @param x the upper x coor
     * @param y the upper y coor
     * @param w the width of the box
     * @param h the height of the box
     */
    public void rfind(int x, int y, int w, int h)
    {

        System.out.println(rfind(x,y,w,h,xMax,xMin,yMax,yMin, 0,root));

    }

//    // ----------------------------------------------------------
//    /**
//     * findest the nearest element in a node in the tree to the one requested
//     * @param x
//     * @return t element in node
//     */
//    public Record findNearest(Record x)
//    {
//        return elementAt(findNearest(x, root));
//    }

    // ----------------------------------------------------------
    /**
     * prints out the binary search tree
     */
    public void list()
    {
        preOrder(root, "", xMax, xMin, yMax, yMin);
    }


    // ----------------------------------------------------------
    /**
     * Make the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }

//
//    // ----------------------------------------------------------
//    /**
//     * Test if the tree is logically empty.
//     *
//     * @return true if empty, false otherwise.
//     */
//    public boolean isEmpty()
//    {
//        if (this.findMax() == null && this.findMin() == null)
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//
//    // ----------------------------------------------------------
//    /**
//     * Internal method to get element value stored in a tree node, with safe
//     * handling of null nodes.
//     *
//     * @param node
//     *            the node.
//     * @return the element field or null if node is null.
//     */
//    private T elementAt(QuadNode<T> node)
//    {
//        return (node == null) ? null : node.getElement();
//    }

    // ----------------------------------------------------------
    /**
     * Internal method to insert a value into a subtree.
     *
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @param xVal
     *            the x coor value for the element x
     * @param yVal
     *            the y coor value for the element y
     * @return the new root of the subtree.
     * @throws DuplicateItemException
     *             if x at that x and y is already present.
     */
    private QuadNode<T> insertHelper(T element, QuadNode<T> p,
                                          int xHi, int xLo, int yHi, int yLo)
    {
        if (p == null)
        {
            return new QuadLeaf<T>(element);
        }
        else if (p.getClass().getName().equals("QuadInternal"))
        {
       //     QuadInternal<T> p = (QuadInternal<T>) node;
            if (((xHi+xLo)/2) > element.getXValue() && ((yHi+yLo)/2) > element.getYValue())
            {
                if (p.getNW() == null)
                {
                    p.setNW(new QuadLeaf<T>(element));
                    return p;
                }
                p.setNW(insertHelper(element,p.getNW(),((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo));
                return p;
            }
            else if (((xHi+xLo)/2) < element.getXValue() && ((yHi+yLo)/2) > element.getYValue())
            {
                if (p.getNE() == null)
                {
                    p.setNE(new QuadLeaf<T>(element));
                    return p;
                }
                p.setNE(insertHelper(element,p.getNE(),xHi, (xHi/2), (yHi/2), yLo));
                return p;
            }
            else if (((xHi+xLo)/2) > element.getXValue() && ((yHi+yLo)/2) < element.getYValue())
            {
                if (p.getSW() == null)
                {
                    p.setSW(new QuadLeaf<T>(element));
                    return p;
                }
                p.setSW(insertHelper(element,p.getSW(),(xHi/2), xLo, yHi, (yHi/2)));
                return p;
            }
            else if (((xHi+xLo)/2) < element.getXValue() && ((yHi+yLo)/2) < element.getYValue())
            {
                if (p.getSE() == null)
                {
                    p.setSE(new QuadLeaf<T>(element));
                    return p;
                }
                p.setSE(insertHelper(element,p.getSE(), xHi, ((xHi+xLo)/2), yHi, ((yHi+yLo)/2)));
                return p;
            }
            else
            {
                //System.out.println("ERROR ERROR ERROR YOU SHOULDNT GET HERE - inserthelper top");
                return p;
            }
        }
        else if (p.getClass().getName().equals("QuadLeaf"))
        {
            i++;
      //      QuadLeaf<T> p = (QuadLeaf<T>) node;

            if (((xHi+xLo)/2) > p.getElement().getXValue() && ((yHi+yLo)/2) > p.getElement().getYValue())
            {
                QuadInternal<T> newInt = new QuadInternal<T>(p,null,null,null);

                return insertHelper(element,newInt,xHi, xLo, yHi, yLo);
            }
            else if (((xHi+xLo)/2) < p.getElement().getXValue() && ((yHi+yLo)/2) > p.getElement().getYValue())
            {
                QuadInternal<T> newInt = new QuadInternal<T>(null,p,null,null);
                return insertHelper(element,newInt,xHi, xLo, yHi, yLo);
            }
            else if (((xHi+xLo)/2) > p.getElement().getXValue() && ((yHi+yLo)/2) < p.getElement().getYValue())
            {
                QuadInternal<T> newInt = new QuadInternal<T>(null,null,p,null);
                return insertHelper(element,newInt,xHi, xLo, yHi, yLo);
            }
            else if (((xHi+xLo)/2) < p.getElement().getXValue() && ((yHi+yLo)/2) < p.getElement().getYValue())
            {
                QuadInternal<T> newInt = new QuadInternal<T>(null,null,null,p);
                return insertHelper(element,newInt,xHi, xLo, yHi, yLo);
            }
            else
            {
              //  System.out.println("ERROR ERROR ERROR YOU SHOULDNT GET HERE - inserthelper bottom");
                return p;
            }
        }
        else
        {
            System.out.println("SHIT");
            return p;
        }
    }

//        if ((find(((xHi+xLo)/2), ((yHi+yLo)/2), node) != null
//            && (find(((xHi+xLo)/2), ((yHi+yLo)/2)).getElement() == null)))
//            {
//                if (node.getElement().getXValue() > element.getXValue()
//                    && node.getElement().getYValue() > element.getYValue())
//                {
//                    return insertHelper(element, node.getNW(), ((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo);
//                }
//                //NE
//                else if (node.getElement().getXValue() < element.getXValue()
//                    && node.getElement().getYValue() > element.getYValue())
//                {
//                    return insertHelper(element, node.getNE(), xHi, (xHi/2), (yHi/2), yLo);
//                }
//                //SW
//                else if (node.getElement().getXValue() > element.getXValue()
//                    && node.getElement().getYValue() < element.getYValue())
//                {
//                    return insertHelper(element, node.getSW(), (xHi/2), xLo, yHi, (yHi/2));
//                }
//                //SE
//                else if(node.getElement().getXValue() < element.getXValue()
//                    && node.getElement().getYValue() < element.getYValue())
//                {
//                    return insertHelper(element, node.getSE(), xHi, ((xHi+xLo)/2), yHi, ((yHi+yLo)/2));
//                }
//                else
//                {
//                    System.out.println("error...");
//                    return node;
//                }
//            }
//        else
//        {
//            QuadNode<T> newInt = new QuadNode<T>(new Record(null, null, ((xHi+xLo)/2),((yHi+yLo)/2));
//            return insertHelper(element, newInt, xHi, xLo, yHi, yLo);
//        }
//
//     }




    // ----------------------------------------------------------
    /**
     * Internal method to remove a specified item from a subtree.
     * @param x
     *            the x coor of the item x
     * @param y
     *            the y value of the item y
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    private QuadNode<T> remove(int x, int y, QuadNode<T> node, int xHi, int xLo, int yHi, int yLo)
    {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        QuadNode<T> result = node;

        if(node == null)
        {
            return null;
        }
        else if (node.getClass().getName().equals("QuadLeaf") && node.getElement().getXValue() == x && node.getElement().getYValue() == y)
        {
            //if (node.getElement().getXValue() == x && node.getElement().getYValue() == y)
            //{
                return null;
            //}

        }
        else
        {
            //NW
            if (((xHi+xLo)/2) > x && ((yHi+yLo)/2) > y)
            {
//                if(children(node.getNW()) == 1 && node.getNW().getClass().getName().equals("QuadLeaf"))
//                {
//                    node.setNW(remove(x, y, node.getNW(), ((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo));
//                }
                node.setNW(remove(x, y, node.getNW(), ((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo));
                if(node.getNW() != null && children(node.getNW()) == 1)
                {
                    node.setNW(getChild(node.getNW()));
                    return node;
                }
                return node;
            }
            //NE
            else if (((xHi+xLo)/2) < x && ((yHi+yLo)/2) > y)
            {
                node.setNE(remove(x, y, node.getNE(),xHi, (xHi/2), (yHi/2), yLo));
                if(node.getNE() != null && children(node.getNE()) == 1)
                {
                    node.setNE(getChild(node.getNE()));
                    return node;
                }
                return node;
            }
            //SW
            else if (((xHi+xLo)/2) > x && ((yHi+yLo)/2) < y)
            {

                 node.setSW(remove(x, y, node.getSW(), (xHi/2), xLo, yHi, (yHi/2)));
                 if(node.getSW() != null && children(node.getSW()) == 1)
                 {
                     node.setSW(getChild(node.getSW()));
                     return node;
                 }
                 return node;
            }
            //SE
            else if (((xHi+xLo)/2) < x && ((yHi+yLo)/2) < y)
            {

                node.setSE(remove(x, y, node.getSE(), xHi, ((xHi+xLo)/2), yHi, ((yHi+yLo)/2)));
                if(node.getSE() != null && children(node.getSE()) == 1)
                {
                    node.setSE(getChild(node.getSE()));
                    return node;
                }
                return node;
            }
            else
            {
                System.out.println("Remove Error in Quad Tree");
                return null;
            }
        }

    }


//    // ----------------------------------------------------------
//    /**
//     * Internal method to find the smallest item in a subtree.
//     *
//     * @param node
//     *            the node that roots the tree.
//     * @return node containing the smallest item.
//     */
//    private BinaryNode<T> findMin(BinaryNode<T> node)
//    {
//        if (node == null)
//        {
//            return null;
//        }
//        else if (node.getLeft() == null)
//        {
//            return node;
//        }
//        else
//        {
//            return findMin(node.getLeft());
//        }
//    }


//    // ----------------------------------------------------------
//    /**
//     * Internal method to find the largest item in a subtree.
//     *
//     * @param node
//     *            the node that roots the tree.
//     * @return node containing the largest item.
//     */
//    private BinaryNode<T> findMax(BinaryNode<T> node)
//    {
//        if (node == null)
//        {
//            return node;
//        }
//        else if (node.getRight() == null)
//        {
//            return node;
//        }
//        else
//        {
//            return findMax(node.getRight());
//        }
//    }


    // ----------------------------------------------------------
    /**
     * Internal method to find an item in a subtree.
     *
     * @param x
     *            is item to search for.
     * @param node
     *            the node that roots the tree.
     * @return node containing the matched item.
     */
    private QuadNode<T> find(int x, int y, QuadNode<T> node, int xHi, int xLo, int yHi, int yLo)
    {
     //   System.out.println(node.getElement().getName());
        if(node == null)
        {
            return null;
        }
        //NW
//        System.out.println(node.getElement().getName());
//        System.out.println(node.getElement().getXValue());
//        System.out.println(node.getElement().getYValue());
        if (node.getClass().getName().equals("QuadInternal"))
        {
            QuadInternal<T> p = (QuadInternal<T>) node;
            if (((xHi+xLo)/2) > x && ((yHi+yLo)/2) > y)
            {
                return find(x,y,p.getNW(),((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo);
            }
            else if (((xHi+xLo)/2) < x && ((yHi+yLo)/2) > y)
            {
                return find(x,y,p.getNE(),xHi, (xHi/2), (yHi/2), yLo);
            }
            else if (((xHi+xLo)/2) > x && ((yHi+yLo)/2) < y)
            {
                return find(x,y,p.getSW(),(xHi/2), xLo, yHi, (yHi/2));
            }
            else if (((xHi+xLo)/2) < x && ((yHi+yLo)/2) < y)
            {
                return find(x,y,p.getSE(), xHi, ((xHi+xLo)/2), yHi, ((yHi+yLo)/2));
            }
            else
            {
                System.out.println("ERROR ERROR ERROR YOU SHOULDNT GET HERE");
                return p;
            }
        }
        else
        {
            if (node.getElement().getXValue() == x && node.getElement().getYValue() == y)
            {
                return node;
            }
            else
            {
                return null;
            }


        }

//            if (node.getElement().getXValue() < x &&
//                        node.getElement().getXValue() < y)
//            {
//                return find(x, y, node.getNW());
//            }
//            //NE
//            else if (node.getElement().getXValue() > x &&
//                        node.getElement().getXValue() < y)
//            {
//                return find(x, y, node.getNE());
//            }
//            //SW
//            else if (node.getElement().getXValue() < x &&
//                        node.getElement().getXValue() > y)
//            {
//                return find(x, y, node.getSW());
//            }
//            //SE
//            else if (node.getElement().getXValue() > x &&
//                        node.getElement().getXValue() > y)
//            {
//                return find(x, y, node.getSE());
//            }
//            else
//            {
//                return node;
//            }
    }

//    /**
//     * called by helper method above to find k
//     */
//    private BinaryNode<T> findKth(int x, BinaryNode<T> node)
//    {
//        if (x > node.getLeftSize())
//        {
//            return findKth((x-1-node.getLeftSize()), node.getRight());
//        }
//        else if (x < node.getLeftSize())
//        {
//            return findKth(x, node.getLeft());
//        }
//        else
//        {
//            return node; //found
//        }
//
//    }
//
//
//    /**
//     * called by the findNearest helper method above. recursive
//     */
//    private BinaryNode<T> findNearest(T x, BinaryNode<T> node)
//    {
//        if (c.getDistance(x, node.getElement()) < 0)
//        {
//            if (node.getRight() == null)
//            {
//                return node;
//            }
//            else
//            {
//                BinaryNode<T> tempNode = findNearest(x, node.getRight());
//                int y = Math.abs((c.compare(node.getElement(), x)));
//                int z = Math.abs((c.compare(tempNode.getElement(), x)));
//                if (y > z)
//                {
//                    return tempNode;
//                }
//                else
//                {
//                    return node;
//                }
//            }
//        }
//        else if (c.getDistance(x, node.getElement()) > 0)
//        {
//            if (node.getLeft() == null)
//            {
//                return node;
//            }
//            else
//            {
//                BinaryNode<T> tempNode2 = findNearest(x, node.getRight());
//                int a = Math.abs((c.compare(node.getElement(), x)));
//                int b = Math.abs((c.compare(tempNode2.getElement(), x)));
//                if (a > b)
//                {
//                    return tempNode2;
//                }
//                else
//                {
//                    return node;
//                }
//
//            }
//        }
//        else
//        {
//            return node;
//        }
//    }


    // ----------------------------------------------------------
    /**
     * This is a method that is used to print out all of the values in my tree
     * @param p the root node to start of
     * @param padding the intial string to print from
     * @param xHi the max x sixe of the tree
     * @param xLo the min x size of the tree
     * @param yHi the max y size of the tree
     * @param yLo the min y size of the tree

     */
    public void preOrder(QuadNode<T> p, String padding, int xHi, int xLo, int yHi, int yLo)
    {

        if (p == null)
        {
            System.out.println(padding + "Empty");
            return;
        }
        if (p.getClass().getName().equals("QuadInternal"))
        {
            System.out.println(padding + "Internal " + ((xHi+xLo)/2) + " " + ((yHi+yLo)/2) );
            preOrder(p.getNW(), padding + "-", ((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo);
            preOrder(p.getNE(), padding + "-", xHi, (xHi/2), (yHi/2), yLo);
            preOrder(p.getSW(), padding + "-", (xHi/2), xLo, yHi, (yHi/2));
            preOrder(p.getSE(), padding + "-", xHi, ((xHi+xLo)/2), yHi, ((yHi+yLo)/2));
        }
  //      System.out.println(padding);

        if (p.getClass().getName().equals("QuadLeaf"))
        {
            System.out.println(padding + p.getElement());
        }
    }

    /**
     * finds the number of children
     * @param parent ndoe to check
     * @return int the number of children
     */
    public int children(QuadNode<T> parent)
    {
        int j = 0;
        if(parent.getNW() != null)
        {
            j++;
        }
        if(parent.getNE() != null)
        {
            j++;
        }
        if(parent.getSW() != null)
        {
            j++;
        }
        if(parent.getSE() != null)
        {
            j++;
        }
        return j;
    }
    /**
     * gets the remaining child note
     * @param parent node
     * @return the children
     */
    public QuadNode<T> getChild(QuadNode<T> parent)
    {
        if (children(parent) == 1)
        {
            if(parent.getNW() != null)
            {
                return parent.getNW();
            }
            else if(parent.getNE() != null)
            {
                return parent.getNE();
            }
            else if(parent.getSW() != null)
            {
                return parent.getSW();
            }
            else
            {
                return parent.getSE();
            }
        }
        else
        {
            return null;
        }
    }

    /**
     *finds the nodes in a range
     * @param x coor for searching range
     * @param y coor for searching rance
     * @param w width of searching range
     * @param h height of searching range
     * @param xHi quadnode size max x size
     * @param xLo quadnode size min x size
     * @param yHi quadnode size max y sixe
     * @param yLo quadnode size min y size
     * @param count the number of nodes touched
     * @param node the root node to start your search on.
     * @return the current count for nodes visited
     */
    public int rfind(int x, int y, int w, int h,  int xHi, int xLo, int yHi, int yLo, int count, QuadNode<T> node)
    {
        int newX = x;
        int newY = y;
        int newW = w;
        int newH = h;
        int newCount = count;
        if (node == null)
        {
            return count;
        }
        else if((((xHi+xLo)/2) > x && ((yHi+yLo)/2) > y))
            {

//                if(node.getClass().getName().equals("QuadInternal"))
//                {
                    if (node.getNW().getClass().getName().equals("QuadInternal"))
                    {
                        if( (x+w) > ((xHi+xLo)/2))
                        {
                           newW = ((xHi+xLo)/2) - x;
                        }
                        if((y+h) > ((yHi+yLo)/2))
                        {
                           newH = ((yHi+yLo)/2) - y;
                        }
                        newCount = count + rfind(x,y,newW,newH,((xHi+xLo)/2), xLo, ((yHi+yLo)/2), yLo, count, node.getNW());
                        return newCount;

                    }
                    //else if ((((xHi+xLo)/2) > node.getNW().getElement().getXValue()) && (((yHi+yLo)/2) > node.getNW().getElement().getYValue()) && (xLo < node.getNW().getElement().getXValue()) && (yLo < node.getNW().getElement().getYValue()))
                    else if(((x+w) > node.getNW().getElement().getXValue()) && (((y+h) > node.getNW().getElement().getYValue()) && (x < node.getNW().getElement().getXValue()) && (y < node.getNW().getElement().getYValue())))
                    {
                        System.out.println(node.getNW().getElement().toString());
                        newCount++;
                        return newCount;
                    }
//                }
                    else
                    {
                        return count;
                    }

            }
        else if(((xHi+xLo)/2) < (x+w) && ((yHi+yLo)/2) > (y+h))
        {

//          if(node.getClass().getName().equals("QuadInternal"))
//          {
              if (node.getNE().getClass().getName().equals("QuadInternal"))
              {
                  if( (x) < ((xHi+xLo)/2))
                  {
                      newX = ((xHi+xLo)/2);
                  }
                  if((y+h) > ((yHi+yLo)/2))
                  {
                      newH = ((yHi+yLo)/2) - y;
                  }
                  newCount = count + rfind(newX,y,w,newH,xHi, (xHi/2), (yHi/2), yLo, count, node.getNE());
                  return newCount;

              }
              //else if ((((xHi+xLo)/2) > node.getNW().getElement().getXValue()) && (((yHi+yLo)/2) > node.getNW().getElement().getYValue()) && (xLo < node.getNW().getElement().getXValue()) && (yLo < node.getNW().getElement().getYValue()))
              else if(((x+w) > node.getNE().getElement().getXValue()) && (((y+h) > node.getNE().getElement().getYValue()) && (x < node.getNE().getElement().getXValue()) && (y < node.getNE().getElement().getYValue())))
              {
                  System.out.println(node.getNE().getElement().toString());
                  newCount++;
                  return newCount;
              }
//          }
              else
              {
                  return count;
              }

        }
        else if(((xHi+xLo)/2) > x && ((yHi+yLo)/2) < y)
        {

//          if(node.getClass().getName().equals("QuadInternal"))
//          {
              if (node.getSW().getClass().getName().equals("QuadInternal"))
              {
                  if( (x+w) > ((xHi+xLo)/2))
                  {
                      newW = ((xHi+xLo)/2) - x;
                  }
                  if((y) < ((yHi+yLo)/2))
                  {
                      newY = ((yHi+yLo)/2);
                  }
                  newCount = count + rfind(x,newY,newW,h,(xHi/2), xLo, yHi, (yHi/2), count, node.getSW());
                  return newCount;

              }
              //else if ((((xHi+xLo)/2) > node.getNW().getElement().getXValue()) && (((yHi+yLo)/2) > node.getNW().getElement().getYValue()) && (xLo < node.getNW().getElement().getXValue()) && (yLo < node.getNW().getElement().getYValue()))
              else if(((x+w) > node.getSW().getElement().getXValue()) && (((y+h) > node.getSW().getElement().getYValue()) && (x < node.getSW().getElement().getXValue()) && (y < node.getSW().getElement().getYValue())))
              {
                  System.out.println(node.getSW().getElement().toString());
                  newCount++;
                  return newCount;
              }
//          }
              else
              {
                  return count;
              }

        }
        else if(((xHi+xLo)/2) < x && ((yHi+yLo)/2) < y)
        {

//          if(node.getClass().getName().equals("QuadInternal"))
//          {
              if (node.getSE().getClass().getName().equals("QuadInternal"))
              {
                  if( (x) < ((xHi+xLo)/2))
                  {
                      newX = ((xHi+xLo)/2);
                  }
                  if((y) < ((yHi+yLo)/2))
                  {
                      newY = ((yHi+yLo)/2);
                  }
                  newCount = count + rfind(newX,newY,w,h, xHi, ((xHi+xLo)/2), yHi, ((yHi+yLo)/2), count, node.getSE());
                  return newCount;

              }
              //else if ((((xHi+xLo)/2) > node.getNW().getElement().getXValue()) && (((yHi+yLo)/2) > node.getNW().getElement().getYValue()) && (xLo < node.getNW().getElement().getXValue()) && (yLo < node.getNW().getElement().getYValue()))
              else if(((x+w) > node.getSE().getElement().getXValue()) && (((y+h) > node.getSE().getElement().getYValue()) && (x < node.getSE().getElement().getXValue()) && (y < node.getSE().getElement().getYValue())))
              {
                  System.out.println(node.getSE().getElement().toString());
                  newCount++;
                  return newCount;
              }
//          }
              else
              {
                  return count;
              }

        }


        return count;
    }
}
