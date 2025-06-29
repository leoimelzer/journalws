package com.journal.journalws.dto.entry;

import com.journal.journalws.annotation.entry.PrivacyCheck;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class EntrySaveRequest {

    @NotNull
    private final String content;

    private final List<String> tags;

    @NotNull
    @PrivacyCheck
    private final String privacy;

    private final List<String> allowedUsers;

    public EntrySaveRequest(String content, List<String> tags, String privacy, List<String> allowedUsers) {
        this.content = content;
        this.tags = tags;
        this.privacy = privacy;
        this.allowedUsers = allowedUsers;
    }

    public String getContent() {
        return content;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getPrivacy() {
        return privacy;
    }

    public List<String> getAllowedUsers() {
        return allowedUsers;
    }

}
