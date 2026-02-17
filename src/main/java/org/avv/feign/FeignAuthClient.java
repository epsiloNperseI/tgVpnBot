package org.avv.feign;

import feign.Headers;
import org.avv.dto.CreateClientDto;
import org.avv.dto.InboundDto;
import org.avv.dto.LoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "authClient", url = "${api.base-url}")
public interface FeignAuthClient {

    @Headers("Content-Type: application/json")
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    ResponseEntity<String> login(@RequestBody LoginDto loginDto);

    @PostMapping("/panel/api/inbounds/add")
    ResponseEntity<String> createConnection(
        @RequestHeader("Authorization") String authorizationHeader,
        @RequestHeader("Cookie") String cookieHeader,
        @RequestBody InboundDto inbound);

    @PostMapping("/clients")
    ResponseEntity<String> createClient(@RequestBody CreateClientDto clientDto);
}
