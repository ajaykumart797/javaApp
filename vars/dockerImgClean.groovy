def call(String project, String imageTag, String hubuser){

    sh"""
      docker rmi  ${hubuser}/${project}:${imageTag}
      docker rmi  ${hubuser}/${project}:latest
    """
}