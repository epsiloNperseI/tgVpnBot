package org.avv.repository;

import org.avv.entity.TelegramLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramLogRepository extends JpaRepository<TelegramLog, Long> {
}
