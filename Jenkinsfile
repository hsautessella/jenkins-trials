#!groovy

node {
  def root_dir = pwd()
  // def utils = load "/var/lib/jenkins/workspace/jenkins-trials"
  echo pwd()
  sh 'ls'
  // checkout scm
  def utils = load "${root_dir}/groovy/utils.groovy"

  properties([
    parameters([
      string(
        defaultValue: utils.get_branch_name(env.JOB_BASE_NAME),
        description: 'The name of the branch to build.',
        name: 'BRANCH_NAME',
        trim: true
      ),
      string(
        defaultValue: utils.get_default_herbert_branch(env.JOB_BASE_NAME),
        description: 'The name of the branch of Herbert to use.',
        name: 'HERBERT_BRANCH_NAME',
        trim: true
      ),
      string(
        defaultValue: utils.get_matlab_release(env.JOB_BASE_NAME),
        description: 'The release number of the Matlab to load e.g. R2019b.',
        name: 'MATLAB_VERSION',
        trim: true
      ),
      string(
        defaultValue: utils.get_release_type(env.JOB_BASE_NAME),
        description: 'The type of the build e.g. "nightly", "release", "pull_request".',
        name: 'RELEASE_TYPE',
        trim: true
      ),
      string(
        defaultValue: utils.get_agent(env.JOB_BASE_NAME),
        description: 'The agent to execute the pipeline on.',
        name: 'AGENT',
        trim: true
      ),
      string(
        defaultValue: '3.7.2',
        description: 'The version of CMake to run the build with.',
        name: 'CMAKE_VERSION',
        trim: true
      ),
      string(
        defaultValue: '6.3.0',
        description: 'The version of GCC to build with.',
        name: 'GCC_VERSION',
        trim: true
      ),
      string(
        defaultValue: '2017',
        description: 'The year of the version of Visual Studio to build with.',
        name: 'VS_VERSION',
        trim: true
      ),
      string(
        defaultValue: '1.77',
        description: 'The version of CppCheck tooling to load to provide the code-style checks.',
        name: 'CPPCHECK_VERSION',
        trim: true
      )
    ])
  ])
}

pipeline {
  agent any

  stages {
    stage('Stage1') {
      steps {
        echo 'Pipelines started'
        echo "${env.BRANCH_NAME}"
        sh 'git rev-parse HEAD'
      }
    }
  }
}
