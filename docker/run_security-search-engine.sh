mvn -f ../security-search-engine/pom.xml clean package
sed "s/\${apikey}/"${1}"/" templates/Dockerfile.security-search-engine.template > ../security-search-engine/Dockerfile
docker-compose up -d --build security-search-engine
docker-compose logs -f security-search-engine
