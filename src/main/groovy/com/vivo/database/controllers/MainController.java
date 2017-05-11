package com.vivo.database.controllers;

import com.vivo.database.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by joaogomes on 10/05/17.
 */
@RestController
public class MainController {

    @Autowired
    DatabaseService dbService;

    @RequestMapping(value = "/usuario/email", method = RequestMethod.GET)
    public Map<String, Object> greeting(@RequestParam(name = "name", defaultValue = "John") String name) {
        return dbService.consultaPorEmail(name);
    }

}
