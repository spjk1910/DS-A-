package Utils;

import Model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class saveData
{
    // Method to save data from AVL tree into a file
    public void saveData(AVL <POI> poiTree, String filename)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
        {
            // Start saving data from the root of the AVL tree
            saveNodeData(poiTree.getRoot(), writer);
        } catch (IOException e)
        {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // Helper method to recursively save node data
    private void saveNodeData(BinaryTreeNode<POI> node, BufferedWriter writer) throws IOException
    {
        if (node != null)
        {
            // Save left subtree data
            saveNodeData(node.left, writer);
            // Save data of the current node
            POI poi = node.data;
            double x = poi.getX();
            double y = poi.getY();
            // Convert services list to a string
            String servicesString = servicesToString(poi.getServices());
            // Format the data and write to the file
            String data = String.format("%.2f|%.2f|%s", x, y, servicesString);
            writer.write(data);
            writer.newLine();
            // Save right subtree data
            saveNodeData(node.right, writer);
        }
    }

    // Method to convert ArrayList of services to string
    private String servicesToString(Model.ArrayList<String> services)
    {
        StringBuilder servicesString = new StringBuilder();
        for (int i = 0; i < services.size(); i++)
        {
            servicesString.append(services.get(i));
            if (i < services.size() - 1) {
                servicesString.append(";");
            }
        }
        return servicesString.toString();
    }
}
