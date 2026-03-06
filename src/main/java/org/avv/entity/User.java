package org.avv.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "tg_user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "tg_user_gen", sequenceName = "tg_user_seq", allocationSize = 2)
public class User {

    @Id
    @GeneratedValue(generator = "tg_user_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    Long tgUserId;

    String firstName;

    Boolean isBot = false;

    String lastName;

    String username;

    String languageCode;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Message> messages;
}
