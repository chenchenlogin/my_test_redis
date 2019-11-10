package suixingpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @创建人 zhou_gc@suixingpay.com
 * @创建时间 2019/11/7 14:28
 * @描述
 */


@SpringBootApplication
@EnableHello
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class,args);
    }

}
