import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// IMPORTANT NOTE: Uncomment all lines of code inside each function as required.
///                 You may also delete the failing assert line at that time.
///                 DO NOT CHANGE THE TEST CODE!! EVER. :)
/// LinkedListTest - A class for testing the LinkedList class
/// LinkedList - A class for creating and manipulating a doubly linked list of nodes containing generic data of type T.
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
public class LinkedListTest {

    /* MILESTONE 1*/

    /// <summary>
    /// Test the constructor to ensure the default values are set properly.
    /// </summary>
    @Test
    public void new_constructor_has_size_of_zero_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getSize(), 0);
    }

    @Test
    /// <summary>
    /// Test GetHead returns null when a new constructor is called.
    /// </summary>
    public void GetHead_is_null_on_new_constructor_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getHead(), null);
    }

        @Test
    /// <summary>
    /// Test GetTail returns null when a new constructor is called.
    /// </summary>
    public void GetTail_is_null_on_new_constructor_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getTail(), null);
    }

    /// <summary>
    /// Test IsEmpty() should return true on an empty list.
    /// </summary>
        @Test
    public void IsEmpty_is_true_on_new_constructor_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertTrue(list.isEmpty());
    }



    /// <summary>
    /// Test AddFirst() to ensure node is added to list.
    /// </summary>
    @Test
    public void AddFirst_on_emptylist_count_increases_from_0_to_1_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getSize(), 0);

        list.addFirst(addedEmployee);

        assertEquals(list.getSize(), 1);
    }

    /// <summary>
    /// Test AddFirst() method to ensure the head pointer is updated when first object is inserted.
    /// </summary>
    @Test
    public void AddFirst_on_emptylist_Head_Updated_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getHead(), null);

        list.addFirst(employee1);

        assertEquals(list.getHead().getElement(), employee1);
    }

    /// <summary>
    /// Test AddFirst() method to ensure the head pointer is updated when many objects are inserted.
    /// </summary>
    @Test
    public void AddFirst_on_larger_Existing_list_Head_Updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getHead(), null);

        list.addFirst(employee1);
        list.addFirst(employee2);
        list.addFirst(employee3);

        assertEquals(list.getHead().getElement(), employee3);
    }

    /// <summary>
    /// Test AddFirst() method to ensure the tail pointer is updated when first object is inserted.
    /// </summary>
    @Test
    public void AddFirst_on_emptylist_Tail_Updated_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getTail(), null);

        list.addFirst(employee1);

        assertEquals(list.getTail().getElement(), employee1);
    }

    /// <summary>
    /// Test AddFirst() to ensure that the added node is added to the head position when more than one node is in the list.
    /// </summary>
    @Test
    public void AddFirst_on_existinglist_count_increases_from_1_to_2_Test()
    {
        Employee employeeInList = new Employee(1);
        Employee addedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        assertEquals(list.getSize(), 0);

        list.addFirst(employeeInList);
        assertEquals(list.getSize(), 1);

        list.addFirst(addedEmployee);
        assertEquals(list.getSize(), 2);
    }

    /// <summary>
    /// Test AddFirst() method to ensure the head pointer is updated when many objects are inserted.
    /// </summary>
    @Test
    public void AddFirst_on_larger_Existing_list_Tail_Updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getHead(), null);

        list.addFirst(employee1);
        list.addFirst(employee2);
        list.addFirst(employee3);

        assertEquals(list.getTail().getElement(), employee1);
    }

    /// <summary>
    /// Test AddFirst() to ensure it can handle null being added to list.
    /// </summary>
    @Test
    public void AddFirstNullTest()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(null);

        assertEquals(list.getSize(), 1);
        assertNull(list.getFirst());
    }

    /// <summary>
    /// Test that GetFirst throws an exception when called on an empty list, because Null.getElement() doesn't exist!
    /// </summary>
    @Test
    public void GetFirst_on_emptylist_throws_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(NoSuchElementException.class, () -> list.getFirst());
    }

    /// <summary>
    /// Test that GetFirst returns the head's element
    /// </summary>
        @Test
    public void GetFirst_on_existinglist_returns_head_element_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(new Employee(1));

        assertEquals(list.getHead().getElement(), list.getFirst());
    }

    /// <summary>
    /// Test that GetLast throws an exception when called on an empty list, because Null.getElement() doesn't exist!
    /// </summary>
        @Test
    public void GetLast_on_emptylist_throws_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(NoSuchElementException.class, () -> list.getLast());
    }

    /// <summary>
    /// Test that GetLast returns the tail's element
    /// </summary>
    @Test
    public void GetLast_on_existinglist_returns_tail_element_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(new Employee(1));

        assertEquals(list.getTail().getElement(), list.getLast());
    }

    /// <summary>
    /// Test IsEmpty() should return false on a list containing nodes.
    /// </summary>
    @Test
    public void IsEmpty_returns_false_on_existinglist_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertFalse(list.isEmpty());
    }

    /// <summary>
    /// Test that Clear() empties a list.
    /// </summary>
    @Test
    public void ClearTest()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        list.addFirst(employee2);
        list.addFirst(employee1);

        assertEquals(list.getSize(), 3);
        assertFalse(list.isEmpty());

        list.clear();

        assertEquals(list.getSize(), 0);
        assertTrue(list.isEmpty());
    }

    /// <summary>
    /// Test GetSize() to make sure it returns the proper size; mostly for fun here. :)
    /// </summary>
    @Test
    public void GetSize_returns_correct_value_after_random_adds_Test()
    {
        Random rnd = new Random();
        int numberOfElements = rnd.nextInt((50 - 1) + 1) + 1;

        Employee employee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();

        for (int i = 0; i < numberOfElements; i++)
        {
            list.addFirst(employee);
        }

        assertEquals(list.getSize(), numberOfElements);
    }


    /* MILESTONE 2*/
    /// <summary>
    /// Test AddFirst() method to ensure the old head pointer's previous now points to the new head.
    /// </summary>
    @Test
    public void AddFirst_on_existingList_updates_oldhead_to_point_previous_to_newhead_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertEquals(list.getHead(), null);

        list.addFirst(employee1);
        Node<Employee> oldHead = list.getHead();

        list.addFirst(employee2);
        Node<Employee> newHead = list.getHead();

        assertEquals(newHead.getElement(), employee2);
        assertEquals(newHead.getPrevious(), null);
        assertEquals(newHead.getNext().getElement(), oldHead.getElement());

        assertEquals(oldHead.getElement(), employee1);
        assertEquals(oldHead.getPrevious().getElement(), newHead.getElement());
        assertEquals(oldHead.getNext(), null);
    }

    /// <summary>
    /// Test AddLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void AddLast_to_emptyList_count_increases_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getSize(), 1);
    }

    /// <summary>
    /// Test AddLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void AddLast_to_emptyList_last_updated_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getLast(), addedEmployee);
    }
    /// <summary>
    /// Test AddLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void AddLast_to_emptyList_first_updated_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getFirst(), addedEmployee);
    }

    /// <summary>
    /// Test AddLast() to ensure node is added to list.
    /// </summary>
    @Test
    public void AddLast_to_emptyList_tail_pointers_are_set_to_null_Test()
    {
        Employee addedEmployee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(addedEmployee);

        assertEquals(list.getTail().getNext(), null);
        assertEquals(list.getTail().getPrevious(), null);
    }

    /// <summary>
    /// Test AddLast() to ensure that the added node is added to the tail position when more than one node is in the list.
    /// </summary>
    @Test
    public void AddLast_to_existingList_tail_previous_set_to_oldTail_Test()
    {
        Employee employeeInList = new Employee(1);
        Employee addedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employeeInList);
        Node<Employee> oldTail = list.getTail();

        list.addLast(addedEmployee);
        Node<Employee> newTail = list.getTail();

        assertEquals(list.getSize(), 2);
        assertEquals(list.getLast(), addedEmployee);
        assertEquals(newTail.getPrevious(), oldTail);
    }

    /// <summary>
    /// Test AddLast() to ensure that the added node is added to the tail position of the list in a larger list.
    /// </summary>
    @Test
    public void AddLast_to_larger_existingList_first_and_last_are_updated_Test()
    {
        Employee employeeInList = new Employee(1);
        Employee employeeInList2 = new Employee(2);
        Employee addedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employeeInList);
        list.addLast(employeeInList2);
        list.addLast(addedEmployee);

        assertEquals(list.getSize(), 3);
        assertEquals(list.getFirst(), employeeInList);
        assertEquals(list.getLast(), addedEmployee);
    }

    /// <summary>
    /// Test AddLast() to ensure it can handle null being added to list.
    /// </summary>
    @Test
    public void AddLast_Null_element_is_allowed_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(null);

        assertEquals(list.getSize(), 1);
        assertEquals(list.getFirst(), null);
        assertEquals(list.getLast(), null);
    }

    /// <summary>
    /// Test calling RemoveFirst() on an empty list causes an exception.
    /// </summary>
    @Test
    public void RemoveFirst_on_EmptyList_throws_exception_test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(IllegalArgumentException.class, () -> list.removeFirst());
    }

    /// <summary>
    /// Test RemoveFirst() returns reduced count by 1
    /// </summary>
    @Test
    public void RemoveFirst_decreases_count_by_1_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        assertEquals(list.getSize(), 1);
        list.removeFirst();
        assertEquals(list.getSize(), 0);
    }

    /// <summary>
    /// Test RemoveFirst() returns the element removed.
    /// </summary>
    @Test
    public void RemoveFirst_Returns_first_Element_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        Employee firstElement = list.getFirst();
        Employee returnedElement = list.removeFirst();

        assertEquals(returnedElement, firstElement);
    }

    /// <summary>
    /// Test RemoveFirst() removes the head and tail on size 1 list
    /// </summary>
    @Test
    public void RemoveFirst_on_list_of_size_1_removes_head_and_tail_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.removeFirst();

        assertEquals(list.isEmpty(), true);
        assertEquals(list.getHead(), null);
        assertEquals(list.getTail(), null);
    }

    /// <summary>
    /// Test RemoveFirst() removes the head node on a larger list
    /// </summary>
    @Test
    public void RemoveFirst_on_larger_existingList_removes_head_and_decreases_count_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        list.addFirst(employee2);
        list.addFirst(employee1);
        assertEquals(list.getSize(), 3);
        assertEquals(list.getFirst(), employee1);
        list.removeFirst();

        assertEquals(list.getSize(), 2);
        assertEquals(list.getFirst(), employee2);
    }

    /// <summary>
    /// Test RemoveFirst() removes the head node and sets previous to null
    /// </summary>
    @Test
    public void RemoveFirst_on_existingList_removes_head_and_sets_previous_to_null_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee3);
        list.addFirst(employee2);
        list.addFirst(employee1);

        list.removeFirst();

        assertEquals(list.getHead().getPrevious(), null);
        assertEquals(list.getHead().getNext().getElement(), employee3);
    }

    /// <summary>
    /// Test calling RemoveLast() on an empty list causes an exception.
    /// </summary>
    @Test
    public void RemoveLast_on_EmptyList_throws_exception_test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.removeLast());
    }

    /// <summary>
    /// Test RemoveLast() decreases count by 1.
    /// </summary>
    @Test
    public void RemoveLast_decreases_count_by_1_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        assertEquals(list.getSize(), 1);
        list.removeLast();

        assertEquals(list.getSize(), 0);
    }

    /// <summary>
    /// Test RemoveLast() returns the element removed.
    /// </summary>
    @Test
    public void RemoveLast_Returns_last_Element_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        Employee lastElement = list.getLast();
        Employee returnedElement = list.removeLast();

        assertEquals(returnedElement, lastElement);
    }

    /// <summary>
    /// Test RemoveLast() removes head and tail on size 1 list
    /// </summary>
    @Test
    public void RemoveLast_on_list_of_size_1_removes_head_and_tail_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        list.removeLast();

        assertTrue(list.isEmpty());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /// <summary>
    /// Test RemoveLast() removes the tail node on a larger list
    /// </summary>
    @Test
    public void RemoveLast_on_larger_existingList_removes_tail_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        list.addFirst(employee2);
        list.addFirst(employee1);
        assertEquals(list.getSize(), 3);
        assertEquals(list.getLast(), employee3);

        list.removeLast();

        assertEquals(list.getSize(), 2);
        assertEquals(list.getLast(), employee2);

        assertEquals(list.getTail().getNext(), null);
    }

    /// <summary>
    /// Test RemoveLast() on two items, removes the tail node and sets head to tail.
    /// </summary>
    @Test
    public void RemoveLast_on_list_of_size_2_makes_the_head_the_newTail_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee1);
        list.addLast(employee2);

        list.removeLast();

        assertEquals(list.getHead(), list.getTail());
        assertEquals(list.getTail().getNext(), null);
        assertEquals(list.getTail().getPrevious(), null);
        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getLast(), employee1);
    }

    /// <summary>
    /// Test SetFirst() on an empty list raises an exception.
    /// </summary>
    @Test
    public void SetFirst_on_emptyList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(IllegalArgumentException.class, () -> list.setFirst(employee1));
    }

    /// <summary>
    /// Test SetFirst() replaces element on the head node on list of 1
    /// </summary>
    @Test
    public void SetFirst_on_list_of_1_replaces_head_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        list.setFirst(employee2);

        assertEquals(list.getFirst(), employee2);
    }

    /// <summary>
    /// Test SetFirst() returns the element that has been replaced.
    /// </summary>
    @Test
    public void SetFirstReturnsReplacedElementTest()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        Employee returnedData = list.setFirst(employee2);

        assertEquals(returnedData, employee1);
    }

    /// <summary>
    /// Test SetLast() on an empty list raises an exception.
    /// </summary>
    @Test
    public void SetLast_on_emptyList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(IllegalArgumentException.class, () -> list.setLast(employee1));
    }

    /// <summary>
    /// Test SetLast() replaces element on the tail node.
    /// </summary>
    @Test
    public void SetLast_on_existingList_updates_tail_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.addFirst(employee2);

        list.setLast(employee3);

        assertEquals(list.getLast(), employee3);
    }

    /// <summary>
    /// Test SetLast() returns the element that has been replaced.
    /// </summary>
    @Test
    public void SetLast_returns_replaced_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.addFirst(employee2);

        Employee returnedData = list.setLast(employee3);

        assertEquals(returnedData, employee1);
    }

    /// <summary>
    /// Ensure that Get(position) returns the element at the correct position.
    /// </summary>
    @Test
    public void Get_By_Position_1_on_existingList_returns_head_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertEquals(list.get(1), list.getFirst());
    }

    /// <summary>
    /// Make sure that calling Get(position) on an empty list results in an exception.
    /// </summary>
    @Test
    public void Get_By_Position_On_EmptyList_throws_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.get(1));
    }

    /// <summary>
    /// Make sure at calling Get(position) with a negative number results in an exception.
    /// </summary>
    @Test
    public void Get_By_number_less_than_1_on_existingList_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.get(-1));
    }

    /// <summary>
    /// Ensure that Get(position) returns the element at the correct position.
    /// </summary>
    @Test
    public void Get_By_Position_2_on_list_of_size_2_returns_last_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertEquals(list.get(2), list.getLast());
    }

    /// <summary>
    /// Ensure that calling Get(position) with a value larger than the size of the list results in an exception.
    /// </summary>
    @Test
    public void Get_By_Position_larger_than_list_size_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.get(list.getSize() + 1));
    }

    /// <summary>
    /// Ensure that calling AddAfter() on an empty list will result in an exception.
    /// </summary>
    @Test
    public void AddAfterPosition_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.addAfter(employee, 1));
    }

    /// <summary>
    /// Ensure that passing a negative position value to AddAfter(element, position) results in an exception.
    /// </summary>
    @Test
    public void AddAfterPosition_Negative_Position_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.addAfter(addEmployee, -1));
    }

    /// <summary>
    /// Ensure that passing a position value larger than size to AddAfter(element, position) results in an exception.
    /// </summary>
    @Test
    public void AddAfterPosition_getsize_plus_1_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.addAfter(addEmployee, list.getSize() + 1));
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void AddAfter_Position_1_on_existingList_inserts_after_head_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        list.addFirst(employee1);

        list.addAfter(employee2, 1);

        assertEquals(list.getHead().getNext().getElement(), employee2);

        assertEquals(list.getSize(), 3);
        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);
    }

    /// <summary>
    /// Checking edge case; Ensure that passing the size as the position will append to the end of the list without error.
    /// </summary>
    @Test
    public void AddAfterPosition_using_GetSize_on_existingList_returns_tail_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        list.addAfter(employee3, list.getSize());

        assertEquals(list.getSize(), 3);
        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee2);
        assertEquals(list.get(3), employee3);
    }

    /// <summary>
    /// Ensure that calling AddBefore() on an empty list will result in an exception.
    /// </summary>
    @Test
    public void AddBeforePosition_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.addAfter(employee, 1));
    }

    /// <summary>
    /// Ensure that passing a negative position value to AddBefore(element, position) results in an exception.
    /// </summary>
    @Test
    public void AddBeforePosition_Negative_Position_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.addBefore(addEmployee, -1));
    }

    /// <summary>
    /// Ensure that passing a position value larger than size to AddBefore(element, position) results in an exception.
    /// </summary>
    @Test
    public void AddBeforePosition_getsize_plus_1_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.addBefore(addEmployee, list.getSize() + 1));
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void AddBefore_Position_1_on_existingList_updates_First_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee3);
        list.addFirst(employee1);

        list.addBefore(employee2, 1);

        assertEquals(list.getFirst(), employee2);

        assertEquals(list.getSize(), 3);
        assertEquals(list.get(1), employee2);
        assertEquals(list.get(2), employee1);
        assertEquals(list.get(3), employee3);
    }

    /// <summary>
    /// Checking edge case; Ensure that passing the size as the position will append to the end of the list without error.
    /// </summary>
    @Test
    public void AddBeforePosition_using_GetSize_on_existingList_inserts_tails_previous_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        list.addBefore(employee3, list.getSize());
        assertEquals(list.getTail().getPrevious().getElement(), employee3);

        assertEquals(list.getSize(), 3);
        assertEquals(list.get(1), employee1);
        assertEquals(list.get(2), employee3);
        assertEquals(list.get(3), employee2);
    }

    /// <summary>
    /// Make sure that calling Remove(position) on an empty list results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_On_EmptyList_throw_exception_Test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.remove(1));
    }

    /// <summary>
    /// Make sure at calling Remove(position) with a negative number results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_Negative_number_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.remove(-1));
    }

    /// <summary>
    /// Ensure that calling Remove(position) with a value of zero results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_Zero_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.remove(0));
    }

    /// <summary>
    /// Ensure that calling Remove(position) with a value larger than the size of the list results in an exception.
    /// </summary>
    @Test
    public void RemoveByPosition_getsize_plus_one_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.remove(100));
    }

    /// <summary>
    /// Ensure that Remove() decreases count
    /// </summary>
    @Test
    public void RemoveByPosition_decreases_count_by_one_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertEquals(list.getSize(), 1);

        Employee returnedElement = list.remove(1);

        assertEquals(list.getSize(), 0);
    }

    /// <summary>
    /// Ensure that Remove() returns the element removed.
    /// </summary>
    @Test
    public void RemoveByPosition_Returns_an_Element_Test()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        Employee returnedElement = list.remove(1);

        assertEquals(returnedElement, employee1);
    }

      /// <summary>
      /// Ensure that Remove() removes the element at the correct position.
      /// </summary>
    @Test
    public void RemoveByPosition_2_in_list_of_size_3_removes_the_right_node_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);
        list.addFirst(employee2);
        list.addFirst(employee3);

        assertEquals(list.getSize(), 3);

        list.remove(2);

        assertEquals(list.getSize(), 2);
        assertEquals(list.getFirst(), employee3);
        assertEquals(list.getLast(), employee1);
    }

    /// <summary>
    /// Test Remove(position) properly updated the head when removing from position 1.
    /// </summary>
    @Test
    public void RemoveByPosition_Head_Updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee3);

        Employee removedElement = list.remove(1);

        assertEquals(removedElement, employee1);
        assertEquals(list.getFirst(), employee2);
        assertEquals(list.getHead().getNext().getElement(), employee3);
        assertEquals(list.getHead().getPrevious(), null);
    }

    /// <summary>
    /// Test Remove(position) properly updates the tail when removing from position size.
    /// </summary>
    @Test
    public void RemoveByPosition_Tail_Updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee3);

        assertEquals(list.getLast(), employee3);

        Employee removedElement = list.remove(list.getSize());

        assertEquals(removedElement, employee3);

        assertEquals(list.getLast(), employee2);
        assertEquals(list.getTail().getNext(), null);
        assertEquals(list.getTail().getPrevious().getElement(), employee1);
    }

    /// <summary>
    /// Test Set(position) on an empty list results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_On_EmptyList_throws_exceptionTest()
    {
        Employee employee1 = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.set(employee1, 1));
    }

    /// <summary>
    /// Test Set(position) with a negative number results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_Negative_Value_throws_exceptionTest()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.set(employee2, -1));
    }

    /// <summary>
    /// Test Set(position) with a value of zero results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_Zero_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.set(employee2, 0));
    }

    /// <summary>
    /// Test Set(position) with a value larger than the size of the list results in an exception.
    /// </summary>
    @Test
    public void SetByPosition_getSize_plus_one_throws_exception_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee1);

        assertThrows(IllegalArgumentException.class, () -> list.set(employee2, list.getSize()+1));
    }

    /// <summary>
    /// Ensure that Set(position) sets the element at the correct position.
    /// </summary>
    @Test
    public void SetByPosition_1_on_list_of_1_updates_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        assertEquals(list.get(1), employee1);

        list.set(employee2, 1);

        assertEquals(list.getSize(), 1);
        assertEquals(list.get(1), employee2);
    }

    /// <summary>
    /// Test Set(position) returns the replaced element.
    /// </summary>
    @Test
    public void SetByPosition_Returns_old_Element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        Employee returnedData = list.set(employee2, 1);

        assertEquals(returnedData, employee1);
    }

    /// <summary>
    /// Ensure that Set(position) sets the element at the correct position.
    /// </summary>
    @Test
    public void SetByPosition_3_on_list_of_3_updates_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee3);

        assertEquals(list.getSize(), 3);
        assertEquals(list.get(list.getSize()), employee3);

        Employee returnedData = list.set(employee4, list.getSize());

        assertEquals(list.getSize(), 3);
        assertEquals(list.get(list.getSize()), employee4);
        assertEquals(returnedData, employee3);
    }

    /* MILESTONE 3*/
    /// <summary>
    /// Ensure that Get by element returns the element at the correct element.
    /// </summary>
    @Test
    public void GetByElement_returns_the_element_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addFirst(employee2);
        list.addFirst(employee1);

        assertEquals(list.get(employee1).compareTo(employee1), 0);
        assertEquals(list.get(employee2).compareTo(employee2), 0);
    }

    /// <summary>
    /// Make sure that Get(element) on an empty list results in an exception.
    /// </summary>
    @Test
    public void GetByElement_On_EmptyList_throw_exception_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.get(employee));
    }

    /// <summary>
    /// Ensure that calling Get(element) with element that is not in the list results in an exception.
    /// </summary>
    @Test
    public void GetByElement_no_match_found_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee missingEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);
        assertThrows(IllegalArgumentException.class, () -> list.get(missingEmployee));
    }

    /// <summary>
    /// Ensure that calling Get(element) with element that matches multiple list elements returns only one result.
    /// </summary>
    @Test
    public void GetByElement_Multiple_matches_found_returns_first_match_test()
    {
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee);
        list.addLast(employee2);
        list.addLast(employee);

        assertEquals(list.get(employee).compareTo(employee), 0);
    }

    /// <summary>
    /// Ensure that calling AddAfter(element) on an empty list will result in an exception.
    /// </summary>
    @Test
    public void AddAfterByElement_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(IllegalArgumentException.class, () -> list.addAfter(employee, employee));
    }

    /// <summary>
    /// Ensure that passing element that is not in the list to AddAfter(element) results in an exception.
    /// </summary>
    @Test
    public void AddAfterByElement_no_match_found_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);
        Employee nonListEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);
        assertThrows(IllegalArgumentException.class, () -> list.addAfter(addEmployee, nonListEmployee));
    }

    /// <summary>
    /// Ensure that passing null value to AddAfter(element, position) results in an exception.
    /// </summary>
    @Test
    public void AddAfterByElement_when_element_is_null_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NullPointerException.class, () -> list.addAfter(addEmployee, null));
    }

    /// <summary>
    /// Checking edge case; Ensure that passing the tail element as the element will append to the end of the list without error.
    /// </summary>
    @Test
    public void AddAfterByElement_Tail_updated_and_count_increases_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee2);
        list.addFirst(employee1);
        assertEquals(list.getSize(),2);

        list.addAfter(employee3, list.getLast()); // adds after 2

        assertEquals(list.getSize(),3);

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(middle.getElement().compareTo(employee2), 0);
        assertEquals(tail.getElement().compareTo(employee3), 0); // new tail is 3

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void AddAfterByElement_adds_appropriately_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee3);
        list.addFirst(employee1);
        list.addAfter(employee2, employee1); // between 1 & 3

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(head.getElement(), list.get(1));

        assertEquals(middle.getElement().compareTo(employee2), 0);
        assertEquals(middle.getElement(), list.get(2));

        assertEquals(tail.getElement().compareTo(employee3), 0);
        assertEquals(tail.getElement(), list.get(3));

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Ensure that passing a element that appears multiple times in the list to AddAfter(element, oldElement) element is inserted after first instance.
    /// </summary>
    @Test
    public void AddAfterByElement_multiple_match_found_adds_after_first_instance_Test()
    {
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee addEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);
        list.addFirst(employee2);
        list.addFirst(employee); // order will be: 1, 2, 1

        list.addAfter(addEmployee, employee); // order should be: 1, 3, 2, 1

        Node<Employee> head = list.getHead();
        Node<Employee> afterHead = head.getNext();
        Node<Employee> tail = list.getTail();
        Node<Employee> beforeTail = tail.getPrevious();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee), 0);
        assertEquals(head.getElement().compareTo(list.get(1)), 0);

        assertEquals(afterHead.getElement().compareTo(addEmployee), 0); // should be in spot 2!
        assertEquals(afterHead.getElement().compareTo(list.get(2)), 0);

        assertEquals(beforeTail.getElement().compareTo(employee2), 0);
        assertEquals(beforeTail.getElement().compareTo(list.get(3)), 0);

        assertEquals(tail.getElement().compareTo(employee), 0);
        assertEquals(tail.getElement().compareTo(list.get(4)), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(afterHead.getNext(), beforeTail);
        assertEquals(beforeTail.getPrevious(), afterHead);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Ensure that calling AddBefore(element) on an empty list will result in an exception.
    /// </summary>
    @Test
    public void AddBeforeByElement_on_EmptyList_throws_exception_test()
    {
        Employee employee = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        assertThrows(IllegalArgumentException.class, () -> list.addBefore(employee, employee));
    }

    /// <summary>
    /// Ensure that passing element that is not in the list to AddBefore(element) results in an exception.
    /// </summary>
    @Test
    public void AddBeforeByElement_no_match_found_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);
        Employee nonListEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.addBefore(addEmployee, nonListEmployee));
    }

    /// <summary>
    /// Ensure that passing null value to AddBefore(element, position) results in an exception.
    /// </summary>
    @Test
    public void AddBeforeByElement_when_element_is_null_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NullPointerException.class, () -> list.addBefore(addEmployee, null));
    }

    /// <summary>
    /// Checking edge case; Ensure that passing the tail element as the element will prepend to the beginning of the list without error.
    /// </summary>
    @Test
    public void AddBeforeByElement_Head_updated_and_count_increases_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee3);
        list.addFirst(employee2);
        assertEquals(list.getSize(),2);

        list.addBefore(employee1, list.getFirst()); // adds before 2
        // order should be: 1, 2, 3

        // size increases
        assertEquals(list.getSize(),3);

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0); // new head is 1
        assertEquals(middle.getElement().compareTo(employee2), 0);
        assertEquals(tail.getElement().compareTo(employee3), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Make sure element is inserted into proper position.
    /// </summary>
    @Test
    public void AddBeforeByElement_adds_appropriately_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee3);
        list.addFirst(employee1);
        list.addBefore(employee2, employee3); // between 1 & 3
        // order should be: 1, 2, 3

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(head.getElement(), list.get(1));

        assertEquals(middle.getElement().compareTo(employee2), 0);
        assertEquals(middle.getElement(), list.get(2));

        assertEquals(tail.getElement().compareTo(employee3), 0);
        assertEquals(tail.getElement(), list.get(3));

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Ensure that passing a element that appears multiple times in the list to AddBefore(element, oldElement) element is inserted before first instance.
    /// </summary>
    @Test
    public void AddBeforeByElement_multiple_match_found_adds_before_first_instance_test()
    {
        Employee employee = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee addEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);
        list.addFirst(employee2);
        list.addFirst(employee); // order will be: 1, 2, 1

        list.addBefore(addEmployee, employee); // order should be: 3, 1, 2, 1

        Node<Employee> head = list.getHead();
        Node<Employee> afterHead = head.getNext();
        Node<Employee> tail = list.getTail();
        Node<Employee> beforeTail = tail.getPrevious();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(addEmployee), 0); // newly added to spot 1
        assertEquals(head.getElement(), list.get(1));

        assertEquals(afterHead.getElement().compareTo(employee), 0);
        assertEquals(afterHead.getElement(), list.get(2));

        assertEquals(beforeTail.getElement().compareTo(employee2), 0);
        assertEquals(beforeTail.getElement(), list.get(3));

        assertEquals(tail.getElement().compareTo(employee), 0);
        assertEquals(tail.getElement(), list.get(4));

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(afterHead.getNext(), beforeTail);
        assertEquals(beforeTail.getPrevious(), afterHead);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Test that Insert() can insert into an empty list and update the head/tail
    /// </summary>
    @Test
    public void Insert_EmptyList_increases_size_updates_head_and_tail_Test()
    {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList();

        assertEquals(list.getSize(), 0);

        list.insert(employee1);

        // size increases
        assertEquals(list.getSize(),1);

        assertEquals(list.getFirst().compareTo(employee1), 0);
        assertEquals(list.getLast().compareTo(employee1), 0);

        // check that end pointers are still null
        assertNull(list.getHead().getPrevious());
        assertNull(list.getTail().getNext());
    }

    /// <summary>
    /// Test that Insert() adds an element to the list in ascending order spot
    /// </summary>
    @Test
    public void Insert_Adds_inbetween_head_and_tail_when_value_between_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee3);
        list.addFirst(employee1);

        list.insert(employee2); // order should be: 1, 2, 3

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(middle.getElement().compareTo(employee2), 0); // newly added value
        assertEquals(tail.getElement().compareTo(employee3), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Edge case; check that Insert() will insert into the head position without error.
    /// </summary>
    @Test
    public void Insert_at_Head_Position_when_smallest_list_value_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee3);
        list.addFirst(employee2);

        list.insert(employee1);  // order should be: 1, 2, 3

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0); // newly added value
        assertEquals(middle.getElement().compareTo(employee2), 0);
        assertEquals(tail.getElement().compareTo(employee3), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Edge case; check that Insert() will insert into the tail position without error.
    /// </summary>
    @Test
    public void InsertTailPositionTest()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee2);
        list.addFirst(employee1);

        list.insert(employee3);  // order should be: 1, 2, 3

        Node<Employee> head = list.getHead();
        Node<Employee> middle = head.getNext();
        Node<Employee> tail = list.getTail();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(middle.getElement().compareTo(employee2), 0);
        assertEquals(tail.getElement().compareTo(employee3), 0); // newly added value

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), middle);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Test that Insert() can handle inserting when duplicates exist in the list already.
    /// </summary>
    @Test
    public void Insert_duplicate_values_in_list_still_maintain_order_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee addEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee2);
        list.addFirst(employee1);
        list.addFirst(employee1); // duplicate 1's in front, order will be: 1, 1, 2

        list.insert(addEmployee); // order should be: 1, 1, 2, 3

        Node<Employee> head = list.getHead();
        Node<Employee> afterHead = head.getNext();
        Node<Employee> tail = list.getTail();
        Node<Employee> beforeTail = tail.getPrevious();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(head.getElement(), list.get(1));

        assertEquals(afterHead.getElement().compareTo(employee1), 0);
        assertEquals(afterHead.getElement(), list.get(2));

        assertEquals(beforeTail.getElement().compareTo(employee2), 0);
        assertEquals(beforeTail.getElement(), list.get(3));

        assertEquals(tail.getElement().compareTo(addEmployee), 0); // newly added value
        assertEquals(tail.getElement(), list.get(4));

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(afterHead.getNext(), beforeTail);
        assertEquals(beforeTail.getPrevious(), afterHead);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Test that Insert() can handle inserting when value to add exists in the list already.
    /// </summary>
    @Test
    public void Insert_new_value_exists_in_list_adds_in_order_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        Employee addEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee3);
        list.addFirst(employee2);
        list.addFirst(employee1); // order will be: 1, 2, 3

        list.insert(addEmployee); // order should be: 1, 2, 2, 3

        Node<Employee> head = list.getHead();
        Node<Employee> afterHead = head.getNext();
        Node<Employee> tail = list.getTail();
        Node<Employee> beforeTail = tail.getPrevious();

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(head.getElement(), list.get(1));

        assertEquals(afterHead.getElement().compareTo(addEmployee), 0); // newly added value
        assertEquals(afterHead.getElement(), list.get(2));

        assertEquals(beforeTail.getElement().compareTo(employee2), 0);
        assertEquals(beforeTail.getElement(), list.get(3));

        assertEquals(tail.getElement().compareTo(employee3), 0);
        assertEquals(tail.getElement(), list.get(4));

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(afterHead.getNext(), beforeTail);
        assertEquals(beforeTail.getPrevious(), afterHead);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Make sure that calling Remove(element) on an empty list results in an exception.
    /// </summary>
    @Test
    public void RemoveByElement_On_EmptyList_throws_exception_Test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.remove(employee));
    }

    /// <summary>
    /// Ensure that calling Remove(element) with element that is not in the list results in an exception.
    /// </summary>
    @Test
    public void RemoveByElement_Not_In_List_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee missingEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.remove(missingEmployee));
    }

    /// <summary>
    /// Test Remove(element) on list of one, removes the first node, reduces size and adjusts head/tail.
    /// </summary>
    @Test
    public void RemoveByElement_on_list_of_1_decreases_size_sets_nulls_head_and_tail_Test()
    {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.remove(employee1);
        assertEquals(list.getSize(), 0);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /// <summary>
    /// Test Remove(element) returns the element removed.
    /// </summary>
    @Test
    public void RemoveByElement_Returns_Element_Test()
    {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        Employee returnedElement = list.remove(employee1);
        assertEquals(returnedElement.compareTo(employee1), 0);
    }

    /// <summary>
    /// Test Remove(element) properly updated the head when removing head element.
    /// </summary>
    @Test
    public void RemoveByElement_Head_removed_pointers_are_updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee3); // order is: 1, 2, 3

        Employee removedElement = list.remove(employee1); // list is now: 2, 3

        assertEquals(list.getSize(),2);

        Node<Employee> head = list.getHead();
        Node<Employee> tail = list.getTail();

        assertEquals(removedElement.compareTo(employee1), 0);

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee2), 0);
        assertEquals(tail.getElement().compareTo(employee3), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), head);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Test Remove(element) properly updated the node points when removing middle element.
    /// </summary>
    @Test
    public void RemoveByElement_middle_removed_pointers_are_updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee3); // order is: 1, 2, 3

        Employee removedElement = list.remove(employee2); // list is now: 1, 3

        assertEquals(list.getSize(),2);

        Node<Employee> head = list.getHead();
        Node<Employee> tail = list.getTail();

        assertEquals(removedElement.compareTo(employee2), 0);

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(tail.getElement().compareTo(employee3), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), head);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Test Remove(element) properly updated the tail when removing last element.
    /// </summary>
    @Test
    public void RemoveByElement_Tail_removed_pointers_are_updated_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee3); // order is: 1, 2, 3

        Employee removedElement = list.remove(employee3); // list is now: 1, 2

        assertEquals(list.getSize(),2);

        Node<Employee> head = list.getHead();
        Node<Employee> tail = list.getTail();

        assertEquals(removedElement.compareTo(employee3), 0);

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(tail.getElement().compareTo(employee2), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), head);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Ensure that calling Remove(element) with element that matches multiple list elements returns only one result.
    /// </summary>
    @Test
    public void RemoveByElement_multiple_matches_removes_first_match_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee elementToRemove = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();

        list.addLast(employee1);
        list.addLast(employee2);
        list.addLast(employee2); // order is: 1, 2, 2

        Employee removedElement = list.remove(elementToRemove); // list is now: 1, 2

        assertEquals(list.getSize(),2);

        Node<Employee> head = list.getHead();
        Node<Employee> tail = list.getTail();

        assertEquals(removedElement.compareTo(elementToRemove), 0);

        // check all values are correct after add
        assertEquals(head.getElement().compareTo(employee1), 0);
        assertEquals(tail.getElement().compareTo(employee2), 0);

        // check that end pointers are still null and that nodes point to each other
        assertNull(head.getPrevious());
        assertEquals(tail.getPrevious(), head);
        assertNull(tail.getNext());
    }

    /// <summary>
    /// Ensure that calling Set(element, oldElement) on an empty list will result in an exception.
    /// </summary>
    @Test
    public void SetByElement_on_EmptyList_throws_Exception_test()
    {
        Employee employee = new Employee(1);

        LinkedList<Employee> list = new LinkedList<Employee>();

        assertThrows(IllegalArgumentException.class, () -> list.set(employee, employee));
    }

    /// <summary>
    /// Ensure that passing element that is not in the list to Set(element, oldElement) results in an exception.
    /// </summary>
    @Test
    public void SetByElement_no_match_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee updatedEmployee = new Employee(2);
        Employee nonListEmployee = new Employee(3);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(IllegalArgumentException.class, () -> list.set(updatedEmployee, nonListEmployee));
    }

    /// <summary>
    /// Ensure that passing null value to Set(element, oldElement) results in an exception.
    /// </summary>
    @Test
    public void SetByElement_Null_element_throws_exception_Test()
    {
        Employee employee = new Employee(1);
        Employee updatedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee);

        assertThrows(NullPointerException.class, () -> list.set(updatedEmployee, null));
    }

    /// <summary>
    /// Test Set(element, oldElement) updates first element on list of one.
    /// </summary>
    @Test
    public void SetByElement_updates_element_pointers_should_not_change_Test()
    {
        Employee employee1 = new Employee(1);
        Employee updatedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        list.set(updatedEmployee, employee1);

        // size should not change.
        assertEquals(list.getSize(),1);

        // new value for head
        assertEquals(list.getFirst().compareTo(updatedEmployee), 0);

        // check tail and head have not been changed.
        assertNull(list.getHead().getPrevious());
        assertNull(list.getHead().getNext());
        assertEquals(list.getHead(), list.getTail());
    }

    /// <summary>
    /// Ensure that the Set(element, oldElement) method returns the old element that has been replaced.
    /// </summary>
    @Test
    public void SetByElement_returns_oldElement_test()
    {
        Employee employee1 = new Employee(1);
        Employee updatedEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);

        Employee returnedValue = list.set(updatedEmployee, employee1);

        // size should not change.
        assertEquals(list.getSize(),1);

        // new value for head
        assertEquals(returnedValue.compareTo(employee1), 0);
    }

    /// <summary>
    /// Ensure that passing a element that appears multiple times in the list to Set(element, oldElement) only first instance is replaced.
    /// </summary>
    @Test
    public void SetByElement_Multiple_Matching_changes_first_instance_only_Test()
    {
        Employee employee1 = new Employee(1);
        Employee employee3 = new Employee(3);
        Employee updateEmployee = new Employee(2);

        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addFirst(employee1);
        list.addLast(employee3);
        list.addLast(employee3);

        Employee oldElement = list.set(updateEmployee, employee3);

        assertEquals(list.getFirst().compareTo(employee1), 0);
        assertEquals(list.get(2).compareTo(updateEmployee), 0);
        assertEquals(list.getLast().compareTo(employee3), 0);
    }

    /// <summary>
    /// We run SortAscending() on an empty list, no exceptions should be thrown.
    /// </summary>
    @Test
    public void SortAscending_on_EmptyList_does_not_throw_exception_test()
    {
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.sortAscending();
        assertTrue(list.isEmpty());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /// <summary>
    /// We run SortAscending() on a list of 1, no changes should be made.
    /// </summary>
    @Test
    public void SortAscending_on_list_of_1_does_not_change_anything_test()
    {
        Employee employee1 = new Employee(1);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.insert(employee1);
        list.sortAscending();
        assertEquals(list.getSize(),1);
        assertEquals(list.getFirst(), employee1);
        assertNull(list.getHead().getNext());
        assertNull(list.getHead().getPrevious());
        assertEquals(list.getTail(), list.getHead());
    }

    /// <summary>
    /// We run SortAscending() on a sorted list of 2, no changes should be made.
    /// </summary>
    @Test
    public void SortAscending_on_sorted_list_of_2_does_not_change_anything_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.insert(employee1);
        list.insert(employee2);
        list.sortAscending();
        assertEquals(list.getSize(),2);
        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getLast(), employee2);
        assertEquals(list.getHead().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertEquals(list.getTail().getPrevious(), list.getHead());
        assertNull(list.getTail().getNext());
    }

    /// <summary>
    /// We run SortAscending() on a sorted list of 3, no changes should be made.
    /// </summary>
    @Test
    public void SortAscending_on_sorted_list_of_3_does_not_change_anything_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.insert(employee1);
        list.insert(employee2);
        list.insert(employee3);
        list.sortAscending();

        assertEquals(list.getSize(),3);
        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getHead().getNext().getElement(), employee2);
        assertEquals(list.getLast(), employee3);
        assertEquals(list.getHead().getNext(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertEquals(list.getTail().getPrevious(), list.getHead().getNext());
        assertNull(list.getTail().getNext());
    }

    /// <summary>
    /// We run SortAscending() on an unsorted list of 2, should sort the values
    /// </summary>
    @Test
    public void SortAscending_on_unsorted_list_of_2_sorts_ascending_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee1);
        list.addFirst(employee2);
        list.sortAscending();
        assertEquals(list.getSize(),2);
        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getLast(), employee2);
        assertEquals(list.getHead().getNext(), list.getTail());
        assertNull(list.getHead().getPrevious());
        assertEquals(list.getTail().getPrevious(), list.getHead());
        assertNull(list.getTail().getNext());
    }

    /// <summary>
    /// We run SortAscending() on an unsorted list of 3, should sort the values
    /// </summary>
    @Test
    public void SortAscending_on_Unsorted_list_of_3_sorts_ascending_test()
    {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee employee3 = new Employee(3);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee1);
        list.addFirst(employee2);
        list.addFirst(employee3);
        list.sortAscending();

        assertEquals(list.getSize(),3);
        assertEquals(list.getFirst(), employee1);
        assertEquals(list.getHead().getNext().getElement(), employee2);
        assertEquals(list.getLast(), employee3);
        assertEquals(list.getHead().getNext(), list.getTail().getPrevious());
        assertNull(list.getHead().getPrevious());
        assertEquals(list.getTail().getPrevious(), list.getHead().getNext());
        assertNull(list.getTail().getNext());
    }

    /// <summary>
    /// We run SortAscending() on a large unsorted list with duplicates, should sort the values
    /// </summary>
    @Test
    public void SortAscending_on_large_Unsorted_list_with_duplicates_sorts_ascending_test() {
        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(2);
        Employee duplicate2 = new Employee(2);
        Employee employee3 = new Employee(3);
        Employee employee4 = new Employee(4);
        Employee employee5 = new Employee(5);
        LinkedList<Employee> list = new LinkedList<Employee>();
        list.addLast(employee1);
        list.addFirst(employee2);
        list.addFirst(duplicate2); // duplicate
        list.addFirst(employee3);
        list.addLast(employee4);
        list.addFirst(employee5); // list is:5, 3, 2, 2, 1, 4
        list.sortAscending();

        assertEquals(list.getSize(),6);
        assertEquals(list.getFirst(), employee1);
        assertEquals(list.get(2).compareTo(duplicate2), 0);
        assertEquals(list.get(3).compareTo(employee2), 0);
        assertEquals(list.get(4), employee3);
        assertEquals(list.get(5), employee4);
        assertEquals(list.getLast(), employee5);

        assertEquals(list.getHead().getNext().getElement().compareTo(duplicate2), 0);
        assertNull(list.getHead().getPrevious());
        assertEquals(list.getTail().getPrevious().getElement(), employee4);
        assertNull(list.getTail().getNext());
    }

}