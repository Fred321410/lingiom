package com.fred.web.controller;

import com.fred.persist.entity.Greeting;
import com.fred.persist.repo.GreetingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by Fred on 05/03/2017.
 */
@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingDao greetingDao;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        /*Greeting g = new Greeting();
        g.setId(counter.incrementAndGet());
        g.setContent(String.format(template, name));*/
        Greeting g = greetingDao.getById(0);
        System.out.println(g.getContent());
        return g;
    }

}
