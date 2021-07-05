package com.example.hiberboottest.listeners;

import com.example.hiberboottest.logger.ConsoleLogger;
import com.example.hiberboottest.User;
import com.example.hiberboottest.logger.UserLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class AuditTrailListener {

    @Autowired
    private UserLogger consoleLogger;

    @PrePersist
    @PreUpdate
    @PreRemove
    private void beforeAnyUpdate(User user) {
        consoleLogger.beforeAnyUpdate(user);
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    private void afterAnyUpdate(User user) {
        consoleLogger.afterAnyUpdate(user);
    }

    @PostLoad
    private void afterLoad(User user) {
        consoleLogger.afterLoad(user);
    }

}