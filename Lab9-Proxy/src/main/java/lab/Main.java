package lab;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ComplexInterface proxyInstance = (ComplexInterface) Proxy.newProxyInstance(
                ComplexClass.class.getClassLoader(),
                new Class[]{ComplexInterface.class},
                new ComplexInvocationHandler());
        proxyInstance.veryComplicatedTask();
    }
}