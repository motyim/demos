# ACTIVE MQ STANDALONE WITH SPRING BOOT

this is a simple demo on standalone ActiveMQ Server integrated 
with spring boot .

consist of :
   * JmsConfing : create configeration bean to connect with ActiveMQ
   * Producer : which create message and push it to queue
   * Consumer : which listen to each message on queue and print it into console
   
### Prerequisites
* install activeMQ on your machine 

### Installing

change activemq.broker-url to your activeMQ URL in application.properties file


```
activemq.broker-url=tcp://localhost:61616
```

## Running the tests

run project and
go to this url follow with any message 

```
http://localhost:8080/rest/publish/welcomeJMS
```

## Authors

* **Mohamed MotYim** - [MotYim](https://github.com/motyim)
