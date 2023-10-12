package br.com.joaovictor.todolist.model.Repository;

import br.com.joaovictor.todolist.model.entities.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ITaskRepository extends JpaRepository<TaskModel, UUID> {
}
