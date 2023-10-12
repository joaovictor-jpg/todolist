package br.com.joaovictor.todolist.Helpers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.joaovictor.todolist.model.entities.UserModel;

public class Bcrypt {
    public static String brycptPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
    public static Boolean description(String password, UserModel user) {
        return BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified;
    }
}
