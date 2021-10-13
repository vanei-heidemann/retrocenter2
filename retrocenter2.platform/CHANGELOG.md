# Changelog
<p>The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),</p>
<p>and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).</p>

## Unreleased

## 00001
- <p>Created project structure.</p>

## 00002
- <p>Added JSON-B as JSON parser.</p>
<p>This was done by adding the following code to pom.xml file:</p>

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-resteasy-jsonb</artifactId>
</dependency>
```

## 00003
- <p>Created the initial REST with fake code.</p>

## 00004
- <p>Created CHANGELOG file.</p>

## 00005
- <p>Added OpenAPI documentation.</p>
<p>This was done by adding the following code to pom.xml file:</p>

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-smallrye-openapi</artifactId>
</dependency>
```
- <p>Configured swagger-ui in application.properties.</p>
- <p>Created class <b>OpenAPIDefinitionApplication</b> to define general documentation information.</p>
- <p>Changed return of methods whose types was a List in order to be documented.</p>
- <p>Added OpenAPI documentation to resources and objects.

## 00006
- <p>Isolated business logic in a separated service.</p>
- <p>Created a mapper class with manual copy of values.</p>

## 00007
- <p>Changed setting to use a yaml file.</p>
<p>This was done by adding the following code to pom.xml file:</p>

```xml
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-config-yaml</artifactId>
</dependency>
```
<p>And creating the file <b>src/main/resources/application.yaml</b>.</p>
