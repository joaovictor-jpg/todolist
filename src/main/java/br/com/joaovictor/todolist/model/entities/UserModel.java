package br.com.joaovictor.todolist.model.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String name;
    private String password;
    private UserModel() {}
}
