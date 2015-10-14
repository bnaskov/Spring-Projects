package main.java.com.school.system.crons;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	// fixedDelay - specifies the interval between invocations measured from the completion of the task
	@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("The time is now " + dateFormat.format(new Date()));
    }
	
	// every 8 seconds
	@Scheduled(cron="*/8 * * * * *")
    public void sayHello() {
        System.out.println("Hello!");
    }
}
