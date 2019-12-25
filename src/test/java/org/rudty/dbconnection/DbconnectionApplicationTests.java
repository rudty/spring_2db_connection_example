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

		Assertions.assertEquals(l1.size(), 0);
		Assertions.assertEquals(l2.size(), 0);
	}

}
