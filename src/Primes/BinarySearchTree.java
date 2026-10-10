package Primes;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        BinarySearchTree.java
 * Project      Primes with ATDs
 * Description  A definition for BinarySearchTree class with multitude of 
 *              methods for operations on trees.
 * Platform     jdk 26.0.2; NetBeans IDE 31; PC Windows 11
 * Course       CS 143, Edmonds College
 * Hours        1 hours and 45 minutes
 * Date         9/28/2026
 * @author	<i>Young Min Kim</i>
 * @version 	%1% %2%
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BinarySearchTree
{
    private BinarySearchTreeNode root;      //root of tree
    private int count = 1;                  //for display
    private final int NUMBERS_PER_LINE = 5; //for display
    StringBuilder printBuffer = new StringBuilder("");
    StringBuilder buffer = new StringBuilder("");
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Constructor     BinarySearchTreeNode()-- deafault constructor
     * Description     Construct a null Tree of ints.
     * @author         <i>Young Min Kim</i>
     * Date            9/28/2026
     * History Log     2/25/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTree()
    {
        root = null;
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       InsertNode()
     * Description  Insert a new node in the binary search tree. If the root 
     *              node is null, create the root node here. Otherwise, call the
     *              insert method from the from the class BinarySearchTreeNode
     * @param       number int
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void insertNode(int number)
    {
        if (root == null)
            root = new BinarySearchTreeNode(number);
        else
            root.insert(number);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       remove()
     * Description  A method to remove a node with given name only. Calls
     *              overloaded remove method with number and the root of the
     *              BinarySearchTree
     * @author      <i>Young Min Kim</i>
     * @param       number int to be removed
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void remove(int number)
    {
	root = remove(number, root);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method           remove()
     * Description      An overloaded recursive method to remove a node with 
     *                  given number and node. 
     * @author          <i>Young Min Kim</i>
     * @param           number int to be removed
     * @param           node BinarySearchTreeNode
     * @return          node BinarySearchTreeNode--the new root
     * Date            9/28/2026
     * History Log      2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode remove(int number, BinarySearchTreeNode node)
    {
	if( node == null )
	    return node;                        // Item not found; do nothing
	if(number < node.data)
	    node.left = remove(number, node.left);
	else if(number > node.data)
	    node.right = remove(number, node.right);
	else if(node.left != null && node.right != null) // Two children
        {
	    node.data = findMin(node.right).data;
	    node.right = remove(node.data, node.right);
	}
	else    //Case 1 & case 2: remove leaf node & single child
	    node = (node.left != null) ? node.left : node.right;
	return node;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getRoot()
     * Description  Getter method to return the root of the tree.
     * @author      <i>Young Min Kim</i>
     * @return      root BinarySearchTreeNode
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    public BinarySearchTreeNode getRoot()
    {
        return root;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       removeAll()
     * Description  A method to remove all nodes of the BinarySearchTree.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void removeAll()
    {
        root = null;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMin()
     * Description  A method to find and return the number with the minimum
     *              value. Calls an overloaded method to start the search 
     *              from the root node that is passed to it.
     * @author      <i>Young Min Kim</i>
     * @return      number int--with minimum value
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int findMin()
    {
        return findMin(root).data;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMin()
     * Description  A recursive overloaded method to find the node with the 
     *              int containing the minimum value. 
     * @author      <i>Young Min Kim</i>
     * @param       node BinarySearchTreeNode--recursive node to search for minimum
     * @return      node BinarySearchTreeNode--node containing the smallest item
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode findMin(BinarySearchTreeNode node)
    {
	if(node == null)
	    return null;
	else if(node.left == null)
	    return node;
	return findMin(node.left);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMax()
     * Description  A method to find and return the int with the maximum
     *              value. Calls an overloaded method to start the search 
     *              from the root node that is passed to it.
     * @author      <i>Young Min Kim</i>
     * @return      int int--with minimum name
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int findMax()
    {
        return findMax(root).data;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findMax()
     * Description  A recursive overloaded method to find the node with the 
     *              number containing the maximum value. 
     * @author      <i>Young Min Kim</i>
     * @param       node BinarySearchTreeNode--recursive node to search for minimum
     * @return      node BinarySearchTreeNode--node containing the largest item.
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode findMax(BinarySearchTreeNode node)
    {
	if( node != null )
        {
	    while( node.right != null )
		node = node.right;
        }	
	return node;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       elementAt()
     * Description  A method to return the int (data) given the node. 
     * @author      <i>Young Min Kim</i>
     * @param       node BinarySearchTreeNode
     * @return      data--int
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int elementAt(BinarySearchTreeNode node)
    {
	return (node == null ? null : node.data);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       nodeWith()
     * Description  A method to return the int (data) given the node.
     * @author      <i>Young Min Kim</i>   
     * @param       data int
     * @param       node BinarySearchTreeNode
     * @return      node BinarySearchTreeNode--the node with specified int
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
    *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private BinarySearchTreeNode nodeWith(int data, BinarySearchTreeNode node)
    {
        if (node == null)
            return null;
        else
        {
            if(data == node.data)
                return node;
            else
                if (data < node.data)
                    return nodeWith(data, node.left);
                else
                    return nodeWith(data, node.right);                            
        }            
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       contains()
     * Description  A boolean method to determine if a number is in the BST
     * @author      <i>Young Min Kim</i>   
     * @param       number int
     * @return      true if int is in tree; false otherwise
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean contains(int number)
    {
        if(nodeWith(number, root) == null)
            return false;
        else 
        {
            BinarySearchTreeNode foundint = nodeWith(number, root);
            return foundint.data == number;
        }            
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       next()
     * Description  An unfinished method to return the next number according
     *              to the sorting of the BST given an number. 
     * @author      <i>Young Min Kim</i>
     * @param       number int
     * @return      number int--the next number.
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int next(int number)
    {
        BinarySearchTreeNode nextNode = nodeWith(number, root);
        if( nextNode.left != null && nextNode.right != null ) // Two children
            return findMin(nextNode.right).data;
        else
            return 0;   //not so--needs work!! UNFINISHED
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       previous()
     * Description  An unfinished method to return the next number according
     *              to the sorting of the BST given an number. 
     * @author      <i>Young Min Kim</i>
     * @param       number int
     * @return      number int--the next number.
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int previous(int number)
    {
        BinarySearchTreeNode nextNode = nodeWith(number, root);
        if( nextNode.left != null && nextNode.right != null ) // Two children
            return findMax(nextNode.left).data;
        else
            return 0; //not so--needs work!! UNFINISHED
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       preorderTraversal()
     * Description  Display data of nodes in preorder: Node, Left, Right, Calls
     *              recursive preorderHelper method to do the real display.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void preorderTraversal()
    {
        preorderHelper( root );
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       preorderHelper()
     * Description  Display data of nodes id preorder: Node, Left, Right.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void preorderHelper( BinarySearchTreeNode node )
    {
        if ( node == null )
            return;
        System.out.print( node.data + " " );
        preorderHelper( node.left );
        preorderHelper( node.right );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       inorderTraversal()
     * Description  Display data of nodes in preorder: Left, Node, Right. Calls
     *              recursive inorderHelper method to do the real display.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void inorderTraversal()
    {
        inorderHelper( root );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       inorderHelper()
     * Description  Display data of nodes in preorder: Left, Node, Right.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void inorderHelper( BinarySearchTreeNode node )
    {
        if ( node == null )
            return;
        inorderHelper( node.left );
        System.out.print( node.data + " " );
        inorderHelper( node.right );
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       postorderTraversal()
     * Description  Display data of nodes in preorder: Left, Right, Node. Calls
     *              recursive postorderHelper method to do the real display.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void postorderTraversal()
    {
        postorderHelper( root );
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       postorderHelper()
     * Description  Display data of nodes in preorder: Left, Right, Node.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void postorderHelper( BinarySearchTreeNode node )
    {
        if ( node == null )
            return;
        postorderHelper( node.left );
        postorderHelper( node.right );
        System.out.print( node.data + " " );
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       toString()
     * Description  Outputs the tree contents in sorted order as a string.
     *              It calls the printTree to print the tree inorder.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString( )
    {
	if( isEmpty() )
	    return( "" );
	else
	    return(printTree( root ));
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       printTree()
     * Description  Outputs the tree contents in preorder.
     * @param       node BinarySearchTreeNode--the node that roots the tree
     * @return      tree String
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String printTree(BinarySearchTreeNode node)
    {	        
	if(node != null)
        {
	    printTree(node.left);
            printBuffer.append(node.data + '\n');        
	    printTree(node.right);
	}
	return printBuffer.toString();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       buildBuffer()
     * Description  Build a StringBuilder formatted NUMBERS_PER_LINE per 
     *              line that contains all data in preorder traversal. 
     * @param       node BinarySearchTreeNode--the node that roots the tree
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void buildBuffer(BinarySearchTreeNode node)
    {
        if(node != null)
        {
            if(count % NUMBERS_PER_LINE != 0)
                buffer.append(node.data + "\t");  
            else
                buffer.append(node.data + "\n");
            count++;
	    buildBuffer(node.left);                 
	    buildBuffer(node.right);
	}
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       getBuffer()
     * Description  Return buffer.
     * @return      buffer  String
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/    
    public String getBuffer()
    {
        return  buffer.toString();      //printBuffer.toString();
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       setBuffer()
     * Description  Set buffer.
     * @param       buffer StringBuilder
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void setBuffer(StringBuilder buffer)
    {
        this.buffer = buffer;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       isEmpty()
     * Description  Test if the tree is logically empty.
     * @return      true if empty, false otherwise
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean isEmpty()
    {
	return root == null;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       size()
     * Description  Find number of nodes in a tree. Calls sizeHelper with the
     *              root of the tree passed to it.
     * @return      number of nodes in a tree
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int size()
    {	
        return sizeHelper(root);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       sizeHelper()
     * Description  Recursive method to find number of nodes in a tree.
     * @param       node BinarySearchTreeNode
     * @return      number of nodes in the tree
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int sizeHelper (BinarySearchTreeNode node)
    {
	if (node == null)
	    return 0;
	else
	    return 1 + sizeHelper(node.left) + sizeHelper(node.right);
    }  

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       countLeaves()
     * Description  Find number of leaves in a tree. Calls countLeavesHelper  
     *              with the root of the tree passed to it.
     * @return      number of leaves in a tree to which node points
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeaves() 
    {
        return countLeavesHelper(root);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       countLeavesHelper()
     * Description  Recursive method to find number of leaves in a tree.
     * @param       node BinarySearchTreeNode
     * @return      number of leaves in the tree
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int countLeavesHelper(BinarySearchTreeNode node)
    {
        if (node == null)
           return 0;
        else if (node.left == null && node.right == null)
            return 1;  // Node is a leaf.
        else
            return countLeavesHelper(node.left) + countLeavesHelper(node.right);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       height()
     * Description  Find height of a tree. Calls heighthHelper with the root 
     *              of the tree passed to it. The height of a node is the 
     *              number of edges on the longest path from the  node to a 
     *              leaf. A leaf node will have a height of 0.
     * @return      height of a tree int
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int height() 
    {
        return heighthHelper(root);        
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       heighthHelper()
     * Description  Recursive method to find the height of a node.
     * @param       node BinarySearchTreeNode
     * @return      height of a node int
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int heighthHelper(BinarySearchTreeNode node)
    {
        if(node == null)
            return 0;
        else
        {
            return 1 + Math.max(heighthHelper(node.left),
                    heighthHelper(node.right));
        }
//        int left = heighthHelper(node.left);
//        int right = heighthHelper(node.right);
//
//        int x = (left > right) ? left + 1 : right + 1;
//        return x;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findParent()
     * Description  Find parent of a number. Calls overloaded findParent with
     *              number, root and parent (null).
     * @param       number int
     * @return      parent node of number BinarySearchTreeNode
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findParent(int number) 
    {
        return findParent(number, root, null);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findParent()
     * Description  Recursive method to find the parent of a number.
     * @param       number int
     * @param       node BinarySearchTreeNode
     * @param       parent BinarySearchTreeNode
     * @return      parent of a node or null--BinarySearchTreeNode
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findParent(int number, 
            BinarySearchTreeNode node, BinarySearchTreeNode parent) 
    {
        if (node == null) 
        {
            return null;
        } 
        else if (node.data != number) 
        {
            parent = findParent(number, node.left, node);
            if (parent == null) 
            {
                parent = findParent(number, node.right, node);
            }
        }
        return parent;
    }
        
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findSuccessor()
     * Description  Recursive method to find the successor of a number 
     *              given the data.
     * @param       data int
     * @return      successor of an number or null--BinarySearchTreeNode
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findSuccessor(int data) 
    {
        return findSuccessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findSuccessor()
     * Description  An overloaded recursive method to find the successor of a
     *              number given a node.
     * @param       node BinarySearchTreeNode
     * @return      successor of an number or null--BinarySearchTreeNode
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findSuccessor(BinarySearchTreeNode node)
    {
	if (node == null)
		return null;
	
	if (node.right != null)
		return findMin(node.right);
	
	BinarySearchTreeNode y = findParent(node.data);
	BinarySearchTreeNode x = node;
	while (y != null && x == y.right)
	{
		x = y;
		y = findParent(y.data);
	}
	// Intuition: as we traverse left up the tree we traverse smaller values
	// The first node on the right is the next larger value
	return y;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findPredecessor()
     * Description  Recursive method to find the predecessor of a number 
     *              given the data.
     * @param       data int
     * @return      successor of an number or null--BinarySearchTreeNode
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findPredecessor(int data) 
    {
        return findPredecessor(nodeWith(data,root));
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       findPredecessor()
     * Description  An overloaded recursive method to find the predecessor of 
     *              a number given a node.
     * @param       node BinarySearchTreeNode
     * @return      predecessor of an number or null--BinarySearchTreeNode
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  2/25/2021, 3/6/2021, 10/1/2026
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinarySearchTreeNode findPredecessor(BinarySearchTreeNode node)
    {
	if (node == null)
            return null;
	
	if (node.left!= null)
            return findMax(node.left);
			
	BinarySearchTreeNode parent = findParent(node.data);

	BinarySearchTreeNode y = parent;
	BinarySearchTreeNode x = node;
	while (y != null && x == y.left)
	{
            x = y;
            y = findParent(y.data);
	}	
	return y;
    }    
}