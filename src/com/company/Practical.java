package com.company;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class Practical {
    public static void main(String[] args) throws IllegalAccessException {
        // Анотации в действии
        // создали класс и вызвали данные из него
        Practical practical = new Practical();
        Person person = new Person();

        practical.print(person, person.getClass());
    }

    void print(Object o, Class c) throws IllegalAccessException {
        // создаём массив значений
        Field[] fields = c.getDeclaredFields();

        for (Field f: fields){ // перебираем

            // создаём массив анотаций найденых в нужном значении
            Annotation[] annotations = f.getDeclaredAnnotations();

            for (Annotation a: annotations){// перебираем

                // если совпала аннотация, выводим на экран
                if (a.annotationType().equals(Show.class)){
                    System.out.println(f.get(o));
                }

            }
        }
    }
}

// Создали аннотацию, которая запускается при запуске программы
@Retention(RetentionPolicy.RUNTIME)
@interface Show{
    boolean value() default true; // по умолчанию правда
}

class Person{
    @Show
    String name = "Tom"; //то есть для этой переменной мы сделали пометку
    int age = 28;
}