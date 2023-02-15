package com.rahil.springemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailDemoApplication {

    private EmailSenderService service;

    public SpringEmailDemoApplication(EmailSenderService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringEmailDemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail() {
        service.sendEmail(
                "rahilthakkar52@gmail.com",
                "Email From Spring Application",
                "Application email sender testing...."
        );
    }

}
