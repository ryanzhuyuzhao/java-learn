package org.ryan.cglib;

import net.sf.cglib.core.Signature;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InterfaceMaker;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.objectweb.asm.Type;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.FileHandler;

/**
 * 测试Cglib
 *
 * Cglib动态代理
 * https://blog.csdn.net/ygy162/article/details/105909439
 */
public class CglibTest {
    public static void main(String[] args) throws ClassNotFoundException {
//        addPropertiesTest();
        addMethodTest();
    }

    /**
     *Cglib动态添加属性测试
     * @throws ClassNotFoundException
     */
    public static void addPropertiesTest() throws ClassNotFoundException {
        //设置类成员属性
        HashMap propertyMap = new HashMap();
        propertyMap.put("id",Class.forName("java.lang.Integer"));
        propertyMap.put("name",Class.forName("java.lang.String"));
        propertyMap.put("address",Class.forName("java.lang.String"));
        //生成动态Bean
        CglibBeanUtil beanUtil = new CglibBeanUtil(propertyMap);
        beanUtil.setValue("id",new Integer(12));
        beanUtil.setValue("name","张三");
        beanUtil.setValue("address","深圳市车公庙");
        //从Bean中获取值，当然了获得的值得类型是Object
        System.out.println("id: " + beanUtil.getValue("id"));
        System.out.println("name: " + beanUtil.getValue("name"));
        System.out.println("address: " + beanUtil.getValue("address"));
        //获得创建的bean的实体
        Object object = beanUtil.getObject();
        //通过反射查看所有的方法名和属性
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * Cglib动态添加方法
     */
    public static void addMethodTest() {
        // 定义一个参数是字符串类型的setCreatedAt方法
        InterfaceMaker im = new InterfaceMaker();
        im.add(new Signature("setCreatedAt", Type.VOID_TYPE,
                new Type[] { Type.getType(String.class) }), null);

        Class myInterface = im.create();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ExampleBean.class);
        enhancer.setInterfaces(new Class[] { myInterface });
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object obj, Method method, Object[] args,
                                    MethodProxy proxy) throws Throwable {

                ExampleBean bean = (ExampleBean) obj;

                // 调用字符串类型的setCreatedAt方法时，转换成Date型后调用Setter
                if (method.getName().startsWith("setCreatedAt")
                        && args[0] != null && args[0] instanceof String) {

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date date = null;
                    try {
                        date = sdf.parse((String) args[0]);
                    } catch (final Exception e) { /* nop */ }
                    bean.setCreatedAt(date);
                    return null;

                }
                return proxy.invokeSuper(obj, args);
            }
        });

        // 生成一个Bean
        ExampleBean bean = (ExampleBean) enhancer.create();
        bean.setId(999);

        try {
            Method method = bean.getClass().getMethod("setCreatedAt", new Class[] {String.class});
            method.invoke(bean, new Object[]{"20100531"});
        } catch (final Exception e) {
            e.printStackTrace();
        }

        System.out.printf("id : [%d] createdAt : [%s]\n", bean.getId(), bean.getCreatedAt());
    }




}
