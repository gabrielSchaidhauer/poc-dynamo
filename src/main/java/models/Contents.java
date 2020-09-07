package models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.*;

@DynamoDBDocument
public class Contents {
    private UUID document;
    private String description;
    private List<String> tags = new ArrayList<>();


    public Contents(UUID document, String description, String... tags) {
        this.document = document;
        this.description = description;
        this.tags = Arrays.asList(tags);
    }

    public Contents() {
    }

    public UUID getDocument() {
        return document;
    }

    public void setDocument(UUID document) {
        this.document = document;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contents contents = (Contents) o;
        return Objects.equals(document, contents.document) &&
                Objects.equals(description, contents.description) &&
                Objects.equals(tags, contents.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document, description, tags);
    }

    @Override
    public String toString() {
        return "Contents{" +
                "document=" + document +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                '}';
    }
}
