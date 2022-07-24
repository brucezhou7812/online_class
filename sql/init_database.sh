#!/bin/bash
source /etc/profile
export MYSQL_PWD="Buptzw&812"
echo "connect mysql!"
echo "initialize database"
mysql -hlocalhost -uroot <<EOF
source init_db.sql;
EOF
echo "success to create database and tables"




