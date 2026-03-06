package org.avv.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@Table(name = "telegram_settings")
@FieldDefaults(level = AccessLevel.PRIVATE)
@SequenceGenerator(name = "telegram_settings_gen", sequenceName = "telegram_settings_seq", allocationSize = 2)
public class TelegramSettings {

    @Id
    @GeneratedValue(generator = "telegram_settings_gen", strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    String botToken;

    String adminId;

    String notificationFrequency;

    Boolean backupEnabled;

    Boolean loginNotificationEnabled;
}
