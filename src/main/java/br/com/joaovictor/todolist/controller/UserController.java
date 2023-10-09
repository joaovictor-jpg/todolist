package br.com.joaovictor.todolist.controller;

import br.com.joaovictor.todolist.model.entities.UserModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/createUser")
    public void create(@RequestBody UserModel userModel) {
        UserModel user = new UserModel(userModel.getUserName(), userModel.getName(), userModel.getPassword());
        System.out.println(user);
    }

}
