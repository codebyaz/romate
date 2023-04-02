package com.codebyaz.romate.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.time.Duration;

@Configuration
public class DriverConfig {

    @Value("${driver.option.headless}")
    private boolean isHeadless;

    @Value("${driver.option.allow-origins}")
    private String allowOrigins;

    @Value("${driver.option.accept-insecure-certificates}")
    private boolean acceptInsecureCerts;

    @Value("${driver.option.default-implicit-wait-seconds}")
    private int defaultImplicitWaitInSeconds;

    @Bean
    public ChromeOptions options() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(this.isHeadless);
        chromeOptions.setAcceptInsecureCerts(this.acceptInsecureCerts);
        chromeOptions.addArguments(this.allowOrigins);
        chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(this.defaultImplicitWaitInSeconds));

        return chromeOptions;
    }

    @Bean
    @Scope("prototype")
    public WebDriver driver(ChromeOptions options) {
        return new ChromeDriver(options);
    }
}
