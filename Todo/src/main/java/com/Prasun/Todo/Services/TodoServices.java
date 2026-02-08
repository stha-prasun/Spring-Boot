package com.Prasun.Todo.Services;

import com.Prasun.Todo.Dto.TodoDto;
import com.Prasun.Todo.Entity.Todo;
import com.Prasun.Todo.Repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServices {
    public final TodoRepository todoRepository;

    public TodoServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //Convert Entity to Dto
    private TodoDto mapToDto(Todo todo){
        return new TodoDto(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted());
    }

    //Convert Dto to Entity
    private Todo mapToEntity(TodoDto todoDto){
        return new Todo(todoDto.getId(), todoDto.getTitle(), todoDto.getDescription(), todoDto.isCompleted());
    }

    // Create a todo
    public TodoDto createTodo(TodoDto todoDto){
        Todo todo = mapToEntity(todoDto);
        Todo saved = todoRepository.save(todo);
        return mapToDto(saved);
    }

    // Get all todos
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Get todo by ID
    public TodoDto getTodoById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        return mapToDto(todo);
    }
    // Update todo
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        Todo updated = todoRepository.save(todo);
        return mapToDto(updated);
    }

    // Delete todo
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
