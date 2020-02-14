package com.dp.viking.domain.util;

import com.dp.viking.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}
