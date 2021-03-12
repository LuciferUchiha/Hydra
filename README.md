Command to create an installer:
```
jpackage --input build/libs/ \
--name Hydra \
--main-jar Hydra-1.0.jar \
--dest build/packages \
--icon src/main/resources/iconMac.icns \
--type dmg \
```
Meaning of options:

- input: location of the input jar files(s)
- name: give a name to the installable package
- main-jar: JAR file to launch at the start of the application
- main-class: main class name in the JAR to launch at the start of the application. This is optional if the 
  MANIFEST. MF file in the main JAR contains the main class name.
- type: what kind of the installer do we want to create? This depends on the base OS on which we're running the 
jpackage command. On macOS, we can pass package type as DMG or PKG. The tool supports MSI and EXE options on Windows and DEB and RPM options on Linux.
- java-options: options to pass to the Java runtime

The above command will create the JPackageDemoApp.dmg file for us.