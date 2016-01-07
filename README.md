# lgw-study  
Some practices for myself  
李国威-somewhater  
Foresee  
Email：guowei400@gmail.com  
QQ：2720437459  
Blog：http://cnblogs.com/somewhater  
@自定义控件
#adb命令中添加csv文件到SQLite
1:进入adb shell:
命令行执行 adb shell
2:进入Android文件中应用程序的安装目录
cd /data/data/com.lgw.coolweather/databases
3:sqlite3操作数据库
4:sqlite3 ChinaCities.db
5:csv文件用邮件记事本打开，另存为UTF-8编码格式，保存覆盖源文件
6：执行.show 命令 查看当前分隔符：sepatator 默认为！这里为了导入csv文件到数据库，修改为逗号：，
命令：.separator ","
7:执行导入命令
.import /data/data/com.lgw.coolweather/databases/areaid_v.csv City
City是表名，数据库名称要区分大小写，否则找不到目标数据库会创建新的数据库。
8:执行查询语句
select * from city
这里会显示乱码，不过没关系，用SQlite Expert 打开显示的就不是乱码了，这里要提一下第五点，作用在这里
9:顺便学了一下VIM编辑器的试用，shift+A是讲光标移动到行尾并编辑。
