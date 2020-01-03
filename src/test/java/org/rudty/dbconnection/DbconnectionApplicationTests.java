package org.rudty.dbconnection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.rudty.dbconnection.entity1.Person1;
import org.rudty.dbconnection.entity2.Person2;
import org.rudty.dbconnection.repository1.Person1Repository;
import org.rudty.dbconnection.repository2.Person2Repository;
import org.rudty.dbconnection.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class DbconnectionApplicationTests {

	@Autowired
	HelloService helloService;

	@Autowired
	Person1Repository person1Repository;

	@Autowired
	Person2Repository person2Repository;

	@Test
	void contextLoads() {
		try {
			helloService.tran();
		} catch (Exception ignore) {
		}

		List<Person1> l1 = person1Repository.findAll();
		List<Person2> l2 = person2Repository.findAll();
		System.out.println(l1.size());
		System.out.println(l1.size());
		Assertions.assertEquals(l1.size(), 0);
		Assertions.assertEquals(l2.size(), 0);
	}

	@Transactional("transactionManager1")
	@Test
	void insertPerson1() {
		Person1 p1 = new Person1();
		p1.setAge(3);
		p1.setName("aa");

		person1Repository.saveAndFlush(p1);
		List<Person1> l1 = person1Repository.findAll();

		Assertions.assertEquals(1, l1.size());

		Person1 firstElem = l1.get(0);

		Assertions.assertEquals(firstElem.getName(), "aa");
		Assertions.assertEquals(firstElem.getAge(), 3);

	}

	@Transactional("transactionManager2")
	@Test
	void insertPerson2() {
		Person2 p2 = new Person2();
		p2.setAge(3);
		p2.setName("aa");

		person2Repository.saveAndFlush(p2);
		List<Person2> l2 = person2Repository.findAll();

		Assertions.assertEquals(1, l2.size());

		Person2 firstElem = l2.get(0);

		Assertions.assertEquals(firstElem.getName(), "aa");
		Assertions.assertEquals(firstElem.getAge(), 3);

	}
}
