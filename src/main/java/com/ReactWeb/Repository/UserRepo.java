package com.ReactWeb.Repository;

import com.ReactWeb.Model.Home;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepo extends ReactiveCrudRepository<Home,Long> {

    Mono<Home> findByEmail(String email);


}
