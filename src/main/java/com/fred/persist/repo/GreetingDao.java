package com.fred.persist.repo;

import com.fred.persist.entity.Greeting;

/**
 * Created by Fred on 06/03/2017.
 */
public interface GreetingDao {

    Greeting getById(int id);
}
