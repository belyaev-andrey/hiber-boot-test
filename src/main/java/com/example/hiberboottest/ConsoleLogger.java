package com.example.hiberboottest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger {

    private static final Log log = LogFactory.getLog(AuditTrailListener.class);

    public void beforeAnyUpdate(User user) {
        if (user.getId() == 0) {
            log.info("[USER AUDIT] About to add a user");
        } else {
            log.info("[USER AUDIT] About to update/delete user: " + user.getId());
        }
    }

    public void afterAnyUpdate(User user) {
        log.info("[USER AUDIT] add/update/delete complete for user: " + user.getId());
    }

    public void afterLoad(User user) {
        log.info("[USER AUDIT] user loaded from database: " + user.getId());
    }


}