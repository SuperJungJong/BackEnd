CHANGE MASTER TO
    MASTER_HOST='192.168.160.2',
    MASTER_USER='replicator',
    MASTER_PASSWORD='replicator',
    MASTER_LOG_FILE='mysql-bin.000003',
    MASTER_LOG_POS=157,
    GET_MASTER_PUBLIC_KEY=1;
START SLAVE;