package com.unimag.espaciosum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class EspaciosumApplicationTests {

    @Test
    void contextLoads() {
    }

}
