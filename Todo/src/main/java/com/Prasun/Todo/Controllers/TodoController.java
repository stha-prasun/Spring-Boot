package com.Prasun.Todo.Controllers;

import com.Prasun.Todo.Dto.TodoDto;
import com.Prasun.Todo.Services.TodoServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoServices todoServices;

    public TodoController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    // Get all todo
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return ResponseEntity.ok(todoServices.getAllTodos());
    }

    // Get todo by id
    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok((todoServices.getTodoById(id)));
    }

    // Create todo
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {
        return new ResponseEntity<>(todoServices.createTodo(todoDto), HttpStatus.CREATED);
    }

    // Update todo
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody
    TodoDto todoDto) {
        return ResponseEntity.ok(todoServices.updateTodo(id, todoDto));
    }

    // Delete todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoServices.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

}
