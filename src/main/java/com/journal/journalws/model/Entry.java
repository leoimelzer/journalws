package com.journal.journalws.model;

import com.journal.journalws.enums.entry.Privacy;
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

    @Field("user_id")
    @NotNull
    private String userId;

    @Field("content")
    @NotNull
    private String content;

    @Field("tags")
    private List<String> tags;

    @Field("privacy")
    @NotNull
    private String privacy;

    @Field("allowed_users")
    private List<String> allowedUsers;

    @Field("created_at")
    @NotNull
    private LocalDateTime createdAt;

    @Field("updated_at")
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @SuppressWarnings("unused")
    public List<String> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(List<String> allowedUsers) {
        this.allowedUsers = allowedUsers;
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
