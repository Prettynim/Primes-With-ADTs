package Primes;
import java.io.Serializable;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        GenericStack.java
 * Description  GenericStack class contains (composition) an ArrayList for an
 *              instance variable and uses the methods of the ArrayList to
 *              define its own getSize, peek, push, pop, isEmpty and toString
 *              methods. Implements Serializable interface in order to allow
 *              saving a Stack object as a binary object.
 *              An object is eligible for serialization if and only if its class
 *              implements the java.io.Serializable interface. Serializable is a
 *              marker interface (contains no methods) that tell the Java
 *              Virtual Machine (JVM) that the objects of this class is ready
 *              for being written to and read from a persistent storage or over
 *              the network.
 * Project      Primes with ADTs
 * Platform     jdk 26.0.2; NetBeans IDE 31; PC Windows 11
 * Course       CS 142, EdCC
 * Hourse       2 hours and 45 minutes
 * Date         9/28/2026
 * Histoly log  5/7/2020, 3/6/2021
 * @author      <i>Young Min Kim</i>
 * @version     %1% %4%
 * @param       <E>
 * @see         javax.swing.JDialog
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class GenericStack<E> implements Serializable
{
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getSize()
     * Description  Method to return the number of elements in the queue. It
     *              calls the getSize method it inherits from the LinkedList
     *              class.
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getSize()
    {
        return list.size();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       peek()
     * Description  Method that returns to examine the top object in the stack
     *              which is the object with index getSize() - 1 of the ArrayList.
     *              Note that the object is not removed from the stack.
     * @return      E
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public E peek()
    {
        return list.get(getSize() - 1);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       push()
     * Description  Method that adds the obj onto the stack. Note that the
     *              obj is added at the end of the list (which becomes the
     *              new top.
     * @param       obj--E
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void push(E obj)
    {
        list.add(obj);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       pop()
     * Description  Method that returns the top object in the stack which is
     *              the obj with index getSize() - 1 of the ArrayList.
     *              Note that the obj is removed from the stack.
     * @return      E
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public E pop()
    {
        E obj = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return obj;
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       isEmpty()
     * Description  Method to determine is the stack is empty. It calls the
     *              isEmpty method of the ArrayList.
     * @return      true or false depending on whether stack is empty--boolean
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Method to display the stack. It calls the toString method
     *              from the ArrayList class.
     * @return      stack as string--String
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString()
    {
        return "stack: " + list.toString();
    }
}
