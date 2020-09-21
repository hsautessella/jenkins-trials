#!groovy

def get_matlab_release(String job_name) {
  return 'R' + job_name[-5..-1]
}

def get_build_type(String job_name) {
  if (env.JOB_BASE_NAME.startsWith('Release-')) {
    return 'Release'
  } else if (env.JOB_BASE_NAME.startsWith('Branch-')) {
    return 'Branch'
  } else if(env.JOB_BASE_NAME.startsWith('PR-')) {
    return 'Pull-request'
  } else {
    return 'Nightly'
  }
}

def get_agent(String job_name) {
  def agent = ''
  if (env.JOB_BASE_NAME.contains('Scientific-Linux-7')) {
    return 'sl7'
  } else if (env.JOB_BASE_NAME.contains('Windows-10')) {
    return 'PACE Windows (Private)'
  }
  return '';
}

def get_release_type(String job_name) {
  String build_type = get_build_type(job_name);

  switch(build_type) {
    case 'Release':
      return 'release'

    case 'Pull-request':
      return 'pull_request'

    case 'Nightly':
      return 'nightly'

    default:
      return ''
  }
}

def get_branch_name(String job_name) {
  String build_type = get_build_type(job_name);

  switch(build_type) {
    case 'Nightly':
      return 'master'

    default:
      return ''
  }
}

def get_default_herbert_branch(String job_name) {
  String build_type = get_build_type(job_name)

  switch(build_type) {
    case 'Release':
      return ''

    case 'Nightly':
      'None'

    default:
      return 'master'
  }
}


properties([
  parameters([
    string(
      defaultValue: get_branch_name(env.JOB_BASE_NAME),
      description: 'The name of the branch to build.',
      name: 'BRANCH_NAME',
      trim: true
    ),
    string(
      defaultValue: get_default_herbert_branch(env.JOB_BASE_NAME),
      description: 'The name of the branch of Herbert to use.',
      name: 'HERBERT_BRANCH_NAME',
      trim: true
    ),
    string(
      defaultValue: get_matlab_release(env.JOB_BASE_NAME),
      description: 'The release number of the Matlab to load e.g. R2019b.',
      name: 'MATLAB_VERSION',
      trim: true
    ),
    string(
      defaultValue: get_release_type(env.JOB_BASE_NAME),
      description: 'The type of the build e.g. "nightly", "release", "pull_request".',
      name: 'RELEASE_TYPE',
      trim: true
    ),
    string(
      defaultValue: get_agent(env.JOB_BASE_NAME),
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


pipeline {
    agent any

    stages {
      stage('Stage1') {
        steps {
          echo 'Pipelines started'
          echo "${env.BRANCH_NAME}"
        }
      }
    }

    // post {
    //   cleanup {
    //     deleteDir()
    //   }
    // }
}
