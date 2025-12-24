package org.avv.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.avv.dto.AllocateDto;
import org.avv.dto.ClientDto;
import org.avv.dto.InboundDto;
import org.avv.dto.InboundSettingsDto;
import org.avv.dto.RealityInnerSettingsDto;
import org.avv.dto.RealitySettingsDto;
import org.avv.dto.SniffingDto;
import org.avv.dto.StreamSettingsDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CreateDtoInboundService {

    public InboundDto createInboundDto() {
        InboundSettingsDto settings = createSettings();
        StreamSettingsDto streamSettings = createStreamSettings();
        SniffingDto sniffing = createSniffing();
        AllocateDto allocate = createAllocate();

        String settingsJson;
        String streamSettingsJson;
        String sniffingJson;
        String allocateJson;
        try {
            settingsJson = new ObjectMapper().writeValueAsString(settings);
            streamSettingsJson = new ObjectMapper().writeValueAsString(streamSettings);
            sniffingJson = new ObjectMapper().writeValueAsString(sniffing);
            allocateJson = new ObjectMapper().writeValueAsString(allocate);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return InboundDto.builder()
            .up(0)
            .down(0)
            .total(0)
            .remark("New")
            .enable(true)
            .expiryTime(0)
            .listen("")
            .port(55421)
            .protocol("vless")
            .settings(settingsJson)
            .streamSettings(streamSettingsJson)
            .sniffing(sniffingJson)
            .allocate(allocateJson)
            .build();
    }

    private InboundSettingsDto createSettings() {
        ClientDto client1 = ClientDto.builder()
            .email("hyvcs325")
            .enable(true)
            .expiryTime(0)
            .flow("")
            .id("")
            .limitIp(0)
            .reset(0)
            .subId("")
            .tgId("")
            .totalGB(0)
            .build();

        ClientDto client2 = ClientDto.builder()
            .email("27225ost")
            .enable(true)
            .expiryTime(0)
            .flow("")
            .id("")
            .limitIp(0)
            .reset(0)
            .subId("")
            .tgId("")
            .totalGB(0)
            .build();

        return InboundSettingsDto.builder()
            .clients(Arrays.asList(client1, client2))
            .decryption("none")
            .fallbacks(Arrays.asList())
            .build();
    }

    private StreamSettingsDto createStreamSettings() {
        RealitySettingsDto realitySettings = RealitySettingsDto.builder()
            .show(false)
            .xver(0)
            .dest("yahoo.com:443")
            .serverNames(Arrays.asList("yahoo.com", "www.yahoo.com"))
            .privateKey("")
            .shortIds(Arrays.asList("97de", "5f7b4df7d0605151", "cc1a7d15c439"))
            .settings(RealityInnerSettingsDto.builder()
                          .publicKey("")
                          .fingerprint("random")
                          .spiderX("/")
                          .build())
            .build();

        return StreamSettingsDto.builder()
            .network("tcp")
            .security("reality")
            .realitySettings(realitySettings)
            .build();
    }

    private SniffingDto createSniffing() {
        return SniffingDto.builder()
            .enabled(false)
            .destOverride(Arrays.asList("http", "tls", "quic", "fakedns"))
            .build();
    }

    private AllocateDto createAllocate() {
        return AllocateDto.builder()
            .strategy("always")
            .refresh(5)
            .concurrency(3)
            .build();
    }
}