package by.beatdev.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@GenericGenerator(name = "PK", strategy = "increment")
public class User extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PK")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "email")
    private String email;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;


    public User() {
        this.status = UserStatus.Offline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

}

