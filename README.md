## SF_AutoCheckIn
[SF轻小说](http://book.sfacg.com/)自动签到脚本

### 功能
- 自动签到
- 签到状态通过[Server酱](https://sc.ftqq.com)推送到微信

### TODO
- 通过账号自动登录

### 食用方法(Linux)
1. 项目通过`Gradle`执行`release`导出jar包（其他方法也可以）
2. 替换`UserInfo.json`中的`Cookie`为你的`Cookie`，`SCKEY`替换为你的[Server酱](https://sc.ftqq.com)的`SCKEY`,之后放在和`SF_AutoCheckIn-1.0-SNAPSHOT.jar`（随版本升级具体版本号会变的哦）同级目录下
3. `cd`到`SF_AutoCheckIn-1.0-SNAPSHOT.jar`目录下执行：
   >`java -jar SF_AutoCheckIn-1.0-SNAPSHOT.jar`   
   - 如果提示发现不了jar包，手动修改jar包中`META-INF/MANIFEST.MF`中的`\ `为 `/`

   测试是否正常运行
4. 在`SF_AutoCheckIn-1.0-SNAPSHOT.jar`同级目录下执行：
   >`vim Run_SF.sh`
   
   输入：
   ```$xslt
   #!/bin/bash
   cd
   source /etc/profile  # 刷新环境变量 否则java环境变量不生效
   cd [path]
   java -jar ./SF_AutoCheckIn-1.2-SNAPSHOT.jar > [path]/SF.log
   ``` 
   保存后执行：
   > chmod +x Run_SF.sh
5. 吧`Run_SF.sh`加入到`linux`系统的`crontab`实现自动签到
    1. 执行
        > crontab -e
    2. 输入：
        ```$xslt
        1 0 * * * [path]/Run_SF.sh
       ```
### 注意事项
次脚本是基于java开发，需要安装java运行环境并配置环境变量