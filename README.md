# sum-prime-numbers
sum prime numbers

### steps
1. mvn archetype:generate -DgroupId=com.example -DartifactId=sum-prime-numbers -DinteractiveMode=false
2. copy spring boot REST prototype app https://github.com/spring-guides/gs-rest-service
3. create one REST endpoint and test for it
4. make a service class responsible for performing calculations
5. implement the prime numbers finding algorithm
6. add one more REST endpoint
7. extend the solution to support the requirement of ten million limit
  1. evaluate performance, optimize algorithm, current result 4s for 1-1m, 5min for 1-10m
  2. make a code to generate and load a pre-calculated table
  3. generate it

I stop the development here. It took about 3.5 hours and looks good to me.

Tomorrow morning I'm going to make two-three more commits not related to service.

Would like to add assertions, javadocs and comments.
