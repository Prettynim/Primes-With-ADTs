package Primes;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        BinarySearchTreeNode.java
 * Project      Primes with ADTs
 * Description  A self-refential class representing a binary tree node of 
 *              integers.      
 * Platform     jdk 26.0.2; NetBeans IDE 31; PC Windows 11
 * Course       CS 143, Edmonds College
 * Hours        1 hours and 45 minutes
 * Date         9/28/2026
 * History Log  2/25/2021, 3/6/2021, 10/1/2026
 * @author	<i>Young Min Kim</i>
 * @version 	%1% %2%
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
class BinarySearchTreeNode
{
    BinarySearchTreeNode left;  // left node
    int data;                   // data item
    BinarySearchTreeNode right; // right node
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor  TreeNOde()-- constructor
     * Description  Initialize data to number and make this a leaf node.
     * @param       number int
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode(int number)
    {
        data = number;
        left = right = null; // this node has no children
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       Insert()
     * Description  Recursive method to insert a number into a Tree that
     *              contains node.
     * @param       number int
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public synchronized void insert(int number)
    {
        if (number < data)
        {
            if (left == null)
                left = new BinarySearchTreeNode(number);
            else
                left.insert(number);
        }
        else
            if (number > data)
            {
                if (right == null)
                    right = new BinarySearchTreeNode(number);
                else
                    right.insert(number);
            }
    }
}