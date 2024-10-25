package xyz.ge1st.model;

public record DiffRequest(String sourceSpec, String targetSpec, boolean useMarkdown) {}
