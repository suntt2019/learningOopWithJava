//listing 7
// Demonstrate the mouse event handlers. 
import java.awt.*; 
import java.awt.event.*; 
import java.applet.*; 

/* 
<applet code="T1507" width=300 height=50> 
</applet> 
*/ 

/*
Java: A Beginner's Guide, 6th Ed.
Chapter 15 Test 7
Improved form Chapter 15 Listing 7(P480)

*/
 
public class T1507 extends Applet 
  implements MouseListener, MouseMotionListener { 
 
  String msg = ""; 
  int mouseX = 0, mouseY = 0; // coordinates of mouse 
  int mouseXLastTime,mouseYLastTime;
 
  public void init() { 
     addMouseListener(this); 
     addMouseMotionListener(this); 
  } 
 
  // Handle mouse clicked. 
  public void mouseClicked(MouseEvent me) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse clicked."; 
    repaint(); 
  } 
 
  // Handle mouse entered. 
  public void mouseEntered(MouseEvent me) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse entered."; 
    repaint(); 
  } 
 
  // Handle mouse exited. 
  public void mouseExited(MouseEvent me) { 
    mouseX = 0; 
    mouseY = 10; 
    msg = "Mouse exited."; 
    repaint(); 
  } 
 
  // Handle button pressed. 
  public void mousePressed(MouseEvent me) { 
    // save coordinates 
    mouseX = me.getX(); 
    mouseY = me.getY(); 
    msg = "Down"; 
    mouseXLastTime = me.getX();
    mouseYLastTime = me.getY();
    repaint(); 
  } 
 
  // Handle button released. 
  public void mouseReleased(MouseEvent me) { 
    // save coordinates 
    mouseX = me.getX(); 
    mouseY = me.getY(); 
    msg = "Up"; 
    repaint(); 
  } 
 
  // Handle mouse dragged. 
  public void mouseDragged(MouseEvent me) { 
    // save coordinates 
    mouseX = me.getX(); 
    mouseY = me.getY(); 
    msg = "*"; 
    showStatus("Dragging mouse at " + mouseX + ", " + mouseY); 
    repaint(); 
  } 
 
  // Handle mouse moved. 
  public void mouseMoved(MouseEvent me) { 
    // show status 
    showStatus("Moving mouse at " + me.getX() + ", " + me.getY()); 
  } 
 
  // Display msg in applet window at current X,Y location. 
  public void paint(Graphics g) { 
    g.drawLine(mouseX, mouseY, mouseXLastTime, mouseYLastTime);
    g.drawString(msg, mouseX, mouseY); 
  } 
}

