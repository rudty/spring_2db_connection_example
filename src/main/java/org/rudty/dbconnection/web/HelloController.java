package org.rudty.dbconnection.web;

import org.rudty.dbconnection.model1.Person1Repository;
import org.rudty.dbconnection.model2.Person2Repository;
import org.rudty.dbconnection.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person1Repository person1Repository;

    @Autowired
    Person2Repository person2Repository;

    @Autowired
    JdbcTemplate datasource3jdbctemplate;

    @RequestMapping("/")
    public String index() {
        person1Repository.findAll();
        person2Repository.findAll();
        datasource3jdbctemplate.execute("select 1");
        return "";
    }

    @Autowired
    HelloService helloService;

    @RequestMapping("/tran")
    public String tran() {
        helloService.tran();
        return "";
    }
}
