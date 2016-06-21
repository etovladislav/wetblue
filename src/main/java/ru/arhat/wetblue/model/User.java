package ru.arhat.wetblue.model;

import org.hibernate.type.StringRepresentableType;
import ru.arhat.wetblue.model.enums.UserRole;

import javax.persistence.*;

/**
 * Created by etovladislav on 21.06.16.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;

    private UserRole userRole;

    public User() {
        this.userRole = UserRole.ROLE_ADMIN;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
