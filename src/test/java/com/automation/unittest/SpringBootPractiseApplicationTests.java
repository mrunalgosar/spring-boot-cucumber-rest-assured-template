package com.automation.unittest;

import com.springbootpractise.SpringBootPractiseApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootTest(classes = SpringBootPractiseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootPractiseApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @Test
    void deleteByName() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("firstName", "user 1");
        restTemplate.delete("http://localhost:" + port + "/api/v1/speakers", map);
    }

}
