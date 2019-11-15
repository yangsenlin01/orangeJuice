# 部署服务器步骤(docker方式)

### 启动mysql
* docker下载mysql镜像，使用如下启动命令
* docker run -d -p 3307:3306 --name oj_mysql -e MYSQL_ROOT_PASSWORD=orange_juice -e MYSQL_ROOT_HOST=% mysql:5.7

### 启动nginx
* docker下载nginx镜像，使用如下命令启动
*

### 打包项目
* 项目根目录新建Dockerfile
* 使用如下命令启动
*