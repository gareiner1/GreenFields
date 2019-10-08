public class AnimationData {
	AnimationDef def;
	int curFrame;
	float secsUntilNextFrame;
	boolean finished;

	public void update(float deltaTime) {
		secsUntilNextFrame -= deltaTime;
		while (secsUntilNextFrame <= 0) {
			curFrame++;
			if (curFrame > def.frames.length - 1) {
				finished = true;
				curFrame = 0;
			}
			secsUntilNextFrame += def.frames[curFrame].frameTimeSecs;
		}
	}

	public void draw(int x, int y) {

	}
}
