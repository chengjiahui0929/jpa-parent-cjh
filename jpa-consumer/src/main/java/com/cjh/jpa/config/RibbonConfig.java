package com.cjh.jpa.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cjh
 * @date 2020/7/22
 */
@Configuration
public class RibbonConfig {

    @Bean
    public IRule rule(){
        return new RandomRule();
    }
}
