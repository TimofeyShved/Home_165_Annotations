package com.company;

import jdk.jfr.Name;

public class Main {

    public static void main(String[] args) {
	    // Анотации
    }
}

// сколько угодно можно указывать анотаций
@Name("MyClass")
@MyAnnotation(value = "s", i=5) // если по умолчанию только (value) то можно @MyAnnotation("s")
class MyClass{

    @Name("var")
    int i;

    // но иногда есть и ограничения, например сюда не вставить @Name
    @Deprecated
    MyClass(){

    }

    @Name("MyMethod")
    public int method(@Deprecated int i){
        @Deprecated
        int j;
        return this.i+i;
    }
}

// создавать свои анотации
@interface  MyAnnotation{
    boolean run() default true; // значение по умолчанию
    int i(); 
    String value();
}