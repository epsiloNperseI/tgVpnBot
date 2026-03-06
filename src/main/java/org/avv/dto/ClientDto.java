package org.avv.dto;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ClientDto {
    String id;
    String flow;
    String email;
    int limitIp;
    int totalGB;
    long expiryTime;
    boolean enable;
    String tgId;
    String subId;
    int reset;
}