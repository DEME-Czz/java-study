## docker相关操作



### 相关文章链接

虚拟机创建及其linux安装：https://www.cnblogs.com/xyinjie/p/9437049.html

linux网络配置：https://www.cnblogs.com/baichuanhuihai/p/8127329.html

linux配置开放端口：https://www.cnblogs.com/huajuanloveyou/articles/10765637.html

官方加速说明网页：https://docker-cn.com/registry-mirrorr

docker 映射开放端口时如果出现一下错误：

```yml
/usr/bin/docker-current: Error response from daemon: driver failed programming external connectivity on endpoint eloquent_goldwasser (7eec791ab332a3e1f4ff1762d4b402ff01cc5fc5455a80d29cb325388c843d92):  (iptables failed: iptables --wait -t nat -A DOCKER -p tcp -d 0/0 --dport 8088 -j DNAT --to-destination 172.17.0.2:8080 ! -i docker0: iptables: No chain/target/match by that name.
```

执行一下命令

```linux
# pkill docker
//如果没有iptables 教程https://www.cnblogs.com/huajuanloveyou/articles/10765637.html
# iptables -t nat -F
//如果没有ifconfig 执行yum install -y net-tools
# ifconfig docker0 down
//如果没有brctl 执行yum install bridge-utils
# brctl delbr docker0
# service docker restart
```

