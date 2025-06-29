package com.journal.journalws.dto;

import com.journal.journalws.validator.PrivacyCheck;
import jakarta.validation.constraints.NotNull;

public class EntrySaveRequest {

    @NotNull
    private final String title;

    @NotNull
    private final String content;

    @NotNull
    @PrivacyCheck
    private final String privacy;

    private final String tags;

    public EntrySaveRequest(String title, String content, String privacy, String tags) {
        this.title = title;
        this.content = content;
        this.privacy = privacy;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTags() {
        return tags;
    }

    public String getPrivacy() {
        return privacy;
    }

}
