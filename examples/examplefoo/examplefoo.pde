import nl.kw.processing.ExampleBazPackage.*;


ExampleQuz eq = new ExampleQuz(this);
int i = 0;

void setup() {
  println();
  println("-----------------------");
  println("This does nothing.");
  println("Please read the documentation at");
  println("https://github.com/commonpike/nl.kw.processing.library-example");
  println();
  println("You may want to check the console output though.");
  println("Class ExampleQuz will print some stuff there.");
  println("-----------------------");
  println();

}

void draw () {
  println("applet draw "+i);
  if (i++ > 3) noLoop();
}
