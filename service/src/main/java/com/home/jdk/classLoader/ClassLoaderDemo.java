package com.home.jdk.classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.TimeUnit;

/**
 * Created by li.ma on 2018/8/3.
 */
public class ClassLoaderDemo {

    private static String name = "xiaoming";

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyThread thread = new MyThread();
        thread.setContextClassLoader(new MyClassLoader(ClassLoader.getSystemClassLoader().getParent()));  // 线程设置单独的类加载器
        thread.start();


        MyThread thread1 = new MyThread();
        thread1.setContextClassLoader(new MyClassLoader(ClassLoader.getSystemClassLoader().getParent()));  // 线程设置单独的类加载器
        thread1.start();


        TimeUnit.SECONDS.sleep(1);

       // thread.getAge().equals(thread1.getAge());



        MyClassLoader mcl = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());  // TestMyClassLoader类的第5行这么写"MyClassLoader mcl = new MyClassLoader(ClassLoader.getSystemClassLoader().getParent());"，
                                        // 即把自定义ClassLoader的父加载器设置为Extension ClassLoader，这样父加载器加载不到Person.class，就交由子加载器MyClassLoader来加载了
        Class<?> c1 = Class.forName("com.home.jdk.classLoader.Person", true, mcl);
        Object obj = c1.newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());
    }
}


class MyThread extends Thread {

    @Override
    public void run() {
        Class<?> c1;
        try {
            c1 = Class.forName("com.home.jdk.classLoader.Person");
            Person person = (Person)c1.newInstance();

            System.out.println(person.getClass().getClassLoader());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public Person getAge() {
        return null;
    }
}

class MyClassLoader extends ClassLoader {
    public MyClassLoader()
    {

    }

    public MyClassLoader(ClassLoader parent)
    {
        super(parent);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException
    {
        File file = getClassFile(name);
        try
        {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private File getClassFile(String name)
    {
        File file = new File("D:\\project\\new\\synseparation\\syn-separation\\service\\target\\classes\\com\\home\\jdk\\classLoader\\Person.class");
        return file;
    }

    private byte[] getClassBytes(File file) throws Exception
    {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true)
        {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }
}
