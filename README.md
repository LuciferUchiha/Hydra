# Hydra
![Gradle build workflow](https://github.com/LuciferUchiha/Hydra/actions/workflows/main.yml/badge.svg)

## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
* [Prerequisites](#prerequisites)
* [Installation](#installation)
* [Usage](#usage)
  * [Run Locally](#run-locally)
  * [Close Application](#close-application)
  * [Build JAR](#build-jar)
  * [Build DMG package for macOS](#build-dmg-package-for-macos)
  * [Build MSI package for Windows](#build-msi-package-for-windows)
* [License](#license)
* [Contribute](#contribute)

## About The Project

This Project was just a small project to get to know the JPackage Tool  and see if I can build a JavaFx 
application and then turn it into a DMG (macOS) and MSI (Windows) package.

So that I can build a JAR that then gets built into the installable package I used Gradle. Gradle also manages my 
dependencies, like JavaFx for me.

Why do I want to do this? JPackage allows developers to create an installable package for their JAR files. The 
user doesn't have to explicitly copy the JAR file or even install Java to run the application. The installable package takes care of all of this.

### Built With
* [Java15](https://openjdk.java.net/projects/jdk/15/)
* [JavaFx11+](https://openjfx.io/index.html)
* [Junit5](https://junit.org/junit5/docs/current/user-guide/)
* [JPackage](https://docs.oracle.com/en/java/javase/14/jpackage/packaging-overview.html#GUID-C1027043-587D-418D-8188-EF8F44A4C06A)
* [Gradle](https://gradle.org/)
* [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Prerequisites
- Git
- JDK version 15 (I have openjdk)
- Gradle

## Installation

Clone the project and open it in your IDEA.
``` 
git clone https://github.com/LuciferUchiha/Hydra.git
```

## Usage:
### Run locally
Execute the gradle run task in the root folder of the project.
``` 
gradle run
```

### Run JUnit5 test
Execute the gradle run task in the root folder of the project.
``` 
gradle test
```

### Close application
On Windows you can close the application with the Task Manager.
On macOS, you can close the application with the Activity Monitor.

### Build JAR
Execute the gradle jar task in the root folder of the project.
``` 
gradle clean jar
```

### Build DMG package for macOS
To create a DMG package run the following command in the root of the project:
```
jpackage --input build/libs/ \
--name Hydra \
--main-jar Hydra-1.0.jar \
--dest build/packages \
--icon src/main/resources/luciferUchihaIcon.icns \
--type dmg \
```
Meaning of options:

- input: Location of the input JAR file
- name:Name for the installable package
- main-jar: JAR file to launch at the start of the application
- dest: Location where the package will be saved.
- icon: Location of the picture that we want the executable to have.
- type: What kind of installer do we want to create? This depends on the base OS on which we're running the 
  jpackage command. On macOS, we can pass package type as DMG or PKG. The tool supports MSI and EXE options on Windows and DEB and RPM options on Linux.

The above command will create the Hydra-1.0.dmg file for us.

### Build MSI package for Windows
To create a MSI package run the following command in the root of the project:
```
jpackage --input build/libs/ --name Hydra --main-jar Hydra-1.0.jar --dest build/packages --icon src/main/resources/luciferUchihaIcon.ico --type msi
```

If you don't already have WIX toolset you will prompted to install the toolset from https://wixtoolset.org/.

Meaning of options:

- input: Location of the input JAR file
- name:Name for the installable package
- main-jar: JAR file to launch at the start of the application
- dest: Location where the package will be saved.
- icon: Location of the picture that we want the executable to have.
- type: What kind of installer do we want to create? This depends on the base OS on which we're running the
  jpackage command. On macOS, we can pass package type as DMG or PKG. The tool supports MSI and EXE options on Windows and DEB and RPM options on Linux.

The above command will create the Hydra-1.0.msi file for us. If you run the installer and install the application 
you will find it under `Program Files/Hydra`.


## License
Distributed under the MIT License. See `LICENSE.md` for more information.

## Contribute
If you wish to contribute, see `CONTRIBUTING.md` for more information.
