package com.journal.journalws.dto;

public class EntryListRequest {

    private final String authorId;

    private final String privacy;

    public EntryListRequest(String authorId, String privacy) {
        this.authorId = authorId;
        this.privacy = privacy;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getPrivacy() {
        return privacy;
    }
}
