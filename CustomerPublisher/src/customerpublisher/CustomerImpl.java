package customerpublisher;

import java.util.*;

public class CustomerImpl implements CustomerService {

    private Scanner scan;
    private List<CustomerModel> RegisteredCustomers;

    public CustomerImpl() {
        scan = new Scanner(System.in);
        RegisteredCustomers = new ArrayList<>();
    }
    

    @Override
    public void AddNewCustomer() {
        System.out.println("\n\n****************************************************************************");
        System.out.println("*********************<<<<<<<<<< Customer Signup >>>>>>>>>>>*****************");
        System.out.println("****************************************************************************");

        System.out.println("\n------- Register New Customer --------");
        System.out.print("Enter Customer's ID: ");
        String cID = scan.nextLine();
        System.out.print("Enter Customer's first name: ");
        String Fname = scan.nextLine();
        System.out.print("Enter Customer's last name: ");
        String Lname = scan.nextLine();
        System.out.print("Enter Customer's Email: ");
        String Email = scan.nextLine();
        System.out.print("Enter Customer's Contact number: ");
        String number = scan.nextLine();

        RegisteredCustomers.add(new CustomerModel(cID, Fname, Lname, Email, number));
        System.out.println("Customer with ID " + cID + " added successfully.");
    }

    @Override
    public void ViewCustomerDetails(String CustomerID) {
        System.out.println("\n------- Customer Details --------");

        for (CustomerModel customer : RegisteredCustomers) {
            if (customer.getCustomerID().equals(CustomerID)) {
                System.out.println("ID: " + customer.getCustomerID() + " | Name: " + customer.getFirstName() + " " + customer.getLastName() +
                        " | Email: " + customer.getEmail() + " | Contact: " + customer.getContactNumber());
                return;
            }
        }
        System.out.println("Customer with ID " + CustomerID + " not found.");
    }

//    @Override
//    public void ViewAllCustomers() {
//        System.out.println("\n------- All Registered Customers --------");
//        
//        if (RegisteredCustomers.isEmpty()) {
//            System.out.println("No customers registered yet.");
//            return;
//        }
//
//        for (CustomerModel customer : RegisteredCustomers) {
//            System.out.println("ID: " + customer.getCustomerID() + " | Name: " + customer.getFirstName() + " " + customer.getLastName() +
//                    " | Email: " + customer.getEmail() + " | Contact: " + customer.getContactNumber());
//        }
//    }

    @Override
    public void RemoveCustomer(String CustomerID) {
        Iterator<CustomerModel> iterator = RegisteredCustomers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCustomerID().equals(CustomerID)) {
                iterator.remove();
                System.out.println("Customer with ID " + CustomerID + " removed successfully.");
                return;
            }
        }
        System.out.println("Customer with ID " + CustomerID + " not found.");
    }

    @Override
    public void updateCustomer(String CustomerID) {
        for (CustomerModel customer : RegisteredCustomers) {
            if (customer.getCustomerID().equals(CustomerID)) {
                System.out.println("Enter new details for Customer ID: " + CustomerID);
                System.out.print("New First Name: ");
                customer.setFirstName(scan.nextLine());
                System.out.print("New Last Name: ");
                customer.setLastName(scan.nextLine());
                System.out.print("New Email: ");
                customer.setEmail(scan.nextLine());
                System.out.print("New Contact Number: ");
                customer.setContactNumber(scan.nextLine());

                System.out.println("Customer details updated successfully.");
                return;
            }
        }
        System.out.println("Customer with ID " + CustomerID + " not found.");
    }
}
