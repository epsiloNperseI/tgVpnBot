package org.avv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class CreateClientDto {
    long id;
    Settings settings;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @FieldDefaults(level = PRIVATE)
    public static class Settings {
        List<Client> clients;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        @FieldDefaults(level = PRIVATE)
        public static class Client {
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
    }
}