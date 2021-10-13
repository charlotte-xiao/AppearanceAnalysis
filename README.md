## 项目说明

本项目是基于SpringBoot写的一个颜值分析小页面。

- 主要技术包括：SpringBoot，阿里云OSS，策略模式+模版方法，接入Faceplusplus(旷视)第三方接口.

- 完成时间：适合自己在小假期（2-3天）来倒腾完成。

先让我们来看看如何使用运行效果趴。

## 使用介绍

1. 申请Faceplusplus(旷视)的apiKey 和 apiSecret：

   - 官网地址：`https://www.faceplusplus.com.cn/`

2. 完成application.yml文件配置信息填写：

   - 图片上传可以为本地上传，也可以使用阿里云的OSS上传到阿里云服务器上。
   - 服务器地址如果需要发布到公网上，必须添加SSL证书，使用HTTPS协议才能正常运行，最好使用nginx进行转化为佳
   - 若没有域名，或没有SSL证书，只能本地运行，本地服务器地址url填写:`http://127.0.0.1:你的端口`即可

   ```
   # 服务器
   server:
     port: 9000
   
   # 上传策略
   upload:
     # 模式：local或者oss
     mode: local
     local:
       # 本地服务器地址
       url: https://xxxx/
       # 前缀路径
       path: images/
       # 映射路径
       mapPath: /images/**
       # 真实路径
       realPath: ./images/
     oss:
       # oss地址
       url: https://xxxx/
       # 前缀路径
       path: mirror/
       endpoint: https://oss-cn-hangzhou.aliyuncs.com
       accessKeyId: xxxx
       accessKeySecret: xxxx
       bucketName: xxxx
   # 人脸识别
   predict:
     face:
       url: https://api-cn.faceplusplus.com/facepp/v3/detect
       # Faceplusplus(旷视)的apiKey
       apiKey: xxxx
       # Faceplusplus(旷视)的apiSecret
       apiSecret: xxxx
   ```

3. 使用maven工具将项目打成jar包，并运行：

   - 打包好的文件`mirror-0.0.1.jar`
   - 运行： `java -jar mirror-0.0.1.jar`

4. 使用nginx作为转发配置SSL到公网上,配置文件如下：(本地运行可略)

   ```nginx
    events {
        worker_connections  1024;
    }
    
    http {
        include       mime.types;
        default_type  application/octet-stream;
        sendfile        on;
        keepalive_timeout  65;
    
        gzip on;
        gzip_min_length  1k;
        gzip_buffers     4 16k;
        gzip_comp_level  4;
        gzip_types       text/plain application/x-javascript text/css application/xml text/javascript application/x-httpd-php image/jpeg image/gif image/png;
        gzip_vary on;
    
        server {
            listen       443    ssl;
            ssl_certificate      SSL pem文件位置; 
            ssl_certificate_key  SSL key文件位置;
            server_name  域名名;
         
            location / {        
                proxy_pass http://127.0.0.1:9000/;
                proxy_set_header   Host             $host;
                proxy_set_header   X-Real-IP        $remote_addr;                       
                proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;
            }        
        }
    }
   ```

## 运行效果

> 前端页面：

公网：`https://域名:端口`

本地：`http://127.0.0.1:端口`

PS：也可以通过后台生成链接

![p1](https://github.com/charlotte-xiao/mirror/blob/main/images/p1.png)

![p2](https://github.com/charlotte-xiao/mirror/blob/main/images/p2.jpg)

![p3](https://github.com/charlotte-xiao/mirror/blob/main/images/p3.png)

> 管理控制台页面

公网：`https://域名:端口/admin.html`

本地：`http://127.0.0.1:端口/admin.html`

1. 身份验证(该部分代码见：cn.xiaostudy.constant.AuthCode)

   - 默认账号：root
   - 默认密码：mirror

   ![p4](https://github.com/charlotte-xiao/mirror/blob/main/images/p4.png)

2. 生成链接：通过该链接进行人脸分析的图片，可以通过该ID查看到

   ![p5](https://github.com/charlotte-xiao/mirror/blob/main/images/p5.png)

3. 查看人脸分析的图片-- 在链接标识处输入以下两种内容，点击查看图片：
   - ID：数字 --- `对应ID数字的图片`
   - TOKEN：默认为`charlottexiao` --`查看所有图片` (该部分代码见：cn.xiaostudy.constant.AuthCode)

![p6](https://github.com/charlotte-xiao/mirror/blob/main/images/p6.png)

## 说到最后

本项目仅供学习使用，需要进行学习交流可在我的主页中找到联系方式联系我。

此外，请勿用于作为违法的事情或者其他用途使用，出现任何问题，本人概不负责。
