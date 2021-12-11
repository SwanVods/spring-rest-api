package com.feirasoft.domain.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "user",
        indexes = @Index(
                name = "idx_user_email",
                columnList = "email",
                unique = true
        ))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    private UserProfile userProfile;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole role;

    private String email;

    private String password;

    private String name;

    @Column(name = "mobile_number")
    private String mobileNumber;

//    @ManyToOne(fetch = )
//    @JoinTable(name = "user_role",
//            joinColumns = {@JoinColumn(name = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "role_id")})
//    private Collection<UserRole> roles;

}

