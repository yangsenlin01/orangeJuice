# 部署服务器步骤(docker方式)
### 配置服务器
* 服务器中创建目录
* /dockerDir/orangeJuice/nginx/conf
* /dockerDir/orangeJuice/images

### 启动mysql
* docker下载mysql镜像，使用如下启动命令
* docker run -d -p 3307:3306 --name oj_mysql -e MYSQL_ROOT_PASSWORD=orange_juice -e MYSQL_ROOT_HOST=% mysql:5.7

### 启动nginx
* docker下载nginx镜像，默认下载latest版本：
* docker search nginx
* docker pull nginx
* 使用nginx默认的配置来启动一个nginx容器：
* docker run -d -p 8081:80 --name nginx nginx:latest
* 拷贝容器内nginx默认配置文件到本地nginx的conf目录：
* docker cp nginx:/etc/nginx/conf.d/default.conf /dockerDir/orangeJuice/nginx/conf
* 修改default.conf，为了做静态文件(图片)浏览
* location / {
        root   /usr/share/nginx/html;
        index  index.html index.htm;
    }
* 改为：
* location / {
      root   /home/userfile/;
      index  index.html index.htm;
    }
* 停止nginx容器 和 删除容器
* docker stop nginx 和 docker rm nginx
* 重新创建并运行容器(挂载nginx配置文件和图片地址)
* docker run -d -p 8081:80 --name nginx -v /dockerDir/orangeJuice/nginx/conf/default.conf:/etc/nginx/conf.d/default.conf -v /dockerDir/orangeJuice/images/:/home/userfile/ --restart=always nginx:latest

### 打包项目
* oj下的配置改为对应服务器的配置(mysql的三个配置，oj自定义路径配置)
* /dockerDir/orangeJuice下新建Dockerfile文件(参考根目录Dockerfile)
* 将jar包上传至/dockerDir/orangeJuice下
* 使用如下命令构建镜像(-t 是为构建的镜像打标签,别忘了最后的 "." )
* docker build -t oj_server:1.0 .
* 使用如下命令启动(使用--net=host，可以直接使用localhost:3307连接mysql)
* docker run --net=host -d -p 8080:8080 -v /dockerDir/orangeJuice/images/:/dockerDir/orangeJuice/images/ --name oj_server oj_server:1.0