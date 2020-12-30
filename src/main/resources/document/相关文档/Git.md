### 第一次上传操作步骤

参考地址：https://www.cnblogs.com/xyfer1018/p/11493718.html

```yml
#初始化库
git init
#把src文件夹提交到远程仓库；src是需要提交到库中的文件
git add -A src
#把代码提交到本地仓库，并备注信息；
git commit -m "首次提交代码"
# 仓库地址：设置远程仓库地址；
git remote add origin +地址
#合并代码
git pull --rebase origin master
#提交代码到远程仓库，master分支；
git push -u origin master
```

#### Git :fatal: refusing to merge unrelated histories解决

git pull origin master --allow-unrelated-histories

#### Git 分支 - 分支的新建与合并

链接：https://git-scm.com/book/zh/v2/Git-%E5%88%86%E6%94%AF-%E5%88%86%E6%94%AF%E7%9A%84%E6%96%B0%E5%BB%BA%E4%B8%8E%E5%90%88%E5%B9%B6



#### Git 相关操作

链接：https://www.cnblogs.com/ydxblog/p/7988317.html