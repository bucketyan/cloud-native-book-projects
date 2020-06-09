package com.fuck.cloudnative.microservices.example.test.service;

import com.fuck.cloudnative.microservices.example.demo.commons.dto.CustomerDto;
import feign.hystrix.FallbackFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * DESCRIPTION:
 *
 * @author zouyan
 * @create 2019-05-22 下午3:51
 * created by fuck~
 **/
@Component
public class RemoteUserServiceFactory implements FallbackFactory<RemoteUserService> {
    private static Logger logger = LogManager.getLogger(RemoteUserServiceFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable) {
        return new RemoteUserService(){
            @Override
            public List<CustomerDto> findAll() {
                logger.error("RemoteUserService failed! start fallback.", throwable);
                return null;
            }
        };
    }
}
