package org.example.app.service;

import org.apache.log4j.Logger;
import org.example.web.dto.Book;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class IdProvider implements InitializingBean, DisposableBean, BeanPostProcessor {
    private final Logger logger = Logger.getLogger(IdProvider.class);

    public String provideId(Book book) {
        return this.hashCode() + "_" + book.hashCode();
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("provider AFTER_PROPERTIES_SET invoked");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("DisposableBean DESTROY invoked");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("post process Before Initialization invoked by bean " + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("post process after Initialization invoked by bean " + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @PostConstruct
    public void postConstructIdProvider() {
        logger.info("POST_CONSTRUCT annotated method called");
    }

    @PreDestroy
    public void preDestroyIdProvider() {
        logger.info("PRE_DESTROY_ID_PROVIDER annotated method called");
    }
}
