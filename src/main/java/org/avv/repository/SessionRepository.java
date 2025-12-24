package org.avv.repository;

import java.util.Optional;
import org.avv.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s WHERE s.userId = :userId ORDER BY s.createdAt DESC")
    Optional<Session> findLatestByUserId(@Param("userId") Long userId);
}

