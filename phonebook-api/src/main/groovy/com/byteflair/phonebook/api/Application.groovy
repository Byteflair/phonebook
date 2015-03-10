package com.byteflair.phonebook.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ImportResource

/**
 *
 * @author <a mailto="victor.hernandezbermejo@gmail.com">Víctor Hernández</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
@ImportResource(["phonebook-api.xml", "classpath:mongo.xml"])
@ComponentScan(basePackages = "com.byteflair.phonebook")
public class Application {

    static void main(String[] args) {
        SpringApplication.run(Application.class, args)
    }
}
