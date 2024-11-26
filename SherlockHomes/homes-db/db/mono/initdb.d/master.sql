CREATE USER 'replicator'@'%' IDENTIFIED WITH mysql_native_password BY 'replicator';
GRANT REPLICATION SLAVE ON *.* TO 'replicator'@'%';
FLUSH PRIVILEGES;