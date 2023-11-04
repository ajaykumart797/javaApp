def call(String project, String imageTag, String hubuser){

    sh"""
      docker image build -t ${hubuser}/${project} .
      docker image tag ${hubuser}/${project} ${hubuser}/${project}:${imageTag}
      docker image tag ${hubuser}/${project} ${hubuser}/${project}:latest
    """
}