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
@Table(name = "telegram_logs")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "telegram_logs_gen", sequenceName = "telegram_logs_seq", allocationSize = 2)
public class TelegramLog {
    @Id
    @GeneratedValue(generator = "telegram_logs_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    String userId;

    String action;

    LocalDateTime createdAt = LocalDateTime.now();
}
