20181114*pike
# Example Processing 3 Library
Does nothing, just the structure

## Location

This whole folder should go into your "sketchbook location",
also sometimes called the "processing library directory".
You can find it's location in the Processing app, under preferences.
It's usually in your homedir somewhere.

## Folder structure

If the Library folder is called ExampleFooLibrary
 - it must contains a folder 'library'
 - which must contain a file ExampleFooLibrary.jar
 - it must(?) contain a file library.properties

It contain lots of unrelated things.

The 'build' folder in this dir is not required.

This 'README.txt' is not required.

## Import logic

You will notice this ExampleFooLibrary only contains
one jar file, the ./library/ExampleFooLibrary.jar. 
This only contains one package, the `ExampleBazPackage`.
If you 'import' the library in the Processing app, all 
it does is write 

`import ExampleBazPackage.*`

in the code.

In the jar file, there could be more packages (?). 
Importing it would then cause more import statements
to be added to your code, that's all.

In the library folder, there could also be more jar files. 
For these files, import statements will not be written automatically.
Only the jar file with the exact same name as the library
gets imported automagically.

See also:
https://github.com/processing/processing/wiki/Library-Basics

## Compiling 

Most people will use some IDE like eclipse to generate
the required jar file. But the hard way is

- write *.java files like the ones in ./source, using vi ofcourse:-)
- compile the .java files to .class files 
- zip the .class files to a .jar  

```

cd build/source
vi ExampleBar.java
vi ExampleQuz.java
cd ../compiled

javac -d . -classpath /path/to/processing/core.jar ../source/*.java
  
jar -cf ../../library/ExampleFooLibrary.jar .
  
  
```

