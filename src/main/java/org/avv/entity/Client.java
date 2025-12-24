package org.avv.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client")
@SequenceGenerator(name = "client_gen", sequenceName = "client_seq", allocationSize = 1)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_gen")
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "inbound_id", nullable = false)
    private Inbound inbound;

    private String clientId;

    private String email;

    private LocalDateTime createdAt = LocalDateTime.now();
}
