package com.example.AutoShop.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table( name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @SequenceGenerator(name = "roles_seq", sequenceName = "roles_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role")
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @Column(name = "users")
    private Set<User> users;

    public Role(long id, String role_user) {
        this.roleId=id;
        this.role=role_user;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
