package org.rudty.dbconnection.service;

import org.rudty.dbconnection.entity1.Person1;
import org.rudty.dbconnection.entity2.Person2;
import org.rudty.dbconnection.repository1.Person1Repository;
import org.rudty.dbconnection.repository2.Person2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;


@Service
public class HelloService {
    @Autowired
    Person1Repository person1Repository;

    @Autowired
    Person2Repository person2Repository;

    // 1. http://localhost:8080/tran
    // 2. http://localhost:8080/h2-console/
    // 3. select * from person2
    @Transactional("transactionManager1And2")
    public void tran() {
        Person1 p1 = new Person1();
        p1.age = 1;
        p1.name = "a";
        person1Repository.saveAndFlush(p1);

        Person2 p2 = new Person2();
        p2.age = 1;
        p2.name = "p";
        person2Repository.saveAndFlush(p2);
        throw new RuntimeException("a");
    }
}
