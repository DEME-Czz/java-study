https://blog.csdn.net/hometing218/article/details/79516686





没有找到OPENSSL报错，

-- Could NOT find OpenSSL, try to set the path to OpenSSL root folder in the system variable OPENSSL_ROOT_DIR (missing: OPENSSL_CRYPTO_LIBRARY OPENSSL_INCLUDE_DIR)
CMake Error at Utilities/cmcurl/CMakeLists.txt:485 (message):
 Could not find OpenSSL. Install an OpenSSL development package or
 configure CMake with -DCMAKE_USE_OPENSSL=OFF to build without OpenSSL.

 **安装  yum -y install openssl-devel**

 ln -s /opt/cmk/cmake-3.19.3/bin/cmake /usr/bin/ 





####  安装Cmake（Linux）

1. 安装所需插件

   yum install -y wget 

   yum install -y gedit

2. 下载cmake安装包 

   wget https://github.com/Kitware/CMake/releases/download/v3.19.3/cmake-3.19.3-Linux-x86_64.tar.gz

3.  解压源码包

   tar zxvf cmake-3.19.3-Linux-x86_64.tar.gz

4. 安装gcc等程序包

   yum install -y gcc-c++

5. 安装cmake,先进入解压后的cmake目录

   cd cmake-3.19.3-Linux-x86_64

   ln -sf /opt/cmk/cmake-3.19.3-Linux-x86_64/bin/* /usr/bin

   cmake --version

6. https://www.cnblogs.com/huizhipeng/archive/2004/01/13/12732019.html