import Controller.MapCotroller;
import Model.*;
import Utils.*;

import View.MapView;

public class Main
{
    public static void main(String[] args)
    {
        // Create instances of saveData and loadData classes - used for reading and writing data (only for running the application)
        saveData save = new saveData();
        loadData load = new loadData();

        // Create an instance of MapManager - used for managing the map (only for running the application)
        MapManager manage = new MapManager();

        // Create an instance of MapController with dependencies injected - used for controlling the map (only for running the application)
        MapCotroller cotroller = new MapCotroller(manage,null,save,load);

        // Create an instance of MapView with MapController - used for displaying function of the map (only for running the application)
        MapView view = new MapView(cotroller);

        // Set the view in the controller - used for displaying function of the map (only for running the application)
        cotroller.setView(view);

        // Run the application - used for running the application (for running the application)
        cotroller.application();
    }
}