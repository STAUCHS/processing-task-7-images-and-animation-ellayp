import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgMeteor;

  // x and y coordinate for meteor
  float fltMeteorX = 0;
  float fltMeteorY = 0;

  // meteor speed variables
  float fltXSpeed = 1;
  float fltYSpeed = 1;

  // define colours
  int black = color(0);

  // gravity
  float x;
  float y;
  float yspeed = 0;
  float xspeed = 0;

  public void settings() {
    size(400, 400);
  }

  public void setup() {

    // load meteor
    imgMeteor = loadImage("spaceMeteors_003.png");

    // resize meteor
    imgMeteor.resize(imgMeteor.width/4, imgMeteor.height/4);
  }

  public void draw() {
    background(black);

    // draw meteor and move
    image(imgMeteor, fltMeteorX, fltMeteorY);

    fltMeteorX += fltXSpeed;
    fltMeteorY += fltYSpeed;

    if (fltMeteorX > width - imgMeteor.width || fltMeteorX < 0) {
      fltXSpeed *= -1;
    }

    if (fltMeteorY > height - imgMeteor.height || fltMeteorY < 0) {
      fltYSpeed *= -1;
    }
  }
}