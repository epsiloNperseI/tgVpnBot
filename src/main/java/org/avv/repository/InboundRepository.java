package org.avv.repository;

import java.util.Optional;
import org.avv.entity.Inbound;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InboundRepository extends JpaRepository<Inbound, Long> {
    Optional<Inbound> findByInboundId(String inboundId);
}
