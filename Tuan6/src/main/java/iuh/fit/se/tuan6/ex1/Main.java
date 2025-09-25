package iuh.fit.se.tuan6.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context;

    public static void main(String[] args) {
        context =  new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = context.getBean("student1", Student.class);
        System.out.println("\n");
        System.out.println(student1);

        Student student2 = context.getBean("student2", Student.class);
        System.out.println("\n");

        Student student3 = context.getBean("student3", Student.class);
        System.out.println(student3);

//        Clazz class2 = context.getBean("class2", Clazz.class);
//        System.out.println(class2);
    }
}
