/*
	this still does nothing, but shows more
*/

package nl.kw.processing.ExampleBazPackage;
import processing.core.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class ExampleQuz {
  PApplet parent;

  public ExampleQuz(PApplet parent) {
    this.parent = parent;
    parent.registerMethod("pre", this);
    parent.registerMethod("draw", this);
    parent.registerMethod("mouseEvent", this);
    parent.registerMethod("keyEvent", this);
    parent.registerMethod("stop", this);
    parent.registerMethod("dispose", this);
    parent.registerMethod("pause", this);
    parent.registerMethod("dispose", this);
    parent.registerMethod("resume", this);
  }

	// Method that's called just after beginDraw(), meaning that it can affect drawing.
 	
 	public void pre() { 
 		// you can draw here
 	}

	// Method that's called at the end of draw(), but before endDraw().
	
	public void draw() { 
 		// you can draw here
 	}

	// Method called after draw has completed and the frame is done. No drawing allowed.
	public void post() { 
 	
 	}

	// Called when a mouse event occurs in the parent applet. Drawing is allowed because mouse events are queued, unless the sketch has called noLoop().
	
	public void mouseEvent(MouseEvent e) { 
 		// you can draw here
 	}

	//Called when a key event occurs in the parent applet. Drawing is allowed because key events are queued, unless the sketch has called noLoop().

	public void keyEvent(KeyEvent e) { 
 	
 	}

	// Called to halt execution. Can be called by users, for instance movie.stop() will shut down a movie that's being played, or camera.stop() stops capturing video. server.stop() will shut down the server and shut it down completely. May be called multiple times.

	public void stop() { 
 	
 	}

	// Called to free resources before shutting down. This should only be called by PApplet. The dispose() method is what gets called when the host applet is being shut down, so this should stop any threads, disconnect from the net, unload memory, etc.

	public void dispose() { 
 	
 	}

	// Called on Android when the sketch is paused (usually sent to the background).

	public void pause() { 
 	
 	}

	// Called on Android when the sketch is resumed.

	public void resume() { 
 	
 	}


}