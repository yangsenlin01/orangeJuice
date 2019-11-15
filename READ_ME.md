# 部署服务器步骤(docker方式)

### 启动mysql
* docker下载mysql镜像，使用如下启动命令
* docker run -d -p 3307:3306 --name oj_mysql -e MYSQL_ROOT_PASSWORD=orange_juice -e MYSQL_ROOT_HOST=% mysql:5.7

### 启动nginx
* docker下载nginx镜像，使用如下命令启动
*

### 打包项目
* oj下的配置改为对应服务器的配置(mysql的三个配置，oj自定义路径配置)
* 项目根目录新建Dockerfile(内容如该文件所示)
* 使用如下命令构建镜像(-t 是为构建的镜像打标签,别忘了最后的 "." )
* docker build -t oj_server:1.0 .
* 使用如下命令启动(使用--net=host，可以直接使用localhost:3307连接mysql)
* docker run --net=host -d -p 8080:8080 -v /dockerDir/orangeJuice/images:/dockerDir/orangeJuice/images --name oj_server oj_server:1.0