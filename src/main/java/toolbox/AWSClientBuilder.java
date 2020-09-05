package toolbox;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class AWSClientBuilder {
  public static AmazonDynamoDB buildDynamoClient() {
    return AmazonDynamoDBClientBuilder
            .standard()
            .withCredentials(new LocalstackCredentialsProvider())
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4569", Regions.US_EAST_1.name()))
            .build();

  }
}
