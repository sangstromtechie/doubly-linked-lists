import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// IMPORTANT NOTE: Uncomment all lines of code inside the function and ensure it works by building
///                 out the appropriate class and methods. You may also delete the failing assert line.
///                 DO NOT CHANGE THE TEST CODE!! EVER. :)
/// NodeTest - A class for testing a Node class
/// Node - A class that is the building block of several data structures including the linked list.
///         Holds generic element data and links to a previous Node and a next Node, if they are available
///
/// Assignment:     #1
/// Course:         ADEV-3001
/// Date Created:   Sept. 18, 2017
///
/// Revision Log
/// Who         When        Reason
/// ----------- ----------- ---------------
///
/// @author: Scott Wachal
/// @version 1.0
/// </summary>
public class NodeTest
{
    /**
     * Test the empty constructor to ensure the values are set to the proper defaults.
     * Will implicity test some getter methods
     */
    @Test
    public void Empty_Constructor_Test()
    {
        Node<Employee> node = new Node<Employee>();
        assertNotNull(node);
        assertNull(node.getElement());
        assertNull(node.getNext());
        assertNull(node.getPrevious());
    }

    /**
     * Test the parameter constructor to ensure the values are being set properly in the created instance.
     */
    @Test
    public void AllParameters_Constructor_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        Node<Employee> previousNode = new Node<Employee>(employee1, null, null);
        Node<Employee> nextNode = new Node<Employee>(employee2, null, null);
        Node<Employee> node = new Node<Employee>(employee3, previousNode, nextNode);

        assertNotNull(node);
        assertEquals(node.getElement(), employee3);
        assertEquals(node.getNext(), nextNode);
        assertEquals(node.getPrevious(), previousNode);
    }

    /**
     * Test the Element property to ensure that it is being set and retrieved properly.
     */
    @Test
    public void setElement_Test()
    {
        Employee employeeTest = new Employee(1);

        Node<Employee> node = new Node<Employee>();
        node.setElement(employeeTest);

        assertEquals(node.getElement(), employeeTest);
    }

    /**
     * Test the Previous property to ensure it is being set and retrieved properly.
     */
    @Test
    public void setPrevious_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Node<Employee> previousNode = new Node<Employee>(employee1, null, null);
        Node<Employee> testNode = new Node<Employee>(employee2, null, null);

        testNode.setPrevious(previousNode);

        assertEquals(testNode.getPrevious(), previousNode);
    }

    /**
     * Test the Next property to ensure it is being set and retrieved properly.
     */
    @Test
    public void setNext_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Node<Employee> nextNode = new Node<Employee>(employee1, null, null);
        Node<Employee> testNode = new Node<Employee>(employee2, null, null);

        testNode.setNext(nextNode);
        assertEquals(testNode.getNext(), nextNode);
    }
}