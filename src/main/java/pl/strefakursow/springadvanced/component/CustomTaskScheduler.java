package pl.strefakursow.springadvanced.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class CustomTaskScheduler {

//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
//    second, minuta, godzina, dzień miesiąca, miesiąc, dzień tygodnia
//    @Scheduled(cron = "${cron.expression}")
    public void doSomeStuff() throws InterruptedException {
//        Thread.sleep(1000);
        System.out.println("Some operation, time: " + LocalTime.now());
    }
}
