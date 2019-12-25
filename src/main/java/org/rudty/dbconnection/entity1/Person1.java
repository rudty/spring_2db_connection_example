package org.rudty.dbconnection.entity1;

import javax.persistence.Entity;
import javax.persistence.Id;

//test
@Entity
public class Person1 {
    @Id
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
