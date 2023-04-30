package com.example.notificationservice.client;

import com.example.notificationservice.dto.Picture;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8081/")
public interface UserServiceClient {
    @Retry(name = "user-service-retry", fallbackMethod = "findPictureByFallback")
    @CircuitBreaker(name = "user-service-circuit-breaker")
    @GetMapping("picture/{id}")
    Picture getPicture(@PathVariable long id);

    default Picture findPictureByFallback(long id, Throwable throwable) {
        return new Picture(id, id, "NOT_KNOWN");
    }

}
