#!/bin/bash
TARGET_DIR=../masterdata
mvn -f ${TARGET_DIR}/pom.xml clean package
docker-compose up -d --build masterdata
docker-compose logs -f masterdata
