package br.com.joaovictor.todolist.controller;

import br.com.joaovictor.todolist.model.Repository.ITaskRepository;
import br.com.joaovictor.todolist.model.entities.TaskModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Tasks")
public class TaskController {

    @Autowired
    ITaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel createTask(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        taskModel.setId((UUID) request.getAttribute("idUser"));
        taskRepository.save(taskModel);
        return taskModel;
    }

}
