package org.avv.dto;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class StreamSettingsDto {
    String network;
    String security;
    List<Object> externalProxy;
    RealitySettingsDto realitySettings;
    TcpSettingsDto tcpSettings;
}
