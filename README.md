# Preserving design patterns

## Configuration
1. Place library JAR file in resources directory
```
mv pattern-annotation-processor.jar src/main/resources/
```
2. Add library to your local Maven repository via command:
```
mvn install:install-file -Dfile=<project_location>/src/main/resources/pattern-annotation-processor.jar -DgroupId=processor -DartifactId=processor -Dversion=1.0 -Dpackaging=jar
```
3. Add Maven dependency like this to `pom.xml` file:
```
<dependency>
   <groupId>processor</groupId>
   <artifactId>processor</artifactId>
   <version>1.0</version>
</dependency>
```
4. Create a file that runs custom annotation processor as a service provider.
```
echo 'processor.PatternAnnotationProcessor' > src/main/resources/META-INF/services/javax.annotation.processing.Processor
```

## Library structure
Directory `processor` contains:
- a directory for each of the 23 design patterns listed by GoF, each of which contains:
   - declaration of a set of annotations regarding the pattern
   - processor that checks the dependencies between annotations
- the `utils` directory containing helper functions used by all processors
- class `PatternAnnotationProcessor`, implementing the interface `javax.annotation.processing.Processor`
- interface `PatternProcessorInterface`, on which all minor single-pattern processors are based

For each of the above-mentioned classes, not only a .class file but also a .java file is included 
to make using the library easier.
