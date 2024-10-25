package xyz.ge1st.impl;

import jakarta.enterprise.context.ApplicationScoped;
import org.openapitools.openapidiff.core.OpenApiCompare;
import org.openapitools.openapidiff.core.model.ChangedOpenApi;
import org.openapitools.openapidiff.core.output.HtmlRender;
import org.openapitools.openapidiff.core.output.MarkdownRender;
import xyz.ge1st.model.DiffRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@ApplicationScoped
public class DiffService {

    public String compareSpecs(DiffRequest diffRequest) {

        // 1 Decode from Base64
        String sourceSpec = new String(Base64.getDecoder().decode(diffRequest.sourceSpec()), StandardCharsets.UTF_8);
        String targetSpec = new String(Base64.getDecoder().decode(diffRequest.targetSpec()), StandardCharsets.UTF_8);

        ChangedOpenApi changedOpenApi = OpenApiCompare.fromContents(sourceSpec, targetSpec);

        if (diffRequest.useMarkdown()) {

            String result = new MarkdownRender().render(changedOpenApi);

            return result.isEmpty() ? "## :heavy_check_mark: No changes to API :heavy_check_mark:" : result;
        } else {
            return new HtmlRender("Changelog", "/styles-dark.css").render(changedOpenApi);
        }
    }
}
