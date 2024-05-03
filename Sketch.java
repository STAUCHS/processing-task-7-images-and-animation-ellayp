import processing.core.PApplet;
import processing.core.PImage;

/**
 * The program Sketch.java implements an image background, and animates an image and a shape.
 * The program incorporates basic edge collision detection
 * such that the animated objects do not permenantaly move off the screen.
 * The animated image moves in a non-linear path (circular).
 * @author: E. Yap
 */
public class Sketch extends PApplet {
  // images
  PImage imgVolleyball;
  PImage imgBackgroundNet;

  // x and y coordinates for the volleyball image
  float fltVolleyballX = 150;
  float fltVolleyballY = 50;

  // radius, angle, and speed variables for the volleyball image
  float fltVolleyballRadius;
  float fltVolleyballAngle;
  float fltVolleyballSpeed = (float) 0.05;

  // x and y coordinates for background volleyball net
  float fltBackgroundX = 0;
  float fltBackgroundY = 0;

  // circle shape variables
  float fltCircleX = 200;
  float fltCircleY = 200;
  float fltCircleSpeed = 3;

  /**
   * Size call.
   */
  public void settings() {
    size(400, 400);
  }

  /**
   * The initial set up values.
   * The background and image.
   */
  public void setup() {
    // load volleyball
    imgVolleyball = loadImage("imageVolleyball.png");

    // resize volleyball
    imgVolleyball.resize(50,50);

    // load background volleyball net
    imgBackgroundNet = loadImage("imageBackgroundNet.png");

    // resize background volleyball net
    imgBackgroundNet.resize(400,400);
  }

  /**
   * Everything drawn to the screen.
   * The background, image, and ellipse.
   */
  public void draw() {
    // draw background volleyball net
    image (imgBackgroundNet, fltBackgroundX, fltBackgroundY);

    // draw volleyball
    image(imgVolleyball, fltVolleyballX, fltVolleyballY);

    // colour and draw ellipse
    fill(255);
    ellipse (fltCircleX, fltCircleY, 50, 50);

    // basic edge collision detection such that the ellipse does not permenantly move off the screen
    fltCircleY += fltCircleSpeed;
    if (fltCircleY <= 25 || fltCircleY >= height - 50) {
      fltCircleSpeed *= -1;
    }

    // move volleyball in a non-linear path (a circle)
    fltVolleyballX += width / 3 * cos (fltVolleyballAngle) * fltVolleyballSpeed;
    fltVolleyballY += height / 3 * sin (fltVolleyballAngle) * fltVolleyballSpeed;

    // basic edge collision detection such that the volleyball does not permenantly move off the screen
    fltVolleyballX = constrain (fltVolleyballX, 0, width - 50);
    fltVolleyballY = constrain (fltVolleyballY, 0, height - 50);
    fltVolleyballAngle += fltVolleyballSpeed;
  }
}