/*
 * Copyright (C) 2017 Adrien Hopkins
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Tank;

import processing.core.*;
import java.util.ArrayList;
/**A game of tanks!
 * @author Adrien Hopkins
 * @version 1.0.0
 */
public class TankGame extends PApplet {
    static String[] program = {"Tank.TankGame"};

    PImage bg, tank;
    float tx=500f, ty=375f, dx=0f, dy=-5f, r=0;
    float bx, by, mbx, mby;
    boolean left, right, up, space;
    Tank myTank;
    ArrayList<Bullet> bulletsList = new ArrayList<>();
    
    public void setup() {
        size(1000, 750, JAVA2D);
        bg = loadImage("images/grassbg.png");
        tank = loadImage("images/tinytank.png");
        myTank = new Tank(500, 375);
    }
     
    public void draw() {
        fill(255, 0, 0);
        image(bg, 0, 0);
        image(bg, 500, 0);
        image(bg, 0, 375);
        image(bg, 500, 375);
        
        resetMatrix();
        
        myTank.update(this);
        myTank.drawThis(this, tank);
        
        for (Bullet bullet : bulletsList) {
            bullet.move();
            bullet.drawThis(this);
        }
    }
    
    public void keyPressed() {
        if (keyCode == LEFT) left = true;
        if (keyCode == RIGHT) right = true;
        if (keyCode == UP) up = true;
        if (key == ' ') space = true;
    } public void keyReleased() {
        if (keyCode == LEFT) left = false;
        if (keyCode == RIGHT) right = false;
        if (keyCode == UP) up = false;
        if (key == ' ') space = false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {PApplet.main(program);}
}
