package br.com.joaovictor.todolist.controller;

import br.com.joaovictor.todolist.model.Repository.ITaskRepository;
import br.com.joaovictor.todolist.model.entities.TaskModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/Tasks")
public class TaskController {

    @Autowired
    ITaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity createTask(@RequestBody TaskModel taskModel, HttpServletRequest request) {

        LocalDateTime ldm = LocalDateTime.now();

        if(ldm.isAfter(taskModel.getStartAt()) || ldm.isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início / data de término deve ser maior do que a data atual");
        }
        if(taskModel.getStartAt().isAfter(taskModel.getEndAt())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser menor que data final");
        }

        taskModel.setUserId((UUID) request.getAttribute("idUser"));
        return ResponseEntity.ok().body(this.taskRepository.save(taskModel));
    }

}
