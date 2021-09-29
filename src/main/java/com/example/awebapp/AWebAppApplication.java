package com.example.awebapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
            DateFormat formatterFull = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.US);
            DateFormat formatterSimple = new SimpleDateFormat("dd.MM.yyyy");
            date = formatterSimple.format(formatterFull.parse(date));
            Tutorial[] t = new Tutorial[11];
            t[0] = new Tutorial("Baeldung-WebApp with Spring and Angular", "https://www.baeldung.com/spring-boot-angular-web", 4.0, "base for this page", date);
            t[1] = new Tutorial("Tutorialspoint-SAP Hybris", "https://www.tutorialspoint.com/sap_hybris/index.htm", 2.0, "largely outdated", date);
            t[2] = new Tutorial("Tutorialspoint Spring XML-based beans", "https://www.tutorialspoint.com/spring/index.htm", 5.0, "- instructive - easy to follow", date);
            t[3] = new Tutorial("Angular.io Tutorial", "https://angular.io/tutorial", 5.0, "well structured, instructive content", date);
            t[4] = new Tutorial("Spring.io Database", "https://spring.io/guides/gs/relational-data-access/", 1.0, "deprecated, too elementary", date);
            t[5] = new Tutorial("Angular.de Tutorial", "https://angular.de/artikel/angular-tutorial-deutsch/", 3.0, "solid, but lacking", date);
            t[6] = new Tutorial("Spartacus Visualization", "https://microlearning.opensap.com/playlist/dedicated/178318381/1_sokuy66v/1_8mmwx8ck", 2.0, "not for developers, otherwise fine tutorial", date);
            t[7] = new Tutorial("SAP Commerce Visualization", "https://microlearning.opensap.com/playlist/dedicated/178317751/1_4ugj2pn9/1_zsyss1nz", 2.0, "not for developers, otherwise fine tutorial", date);
            t[8] = new Tutorial("CronJobs", "http://javainsimpleway.com/cron-jobs-overview/", 3.0, "basic, still instructive", date);
            t[9] = new Tutorial("Spring Angular Security", "https://spring.io/guides/tutorials/spring-security-and-angular-js/", 1.0, "mostly deprecated dependencies", date);
            t[10] = new Tutorial("Spring Bean Configuration", "https://www.codingame.com/playgrounds/2096/playing-around-with-spring-bean-configuration", 3.0, "fine as a quick reference", date);
            Wiki w = new Wiki("SAP Commerce Wiki", "https://help.sap.com/viewer/product/SAP_COMMERCE_CLOUD/SHIP/en-US?task=discover_task");

            tutorialRepository.saveAll(Arrays.asList(t));
            wikiRepository.save(w);


        };
    }
}
