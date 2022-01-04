package com.feirasoft.authservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Accessors(chain = true)
public class UserProfile implements Serializable {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dob;
    private String bio;
    private String image;

    public String getFullName() {
        return firstName != null ? firstName.concat(" ").concat(lastName) : "";
    }

}
