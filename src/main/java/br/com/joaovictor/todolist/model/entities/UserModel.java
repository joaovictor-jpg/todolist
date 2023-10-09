package br.com.joaovictor.todolist.model.entities;

import java.io.Serializable;
import java.util.Objects;

public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String name;
    private String password;

    private UserModel() {}

    public UserModel(String userName, String name, String password) {
        this.userName = userName;
        this.name = name;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return userName.equals(userModel.userName) && name.equals(userModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, name);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
