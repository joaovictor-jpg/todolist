package br.com.joaovictor.todolist.controller;

import br.com.joaovictor.todolist.model.Repository.ITaskRepository;
import br.com.joaovictor.todolist.model.entities.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Tasks")
public class TaskController {

    @Autowired
    ITaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel createTask(@RequestBody TaskModel taskModel) {
        System.out.println("Depois do filter. Chegou na controller");
        taskRepository.save(taskModel);
        return taskModel;
    }

}
