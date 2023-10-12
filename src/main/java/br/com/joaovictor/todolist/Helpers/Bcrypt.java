package br.com.joaovictor.todolist.Helpers;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Bcrypt {
    public static String brycptPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
}
