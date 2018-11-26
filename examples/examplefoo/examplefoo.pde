import nl.kw.processing.ExampleBazPackage.*;


ExampleQuz eq = new ExampleQuz(this);
int i = 0;

void setup() {
  
  println("This does nothing.");
  println("However, you may want to check the console output.");
  println("Class ExampleQuz will print some output there.");
  println();

}

void draw () {
  println("applet draw "+i);
  if (i++ > 3) noLoop();
}
