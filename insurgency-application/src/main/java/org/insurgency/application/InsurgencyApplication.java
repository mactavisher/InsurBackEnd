package org.insurgency.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"org.insurgency"})
public class InsurgencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(InsurgencyApplication.class);
    }
}
