# Documentation demo

This is a very basic CRUD API used to showcase some features of Docass.

## Usage

### View functional documentation

The latest functional documentation related to this application is here: http://furydocs.io/demo-bootcamp-doc-service/guide/

### View API Specs

Check http://furydocs.io/demo-bootcamp-doc-service/specs/

## How to edit the existing documentation

That's easy!

1.  Get the application

    ```
    fury get demo-bootcamp-doc-service
    ```
2. Enter the newly created directory and go to the docs root

   ```
   cd demo-bootcamp-doc-service/docs/
    ```

3. Edit the files at will

    * If you want to edit the functional documentation, the files are in the `guide` directory
    ```
    cd guide
    vim <some file>
    ```

    * in case you are interested in the API specs, the json file is in the `specs` directory
    ```
   cd specs
   vim swagger.json
    ``` 
4. Commit the changes and create a version:

   You can create a version by opening a PR and commenting `rp build test` or using fury cli's `fury create-version <version>` command.

5. Review the documentation

   Go to <URL> and confirm that everything is as expected

6. Promote!

   When you are ok with the changes and you are ready to show the latest documentation to the world, go to:

   ```
   https://web.furycloud.io/demo-bootcamp-doc-service/documentation
   ```  

   Find the row corresponding to the relevant version and hit `Promote`

   <image>

#### Bonus!

This application uses `springdoc` plugin to automatically create the json spec file for us **on demand** (meaning, we need to execute the maven goal manually).

You just need to run:

```bash
SCOPE=local mvn compile spring-boot:start springdoc-openapi:generate spring-boot:stop
```

Or run the `generate_swagger.sh` file in the root of this repository

#### Customization

SpringDoc's generated json is highly customizable. Please refer to the configuration file in `/src/main/java/com/mercadolibre/demo/config/SpringDocConfig.java`

## Questions

This readme is enough for most people, but if you still have questions, feel free to contact me via slack or email.