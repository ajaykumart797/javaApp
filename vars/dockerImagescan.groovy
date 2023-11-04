def call(String project, String imageTag, String hubuser){

   sh"""
     trivy image ${hubuser}/${project}:latest >scan.txt
     cat scan.txt
    """
}