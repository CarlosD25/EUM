package com.unimag.espaciosum;

import org.springframework.boot.SpringApplication;

public class TestEspaciosumApplication {

    public static void main(String[] args) {
        SpringApplication.from(EspaciosumApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
