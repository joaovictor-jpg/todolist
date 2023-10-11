package br.com.joaovictor.todolist.model.Repository;

import br.com.joaovictor.todolist.model.entities.UserModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    List<UserModel> findByUserName(String userName);

}
