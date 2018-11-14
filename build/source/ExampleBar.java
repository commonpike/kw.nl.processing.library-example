/*
	this is teh absolute minimum package
*/

package nl.kw.processing.ExampleBazPackage;
import processing.core.*;

public class ExampleBar {
  PApplet parent;

  public ExampleBar(PApplet parent) {
    this.parent = parent;
    parent.registerMethod("dispose", this);
  }

  public void dispose() {
    // Anything in here will be called automatically when 
    // the parent sketch shuts down. For instance, this might
    // shut down a thread used by this library.
  }
}