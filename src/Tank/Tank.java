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
/**A tank!
 * @author Adrien Hopkins
 */
public class Tank {
    int shootCooldown = 0;
    float x, y, r;
    final static int SHOOT_COOLDOWN = 24;
    final static float TANK_SPEED = 3f, ROTATION_PER_FRAME = .08f;
    
    /**Creates the tank object.
     * @param x the tank's x position
     * @param y the tank's y position
     */
    Tank(float x, float y) {
        this.x = x;
        this.y = y;
        this.r = 0;
    }
    
    /**Draws the tank.
     * @param drawOn the surface to draw on
     * @param image the image to use
     */
    public void drawThis(PApplet drawOn, PImage image) {
        drawOn.translate(this.x, this.y);
        drawOn.rotate(this.r);
        drawOn.image(image, -image.width/2, -image.height/2);
        drawOn.resetMatrix();
    }
    
    /**
     * Shoots a bullet
     * @return the bullet shot
     */
    public Bullet shoot() {
        return new Bullet(this.x, this.y, r);
    }
    
    /**Updates the tank.
     * @param g the ongoing game
     */
    public void update(TankGame g) {
        // rotation left or right
        if (g.right || g.d) this.r += ROTATION_PER_FRAME;
        if (g.left || g.a) this.r -= ROTATION_PER_FRAME;
        r %= Math.PI * 2;
        
        if (g.up || g.w) { // move forward
            this.x += TANK_SPEED * (float) Math.sin(r);
            this.y += TANK_SPEED * (float) -Math.cos(r);
        }
        // check if out of bounds and if so, place it back in bounds
        if (this.x < 0) this.x = 0;
        else if (this.x > g.WIDTH) this.x = g.WIDTH;
        if (this.y < 0) this.y = 0;
        else if (this.y > g.HEIGHT) this.y = g.HEIGHT;
        
        // shoots if space is held and cooldown is 0
        if (shootCooldown > 0) shootCooldown--;
        if (g.space && shootCooldown == 0) {
            shootCooldown = SHOOT_COOLDOWN;
            g.bulletsList.add(shoot());
        }
    }
}
