package com.example.hiberboottest.logger;

import com.example.hiberboottest.User;
import com.example.hiberboottest.listeners.AuditTrailListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ConsoleLogger implements UserLogger {

    private static final Log log = LogFactory.getLog(AuditTrailListener.class);

    @Override
    public void beforeAnyUpdate(User user) {
        if (user.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }

    @Override
    public void afterAnyUpdate(User user) {
        log.info("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }

    @Override
    public void afterLoad(User user) {
        log.info("[USER AUDIT] user loaded from database: " + user.getId());
    }


}