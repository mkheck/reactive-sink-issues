package com.thehecklers.brpsink;

import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.util.function.Consumer;

@SpringBootApplication
public class BrpSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrpSinkApplication.class, args);
    }

}

@EnableBinding(Sink.class)
class MessageSink {
    @Bean
    public Consumer<Flux<Subscriber>> fluxConsumer() {
        return flux -> flux.subscribe(System.out::println);
    }
}

@Value
class Subscriber {
    private final String id, firstName, lastName;
    private final Instant subscribeDate;
}