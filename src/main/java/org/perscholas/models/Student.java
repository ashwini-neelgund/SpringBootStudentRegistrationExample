package org.perscholas.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student implements Serializable {

    //fields
    @NotNull @NotBlank(message = "Enter something") @Size(min=3, max=25, message = "Should be between {1} and {2}")
    String sUserName;

    @NotNull @NotBlank(message = "Enter something") @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)+$", message = "Invalid email address")
    String sEmail;

    @NotNull @NotBlank(message = "Enter something")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",
            message = "- at least 8 characters\n" +
                    "- must contain at least 1 uppercase letter, 1 lowercase letter, and 1 number\n" +
                    "- Can contain special characters")
    String sPassword;

}
