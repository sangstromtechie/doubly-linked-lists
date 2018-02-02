/**
 * Employee - A class for representing an employee with a first name, last name and EmployeeID.
 *            Must be comparable with itself based on the EmployeeID
 *
 * <pre>
 *
 * Assignment:     #1
 * Course:         ADEV-3001
 * Date Created:   January 11th 2018
 *
 * Revision Log
 * Who       When          Reason
 * --------- ------------- ---------------------------------
 *
 * </pre>
 *
 * @author Christian Wenham
 * @version 1.0
 *
 */
public class Employee implements Comparable<Employee>{

    private int employeeId;
    private String firstName, lastName;

    /**
     * Constructor, initializes only the employeeId, but sets the other fields to null.
     * @param employeeId
     */
    public Employee(int employeeId){
        this.employeeId = employeeId;
    }

    /**
     * Constructor, initializes private fields using parameter values.
     * @param employeeId
     * @param firstName
     * @param lastName
     */
    public Employee(int employeeId, String firstName, String lastName){
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return Returns the employeeID.
     */
    public int getEmployeeID() {
        return employeeId;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Compares employees with one another based on their EmployeeID.
     */
    public int compareTo(Employee o){
        return Integer.compare(this.employeeId, o.employeeId);
    }

    /**
     * @return Prints: employeeId firstName lastName
     */
    public String toString(){
        return employeeId + " " + firstName + " " + lastName;
    }
}
