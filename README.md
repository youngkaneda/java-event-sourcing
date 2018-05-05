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

## Future additions

1. use a database to keep the events, and store the ships data.
2. add the CQRS(Command Query Responsibility Segregation) pattern.
3. Transfer all the project to a Docker containers environment
