package suixingpay;

import com.sun.corba.se.pept.transport.Selector;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

/**
 * @author zhou_gc@suixingpay.com
 * @description
 * @date 2019/11/10 11:52
 */


public class EnableHelloAutoConfigruation implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
       List<String> list=SpringFactoriesLoader.loadFactoryNames(EnableHello.class,null);
        for (String s : list) {
            System.out.println(s);
        }
        return (list != null ? list.toArray(new String[0]) : new String[0]);
    }
}
