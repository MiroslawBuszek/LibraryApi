package com.buszek.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    Long id;
    String name;
    String surname;
    String nick;
    String email;

    public void updateUser (User other) {

        if (other != null) {

            if (other.getName() != null) {
                name = other.getName();
            } else if (other.getSurname() != null) {
                surname = other.getSurname();
            } else if (other.getNick() != null) {
                nick = other.getNick();
            } else if (other.getEmail() != null) {
                email = other.getEmail();
            }
        }
    }
}
