package customerconsumer;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import customerpublisher.CustomerService;

import java.util.Scanner;

public class Activator implements BundleActivator {

    ServiceReference serviceReference;
    private Scanner scan;
    

    public void start(BundleContext context) throws Exception {
        System.out.println("Customer Consumer Start");
        
        serviceReference = context.getServiceReference(CustomerService.class.getName());
        @SuppressWarnings("unchecked")
		CustomerService customerService = (CustomerService) context.getService(serviceReference);

        scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n-------------- Choose an option from Customer Management --------------");
            System.out.println("1. Add a New Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. Update Customer Details");
            System.out.println("4. Remove Customer");
            System.out.println("5. Exit");

            System.out.print("Enter your choice:");
            int choice = scan.nextInt();
            scan.nextLine(); // Consume newline character
          
            
            
            
            switch (choice) {
                case 1:
                    customerService.AddNewCustomer();
                    break;
                case 2:
                    System.out.println("\nEnter the Customer ID to view details:");
                    String customerID = scan.nextLine();
                    customerService.ViewCustomerDetails(customerID);
                    break;

                case 3:
                    System.out.println("\nEnter the Customer ID to update details:");
                    String updateID = scan.nextLine();
                    customerService.updateCustomer(updateID);
                    break;
                case 4:
                    System.out.println("\nEnter the Customer ID to remove:");
                    String removeID = scan.nextLine();
                    customerService.RemoveCustomer(removeID);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Customer Consumer Stop");
        context.ungetService(serviceReference);
    }
}







