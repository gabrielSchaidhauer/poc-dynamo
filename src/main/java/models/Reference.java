package models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;
import java.util.UUID;

@DynamoDBTable(tableName = "references")
public class Reference {

    @DynamoDBHashKey
    private UUID owner;

    @DynamoDBRangeKey
    private String type;
    private String name;
    private Contents contents;

    public Reference(UUID owner, String name, Contents contents, String type) {
        this.owner = owner;
        this.name = name;
        this.contents = contents;
        this.type = type;
    }

    public Reference() {
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Contents getContents() {
        return contents;
    }

    public void setContents(Contents contents) {
        this.contents = contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reference reference = (Reference) o;
        return Objects.equals(owner, reference.owner) &&
                Objects.equals(name, reference.name) &&
                Objects.equals(type, reference.type) &&
                Objects.equals(contents, reference.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name, type, contents);
    }

    @Override
    public String toString() {
        return "Reference{" +
                "owner=" + owner +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", contents=" + contents +
                '}';
    }
}
