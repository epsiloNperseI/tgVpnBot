package org.avv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "session")
@SequenceGenerator(name = "session_gen", sequenceName = "session_seq", allocationSize = 1)
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "session_gen")
    private Long id;

    private Long userId;

    private String sessionId;

    private LocalDateTime createdAt = LocalDateTime.now();

    private String cookie;
}

