package org.perscholas.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
public class Student implements Serializable {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    @NotNull @NotBlank(message = "Enter something") @Size(min=3, max=25, message = "Should be between {1} and {2}")
    String studentUserName;

    @NotNull @NotBlank(message = "Enter something") @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$", message = "Invalid email address")
    String studentEmail;

    @NotNull @NotBlank(message = "Enter something")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",
            message = "- at least 8 characters\n" +
                    "- must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number\n" +
                    "- Can contain special characters")
    String studentPassword;

    @PostConstruct
    public void postConstruct(){
        log.warning("");
    }

}
