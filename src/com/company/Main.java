package com.company;

import jdk.jfr.Name;

import java.lang.annotation.*;

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
@Inherited // то что он может быть наслодован
@Retention(RetentionPolicy.RUNTIME) // кагда аннотацию вступают в силу (во время запуска)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.TYPE}) // где применять
@interface  MyAnnotation{
    boolean run() default true; // значение по умолчанию
    int i();
    String value();
}

// аннотации об ошибках
@interface  BugReport{
    enum Status {UNCONFIRMED, CONFIRMED, FIXED, NOTABUG};
    boolean showStop() default  false;
    // он может быть int, short, byte, long, float

    String ast1() default "[none]";
    String ast2() default  "";
    // Так нельзя!
    //String ast3() default "[none]" + new String("");
    //String ast3() default null;

    int i() default 4; // константы
    Class<?> testCase() default Void.class; // специальный класс
    BugReport.Status status() default  BugReport.Status.UNCONFIRMED; // свои и другие аннотации
    String[] report(); // массив строк

    //Так нельзя! Другие объекты в том числе и простые классы
    //Object o;

}