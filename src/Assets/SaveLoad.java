package Assets;

import maincode.Story;

import java.io.*;
public class SaveLoad {

	Story str;
	
	public SaveLoad(Story str) {
		this.str = str;
	}
	public static boolean saveObject(String path, Object obj) {
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(path, false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(outputStream);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }

        return false;
    }
	public static Object loadObject(String path) {
        Object out = null;

        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return out;
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(inputStream);
            out = (Object) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return out;
            }
        }

        return out;
    }
}
