# Marvel API RESTful Consumer

This project is a RESTful API consumer for the Marvel API, fetching data from the Marvel API and exposing it through its own API.

## Usage of the JAR File

To use the JAR file, follow these steps:

1. Download the JAR file from the release section.
2. Run the JAR file using the following command:

    ```shell
    java -jar target/marvel-api-consumer-0.0.1-SNAPSHOT.jar
    ```

## Building the Project

Follow these steps to build the project:

1. Clone the repository.
2. Run the following command in the root directory of the project:

    ```shell
    mvn clean install
    ```

3. The JAR file will be generated in the `target` directory.
4. Follow the steps mentioned in the "Usage of the JAR File" section to run the JAR file.

## Calling the API

When the JAR is running, you can call the following endpoints using Postman:

1. `http://localhost:8080/characters`
2. `http://localhost:8080/characters/{characterId}`

## Important

When creating a JAR file, ensure the configuration in your `pom.xml` is set to generate the JAR file as a library dependency rather than an executable JAR. This is crucial to avoid issues when using the JAR in another project.

To generate the JAR file as a library dependency, follow these steps:

1. Ensure your `pom.xml` is correctly configured.
2. Generate the JAR file with the following command:

    ```shell
    mvn clean install
    ```

3. Install the generated JAR file in your local Maven repository with the following command:

    ```shell
    mvn install:install-file -Dfile=target/marvel-api-consumer-0.0.1-SNAPSHOT.jar -DgroupId=com.marvel.demo -DartifactId=marvel-api-consumer -Dversion=1.0.0 -Dpackaging=jar
    ```

4. To use the JAR file in another project, add the following dependency to your `pom.xml` file:

    ```xml
    <dependency>
        <groupId>com.marvel.demo</groupId>
        <artifactId>marvel-api-consumer</artifactId>
        <version>1.0.0</version>
    </dependency>
    ```

## Author

- **Starling Diaz**
    - [Website](http://starlingdiaz.com)
    - [GitHub](https://github.com/NSTLRD)
    - [Email](mailto:starlingdiaz70@gmail.com)

For more information, feel free to contact me through my website or email.