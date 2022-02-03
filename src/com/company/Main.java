package com.company;

public class Main {

    public static void main(String[] args) {
	    String str = "animals";
        System.out.println(str.length());  //7
        System.out.println(str.charAt(0)); //a
        System.out.println(str.charAt(6)); //s
    //  System.out.println(str.charAt(7)); // exception - выходим за пределы массива символов animals
        System.out.println(str.indexOf("a")); //0
        System.out.println(str.replace ('a','A')); // Найти и заменить

    }
}
