# Rest API for Search for security (stock shares) data
 
## Request Examples

* `curl --data '{"code":"BABA", "name":"Alibaba","headquarter":"CN"}' -X POST -H "Content-Type: application/json" http://localhost:8082/security-search-engine/rest/company`

* `curl -X GET -H "Content-Type: application/json" http://localhost:8082/security-search-engine/rest/company/FORTUM`

