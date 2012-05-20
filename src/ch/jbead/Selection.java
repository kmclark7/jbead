/** jbead - http://www.brunoldsoftware.ch
    Copyright (C) 2001-2012  Damian Brunold

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package ch.jbead;

/**
 * 
 */
public class Selection {

    private Point origin = new Point(0, 0);
    private Point dest = new Point(0, 0);
    private boolean selection;

    public void clear() {
        selection = false;
    }
    
    public boolean isActive() {
        return selection;
    }
    
    public void init(Point origin) {
        this.origin = this.dest = origin;
        selection = false;
    }
    
    public void update(Point end) {
        this.dest = end;
        selection = !origin.equals(dest);
    }

    public Point getOrigin() {
        return origin;
    }
    
    public Point getDestination() {
        return dest;
    }
    
    public Point getBegin() {
        return new Point(Math.min(origin.getX(), dest.getX()), Math.min(origin.getY(), dest.getY()));
    }
    
    public Point getEnd() {
        return new Point(Math.max(origin.getX(), dest.getX()), Math.max(origin.getY(), dest.getY()));
    }
    
    public boolean isSquare() {
        return Math.abs(dest.getX() - origin.getX()) == Math.abs(dest.getY() - origin.getY());
    }
    
    public boolean isColumn() {
        return origin.getX() == dest.getX();
    }
    
    public boolean isRow() {
        return origin.getY() == dest.getY();
    }
    
    public boolean isNormal() {
        return origin.getX() != dest.getX() && origin.getY() != dest.getY();
    }

    public int left() {
        return getBegin().getX();
    }
    
    public int right() {
        return getEnd().getX();
    }
    
    public int bottom() {
        return getBegin().getY();
    }
    
    public int top() {
        return getEnd().getY();
    }
    
    public Point getLineDest() {
        int x = dest.getX();
        int y = dest.getY();
        int ax = Math.abs(getDeltaX());
        int ay = Math.abs(getDeltaY());
        if (ax > ay) {
            x = origin.getX() + ay * getDx();
        } else {
            y = origin.getY() + ax * getDy();
        }
        return new Point(x + getDx(), y + getDy());
    }

    public int getDeltaX() {
        return dest.getX() - origin.getX();
    }
    
    public int getDeltaY() {
        return dest.getY() - origin.getY();
    }
    
    public int getDx() {
        return origin.getX() < dest.getX() ? 1 : -1;
    }
    
    public int getDy() {
        return origin.getY() < dest.getY() ? 1 : -1; 
    }

}
