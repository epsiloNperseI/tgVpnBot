package org.avv;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @GetMapping("/api/endpoint")
    public RestResponse getResponse() {
        return new RestResponse("Это ответ от бэка!");
    }

    @Setter
    @Getter
    public static class RestResponse {
        private String message;

        public RestResponse(String message) {
            this.message = message;
        }

    }
}
