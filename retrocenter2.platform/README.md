# Project for manage emulated game platforms (retro games).

<p>The main purpose of this project is to learn and test development technologies, tools and patterns.</p>

<p>This project use technologies such as:</p>

- [Quarkus](https://quarkus.io/) to develop a RESTFul API.
- [OpenAPI](https://www.openapis.org/) to generate API documentation.

<p>And techniques such as:</p>

- API versioning
- Isolation of business objects so that they are not directly available in the API
- Mapping of business objects to API objects without using external libs

## Requirements

To compile and run these project you will need:

- JDK 11+
- GraalVM with native image support

## Building the application

Launch the Maven build on the checked out sources of this project:

> ./mvnw package

### Live coding with Quarkus

The Maven Quarkus plugin provides a development mode that supports
live coding. To try this out:

> ./mvnw quarkus:dev

This command will leave Quarkus running in the foreground listening on port 8080.

- Visit the Swagger UI endpoint: [http://127.0.0.1:8080/platform/q/swagger-ui/](http://127.0.0.1:8080/platform/q/swagger-ui/).

### Run Quarkus in JVM mode

<p>When you're done iterating in developer mode, you can run the application as a conventional jar file.</p>

<p>First compile it:</p>

> ./mvnw package

<p>Then run it:</p>

> java -jar ./target/quarkus-app/quarkus-run.jar

<p>Have a look at how fast it boots, or measure the total native memory consumption.</p>

### Run Quarkus as a native executable

<p>You can also create a native executable from this application without making any source code changes.</p>
<p>A native executable removes the dependency on the JVM: everything needed to run the application on the target platform is included in the executable, allowing the application to run with minimal resource overhead.</p>

<p>Compiling a native executable takes a bit longer, as GraalVM performs additional steps to remove unnecessary codepaths. Use the  `native` profile to compile a native executable:</p>

> ./mvnw package -Dnative

<p>After getting a cup of coffee, you'll be able to run this executable directly:</p>

> ./target/retrocenter2.platform-1.0.0-SNAPSHOT-runner
