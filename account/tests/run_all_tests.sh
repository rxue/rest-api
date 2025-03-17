source ../generate_keypair.sh ../src/main/resources/httpscert.p12
mvn --file ../pom.xml clean verify
mvn --file ../pom.xml spring-boot:run &
sleep 8
npm install
npm test
ps aux |grep spring-boot |awk '{print $2}' |xargs kill
