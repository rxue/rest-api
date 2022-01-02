mvn -f ../security-search-engine/pom.xml clean package
docker-compose up -d --build security-search-engine
docker-compose logs -f security-search-engine
