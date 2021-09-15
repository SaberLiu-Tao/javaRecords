package lt;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = new MyClassLoader().findClass("Hello");
        Method hello =aClass.getMethod("hello");
        hello.invoke(aClass.newInstance());
    }

    @Override
    protected Class<?> findClass(String name)  {
        try {
            File file = new File("D:\\code\\bendicesshi\\src\\bendi\\liutao\\liutao01\\Hello.xlass");
            FileInputStream input = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            input.read(bytes);
            input.close();
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            Class<?> aClass = defineClass(name, bytes, 0, bytes.length);
            return aClass;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }


    }
}
