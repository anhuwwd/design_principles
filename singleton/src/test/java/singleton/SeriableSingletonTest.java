package singleton;

import seriable.SeriableSingleton;

import java.io.*;

/**
 * @program: design_model
 * @description:
 * @author: wuweidong
 * @create: 2020-02-26 22:19
 **/
public class SeriableSingletonTest {
    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();
        try {
            FileOutputStream os = new FileOutputStream("SeriableSingleton.obj");
            ObjectOutputStream obs = new ObjectOutputStream(os);
            obs.writeObject(s2);
            obs.flush();
            obs.close();

            FileInputStream in  =new FileInputStream("SeriableSingleton.obj");
            ObjectInputStream ibs = new ObjectInputStream(in);
            s1 = (SeriableSingleton) ibs.readObject();
            System.out.println(s2);
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
