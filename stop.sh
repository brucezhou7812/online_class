#!/usr/bin/bash
PROJECT_NAME="online_class"
ps aux | grep ${PROJECT_NAME} | grep -v "grep" | awk '{print "kill -9 "$2}' | sh
