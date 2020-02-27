package singleton;

import register.ContainerSIngleton;

/**
 * @program: design_model
 * @description:
 * @author: wuweidong
 * @create: 2020-02-26 22:09
 **/
public class ContainerSingletonTest {
    public static void main(String[] args) {
        PojoTest pojoTest= (PojoTest) ContainerSIngleton.getInstance("singleton.PojoTest");
        PojoTest pojoTest2= (PojoTest) ContainerSIngleton.getInstance("singleton.PojoTest");
        System.out.println(pojoTest);
        System.out.println(pojoTest2);
    }
}
