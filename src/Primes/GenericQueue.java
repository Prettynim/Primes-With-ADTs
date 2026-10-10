package Primes;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        GenericQueue.java
 * Description  GenericQueue class is derived (inheritance) from the LinkedList
 *              class.
 * Project      Primes with ADTs
 * Platform     jdk 26.0.2; NetBeans IDE 31; PC Windows 11
 * Course       CS 142, EdCC
 * Hourse       2 hours and 45 minutes
 * Date         9/28/2026
 * Histoly log  5/7/2020, 3/6/2021
 * @param       <E>
 * @author      <i>Young Min Kim</i>
 * @version     %1% %4%
 * @see         javax.swing.JDialog
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class GenericQueue<E> extends java.util.LinkedList<E>
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       enqueue()
     * Description  Method to add Object obj to the end of the queue. Relies
     *              on the addLast method from the LinkedList class.
     * @param       obj--E
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void enqueue(E obj)
    {
        this.addLast(obj);
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       dequeue()
     * Description  Method to remove and return the obj from the front of the
     *              queue. It calls the removeFirst method it inherits from the
     *              LinkedList class.
     * @return      first object--Object
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public Object dequeue()
    {
        return removeFirst();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       getSize()
     * Description  Method to return the number of elements in the queue. It
     *              calls the getSize method it inherits from the LinkedList
     *              class.
     * @return      size--int
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public int getSize()
    {
        return size();
    }

    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       toString()
     * Description  Method to display the queue. It calls the toString method
     *              it inherits from the LinkedList class.
     * @return      queue as string--String
     * @author      <i>Young Min Kim</i>
     * Date         9/28/2026
     * History Log  7/18/2018, 4/5/2021, 10/1/2026
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    @Override
    public String toString()
    {
        return "Queue: " + toString();
    }
}
