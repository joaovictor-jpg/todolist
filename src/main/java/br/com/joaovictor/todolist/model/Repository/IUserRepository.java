package br.com.joaovictor.todolist.model.Repository;

import br.com.joaovictor.todolist.model.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUserName(String userName);

}
