package com.cafeconpalito.prueba1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Albano Díez de Paulino
 */
public class Prueba1 {

    public static void main(String[] args) {
        
        //FORMA 1
        /*ApplicationContext context1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        HolaMundo a1=(HolaMundo) context1.getBean("A1",HolaMundo.class);
        System.out.println(a1.holamundo());*/
        
        //FORMA 2
        ApplicationContext context2 = new ClassPathXmlApplicationContext("newSpringXMLConfig.xml");
        HolaMundo a2=(HolaMundo) context2.getBean(HolaMundo.class);
        System.out.println(a2.holamundo());
       
    }
}
