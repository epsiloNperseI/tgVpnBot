package org.avv.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "message")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "message_gen", sequenceName = "message_seq", allocationSize = 2)
public class Message {

    @Id
    @GeneratedValue(generator = "message_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    Long tgMessageId;

    @ManyToOne
    @JoinColumn(name = "user_id_from", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    Chat chat;

    String messageText;

    @Column(nullable = false)
    LocalDateTime dateCreated = LocalDateTime.now();
}
