package com.journal.journalws.dto.entry;

public class EntryListRequest {

    private final String userId;

    private final String privacy;

    public EntryListRequest(String userId, String privacy) {
        this.userId = userId;
        this.privacy = privacy;
    }

    public String getUserId() {
        return userId;
    }

    public String getPrivacy() {
        return privacy;
    }
}
