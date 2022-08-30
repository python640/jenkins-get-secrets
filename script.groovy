def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
    com.cloudbees.plugins.credentials.impl.BaseStandardCredentials.class,
    Jenkins.instance,
    null,
    null
)

for(c in creds) {
  if(c instanceof com.cloudbees.jenkins.plugins.sshcredentials.impl.BasicSSHUserPrivateKey){
    println(String.format("id=%s  desc=%s key=%s\n", c.id, c.description, c.privateKeySource.getPrivateKeys()))
  }
  else if (c instanceof com.cloudbees.plugins.credentials.impl.UsernamePasswordCredentialsImpl){
    println(String.format("id=%s  desc=%s user=%s pass=%s\n", c.id, c.description, c.username, c.password))
  }
  else if (c instanceof org.jenkinsci.plugins.plaincredentials.impl.StringCredentialsImpl){
  	println(String.format("id=%s  desc=%s secret=%s\n", c.id, c.description, c.secret))
  }
  else if (c instanceof org.jenkinsci.plugins.plaincredentials.impl.FileCredentialsImpl){
  	println(String.format("id=%s  desc=%s fileName=%s secretBytes=%s\n", 
                          c.id, 
                          c.description, 
                          c.fileName, 
                          new String(com.cloudbees.plugins.credentials.SecretBytes.fromString(c.secretBytes.toString()).getPlainData())))
  }
  else if (c instanceof com.cloudbees.jenkins.plugins.awscredentials.AWSCredentialsImpl){
    println(String.format("id=%s desc=%s accessKey=%s secret=%s\n", c.id, c.description, c.accessKey, c.secretKey))
  }
  else if (c instanceof com.cloudbees.plugins.credentials.impl.CertificateCredentialsImpl) {
    println(String.format("id=%s  desc=%s password=%s  keyStoreSource=%s\n", c.id, c.description, c.password, c.keyStoreSource))
  }
  else if (c instanceof com.google.jenkins.plugins.googlecontainerregistryauth.GoogleContainerRegistryCredential) {
    println(String.format("id=%s  credentials=%s\n", c.id, c.credentials))
  }
  else if (c instanceof com.microsoft.azure.util.AzureCredentials) {
   	println(String.format("id=%s  desc=%s subscriptionId=%s clientId=%s clientSecret=%s\n", c.id, c.description, c.subscriptionId, c.clientId, c.clientSecret))
  }
  else {
  	println(c.getClass())
  }
}
