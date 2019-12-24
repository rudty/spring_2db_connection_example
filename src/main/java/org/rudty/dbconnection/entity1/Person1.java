package org.rudty.dbconnection.entity1;

import javax.persistence.Entity;
import javax.persistence.Id;

//test
@Entity
public class Person1 {
    @Id
    public String name;
    public int age;
}
