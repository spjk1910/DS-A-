package View;

import Controller.MapCotroller;
import Model.*;

import java.util.Scanner;

public class MapView
{
    MapCotroller controller;
    Scanner sc;

    // Constructor
    public MapView(MapCotroller controller)
    {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    // Method to display main menu
    public void displayMenu()
    {
        System.out.println("\n========================================");
        System.out.println("Welcome, user!");
        System.out.println("~~~ Searching For Point Of Interest (POI) ~~~");
        System.out.println("1: Add a new place to the map");
        System.out.println("2: Remove a place from the map");
        System.out.println("3: Search for a list of places");
        System.out.println("4: Edit a specific place");
        System.out.println("0: Exit");
        System.out.println("========================================");
    }

    // Method to display service menu
    public void ServiceMenu()
    {
        System.out.println("========================================");
        System.out.println("Available services:");
        System.out.println("1. Restaurant");
        System.out.println("2. Hospital");
        System.out.println("3. Museum");
        System.out.println("4. Cafe");
        System.out.println("5. Park");
        System.out.println("6. Library");
        System.out.println("7. Theater");
        System.out.println("8. Hospital");
        System.out.println("9. Pharmacy");
        System.out.println("10. Supermarket");
        System.out.println("Type the name of service you want to search on the terminal");
        System.out.println("Enter 0: Exit");
        System.out.println("========================================");
    }

    // Method to take suitable information from user and add a new place to the map
    public void addPlace(AVL<POI> poiTree)
    {
        System.out.println("Adding a new place to the map...");

        System.out.print("Enter the x-coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate: ");
        double y = sc.nextDouble();
        sc.nextLine();

        ServiceMenu();
        System.out.print("Enter the number of services: ");
        int num = sc.nextInt();
        sc.nextLine();

        Model.ArrayList<String> services = new ArrayList<>();
        for (int i = 0 ; i < num ; i++)
        {
            System.out.print("Enter the service: ");
            String service = sc.nextLine();
            services.insert(service);
        }

        POI poi = new POI(x, y, services);
        controller.addPlace(poiTree,poi);
    }

    // Method to take suitable information from user and remove a place to the map
    public void removePlace(AVL<POI> poiTree)
    {
        System.out.println("Removing a place from the map...");

        System.out.print("Enter the x-coordinate of place: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate of place: ");
        double y = sc.nextDouble();
        sc.nextLine();

        POI poi = new POI(x, y, null);
        controller.removePlace(poiTree,poi);
    }

    // Method to take suitable information from user and search for a list of places in a map (maximum 50 places)
    public void searchPlace(AVL<POI> poiTree)
    {
        System.out.println("Searching for a list of places...");

        System.out.print("Enter the x-coordinate of the top left corner: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate of the top left corner: ");
        double y = sc.nextDouble();
        System.out.print("Enter the width of the bounding rectangle: ");
        double width = sc.nextDouble();
        System.out.print("Enter the height of the bounding rectangle: ");
        double height = sc.nextDouble();
        sc.nextLine();
        ServiceMenu();
        System.out.print("Enter the type of service: ");
        String service = sc.nextLine();

        boundingRectangle rectangle = new boundingRectangle(x, y, width, height);

        controller.searchPlace(poiTree,service, rectangle);

    }

    // Method to take suitable information from user and edit a specific place (only edit services - not x and y coordinates)
    public void editPlace(AVL<POI> poiTree)
    {
        System.out.println("Editing a specific place...");

        System.out.print("Enter the x-coordinate of place: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate of place: ");
        double y = sc.nextDouble();
        sc.nextLine();

        POI poi = controller.searchPlace(poiTree,x,y);

        System.out.println("Services of the place:" + poi.toString());

        System.out.println("Enter 1 if you want to insert services into place");
        System.out.println("Enter 2 if you want to delete services into place");
        System.out.print("Your choice:");
        int choice = sc.nextInt();

        if (choice == 1)

        {  ServiceMenu();
            System.out.print("Enter how many services you want to insert: ");
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++)
            {
                System.out.print("Enter the Type of service: ");
                String service = sc.nextLine();
                poi.getServices().insert(service);
            }

        }
        else if (choice == 2)
        {   ServiceMenu();
            System.out.print("Enter how many services you want to delete: ");
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++)
            {
                System.out.print("Enter the Type of service: ");
                String service = sc.nextLine();
                poi.getServices().remove(service);
            }

        }
        System.out.println("The POI after editing is: " + poi.toString());
    }

}
