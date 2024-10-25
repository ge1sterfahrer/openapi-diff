package xyz.ge1st.model;


import lombok.Data;

@Data
public class DiffRequest {

    String sourceSpec;
    String targetSpec;
    boolean useMarkdown;

}
