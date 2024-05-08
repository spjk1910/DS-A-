package Utils;

import Model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class loadData
{
    private String filePath;

    // Constructor
    public loadData()
    {
        this.filePath = "data.txt";
    }

    // Method to load data from a file into the AVL tree
    public void load(AVL<POI> poiTree, String file)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            // Read each line of the file
            while ((line = br.readLine()) != null)
            {
                // Split the line into parts using '|' as delimiter
                String[] parts = line.split("\\|");
                // Extract x and y coordinates from the first two parts
                double x = Double.parseDouble(parts[0].replace(",", "."));
                double y = Double.parseDouble(parts[1].replace(",", "."));
                // Extract services from the third part
                String[] servicesArray = parts[2].split(";");
                ArrayList<String> services = new ArrayList<>();
                // Add each service to the ArrayList
                for (String service : servicesArray)
                {
                    services.insert(service);
                }
                // Create a new POI object with extracted data
                POI poi = new POI(x, y, services);
                // Add the POI to the AVL tree
                poiTree.add(poi);
            }
        } catch (IOException e)  // Catch any exceptions
        {
            e.printStackTrace();
        }
    }
}