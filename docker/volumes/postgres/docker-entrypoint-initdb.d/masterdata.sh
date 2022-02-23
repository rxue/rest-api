create_single_db () {
  local _db_name=${1}
  echo "Creating database ${_db_name}"
  psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL
    CREATE DATABASE ${_db_name};
EOSQL
}
db_names=("masterdata" "security")
for db_name in ${db_names[@]}; do
  create_single_db ${db_name}
done
