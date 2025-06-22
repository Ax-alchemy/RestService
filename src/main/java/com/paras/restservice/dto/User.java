package com.paras.restservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author parachau
 **/

@Getter
@Setter
public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String email;




    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
