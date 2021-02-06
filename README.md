# gs-mysql
Sample SpringBoot with MySQL integration

## Command for connecting to database and creating a table
``` bash
mysql> create database db_example; -- Create the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all the privileges to the new user on the newly created database
```