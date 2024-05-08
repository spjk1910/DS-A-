package Controller;

import Model.*;
import Utils.*;

import View.MapView;

import java.util.Scanner;

public class MapCotroller
{
    MapManager manage;
    MapView view;
    saveData save;
    loadData load;
    AVL <POI> poiTree;

    // Constructor
    public MapCotroller(MapManager manage,MapView view, saveData save, loadData load)
    {
        this.manage = manage;
        this.view = view;
        this.save = save;
        this.load = load;
        this.poiTree = new AVL<>();
    }

    // Setter for view - only for running application
    public void setView(MapView view)
    {
        this.view = view;
    }

    // Method to run application -- main method -- only for running application
    public void application()
    {
        int choice;

        load.load(poiTree,"data.txt");
        Scanner sc = new Scanner(System.in);

        // Loop the menu for user to continually interact with the application until they choose to exit
        do
        {
            view.displayMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    view.addPlace(poiTree);
                    break;
                case 2:
                    view.removePlace(poiTree);
                    break;
                case 3:
                    view.searchPlace(poiTree);
                    break;
                case 4:
                    view.editPlace(poiTree);
                    break;
                case 0:
                    save.saveData(poiTree,"data.txt"); // Save data before exiting
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        }

        // Method to add a place to the AVL tree
        public void addPlace(AVL<POI> poiTree,POI poi)
        {
            manage.addPlace(poiTree,poi);
            updatePoiTreeInManager();
        }

        // Method to remove a place from the AVL tree
        public void removePlace(AVL<POI> poiTree,POI poi)
        {
            manage.removePlace(poiTree,poi);
            updatePoiTreeInManager();
        }

        // Method to search for a list of place in the bounding rectangle in the AVL tree (maximum 50 places)
        public void searchPlace(AVL<POI> poiTree,String service, boundingRectangle rectangle)
        {
            manage.searchPlace(poiTree,service, rectangle);
            updatePoiTreeInManager();
        }

        // Method to search for a place in the AVL tree and edit the services of it
        public POI searchPlace(AVL<POI> poiTree,double x, double y)
        {
            POI tmp =  manage.searchPlace(poiTree,x, y);
            updatePoiTreeInManager();
            return tmp;
        }

        // Method to update the AVL tree after changing
        public void updatePoiTreeInManager()
        {
            manage.setPoiTree(this.poiTree);
        }
    }
