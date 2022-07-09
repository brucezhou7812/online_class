#!/usr/bin/bash
sudo su
source /etc/profile
echo "connect mysql!"
mysql -hlocalhost -uroot -pBuptzw&812
if [[ $? = 0 ]];then
  echo "success to connect mysql."
else
  echo "fail to connect mysql."
  exit 1
fi

echo "execute create_db.sql"
mysql -e "create_db.sql"
if [[ $? = 0 ]];then
  echo "success to execute create_db.sql"
else
  echo "fail to execute create_db.sql"
  exit 1
fi

echo "execute user.sql"
mysql -e "user.sql"
if [[ $? = 0 ]];then
  echo "success to execute user.sql"
else
  echo "fail to execute user.sql"
fi

echo "execute video.sql"
mysql -e "video.sql"
if [[ $? = 0 ]];then
  echo "success to execute video.sql"
else
  echo "fail to execute video.sql"
fi

echo "execute episode.sql"
mysql -e "episode.sql"
if [[ $? = 0 ]];then
  echo "success to execute episode.sql"
else
  echo "fail to execute episode.sql"
fi

echo "execute chapter.sql"
mysql -e "chapter.sql"
if [[ $? = 0 ]];then
  echo "success to execute chapter.sql"
else
  echo "fail to execute chapter.sql"
fi

echo "execute video_banner.sql"
mysql -e "video_banner.sql"
if [[ $? = 0 ]];then
  echo "success to execute video_banner.sql"
else
  echo "fail to execute video_banner.sql"
fi

echo "execute video_order.sql"
mysql -e "video_order.sql"
if [[ $? = 0 ]];then
  echo "success to execute video_order.sql"
else
  echo "fail to execute video_order.sql"
fi




