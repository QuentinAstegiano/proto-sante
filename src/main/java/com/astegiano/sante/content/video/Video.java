package com.astegiano.sante.content.video;

import com.google.common.collect.ImmutableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 25/04/2016.
 *
 *
 */
public class Video {

    private final String id;
    private final String title;
    private final String thumbnail;
    private final String description;
    private final List<String> tags;
    private final String url;
    private final LocalDate date;

    public Video(Builder b) {
        this.id = b.id;
        this.title = b.title;
        this.thumbnail = b.thumbnail;
        this.description = b.description;
        this.tags = ImmutableList.copyOf(b.tags);
        this.url = b.url;
        this.date = b.date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public LocalDate getDate() {
        return date;
    }

    public static class Builder {
        private String id;
        private String title;
        private String thumbnail;
        private String description;
        private List<String> tags = new ArrayList<>();
        private String url;
        private LocalDate date;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }
}
