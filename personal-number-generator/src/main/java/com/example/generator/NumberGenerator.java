package com.example.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@Slf4j
@RestController("/")
@SpringBootApplication
public class NumberGenerator {
    @GetMapping("/hc")
    public ResponseEntity<String> hc() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping("/number")
    public ResponseEntity<Long> generateNumber() {
        long generatedLong = new Random().nextLong();
        return new ResponseEntity<>(generatedLong, HttpStatus.OK);
    }

    public static void main(String[] args) throws UnknownHostException {
        Environment env = SpringApplication.run(NumberGenerator.class, args).getEnvironment();
        log.info(
                "\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://127.0.0.1:{}\n\t"
                        + "External: \thttp://{}:{}\n\t"
                        + "Message: \t{}"
                        + "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getProperty("spring.message")
        );
    }
}
