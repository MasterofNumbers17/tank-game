/* Copyright (C) 2017 Adrien Hopkins
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

import processing.core.PApplet;
/**A bullet!
 * @author Adrien Hopkins
 */
public class Bullet {
    float x, y, r;
    final static float BULLET_SIZE = 10, BULLET_SPEED = 5;

    Bullet(float x, float y, float r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    
    /**Draws the bullet.
     * @param drawOn the surface to draw on
     */
    public void drawThis(PApplet drawOn) {
        drawOn.stroke(0, 0, 0);
        drawOn.fill(191, 191, 191);
        drawOn.ellipse(x, y, BULLET_SIZE, BULLET_SIZE);
    }
    
    /**Moves the bullet.
     */
    public void move() {
        this.x += BULLET_SPEED * (float) Math.sin(this.r);
        this.y += BULLET_SPEED * (float) -Math.cos(this.r);
    }
}
