package com.zyc.service;

import com.zyc.bean.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestService {

    public Flux<User> list();

    public Mono<User> getById(final String id);

    public Mono<User> del(final String id);
}
