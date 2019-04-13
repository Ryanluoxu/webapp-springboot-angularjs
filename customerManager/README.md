
# DB
cd /d h:\PostgreSQL\pg11\bin>
psql -U postgres
jr
create database customermanager;
CREATE USER customermanager WITH PASSWORD 'customermanager';
GRANT ALL PRIVILEGES ON database customermanager TO customermanager;
insert into user_info values (99999, '2019-02-15' , 'admin','active','admin','ADMIN');

# Entity
## application.properties
## persistence.xml
## entity class
## JpaUtil.java
run and get DB




# credential
admin/admin $2a$10$Xvc3mb78r6/MSZKuQfG89e0KP416xmhADre4ov8vscwC5LgDlQR8u
ryan/luoxu
user/user


