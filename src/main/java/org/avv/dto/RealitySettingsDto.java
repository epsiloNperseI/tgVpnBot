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
public class RealitySettingsDto {
    boolean show;
    int xver;
    String dest;
    List<String> serverNames;
    String privateKey;
    String minClient;
    String maxClient;
    int maxTimediff;
    List<String> shortIds;
    RealityInnerSettingsDto settings;
}
