#!/bin/bash
APIKEY=${1}
if [ -z "${APIKEY}" ]; then
  echo "API key has to be given in order to make the REST end-point work"
  echo "Usage: source run_security_search_engine.sh <api-key>"
  return
fi
docker-compose up -d --build --force-recreate --renew-anon-volumes postgres
CONFIG_DIR=../security-search-engine/docker-config
get_postgresql_version () {
  local _postgresql_line=`grep "<version.postgresql>" ../security-search-engine/pom.xml`
  echo $_postgresql_line | sed -e 's/<version.postgresql>//' |sed -e 's/<\/version.postgresql>//'
}
POSTGRESQL_VERSION=`get_postgresql_version`
if [ ! -d "${CONFIG_DIR}" ]; then
  mkdir ${CONFIG_DIR}
  wget --directory-prefix=../security-search-engine/docker-config https://jdbc.postgresql.org/download/postgresql-${POSTGRESQL_VERSION}.jar
fi
if [ ! -f "${CONFIG_DIR}/postgresql-${POSTGRESQL_VERSION}.jar" ]; then
  wget --directory-prefix=../security-search-engine/docker-config https://jdbc.postgresql.org/download/postgresql-${POSTGRESQL_VERSION}.jar
fi
cp templates/security-search-engine.standalone.xml ../security-search-engine/docker-config/standalone.xml
sed "s/\${postgresql.version}/"${POSTGRESQL_VERSION}"/" templates/security-search-engine.postgresql.module.xml.template > ../security-search-engine/docker-config/postgresql.module.xml
sed "s/\${apikey}/"${APIKEY}"/" templates/security-search-engine.Dockerfile.template > ../security-search-engine/Dockerfile
sed -i "s/\${postgresql.version}/"${POSTGRESQL_VERSION}"/" ../security-search-engine/Dockerfile
mvn -f ../security-search-engine/pom.xml clean package
docker-compose up -d --build security-search-engine
docker-compose logs -f security-search-engine
