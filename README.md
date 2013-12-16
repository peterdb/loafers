Loafers
=======

Loafers is all about writing windowing applications. It differs from the other windowing toolkits by its simple syntax. Loafers is heavily inspired by Shoes.

Usage
----
```groovy
import loafers.Loafers

Loafers.app {
    button "push me", {
        alert "You pushed me"
    }
}
```

Read why Loafers is for you, see more examples?, learn how to write? an application, or get started right away!

Build
----
Faker uses [Maven](http://maven.apache.org/download.html "Maven").

    mvn clean install

Contributing
----
If you'd like to contribute code or formats/data for another locale, fork the project at github, make your changes, then send a pull request.

This project uses the following technologies:
- [Groovy](http://groovy.codehaus.org/ "Groovy"): programming language
- [Maven](http://maven.apache.org/download.html "Maven"): build tool
- [Spock](https://code.google.com/p/spock/ "Spock"): testing

If you make changes, please include a Spock test.

License
----
This code is free to use under the terms of the MIT license.
