package com.zyc;

import static org.junit.Assert.assertTrue;

import com.zyc.bean.User;
import org.junit.Test;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        Mono<String> userFlux = WebClient.create().get()//有删除还有其他的  get是 查询
                .uri("http://localhost:8080/api/find?id={id}",1)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(String.class);
            System.out.println(userFlux.block());
    }
    @Test
    public void shouldAnswerWithTrue2() {

        Flux<String> userFlux = WebClient.create().get()
                .uri("http://localhost:8080/api/list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToFlux(String.class);
        userFlux.subscribe(
                System.out::println,
                System.out::println,
                () -> System.out.print("\ncomplete"),
                subscription -> {
                    System.out.println("订阅发生时");
                    subscription.request(10);
                }
        );
    }
}
