def call(){

   sh"
     trivy image ${hubuser}/${project}: latest >scan.txt
     cat txt
    "
}