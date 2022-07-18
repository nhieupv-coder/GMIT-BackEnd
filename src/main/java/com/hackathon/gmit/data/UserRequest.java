/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    @Email(message = "Email not match")
    @NotBlank
    String email;

    @Size(min = 6)
    @NotBlank
    String password;

    @JsonProperty("full_name")
    @NotBlank
    @Size(max = 100)
    String fullName;

    @Size(max = 100)
    String avatar;

    @NotBlank
    @Size(max = 300)
    String address;
}
