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
