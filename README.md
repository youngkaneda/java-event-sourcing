# Event Sourcing Example :coffee:

This is a simple in-memory java implementation of Martin Fowler Ship Tracking example, that was used in [this article](https://martinfowler.com/eaaDev/EventSourcing.html).

## How run this project

```
// clone this repository
git clone https://github.com/juanpablolvl99/java-event-sourcing-example <name_dir>
cd <name_dir>
mvn clean compile
java -cp target/classes/ es.example.Loader
// and the logs will be printed
```

This project use a message broker to share the events that happen and propagate them to the read database, to make it more easy to configure, was used a docker container to run a [ActiveMQ](http://activemq.apache.org/) broker.

The respective dockerfile used can be found in [this](https://github.com/juanpablolvl99/alpine-activemq-dockerfile) link.


## Future additions

1. Transfer all the project to a Docker containers environment
