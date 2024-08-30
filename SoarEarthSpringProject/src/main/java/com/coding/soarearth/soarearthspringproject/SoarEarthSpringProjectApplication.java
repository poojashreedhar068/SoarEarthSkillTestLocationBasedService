package com.coding.soarearth.soarearthspringproject;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Soar Earth Test Project",
        description="Soar Earth Test Project designed and developed by Pooja Shreedhar"))
public class SoarEarthSpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoarEarthSpringProjectApplication.class, args);
    }
    @Bean
    public JtsModule jtsModule() {
        return new JtsModule();
    }


}
