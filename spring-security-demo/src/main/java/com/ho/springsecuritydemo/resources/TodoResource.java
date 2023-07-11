package com.ho.springsecuritydemo.resources;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODO_LIST = List.of(new Todo("ho", "do Somethin"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODO_LIST;
}
    @GetMapping("/todos/{username}")
    public Todo retrieveTodosForSpecificuser(@PathVariable String username){
        return TODO_LIST.get(0);
    }
    @PostMapping("/todos/{username}")
    public void createTodosForSpecificuser(@PathVariable String username, @RequestBody  Todo todo){
        logger.info("Create {} for {}",todo,username);
    }
record Todo(String username,String description){
    }
}
