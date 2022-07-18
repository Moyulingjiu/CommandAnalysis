package com.moyulingjiu.scanner;

import com.moyulingjiu.exceptions.ScannerClassException;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author 墨羽翎玖
 */
public class JarScanner implements Scanner {

    @Override
    public Set<Class<?>> search(String classPath, String packagePath, Predicate<Class<?>> predicate) {
        Set<Class<?>> classes = new HashSet<>();

        try {
            //通过当前线程得到类加载器从而得到URL的枚举
            Enumeration<URL> urlEnumeration = Thread.currentThread().getContextClassLoader().getResources(packagePath.replace(".", "/"));
            while (urlEnumeration.hasMoreElements()) {
                URL url = urlEnumeration.nextElement();
                String protocol = url.getProtocol();
                if ("jar".equalsIgnoreCase(protocol)) {
                    JarURLConnection connection = (JarURLConnection) url.openConnection();
                    if (connection != null) {
                        JarFile jarFile = connection.getJarFile();
                        if (jarFile != null) {
                            //得到该jar文件下面的类实体
                            Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                            while (jarEntryEnumeration.hasMoreElements()) {
                                JarEntry entry = jarEntryEnumeration.nextElement();
                                String jarEntryName = entry.getName();
                                //这里我们需要过滤不是class文件和不在basePack包名下的类
                                if (jarEntryName.contains(".class") && jarEntryName.replaceAll("/", ".").startsWith(packagePath)) {
                                    String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
                                    Class<?> cls = Class.forName(className);
                                    if (predicate == null || predicate.test(cls)) {
                                        classes.add(cls);
                                    }
                                }
                            }
                        }
                    }
                } else if ("file".equalsIgnoreCase(protocol)) {
                    //从maven子项目中扫描
                    FileScanner fileScanner = new FileScanner();
                    classes.addAll(fileScanner.search(classPath, packagePath, predicate));
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            throw new ScannerClassException(e.getMessage());
        }
        return classes;
    }
}
