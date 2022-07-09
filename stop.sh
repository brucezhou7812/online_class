#!/bin/bash
PROJECT_NAME="online_class-0.0.1-SNAPSHOT"
ps aux | grep ${PROJECT_NAME} | grep -v "grep" | awk '{print "kill -9 "$2}' | sh
