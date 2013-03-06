import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo() method.
 *
 * @param <T>
 *            The type of data element contained in the node.
 * @author Tam Ayers (tamayers)
 */
@SuppressWarnings("unused")
public class BinarySearchTree<T>
{
    // ~ Instance/static variables .............................................

    //root node
    private BinaryNode<T> root;
    //used for comparing distances on elements in tree
    private DistanceComparator<? super T> c;

    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * makes a new binarysearch tree
     * @param c a distanceComparator
     */
    public BinarySearchTree(DistanceComparator<? super T> c)
    {
        this.c = c; //distance compare
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
        root = insert(x, root);
    }


    // ----------------------------------------------------------
    /**
     * Remove the specified value from the tree.
     *
     * @param x
     *            the item to remove.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    public void remove(T x)
    {
        root = remove(x, root);
    }


    // ----------------------------------------------------------
    /**
     * Find the smallest item in the tree.
     *
     * @return The smallest item, or null if the tree is empty.
     */
    public T findMin()
    {
        return elementAt(findMin(root));
    }


    // ----------------------------------------------------------
    /**
     * Find the largest item in the tree.
     *
     * @return The largest item in the tree, or null if the tree is empty.
     */
    public T findMax()
    {
        return elementAt(findMax(root));
    }


    // ----------------------------------------------------------
    /**
     * Find an item in the tree.
     *
     * @param x
     *            the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T x)
    {

        return elementAt(find(x, root));
    }

    // ----------------------------------------------------------
    /**
     * Find kth item in the binary seach tree
     * @param x
     * @return T element in node
     */
    public T findKth(int x)
    {
        return elementAt(findKth(x, root));
    }

    // ----------------------------------------------------------
    /**
     * findest the nearest element in a node in the tree to the one requested
     * @param x
     * @return t element in node
     */
    public T findNearest(T x)
    {
        return elementAt(findNearest(x, root));
    }

    // ----------------------------------------------------------
    /**
     * prints out the binary search tree
     */
    public void list()
    {
        inOrder(root, 0);
    }


    // ----------------------------------------------------------
    /**
     * Make the tree logically empty.
     */
    public void makeEmpty()
    {
        root = null;
    }


    // ----------------------------------------------------------
    /**
     * Test if the tree is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty()
    {
        if (this.findMax() == null && this.findMin() == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to get element value stored in a tree node, with safe
     * handling of null nodes.
     *
     * @param node
     *            the node.
     * @return the element field or null if node is null.
     */
    private T elementAt(BinaryNode<T> node)
    {
        return (node == null) ? null : node.getElement();
    }

    // ----------------------------------------------------------
    /**
     * Internal method to insert a value into a subtree.
     *
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> node)
    {
        if (node == null)
        {
            return new BinaryNode<T>(x);
        }
        else if (c.compare(x,node.getElement()) < 0)
        {
            node.setLeft(insert(x, node.getLeft()));
            node.leftSize++;
        }
        else if (c.compare(x,node.getElement()) > 0)
        {
            node.setRight(insert(x, node.getRight()));
        }
        else
        {
            throw new DuplicateItemException(x.toString());
        }
        return node;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to remove a specified item from a subtree.
     *
     * @param x
     *            the item to remove.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> node)
    {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<T> result = node;

        // If there's no more subtree to examine
        if (node == null)
        {
            throw new ItemNotFoundException(x.toString());
        }

        // if value should be to the left of the root
        if (c.compare(x,node.getElement()) < 0)
        {
            node.setLeft(remove(x, node.getLeft()));
            node.leftSize--;
        }
        // if value should be to the right of the root
        else if (c.compare(x, node.getElement()) > 0)
        {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else
        {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null)
            {
                result = node.getLeft();
            }
            // If there is only one child on the left
            else if (node.getLeft() != null)
            {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else
            {
                result = node.getRight();
            }
        }
        return result;
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param node
     *            the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> node)
    {
        if (node == null)
        {
            return null;
        }
        else if (node.getLeft() == null)
        {
            return node;
        }
        else
        {
            return findMin(node.getLeft());
        }
    }


    // ----------------------------------------------------------
    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param node
     *            the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node)
    {
        if (node == null)
        {
            return node;
        }
        else if (node.getRight() == null)
        {
            return node;
        }
        else
        {
            return findMax(node.getRight());
        }
    }


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
    private BinaryNode<T> find(T x, BinaryNode<T> node)
    {
        if (node == null)
        {
            return null; // Not found
        }
        else if (c.compare(x,node.getElement()) < 0)
        {
            // Search in the left subtree
            return find(x, node.getLeft());
        }
        else if (c.compare(x,node.getElement()) > 0)
        {
            // Search in the right subtree
            return find(x, node.getRight());
        }
        else
        {
            return node; // Match
        }
    }

    /**
     * called by helper method above to find k
     */
    private BinaryNode<T> findKth(int x, BinaryNode<T> node)
    {
        if (x > node.getLeftSize())
        {
            return findKth((x-1-node.getLeftSize()), node.getRight());
        }
        else if (x < node.getLeftSize())
        {
            return findKth(x, node.getLeft());
        }
        else
        {
            return node; //found
        }

    }


    /**
     * called by the findNearest helper method above. recursive
     */
    private BinaryNode<T> findNearest(T x, BinaryNode<T> node)
    {
        if (c.getDistance(x, node.getElement()) < 0)
        {
            if (node.getRight() == null)
            {
                return node;
            }
            else
            {
                BinaryNode<T> tempNode = findNearest(x, node.getRight());
                int y = Math.abs((c.compare(node.getElement(), x)));
                int z = Math.abs((c.compare(tempNode.getElement(), x)));
                if (y > z)
                {
                    return tempNode;
                }
                else
                {
                    return node;
                }
            }
        }
        else if (c.getDistance(x, node.getElement()) > 0)
        {
            if (node.getLeft() == null)
            {
                return node;
            }
            else
            {
                BinaryNode<T> tempNode2 = findNearest(x, node.getRight());
                int a = Math.abs((c.compare(node.getElement(), x)));
                int b = Math.abs((c.compare(tempNode2.getElement(), x)));
                if (a > b)
                {
                    return tempNode2;
                }
                else
                {
                    return node;
                }

            }
        }
        else
        {
            return node;
        }
    }


    // ----------------------------------------------------------
    /**
     * This is a method that is used to print out all of the values in my tree
     * @param node
     * @param x
     */
    public void inOrder(BinaryNode<T> node, int x)
    {
        if (node == null)
        {
            return;
        }
        inOrder(node.getLeft(), x+1);
        int i = 0;
        while (i < x)
        {
            System.out.print("-");
            i++;
        }
        System.out.print(node.getElement() + "\n");
        inOrder(node.getRight(), x+1);
    }
}
