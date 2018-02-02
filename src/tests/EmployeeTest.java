import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// <summary>
/// IMPORTANT NOTE: Uncomment all lines of code inside the function and ensure it works by building
///                 out the appropriate class and methods. You may also delete the failing assert line.
///                 DO NOT CHANGE THE TEST CODE!! EVER. :)
/// EmployeeTest - A class for testing the Employee class
/// Employee - A class for representing an employee with a first name, last name and EmployeeID.
///            Must be comparable with itself based on the EmployeeID
///
/// Assignment:     #1
/// Course:         ADEV-3001
/// Date Created:   Sept. 18, 2017
///
/// @author: Scott Wachal
/// @version 1.0
/// </summary>
public class EmployeeTest
{
    /**
     * Test the constructor that takes an EmployeeID number to make sure EmployeeID is set, and the other values are default.
     */
    @Test
    public void EmployeeId_Constructor_Test()
    {
        int employeeId = 32;
        Employee employee = new Employee(employeeId);

        assertNotNull(employee);
        assertEquals(employee.getEmployeeID(),employeeId);
        assertNull(employee.getFirstName());
        assertNull(employee.getLastName());
    }

    /**
     * Test the constructor that takes all parameters to ensure the values are being set correctly.
     * Because the properties are read-only, this test is implictly testing our getter methods as well.
     **/
    @Test
    public void FullEmployee_Constructor_Test()
    {
        int employeeId = 32;
        String firstName = "John";
        String lastName = "Smith";

        Employee employee = new Employee(employeeId, firstName, lastName);

        assertNotNull(employee);
        assertEquals(employee.getEmployeeID(), employeeId);
        assertEquals(employee.getFirstName(), firstName);
        assertEquals(employee.getLastName(), lastName);
    }

    /**
     * Test the CompareTo with an object that should preceed the second object.
     **/
    @Test
    public void CompareTo_First_is_Lower_Test()
    {
        Employee employee1 = new Employee(1, "First", "Employee");
        Employee employee2 = new Employee(2, "Second", "Employee");

        assertTrue(employee1.compareTo(employee2) < 0);
    }

    /**
     * Test the CompareTo with an object that should follow the second object.
     */
    @Test
    public void CompareTo_First_is_Higher_Test()
    {
        Employee employee1 = new Employee(2, "First", "Employee");
        Employee employee2 = new Employee(1, "Second", "Employee");

        assertTrue(employee1.compareTo(employee2) > 0);
    }

    /**
     * Test the CompareTo with two objects that are equal.
     */
    @Test
    public void CompareTo_Equal_Test()
    {
        Employee employee1 = new Employee(1, "First", "Employee");
        Employee employee2 = new Employee(1, "Second", "Employee");

        assertEquals(employee1.compareTo(employee2), 0);
    }

    /**
     * Test the ToString method with a FirstName and LastName set to ensure the returned String is as expected.
     */
    @Test
    public void ToString_Test()
    {
        int employeeId = 1;
        String firstName = "First";
        String lastName = "Employee";
        Employee employee = new Employee(employeeId, firstName, lastName);

        String expectedToString = employeeId + " " + firstName + " " + lastName;
        assertEquals(employee.toString(), expectedToString);
    }

    /**
     * Test the ToString method without a FirstName or LastName set, should display with the word null for the missing values
     */
    @Test
    public void ToString_with_no_names_shows_Nulls_Test()
    {
        int employeeId = 1;
        Employee employee = new Employee(employeeId);

        String expectedToString = employeeId + " null null";
        assertEquals(employee.toString(), expectedToString);
    }
}