package suixingpay;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhou_gc@suixingpay.com
 * @description
 * @date 2019/11/10 11:45
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(EnableHelloAutoConfigruation.class)
public @interface EnableHello {

}
