import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

import Model.*;

public class Main
{
    AVL <POI> poiTree = new AVL<>();
    public void addPlace()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("Adding a new place to the map...");

        System.out.print("Enter the x-coordinate: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate: ");
        double y = sc.nextDouble();

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
        poiTree.add(poi);
    }

    public void removePlace()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("Removing a place from the map...");

        System.out.print("Enter the x-coordinate of place: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate of place: ");
        double y = sc.nextDouble();

        POI poi = new POI(x, y, null);
        poiTree.remove(poi);
    }

    public void searchPlace()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();

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
        System.out.print("Enter the type of service: ");
        String service = sc.nextLine();

        boundingRectangle rectangle = new boundingRectangle(x, y, width, height);

        poiTree.search(service, rectangle);

    }

    public void editPlace()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();

        System.out.println("Editing a specific place...");

        System.out.print("Enter the x-coordinate of place: ");
        double x = sc.nextDouble();
        System.out.print("Enter the y-coordinate of place: ");
        double y = sc.nextDouble();

        POI poi = poiTree.search(x,y);

        System.out.println("Services of the place:" + poi.toString());

        System.out.println("Enter 1 if you want to insert services into place");
        System.out.println("Enter 2 if you want to delete services into place");
        System.out.print("Your choice:");
        int choice = sc.nextInt();

        if (choice == 1)
        {
            System.out.print("Enter the number of services you want to insert: ");
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++)
            {
                System.out.print("Enter the service: ");
                String service = sc.nextLine();
                poi.getServices().insert(service);
            }

        }
        else if (choice == 2)
        {
            System.out.print("Enter the number of services you want to delete: ");
            int num = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < num; i++)
            {
                System.out.print("Enter the service: ");
                String service = sc.nextLine();
                poi.getServices().remove(service);
            }

        }
        System.out.println("The POI after editing is: " + poi.toString());
    }
    public void Menu()
    {
        System.out.println("Welcome, user!");
        System.out.println("~~~ Searching For Point Of Interest (POI) ~~~");
        System.out.println("Enter 1: Add a new place to the map");
        System.out.println("Enter 2: Remove a place from the map");
        System.out.println("Enter 3: Search for a list of places");
        System.out.println("Enter 4: Edit a specific place");
        System.out.println("Enter 0: Exit");
    }

    public void loadData()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt")))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                ArrayList<String> services = new ArrayList<>();
                String[] servicesArray = parts[2].split(";");
                for (String service : servicesArray) {
                    services.insert(service);
                }
                POI poi = new POI(x, y, services);
                poiTree.add(poi);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println();

        Main manager = new Main();
        manager.loadData();
        int choice;

        do
        {
            Scanner sc = new Scanner(System.in);

            manager.Menu();

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice)
            {
                case 1:
                    manager.addPlace();
                    //manager.poiTree.inOrderDisplay();  -- This is for testing result
                    break;
                case 2:
                    manager.removePlace();
                    //manager.poiTree.inOrderDisplay(); -- This is for testing result
                    break;
                case 3:
                    manager.searchPlace();
                    break;
                case 4:
                    //manager.poiTree.inOrderDisplay(); -- This is for testing result
                    manager.editPlace();
                   // manager.poiTree.inOrderDisplay(); -- This is for testing result
                    break;
                case 0:

                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } while (choice != 0);
    }
}