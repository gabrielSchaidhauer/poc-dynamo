package samples;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.*;
import models.Contents;
import models.Reference;
import toolbox.AWSClientBuilder;

import javax.print.DocFlavor;
import java.sql.Ref;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class SampleQueryItems {
    public static void main(String... args) {
        final AmazonDynamoDB dynamoClient = AWSClientBuilder.buildDynamoClient();
        DynamoDBMapper mapper = new DynamoDBMapper(dynamoClient);
        CreateTableRequest req = mapper.generateCreateTableRequest(Reference.class);
        DeleteTableRequest delReq = mapper.generateDeleteTableRequest(Reference.class);
        req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));

        try {
            dynamoClient.deleteTable(delReq);
            dynamoClient.createTable(req);

            Contents contents = new Contents(UUID.randomUUID(), "Character 123", "Character", "Story 123");
            Reference reference = new Reference(UUID.fromString("8b5d4861-01ea-42f6-a04c-4da3453e0afa"), "Boris", contents, "Character");
            mapper.save(reference);

            Thread.sleep(3000);
            System.out.println(mapper.load(Reference.class, UUID.fromString("8b5d4861-01ea-42f6-a04c-4da3453e0afa"), "Character"));

        } catch (ResourceInUseException ex) {
            System.out.println("Table already exists");
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
}
