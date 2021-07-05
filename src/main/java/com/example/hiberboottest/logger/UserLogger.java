package com.example.hiberboottest.logger;

import com.example.hiberboottest.User;

public interface UserLogger {
    void beforeAnyUpdate(User user);

    void afterAnyUpdate(User user);

    void afterLoad(User user);
}