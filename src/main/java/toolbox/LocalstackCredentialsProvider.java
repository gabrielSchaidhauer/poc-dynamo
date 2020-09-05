package toolbox;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

class LocalstackCredentialsProvider implements AWSCredentialsProvider {

  @Override
  public AWSCredentials getCredentials() {
    return new BasicAWSCredentials("anyAccessKey", "anySecretKey");
  }

  @Override
  public void refresh() {
    // Do Nothing
  }
}