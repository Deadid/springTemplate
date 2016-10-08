package com.smakhov.springtemplate.rest;

import com.smakhov.springtemplate.model.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by SMakhov on 08.10.2016.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") User user) {
        return user;
    }
}
