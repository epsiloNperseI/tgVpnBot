package org.avv.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class InboundDto {
    int up;
    int down;
    int total;
    String remark;
    boolean enable;
    long expiryTime;
    String listen;
    int port;
    String protocol;
    String settings;
    String streamSettings;
    String sniffing;
    String allocate;
}