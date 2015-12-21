/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinvoke;

import java.lang.reflect.Method;

/**
 * 反射的使用方法
 *
 * @author asus
 */
public class TestInvoke {

    public static void main(String[] args) {
        Class<?> clazz;
        Object obj;
        try {
            TestInvoke it = new TestInvoke();
            clazz = Class.forName("testinvoke.User");
            obj = clazz.newInstance();

//            User u = (User) obj;
//            u.setAge(20);
//            u.setName("pigge");
//            String result = u.introduction("piggy", 20);

            Param p = new Param();
            p.setMethodName("introduction");
            p.setParamTypes(new Class<?>[]{String.class, int.class});
            p.setParamValuese(new Object[]{"Tom", 20});
            Object result = it.call(obj, p);
            System.out.println(result + "");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 反射方法调用
     *
     * @param declareCLass classInstatnce
     * @param param 参数设置类
     * @return
     * @throws Exception
     */
    public Object call(Object declareCLass, Param param) throws Exception {
        Class<?> clazz = declareCLass.getClass(); //获取class对象
        String name = param.getMethodName(); //从param类中获取调用方法名
        Class<?>[] methodParamTypes = param.getParamTypes(); //从param类中获取调用方法参数类型
        Object[] objs = param.getParamValuese(); //从param类中获取调用方法参数值
        Method method = clazz.getDeclaredMethod(name, methodParamTypes); //通过class对象获取对应的方法
        return method.invoke(declareCLass, objs);  //invoke调用方法，传入 classInstance、 参数值
    }

}

/**
 * 参数设置类
 *
 * @author Administrator
 *
 */
class Param {

    private String methodName;

    private Class<?>[] paramTypes;

    private Object[] paramValuese;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParamValuese() {
        return paramValuese;
    }

    public void setParamValuese(Object[] paramValuese) {
        this.paramValuese = paramValuese;
    }
}

//class User {
//
//   
//}
