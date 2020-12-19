package blockchain;

import java.io.*;

public class SerializationUtils {

    /**
     * Serialize the given object to the file
     */
    public static void serialize(Object object, String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(object);
        oos.close();
    }

    /**
     * Deserialize to an object from the file
     */
    public static Object deserialize(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object object = ois.readObject();
        ois.close();
        return object;
    }
}