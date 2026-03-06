package org.avv.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.avv.dto.InboundDto;
import org.avv.entity.Session;
import org.avv.feign.FeignAuthClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InboundService {

    FeignAuthClient feignAuthClient;

    public String createInbound(InboundDto inbound, Session session) {
        ResponseEntity<String> response = feignAuthClient.createConnection(session.getSessionId(),
                                                                           session.getCookie(),
                                                                           inbound);

        return response.getBody();
    }
}
