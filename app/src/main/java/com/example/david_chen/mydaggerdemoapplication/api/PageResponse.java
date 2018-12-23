package com.example.david_chen.mydaggerdemoapplication.api;

import java.util.Map;

public class PageResponse {

    public PageResponse() {
    }

    public Query query;

    public class Query {
        public Map<String, Page> pages;
    }

    public class Page {
        public int pageid;
        public Thumbnail thumbnail;
        public String title;
    }

    public class Thumbnail {
        public String source;
    }
}
