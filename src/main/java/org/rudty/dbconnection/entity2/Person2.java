package org.rudty.dbconnection.entity2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person2 {
    @Id
    public String name;
    public int age;
}
