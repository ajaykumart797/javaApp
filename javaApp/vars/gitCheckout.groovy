def call(Map1 stageParams){

    checkout([

        $class: 'GitSCM',
        branches: [[name: stageParams.branch]],
        userRemoteConfigs: [[url: stageParams.url]]
    ] )
}