#!/usr/bin/env groovy

def call (){
    /*not the final code*/
          echo "Checking environmentals"
          sh "printenv | sort"
          env.jobname = "${JOB_NAME}"
          env.jobname = env.jobname.replaceAll('/','-') 
          sh "printenv | sort"
          echo "done"
    }