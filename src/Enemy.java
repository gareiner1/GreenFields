import java.util.ArrayList;
import java.util.Random;

public class Enemy {
	public int x;
	public int defaultX;
	public int defaultY;
	public int y;
	public int headX;
	public int headY;
	public int leftPanelX;
	public int leftPanelY;
	public int rightPanelX;
	public int rightPanelY;
	public int width;
	public int height;
	public int image;
	public int hp;
	public boolean visible;
	public ArrayList<Projectile> westShots;
	public ArrayList<Projectile> northWestShots;
	public ArrayList<Projectile> southWestShots;
	public ArrayList<Projectile> eastShots;
	public ArrayList<Projectile> northEastShots;
	public ArrayList<Projectile> southEastShots;
	public ArrayList<Projectile> southShots;
	public ArrayList<Projectile> northShots;
	public int rand;
	public String type;

	public void Update(long delta, int targetX, int targetY) {
		if (targetY - y < 15){
			if (x < targetX) {
				x -= 2;
			} else if (x > targetX) {
				x += 2;
			} else if (y < targetY) {
				y -= 2;
			} else if (y > targetY) {
				y += 2;
			}
		}
		else{
			if (x < targetX) {
				x += 2;
			} else if (x > targetX) {
				x -= 2;
			} else if (y < targetY) {
				y -= 2;
			} else if (y > targetY) {
				y -= 2;
			}
		}
	}
}