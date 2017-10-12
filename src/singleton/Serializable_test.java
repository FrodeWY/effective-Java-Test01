package singleton;

import java.io.*;

/**
 * Created by mac on 2017/10/9.
 */
public class Serializable_test {
    public static byte[] serialize(final Object obj){
        ObjectOutputStream outputStream=null;
        ByteArrayOutputStream arrayOutputStream=null;
        try {
            arrayOutputStream=new ByteArrayOutputStream();
            outputStream=new ObjectOutputStream(arrayOutputStream);
            outputStream.writeObject(obj);
            return arrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if(arrayOutputStream!=null){
                    arrayOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static Object unserialize(final byte[] bytes){
        ObjectInputStream objectInputStream=null;
        ByteArrayInputStream byteArrayInputStream=null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bytes);
            objectInputStream=new ObjectInputStream(byteArrayInputStream);
            return objectInputStream.readObject();//ObjectInputStream的readObject()方法会检查被反序列化的类中是否有readResolve()方法

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(byteArrayInputStream!=null)byteArrayInputStream.close();
                if (objectInputStream!=null)objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
