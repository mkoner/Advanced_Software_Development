package lab;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ComplexInvocationHandler implements InvocationHandler {
    private ComplexClass complexObject;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if(method.getName().equals("veryComplicatedTask")) {
                complexObject = new ComplexClass();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return method.invoke(complexObject, args);
    }
}
