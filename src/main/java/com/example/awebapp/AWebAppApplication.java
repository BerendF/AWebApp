package com.example.awebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootApplication
public class AWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AWebAppApplication.class, args);
    }

    @Bean
    CommandLineRunner init(TutorialRepository tutorialRepository, WikiRepository wikiRepository) {
        return args -> {
            String date = new Date().toString();
            DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.US);
            DateFormat formatter1 = new SimpleDateFormat("dd.MM.yyyy");
            date = formatter1.format(formatter.parse(date));
            Tutorial[] t = new Tutorial[9];
            t[0] = new Tutorial("Baeldung-WebApp with Spring and Angular", "https://www.baeldung.com/spring-boot-angular-web", 4.0, "base for this page", date);
            t[1] = new Tutorial("Tutorialspoint-SAP Hybris", "https://www.tutorialspoint.com/sap_hybris/index.htm", 2.0, "largely outdated", date);
            t[2] = new Tutorial("Tutorialspoint Spring XML-based beans", "https://www.tutorialspoint.com/spring/index.htm", 5.0, "- instructive - easy to follow", date);
            t[3] = new Tutorial("Angular.io Tutorial", "https://angular.io/tutorial", 5.0, "well structured, instructive content", date);
            t[4] = new Tutorial("Spring.io Database", "https://spring.io/guides/gs/relational-data-access/", 2.0, "deprecated, too simple", date);
            t[5] = new Tutorial("Angular.de Tutorial", "https://angular.de/artikel/angular-tutorial-deutsch/", 3.0, "solid, but lacking", date);
            t[6] = new Tutorial("Spartacus Visualization", "https://microlearning.opensap.com/playlist/dedicated/178318381/1_sokuy66v/1_8mmwx8ck", 1.0, "not for developers", date);
            t[7] = new Tutorial("SAP Commerce Visualization", "https://microlearning.opensap.com/playlist/dedicated/178317751/1_4ugj2pn9/1_zsyss1nz", 1.0, "not for developers", date);
            t[8] = new Tutorial("CronJobs", "http://javainsimpleway.com/cron-jobs-overview/", 3.0, "simple", date);


            for (int i = 0; i < t.length; i++) {
                tutorialRepository.save(t[i]);
            }
            tutorialRepository.findAll().forEach(System.out::println);
            Wiki w = new Wiki("SAP Commerce Wiki","https://help.sap.com/viewer/product/SAP_COMMERCE_CLOUD/SHIP/en-US?task=discover_task");
            wikiRepository.save(w);
        };
    }
}
