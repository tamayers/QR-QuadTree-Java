import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 * This program takes input from System.in and the takes the input and
 * implies the commands to a database. This program stores and organize
 * record objects.
 *
 *  @author tamayers
 *  @version Feb 10, 2012
 *  @version mac os x
 */
public class quad
{

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args
     */
    public static void main(String[] args)
    {
        Controller database = new Controller();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine())
        {
            if(sc.hasNext("insert"))
            {
                sc.next();
                database.insert(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt());
            }
            if(sc.hasNext("find"))
            {
                sc.next();
                if(sc.hasNext("population"))
                {
                    database.find(sc.next(), sc.nextInt());
                }
                if(sc.hasNext("name"))
                {
                    database.find(sc.next(), sc.next());
                }
                if(sc.hasNext("location"))
                {
                    sc.next();
                    database.find(sc.nextInt(), sc.nextInt());
                }
            }
            if(sc.hasNext("findKth"))
            {
                sc.next();
                database.findKth(sc.next(),sc.nextInt());
            }
            if(sc.hasNext("findNearest"))
            {
                sc.next();
                if(sc.hasNext("population"))
                {
                    database.findNearest(sc.next(), sc.nextInt());
                }
                if(sc.hasNext("name"))
                {
                    database.findNearest(sc.next(), sc.next());
                }
            }
            if(sc.hasNext("remove"))
            {
                sc.next();
                if(sc.hasNext("population"))
                {
                    database.remove(sc.next(), sc.nextInt());
                }
                if(sc.hasNext("name"))
                {
                    database.remove(sc.next(), sc.next());
                }
                if(sc.hasNext("location"))
                {
                    sc.next();
                    database.remove(sc.nextInt(), sc.nextInt());
                }
            }
            if(sc.hasNext("list"))
            {
                sc.next();
                database.list(sc.next());
            }
            if(sc.hasNext("makenull"))
            {
                sc.next();
                database.makenull();
            }
            if(sc.hasNext("rfind"))
            {
                sc.next();
                database.rfind(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

        }
        return;

    }

}
//// // // // // // // // // // // // // // // // //
//On my honor:
//- I have not used source code obtained from another student, or any other unauthorized source, either modified or unmodified.
//- All source code and documentation used in my program is either my original work, or was derived by me from the source code published in the textbook for this course.
//- I have not discussed coding details about this project with
//anyone other than the instructor, ACM/UPE tutors or the TAs assigned to this course. I understand that I may discuss the concepts
//of this program with other students, and that another student
//may help me debug my program so long as neither of us writes anything during the discussion or modifies any computer file
//during the discussion. I have violated neither the spirit nor
//letter of this restriction.
