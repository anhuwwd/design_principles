package com.example.proxy.myproxy.proxy;

import sun.reflect.CallerSensitive;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
    public static final String ln = "\r\n";

    @CallerSensitive
    public static Object newProxyInstance(MyClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h)
            throws IllegalArgumentException {
        try {
            //1.动态生成源码 。java文件
            String src = generateSrc(interfaces);
            System.out.println(src);
            //2.输出java文件保存到磁盘，保存为$proxy.java
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(filePath);
            fw.write(src);
            fw.flush();
            fw.close();
            //3.编译java文件

            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, manager, null, null, null, iterable);

            task.call();
            manager.close();

            //4.加载到jvm
            Class proxyClass=loader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            //返回新的代理对象
            return constructor.newInstance(h);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.example.proxy.myproxy.proxy;" + ln);
        sb.append("import com.example.proxy.myproxy.IPerson;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public final class $Proxy0 implements" + interfaces[0].getName() + "{" + ln);
        sb.append("MyInvocationHandler h;" + ln);
        sb.append("public $Proxy0( MyInvocationHandler h){" + ln);
        sb.append("this.h=h;" + ln);
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuilder paramsNames = new StringBuilder();
            StringBuilder paramsValues = new StringBuilder();
            StringBuilder paramsTypes = new StringBuilder();

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + " (){" + ln);
            sb.append("try{" +
                    "Method m1= " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{});" +
                    "this.h.invoke(this)" +
                    "}catch(Exception e){" +
                    " throw e" +
                    "}");
            sb.append("}");
        }
return sb.toString();
    }
}
