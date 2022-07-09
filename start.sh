#!/usr/bin/bash
set -e
set -o pipefail

PROJECT_NAME="online_class"
nohup java -jar ${PROJECT_NAME}.jar >${PROJECT_NAME}.log&
start_ok=false
if [[ $? = 0 ]];then
  sleep 3
  tail -n 10 ${PROJECT_NAME}.log
  sleep 5
  tail -n 50 ${PROJECT_NAME}.log
fi
aaa=`grep "Started" ${PROJECT_NAME}.log | awk '{print $1}'`
if [[ -n "${aaa}" ]]; then
  echo "app started ok"
  exit 0
else
  echo "app started failed"
  exit 1
fi
