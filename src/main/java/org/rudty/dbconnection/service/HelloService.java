package org.rudty.dbconnection.service;

import org.rudty.dbconnection.entity1.Person1;
import org.rudty.dbconnection.entity2.Person2;
import org.rudty.dbconnection.model1.Person1Repository;
import org.rudty.dbconnection.model2.Person2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HelloService {
    @Autowired
    Person1Repository person1Repository;

    @Autowired
    Person2Repository person2Repository;

    // 1. http://localhost:8080/tran
    // 2. http://localhost:8080/h2-console/
    // 3. select * from person2
    @Transactional
    public void tran() {
//        Person1 p1 = new Person1();
//        p1.age = 1;
//        p1.name = "a";
//        person1Repository.save(p1);

        Person2 p2 = new Person2();
        p2.age = 1;
        p2.name = "p";
        person2Repository.save(p2);
        person2Repository.flush();
//        throw new RuntimeException("a");
    }
}
