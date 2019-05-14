20181114*pike
# Example Processing 3 Library

This does nothing. Just explains a library structure and is a working example.

This README is best read at 
https://github.com/commonpike/nl.kw.processing.library-example

You can download a distribution at 
https://commonpike.github.io/nl.kw.processing.library-example/dist/ExampleFooLibrary.zip

The distribution does not include everything inside the git repo,
like the source files, because of the publishing guidelines.

There is also a summary at 
https://commonpike.github.io/nl.kw.processing.library-example/docs/summary.html

## Install location

This whole folder should go into your "sketchbook location",
also sometimes called the "processing library directory".
You can find its location in the Processing app, in the menu,
under preferences. It's usually in your homedir somewhere.

This whole folder should be called ‘ExampleFooLibrary’.
If you cloned it from GIT, rename it.

## Folder structure

If the Library folder is called `ExampleFooLibrary`, the
following files, with those exact names, are required:

 - it must contain a folder `ExampleFooLibrary/library`
 - it must contain a file `ExampleFooLibrary/library.properties`
 - it must contain a file `ExampleFooLibrary/library/ExampleFooLibrary.jar`


This is all that is required to get it to work. 
If it has these things, and it is in the right location,
you can see it in your Processing app under Sketch > Import Library


The folder may also contain other things, as this
one does. Some are related to _publishing_ the library 
(read more below). Some are folders I personally use to 
_compile_ the java code on the spot or keep some public
stuff. You can delete all that, and it will still work.

## Import logic

You will notice this library only contains
one jar file, the `./library/ExampleFooLibrary.jar`. 
The jar contains two java classes, `ExampleBar` and `ExampleQuz`.
Both belong to the same java package, `nl.kw.processing.ExampleBazPackage`.

If you 'import' the library in the Processing app, all 
it does is write 

`import nl.kw.processing.ExampleBazPackage.*`

in your code. And when you run your code, when compiling,
it tries to read the classes from the jar file in the library folder.

Notice how activating the ExampleFooLibrary imports the 
ExampleBazPackage, and consider why it does that…

In the jar file, there could be more packages (?). 
Importing it would then cause more import statements
to be added to your code, that's all.

In the library folder, there could also be more jar files. 
For these files, import statements will _not_ be written automatically.
Only the jar file with the exact same name as the library
gets imported automagically when you ‘activate’ the library.



See also:
https://github.com/processing/processing/wiki/Library-Basics

See also:
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

## Compile problems 

If you have problems compiling, you may be using the wrong java
version (JRE or JDK). Check what `java -version` and `javac -version` say.

If your code came from a sketch, and during compiling you get errors like 
``error: cannot find symbol (...) createShape``
remember your code is not part of a PApplet anymore. 
`createShape` is now knwon as `processing.core.PApplet.createShape()`;
but since that is not a  static method it needs a PApplet
to work. You will have to rewrite your code.

Also a lot of math functions like `abs()`, `floor()` etc. can
be rewritten to `Math.abs()`, `Math.floor()`. 

But Processings `random()` and `noise()` don't belong to 
java.lang.Math. You'll have to rewrite them.

Also remember, `color` is not a java type. Rewrite it to `int`.

All this rewriting is done in the PDE by the _PDE Precompiler_,
but now you'll have to do it by hand. 

## Publishing

### naming conventions

According to guidelines, your libraries should adhere
to some naming rules:


  - Libraries, or classes inside them, should not be prefixed with "P" 
  - Same goes for using "Processing", "Pro", or "P5" 
  - The same goes for suffixes
  - Don't use ``processing`` as the prefix for your library packages

### folder structure
  
As mentioned under _folder structure_ above, 
these files are needed to get your library to work:

 - the folder `ExampleFooLibrary/library`
 - the file `ExampleFooLibrary/library.properties`
 - the file `ExampleFooLibrary/library/ExampleFooLibrary.jar`

But if you want to publish it, you must follow some additional
guidelines. According to these guidelines, this folder 
should also contain

 - `ExampleFooLibrary/reference/` - documentation in HTML format as generated from Javadoc
 - `ExampleFooLibrary/examples/`  - a set of example PDE sketches 
 - `ExampleFooLibrary/src/` - java source

But these folders in this library are not required:

 - ExampleFooLibrary/bin  is not required;
 - ExampleFooLibrary/build is not required;
 - ExampleFooLibrary/dist is not required;
 - ExampleFooLibrary/docs is not required; 
 - ExampleFooLibrary/README.md is not required.

### published files

What you will be publishing are three files on a public location 
with a fixed url. I keep a copy of those three files in the git repo:

 - a HTML summary (see `docs/summary.html`)
 - a text version of the properties file (see `dist/ExampleFooLibrary.txt`)
 - a zip file with the required files in it (see `dist/ExampleFooLibrary.zip`)

The zip file should unzip to a single folder with *only the 
required files, plus those required by the publishing guidelines* 
contained in that folder. See `bin/createzip.sh` for an example 
on how to create that zip.

Put these files online (I use github.io) and communicate
the 3 urls with the Processing maintainers. If they agree
to publish it, apparently they will check the library.properties
in the remote published zip, or its text version alongside it, 
regularly to see if there is a new version.

See also:
https://github.com/processing/processing/wiki/Library-Guidelines

See also:
https://github.com/processing/processing/wiki/Library-Basics#library-naming-rules
