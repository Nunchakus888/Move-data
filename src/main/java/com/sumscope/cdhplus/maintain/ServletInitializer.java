package com.sumscope.cdhplus.maintain; /**
 * Created by Administrator on 2015/10/23.
 */


import com.sumscope.cdhplus.maintain.mapper.MaintainMapper;
import com.sumscope.cdhplus.maintain.service.MaintainJob;
import com.sumscope.cdhplus.maintain.service.MaintainService;
import com.sumscope.cdhplus.maintain.service.MaintainServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ImportResource("classpath:datasource-config.xml")
@EnableTransactionManagement
public class ServletInitializer {

    @Bean
    public MaintainService maintainService(){
        return new MaintainServiceImpl();
    }

    @Bean
    public MaintainMapper maintainMapper(){
        return new MaintainMapper();
    }

    public static void main(String[] args) throws Exception {
        final ApplicationContext applicationContext = SpringApplication.run(ServletInitializer.class, args);
        /*MaintainJob maintainJob = (MaintainJob)applicationContext.getBean("maintainJob");
        maintainJob.doTLogJob();*/
    }
}