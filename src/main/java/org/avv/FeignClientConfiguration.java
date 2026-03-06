package org.avv;

import feign.Client;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import javax.net.ssl.TrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public Client feignClient() throws Exception {
        CertificateFactory cf = CertificateFactory.getInstance("X.509");

        try (InputStream certStream = getClass().getResourceAsStream("/cert.crt")) {
            if (certStream == null) {
                throw new RuntimeException("cert.crt not found in classpath!");
            }
            X509Certificate cert = (X509Certificate) cf.generateCertificate(certStream);

            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null);
            trustStore.setCertificateEntry("3xui-cert", cert);

            TrustManagerFactory tmf = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm()
            );
            tmf.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), new SecureRandom());

            return new Client.Default(sslContext.getSocketFactory(), null);
        }

    }
}
