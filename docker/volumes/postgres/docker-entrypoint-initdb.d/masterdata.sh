echo "  Creating user and database 'masterdata'"
psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE USER masterdata;
    CREATE DATABASE masterdata;
    GRANT ALL PRIVILEGES ON DATABASE masterdata TO masterdata;
EOSQL
