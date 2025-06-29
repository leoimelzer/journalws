package com.journal.journalws.model;

import com.journal.journalws.enums.EntryPrivacy;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "entries")
public class Entry {

    @Id
    private String id;

    @Field("author_id")
    @NotNull
    private String authorId;

    @Field("title")
    @NotNull
    private String title;

    @Field("content")
    @NotNull
    private String content;

    @Field("tags")
    private List<String> tags;

    @Field("privacy")
    @NotNull
    private String privacy;

    @Field("created_at")
    @NotNull
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unused")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @SuppressWarnings("unused")
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public EntryPrivacy getPrivacy() {
        return EntryPrivacy.getInstanceByValue(privacy);
    }

    public void setPrivacy(EntryPrivacy entryPrivacy) {
        this.privacy = entryPrivacy.getValue();
    }

    @SuppressWarnings("unused")
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @SuppressWarnings("unused")
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
