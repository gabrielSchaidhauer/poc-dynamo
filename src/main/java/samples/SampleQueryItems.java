package samples;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import toolbox.AWSClientBuilder;

public class SampleQueryItems {
  public static void main(String... args) {
    final AmazonDynamoDB dynamoClient = AWSClientBuilder.buildDynamoClient();
    final CreateTableRequest request = new CreateTableRequest()
            .withAttributeDefinitions(
                    new AttributeDefinition("Name", ScalarAttributeType.S),
                    new AttributeDefinition("Type", ScalarAttributeType.S)
            )
            .withKeySchema(
                    new KeySchemaElement("Name", KeyType.HASH),
                    new KeySchemaElement("Type", KeyType.RANGE))
            .withProvisionedThroughput(new ProvisionedThroughput(10L, 10L))
            .withTableName("references");

    try {
      if (dynamoClient.listTables("references").getTableNames().size() == 0) {
        CreateTableResult result = dynamoClient.createTable(request);
        System.out.println(result.getTableDescription().getTableName());
      } else {
        System.out.println("Table already exists");
      }

    } catch (AmazonServiceException e) {
      System.err.println(e.getErrorMessage());
      System.exit(1);
    }
  }
}
