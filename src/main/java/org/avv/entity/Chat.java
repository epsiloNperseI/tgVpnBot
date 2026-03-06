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
@Table(name = "chat")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "chat_gen", sequenceName = "chat_seq", allocationSize = 2)
public class Chat {

    @Id
    @GeneratedValue(generator = "chat_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    Long tgChatId;

    String type;

    String title;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    List<Message> messages;
}
