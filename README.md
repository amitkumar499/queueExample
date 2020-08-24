This project has two key features : 
1. There is a scheduler which emits 5 numbers per second and pushes it into the queue.
2. There is an API exposed which gives sum of elements received in last 5min, 10 min, 30 min


Assumptions: 

1. Returning sum of elements stored in last X minutes
2. There is fixed number of intervals which needs to be returned in response


How TO run : 
-> Clone this project
-> Go inside the project you have cloned
-> Run following command
	 ./mvnw spring-boot:run

-> Hit following Url to get sum of elements generated in last X minutes 
	http://localhost:8080/queue/stats
