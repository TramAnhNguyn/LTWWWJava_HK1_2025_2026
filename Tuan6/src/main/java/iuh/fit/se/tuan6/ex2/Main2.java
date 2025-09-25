package iuh.fit.se.tuan6.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans2.xml");
        Address address1 = context.getBean("address1", Address.class);
        System.out.println(address1);
        System.out.println("\n");

        Person person1 = context.getBean("person1", Person.class);
        System.out.println(person1);
    }
}
