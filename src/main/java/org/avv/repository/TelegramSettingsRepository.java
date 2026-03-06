package org.avv.repository;

import org.avv.entity.TelegramSettings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramSettingsRepository extends JpaRepository<TelegramSettings, Long> {
}
