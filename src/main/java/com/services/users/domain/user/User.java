package com.services.users.domain.user;

import com.services.users.domain.user.dto.ModifyUserDto;
import com.services.users.service.CountryValidation;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Column (unique = true)
    @Pattern(regexp = "\\w+\\s\\w+", message = "Must contain space separated first name and last name")
    private String name;
    @NotNull
    @Pattern(regexp = "^.{8,16}$", message = "nooooo")
    private String password;
    @Column (unique = true)
    @Email
    private String email;
    private String phone;
    @CountryValidation
    private String location;

    //private BufferedImage photo;

    private Boolean admin = false;
    @CreationTimestamp
    private ZonedDateTime creation;


    public void updateInfo(@Valid ModifyUserDto newInfo){
        this.name = newInfo.name();
        this.phone = newInfo.phone();
        this.location = newInfo.location();
    }

}
