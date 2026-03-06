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
@Table(name = "inbound")
@SequenceGenerator(name = "inbound_gen", sequenceName = "inbound_seq", allocationSize = 1)
public class Inbound {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inbound_gen")
    private Long id;

    private Long userId;

    private String inboundId;

    private String remark;

    private String protocol;

    private LocalDateTime createdAt = LocalDateTime.now();
}

