/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testinvoke;

/**
 *
 * @author asus
 */
public class User {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("called method setName value = " + name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("called method setAge value = " + age);
        this.age = age;
    }

    public String introduction(String name, int age) {
        return "My name is " + name + ". I'm " + age + " years old.";
    }

}
