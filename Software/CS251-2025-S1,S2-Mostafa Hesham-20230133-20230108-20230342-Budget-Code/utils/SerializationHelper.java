package utils;
import java.io.*;

/**
 * Utility class for handling serialization and deserialization of objects.
 */
public class SerializationHelper {
    private static final String DATA_DIR = "data";

    /**
     * Saves an object to a file using Java serialization.
     * @param obj The object to serialize
     * @param filename The name of the file to save to
     * @return true if successful, false otherwise
     */
    public static boolean saveObject(Object obj, String filename) {
        try {
            // Create data directory if it doesn't exist
            File directory = new File(DATA_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the object
            FileOutputStream fileOut = new FileOutputStream(DATA_DIR + File.separator + filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            System.err.println("Error saving object: " + e.getMessage());
            return false;
        }
    }

    /**
     * Loads an object from a file using Java serialization.
     * @param filename The name of the file to load from
     * @return The loaded object, or null if loading failed
     */
    public static Object loadObject(String filename) {
        try {
            File file = new File(DATA_DIR + File.separator + filename);
            if (!file.exists()) {
                return null;
            }

            FileInputStream fileIn = new FileInputStream(file);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object obj = in.readObject();
            in.close();
            fileIn.close();
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading object: " + e.getMessage());
            return null;
        }
    }
} 