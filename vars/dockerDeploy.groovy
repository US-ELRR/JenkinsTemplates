#!/usr/bin/env groovy

def call (){
    /*not the final code*/
    def gostr = "ssh -i ${env.PemFile} ${env.REMOTE_USER}@${env.REMOTE_HOST}"+' "chmod +x deploy.sh"'
    def stopstr = "ssh -i ${env.PemFile} ${env.REMOTE_USER}@${env.REMOTE_HOST}"+' "sudo snap restart docker"'
    sh stopstr 
    sh "scp -i ${env.PemFile} deploy.sh ${env.REMOTE_USER}@${env.REMOTE_HOST}:~/"
    sh gostr
    sh "ssh -i ${env.PemFile} ${env.REMOTE_USER}@${env.REMOTE_HOST} ./deploy.sh"
}
