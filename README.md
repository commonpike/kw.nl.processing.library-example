20181114*pike
# Example Processing 3 Library

Does nothing. Just explains a library structure and is a working example.

This README is best read at 
https://github.com/commonpike/nl.kw.processing.library-example

## Location

This whole folder should go into your "sketchbook location",
also sometimes called the "processing library directory".
You can find its location in the Processing app, in the menu,
under preferences. It's usually in your homedir somewhere.

## Folder structure

If the Library folder is called `ExampleFooLibrary`
 - it must contain a folder `ExampleFooLibrary/library`
 - it must contain a file `ExampleFooLibrary/library.properties`
 - it must contain a file `ExampleFooLibrary/library/ExampleFooLibrary.jar`

If it has these things, and it is in the right location,
you can see it in your Processing app under Sketch > Import Library

This is all that is required to work. But according to the 
guidelines, this folder should also contain

 - `ExampleFooLibrary/reference/` - documentation in HTML format as generated from Javadoc
 - `ExampleFooLibrary/examples/`  - a set of example sketches 
 - `ExampleFooLibrary/src/` - java source

The folder may contain other unrelated things.

 - ExampleFooLibrary/bin  is not required;
 - ExampleFooLibrary/build is not required;
 - ExampleFooLibrary/dist is not required;
 - ExampleFooLibrary/README.md is not required.
 
See also:
https://github.com/processing/processing/wiki/Library-Guidelines


## Import logic

You will notice this library only contains
one jar file, the `./library/ExampleFooLibrary.jar`. 
That jar only contains one java package, the `nl.kw.processing.ExampleBazPackage`.
That package contains two classes, `ExampleBar` and `ExampleQuz`.

If you 'import' the library in the Processing app, all 
it does is write 

`import nl.kw.processing.ExampleBazPackage.*`

in your code. And when you run your code, when compiling,
it tries to read the classes from the jar file in the library folder.

In the jar file, there could be more packages (?). 
Importing it would then cause more import statements
to be added to your code, that's all.

In the library folder, there could also be more jar files. 
For these files, import statements will not be written automatically.
Only the jar file with the exact same name as the library
gets imported automagically.



See also:
https://github.com/processing/processing/wiki/Library-Basics
https://processing.org/tutorials/eclipse/

## Compiling 

Most people will use some IDE like eclipse to generate
the required jar file. But the hard way is

- write *.java files like the ones in ./src, using vi ofcourse :-)
- compile the .java files to .class files 
- zip the .class files to a .jar  

```

cd src
vi ExampleBar.java
vi folder/foo/whatever/ExampleQuz.java
cd ../

javac -d build/ -classpath /path/to/processing/core.jar \
 ./src/*.java ./src/folder/foo/whatever/*java

jar -cf library/ExampleFooLibrary.jar -C build/ .
  
  
```

or just take a look at `bin/compile.sh` in this repo,
for linux and mac users.

## Problems 

If you have problems compiling, you may be using the wrong java
version (JRE or JDK). Check what `java -version` and `javac -version` say.

If your code came from a sketch, and during compiling you get errors like 
``error: cannot find symbol (...) createShape``
remember your code is not part of a PApplet anymore. 
`createShape` is now `processing.core.PApplet.createShape()`
But createShape() is not a  static method and needs a PApplet
to work. So you'll have to rewrite your code.

`random()` and `noise()` are also not static functions on PApplet, 
and don't belong to java.lang.Math either. You'll have to rewrite
them.

Also remember, `color` is not a java type. Rewrite it to `int`.

Also a lot of math functions like `abs()`, `floor()` etc. can
be rewritten to `Math.abs()`, `Math.floor()`. 


