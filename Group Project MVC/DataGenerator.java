import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataGenerator {
    private static final int MAX_DATA_POINTS = 100;
    private static final int MAX_COORDINATE = 1000000;
    private static final String[] SERVICES = {"Restaurant", "Hotel", "Museum", "Cafe", "Park", "Library", "Theater", "Hospital", "Pharmacy", "Supermarket"};

    public static void main(String[] args) {
        HashSet<String> dataSet = new HashSet<>();
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"))) {
            while (dataSet.size() < MAX_DATA_POINTS) {
                double x = random.nextDouble() * MAX_COORDINATE;
                double y = random.nextDouble() * MAX_COORDINATE;

        

                Set<String> uniqueServices = new HashSet<>();
                int numServices = random.nextInt(10) + 1; // Generate between 1 and 10 services
                while (uniqueServices.size() < numServices) {
                    uniqueServices.add(SERVICES[random.nextInt(SERVICES.length)]);
                }
                String services = String.join(";", uniqueServices);

                String data = String.format("%s|%s|%s", x, y, services);

                if (dataSet.add(data)) {
                    writer.write(data);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
