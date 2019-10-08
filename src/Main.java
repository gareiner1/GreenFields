import com.jogamp.nativewindow.WindowClosingProtocol;
import com.jogamp.opengl.*;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.opengl.GLWindow;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.Clip;

public class Main {
	// Set this to true to make the game loop exit.
	private static boolean shouldExit;

	// The previous frame's keyboard state.
	private static boolean kbPrevState[] = new boolean[256];

	// The current frame's keyboard state.
	private static boolean kbState[] = new boolean[256];

	// Position of the sprite.
	private static int[] spritePos = new int[] { 375, 275 };
	private static int[] bomb1Pos = new int[] { 50, -300 };
	private static int[] bomb2Pos = new int[] { 700, -450 };
	private static int[] bomb3Pos = new int[] { 10, -700 };
	private static int[] bomb4Pos = new int[] { 150, -900 };
	private static int[] bomb5Pos = new int[] { 50, -1100 };
	private static int[] bomb6Pos = new int[] { 700, -1300 };
	private static int[] bomb7Pos = new int[] { 10, -1400 };
	private static int[] bomb8Pos = new int[] { 770, -800 };
	private static int[] bomb9Pos = new int[] { 60, -1622 };
	private static int[] bomb10Pos = new int[] { 699, -1700 };
	private static int[] bomb11Pos = new int[] { 10, -2000 };
	private static int[] bomb12Pos = new int[] { 150, -2100 };
	private static int[] turret1Pos = new int[] { 50, -305 };
	private static int[] turret2Pos = new int[] { 700, -128 };
	private static int[] turret3Pos = new int[] { 50, -400 };
	private static int[] turret4Pos = new int[] { 50, -700 };
	private static int[] turret5Pos = new int[] { 50, -900 };
	private static int[] turret6Pos = new int[] { 700, -700 };
	private static int[] turret7Pos = new int[] { 50, -800 };
	private static int[] turret8Pos = new int[] { 50, -2100 };
	private static int[] turret9Pos = new int[] { 700, -2100 };
	private static int[] turret10Pos = new int[] { 50, -2050 };
	private static int[] turret11Pos = new int[] { 700, -2050 };
	private static int[] turret12Pos = new int[] { 50, -2000 };
	private static int[] turret13Pos = new int[] { 700, -2000 };
	private static int[] gunman1Pos = new int[] { 850, -400 };
	private static int[] gunman2Pos = new int[] { 770, -250 };
	private static int[] gunman3Pos = new int[] { 10, -250 };
	private static int[] gunman4Pos = new int[] { 850, -800 };
	private static int[] gunman5Pos = new int[] { 770, -1545 };
	private static int[] gunman6Pos = new int[] { 10, -1243 };
	private static int[] gunman7Pos = new int[] { 850, -1600 };
	private static int[] gunman8Pos = new int[] { 770, -843 };
	private static int[] gunman9Pos = new int[] { 10, -743 };
	private static int[] gunman10Pos = new int[] { 850, -1800 };
	private static int[] gunman11Pos = new int[] { 770, -1243 };
	private static int[] gunman12Pos = new int[] { 10, -456 };
	private static int[] gunman13Pos = new int[] { 850, -577 };
	private static int[] gunman14Pos = new int[] { 770, -1994 };
	private static int[] gunman15Pos = new int[] { 10, -1839 };
	private static int[] gunman16Pos = new int[] { 770, -1200 };
	private static int[] gunman17Pos = new int[] { 10, -1400 };
	private static int[] tankBodyPos = new int[] { 375, -2400 };
	private static int[] tankHeadPos = new int[] { tankBodyPos[0] + 20, tankBodyPos[1] + 35};
	private static int[] tankLeftPanelPos = new int[] { tankBodyPos[0], tankBodyPos[1] + 35};
	private static int[] tankRightPanelPos = new int[] { tankBodyPos[0] + 65, tankBodyPos[1] + 35};
	
	private static int[] refPoint = new int[] { 0, 0 };

	// Texture for the sprite.
	private static int spriteTex;
	private static int bombTex;
	private static int playerShotTex;
	private static int enemyShotTex;
	private static int grass1Tex;
	private static int grass2Tex;
	private static int bushTex;
	private static int turretTex;
	private static int gunmanTex1;
	private static int gunmanTex2;
	private static int gunmanTex3;
	private static int tankBodyTex;
	private static int tankHeadTex;
	private static int tankLeftPanelTex;
	private static int tankRightPanelTex;
	private static int explosionTex;
	private static int tankDeadTex;

	
	// Size of the sprite.
	private static int[] spriteSize = new int[2];
	private static int[] bombSize = new int[2];
	private static int[] playerShotSize = new int[2];
	private static int[] enemyShotSize = new int[2];
	private static int[] grass1Size = new int[2];
	private static int[] grass2Size = new int[2];
	private static int[] bushSize = new int[2];
	private static int[] fontSize = new int[2];
	private static int[] turretSize = new int[2];
	private static int[] gunmanSize = new int[2];
	private static int[] tankBodySize = new int[2];
	private static int[] tankHeadSize = new int[2];
	private static int[] tankLeftPanelSize = new int[2];
	private static int[] tankRightPanelSize = new int[2];
	private static int[] explosionSize = new int[2];
	private static int[] tankDeadSize = new int[2];
	private static int[] tankRotateSize0 = new int[2];
	private static int[] tankRotateSize1 = new int[2];
	private static int[] tankRotateSize2 = new int[2];
	private static int[] tankRotateSize3 = new int[2];
	private static int[] tankRotateSize4 = new int[2];
	private static int[] tankRotateSize5 = new int[2];
	private static int[] tankRotateSize6 = new int[2];
	private static int[] tankRotateSize7 = new int[2];
	private static int[] tankRotateSize8 = new int[2];
	private static int[] tankRotateSize9 = new int[2];
	private static int[] tankRotateSize10 = new int[2];
	private static int[] tankRotateSize11 = new int[2];
	private static int[] tankRotateSize12 = new int[2];
	private static int[] tankRotateSize13 = new int[2];
	private static int[] tankRotateSize14 = new int[2];

	private static int playerHp = 10;
	private static int bombHp = 2;
	private static int turretHp = 3;
	private static int gunmanHp = 2;
	private static int tankHp = 50;
	
	public static void main(String[] args) {
		GLProfile gl2Profile;

		try {
			// Make sure we have a recent version of OpenGL
			gl2Profile = GLProfile.get(GLProfile.GL2);
		} catch (GLException ex) {
			System.out.println("OpenGL max supported version is too low.");
			System.exit(1);
			return;
		}

		// Create the window and OpenGL context.
		GLWindow window = GLWindow.create(new GLCapabilities(gl2Profile));
		window.setSize(800, 600);
		window.setTitle("Final Project");
		window.setVisible(true);
		window.setDefaultCloseOperation(WindowClosingProtocol.WindowClosingMode.DISPOSE_ON_CLOSE);
		window.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent keyEvent) {
				if (keyEvent.isAutoRepeat()) {
					return;
				}
				kbState[keyEvent.getKeyCode()] = true;
			}

			@Override
			public void keyReleased(KeyEvent keyEvent) {
				if (keyEvent.isAutoRepeat()) {
					return;
				}
				kbState[keyEvent.getKeyCode()] = false;
			}
		});

		// Setup OpenGL state.
		window.getContext().makeCurrent();
		GL2 gl = window.getGL().getGL2();
		gl.glViewport(0, 0, 800, 600);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glOrtho(0, 800, 600, 0, 0, 100);
		gl.glEnable(GL2.GL_TEXTURE_2D);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);

		// Game initialization goes here	
		spriteTex = glTexImageTGAFile(gl, "player_up0.tga", spriteSize);
		bombTex = glTexImageTGAFile(gl, "bomb0.tga", bombSize);
		playerShotTex = glTexImageTGAFile(gl, "player_shot.tga", playerShotSize);
		enemyShotTex = glTexImageTGAFile(gl, "enemy_shot.tga", enemyShotSize);
		grass1Tex = glTexImageTGAFile(gl, "grass2.tga", grass1Size);
		grass2Tex = glTexImageTGAFile(gl, "grass1.tga", grass2Size);
		bushTex = glTexImageTGAFile(gl, "bush.tga", bushSize);
		turretTex = glTexImageTGAFile(gl, "turret_s.tga", turretSize);
		gunmanTex1 = glTexImageTGAFile(gl, "gunman_top0.tga", gunmanSize);
		gunmanTex2 = glTexImageTGAFile(gl, "gunman_left0.tga", gunmanSize);
		gunmanTex3 = glTexImageTGAFile(gl, "gunman_right0.tga", gunmanSize);
		tankBodyTex = glTexImageTGAFile(gl, "tank_body.tga", tankBodySize);
		tankHeadTex = glTexImageTGAFile(gl, "tank_head_down0.tga", tankHeadSize);
		tankLeftPanelTex = glTexImageTGAFile(gl, "tank_left_panel.tga", tankLeftPanelSize);
		tankRightPanelTex = glTexImageTGAFile(gl, "tank_right_panel.tga", tankRightPanelSize);
		explosionTex = glTexImageTGAFile(gl, "explosion0.tga", explosionSize); 
		tankDeadTex = glTexImageTGAFile(gl, "tank_dead.tga", tankDeadSize); 
		
		int backgroundX = 400;
		int backgroundY = 304;
		BackgroundDef field = new BackgroundDef();
		field.tiles = new int[] {0, 1, 2, 3};
		int fieldGrid[][] = new int[backgroundX][backgroundY];
		for (int i = 0; i < backgroundX; i++){
			for (int j = 0; j < backgroundY; j++){
				fieldGrid[i][j] = 0;
			}
		}
		Random r = new Random();
		for (int i = 0; i < 4500; i++){
			fieldGrid[r.nextInt(backgroundX)][r.nextInt(backgroundY)] = 1;
			fieldGrid[r.nextInt(backgroundX)][r.nextInt(backgroundY)] = 2;
		}
		
		int startX;
		int endX;
		int startY;
		int endY;
		
		Camera c = new Camera();
		c.x = 16;
		c.y = 16;
		c.width = 800;
		c.height = 600;

		FrameDef frogback0 = new FrameDef();
		frogback0.image = 0;
		frogback0.frameTimeSecs = 150;
		FrameDef frogback1 = new FrameDef();
		frogback1.image = 1;
		frogback1.frameTimeSecs = 150;
		FrameDef frogback2 = new FrameDef();
		frogback2.image = 2;
		frogback2.frameTimeSecs = 150;
		FrameDef frogback3 = new FrameDef();
		frogback3.image = 3;
		frogback3.frameTimeSecs = 150;
		AnimationDef frogWalkingUp = new AnimationDef();
		frogWalkingUp.frames = new FrameDef[] { frogback0, frogback1,
				frogback2, frogback3, frogback2, frogback1 };
		AnimationData frogWalkingUpAnimation = new AnimationData();
		frogWalkingUpAnimation.def = frogWalkingUp;

		FrameDef frogfront0 = new FrameDef();
		frogfront0.image = 4;
		frogfront0.frameTimeSecs = 150;
		FrameDef frogfront1 = new FrameDef();
		frogfront1.image = 5;
		frogfront1.frameTimeSecs = 150;
		FrameDef frogfront2 = new FrameDef();
		frogfront2.image = 6;
		frogfront2.frameTimeSecs = 150;
		FrameDef frogfront3 = new FrameDef();
		frogfront3.image = 7;
		frogfront3.frameTimeSecs = 150;
		AnimationDef frogWalkingDown = new AnimationDef();
		frogWalkingDown.frames = new FrameDef[] { frogfront0, frogfront1,
				frogfront2, frogfront3, frogfront2, frogfront1 };
		AnimationData frogWalkingDownAnimation = new AnimationData();
		frogWalkingDownAnimation.def = frogWalkingDown;

		FrameDef frogleft0 = new FrameDef();
		frogleft0.image = 8;
		frogleft0.frameTimeSecs = 150;
		FrameDef frogleft1 = new FrameDef();
		frogleft1.image = 9;
		frogleft1.frameTimeSecs = 150;
		FrameDef frogleft2 = new FrameDef();
		frogleft1.image = 10;
		frogleft1.frameTimeSecs = 150;
		FrameDef frogleft3 = new FrameDef();
		frogleft1.image = 11;
		frogleft1.frameTimeSecs = 150;
		AnimationDef frogWalkingLeft = new AnimationDef();
		frogWalkingLeft.frames = new FrameDef[] { frogleft0, frogleft1, frogleft2, frogleft3, frogleft2, frogleft1};
		AnimationData frogWalkingLeftAnimation = new AnimationData();
		frogWalkingLeftAnimation.def = frogWalkingLeft;

		FrameDef frogright0 = new FrameDef();
		frogright0.image = 12;
		frogright0.frameTimeSecs = 200;
		FrameDef frogright1 = new FrameDef();
		frogright1.image = 13;
		frogright1.frameTimeSecs = 150;
		FrameDef frogright2 = new FrameDef();
		frogright1.image = 14;
		frogright1.frameTimeSecs = 150;
		FrameDef frogright3 = new FrameDef();
		frogright1.image = 15;
		frogright1.frameTimeSecs = 150;
		AnimationDef frogWalkingRight = new AnimationDef();
		frogWalkingRight.frames = new FrameDef[] { frogright0, frogright1, frogright2, frogright3, frogright2, frogright1};
		AnimationData frogWalkingRightAnimation = new AnimationData();
		frogWalkingRightAnimation.def = frogWalkingRight;
		
		FrameDef bombSpin0 = new FrameDef();
		bombSpin0.image = 0;
		bombSpin0.frameTimeSecs = 200;
		FrameDef bombSpin1 = new FrameDef();
		bombSpin1.image = 1;
		bombSpin1.frameTimeSecs = 150;
		FrameDef bombSpin2 = new FrameDef();
		bombSpin2.image = 2;
		bombSpin2.frameTimeSecs = 150;
		FrameDef bombSpin3 = new FrameDef();
		bombSpin3.image = 3;
		bombSpin3.frameTimeSecs = 150;
		AnimationDef bombSpin = new AnimationDef();
		bombSpin.frames = new FrameDef[] { bombSpin0, bombSpin1, bombSpin2, bombSpin3 };
		AnimationData bombSpinAnimation = new AnimationData();
		bombSpinAnimation.def = bombSpin;
		
		FrameDef turretSouth = new FrameDef();
		turretSouth.image = 0;
		turretSouth.frameTimeSecs = 150;
		FrameDef turretSouthwest = new FrameDef();
		turretSouthwest.image = 1;
		turretSouthwest.frameTimeSecs = 150;
		FrameDef turretWest = new FrameDef();
		turretWest.image = 2;
		turretWest.frameTimeSecs = 150;
		FrameDef turretNorthwest = new FrameDef();
		turretNorthwest.image = 3;
		turretNorthwest.frameTimeSecs = 150;
		FrameDef turretNorth = new FrameDef();
		turretNorth.image = 4;
		turretNorth.frameTimeSecs = 150;
		FrameDef turretNortheast = new FrameDef();
		turretNortheast.image = 5;
		turretNortheast.frameTimeSecs = 150;
		FrameDef turretEast = new FrameDef();
		turretEast.image = 6;
		turretEast.frameTimeSecs = 150;
		FrameDef turretSoutheast = new FrameDef();
		turretSoutheast.image = 7;
		turretSoutheast.frameTimeSecs = 150;
		AnimationDef turretRotation = new AnimationDef();
		turretRotation.frames = new FrameDef[] { turretSouth, turretSouthwest, turretWest, turretNorthwest, turretNorth, turretNortheast, turretEast, turretSoutheast};
		AnimationData turretRotationAnimation = new AnimationData();
		turretRotationAnimation.def = turretRotation;
		
		FrameDef gunmanTop0 = new FrameDef();
		gunmanTop0.image = 0;
		gunmanTop0.frameTimeSecs = 150;
		FrameDef gunmanTop1 = new FrameDef();
		gunmanTop1.image = 1;
		gunmanTop1.frameTimeSecs = 150;
		FrameDef gunmanTop2 = new FrameDef();
		gunmanTop2.image = 2;
		gunmanTop2.frameTimeSecs = 150;
		FrameDef gunmanTop3 = new FrameDef();
		gunmanTop3.image = 3;
		gunmanTop3.frameTimeSecs = 150;
		FrameDef gunmanTop4 = new FrameDef();
		gunmanTop4.image = 4;
		gunmanTop4.frameTimeSecs = 300;
		AnimationDef gunmanTop = new AnimationDef();
		gunmanTop.frames = new FrameDef[] {gunmanTop0, gunmanTop1, gunmanTop2, gunmanTop3, gunmanTop2, gunmanTop1};
		AnimationData gunmanTopAnimation = new AnimationData();
		gunmanTopAnimation.def = gunmanTop;
		AnimationDef gunmanTopShoot = new AnimationDef();
		gunmanTopShoot.frames = new FrameDef[] {gunmanTop4, gunmanTop4};
		AnimationData gunmanTopShootAnimation = new AnimationData();
		gunmanTopShootAnimation.def = gunmanTopShoot;
		
		FrameDef gunmanLeft0 = new FrameDef();
		gunmanLeft0.image = 5;
		gunmanLeft0.frameTimeSecs = 150;
		FrameDef gunmanLeft1 = new FrameDef();
		gunmanLeft1.image = 6;
		gunmanLeft1.frameTimeSecs = 150;
		FrameDef gunmanLeft2 = new FrameDef();
		gunmanLeft2.image = 7;
		gunmanLeft2.frameTimeSecs = 150;
		FrameDef gunmanLeft3 = new FrameDef();
		gunmanLeft3.image = 8;
		gunmanLeft3.frameTimeSecs = 150;
		FrameDef gunmanLeft4 = new FrameDef();
		gunmanLeft4.image = 9;
		gunmanLeft4.frameTimeSecs = 300;
		AnimationDef gunmanLeft = new AnimationDef();
		gunmanLeft.frames = new FrameDef[] {gunmanLeft0, gunmanLeft1, gunmanLeft2, gunmanLeft3, gunmanLeft2, gunmanLeft1};
		AnimationData gunmanLeftAnimation = new AnimationData();
		gunmanLeftAnimation.def = gunmanLeft;
		
		FrameDef gunmanRight0 = new FrameDef();
		gunmanRight0.image = 10;
		gunmanRight0.frameTimeSecs = 150;
		FrameDef gunmanRight1 = new FrameDef();
		gunmanRight1.image = 11;
		gunmanRight1.frameTimeSecs = 150;
		FrameDef gunmanRight2 = new FrameDef();
		gunmanRight2.image = 12;
		gunmanRight2.frameTimeSecs = 150;
		FrameDef gunmanRight3 = new FrameDef();
		gunmanRight3.image = 13;
		gunmanRight3.frameTimeSecs = 150;
		FrameDef gunmanRight4 = new FrameDef();
		gunmanRight4.image = 14;
		gunmanRight4.frameTimeSecs = 300;
		AnimationDef gunmanRight = new AnimationDef();
		gunmanRight.frames = new FrameDef[] {gunmanRight0, gunmanRight1, gunmanRight2, gunmanRight3, gunmanRight2, gunmanRight1};
		AnimationData gunmanRightAnimation = new AnimationData();
		gunmanRightAnimation.def = gunmanRight;
		

		FrameDef tankShootingDown0 = new FrameDef();
		tankShootingDown0.image = 16;
		tankShootingDown0.frameTimeSecs = 1000;
		FrameDef tankShootingDown1 = new FrameDef();
		tankShootingDown1.image = 4;
		tankShootingDown1.frameTimeSecs = 1000;
		FrameDef tankShootingDown2 = new FrameDef();
		tankShootingDown2.image = 18;
		tankShootingDown2.frameTimeSecs = 1000;
		AnimationDef tankShootingDown = new AnimationDef();
		tankShootingDown.frames = new FrameDef[] {tankShootingDown0, tankShootingDown1, tankShootingDown0, tankShootingDown2, tankShootingDown0};
		AnimationData tankShootingDownAnimation = new AnimationData();
		tankShootingDownAnimation.def = tankShootingDown;
		
		FrameDef tankShootingUp0 = new FrameDef();
		tankShootingUp0.image = 15;
		tankShootingUp0.frameTimeSecs = 1000;
		FrameDef tankShootingUp1 = new FrameDef();
		tankShootingUp1.image = 12;
		tankShootingUp1.frameTimeSecs = 1000;
		FrameDef tankShootingUp2 = new FrameDef();
		tankShootingUp2.image = 17;
		tankShootingUp2.frameTimeSecs = 1000;
		AnimationDef tankShootingUp = new AnimationDef();
		tankShootingUp.frames = new FrameDef[] {tankShootingUp0, tankShootingUp1, tankShootingUp0, tankShootingUp2, tankShootingUp0};
		AnimationData tankShootingUpAnimation = new AnimationData();
		tankShootingUpAnimation.def = tankShootingUp;
		
		FrameDef tankRotate0 = new FrameDef();
		tankRotate0.image = 0;
		tankRotate0.frameTimeSecs = 50;
		tankRotate0.size = tankRotateSize0;
		FrameDef tankRotate1 = new FrameDef();
		tankRotate1.image = 1;
		tankRotate1.frameTimeSecs = 50;
		tankRotate1.size = tankRotateSize1;
		FrameDef tankRotate2 = new FrameDef();
		tankRotate2.image = 2;
		tankRotate2.frameTimeSecs = 50;
		tankRotate2.size = tankRotateSize2;
		FrameDef tankRotate3 = new FrameDef();
		tankRotate3.image = 3;
		tankRotate3.frameTimeSecs = 50;
		tankRotate3.size = tankRotateSize3;
		FrameDef tankRotate4 = new FrameDef();
		tankRotate4.image = 4;
		tankRotate4.frameTimeSecs = 50;
		tankRotate4.size = tankRotateSize4;
		FrameDef tankRotate5 = new FrameDef();
		tankRotate5.image = 5;
		tankRotate5.frameTimeSecs = 50;
		tankRotate5.size = tankRotateSize5;
		FrameDef tankRotate6 = new FrameDef();
		tankRotate6.image = 6;
		tankRotate6.frameTimeSecs = 50;
		tankRotate6.size = tankRotateSize6;
		FrameDef tankRotate7 = new FrameDef();
		tankRotate7.image = 7;
		tankRotate7.frameTimeSecs = 50;
		tankRotate7.size = tankRotateSize7;
		FrameDef tankRotate8 = new FrameDef();
		tankRotate8.image = 8;
		tankRotate8.frameTimeSecs = 50;
		tankRotate8.size = tankRotateSize8;
		FrameDef tankRotate9 = new FrameDef();
		tankRotate9.image = 9;
		tankRotate9.frameTimeSecs = 50;
		tankRotate9.size = tankRotateSize9;
		FrameDef tankRotate10 = new FrameDef();
		tankRotate10.image = 10;
		tankRotate10.frameTimeSecs = 50;
		tankRotate10.size = tankRotateSize10;
		FrameDef tankRotate11 = new FrameDef();
		tankRotate11.image = 11;
		tankRotate11.frameTimeSecs = 50;
		tankRotate11.size = tankRotateSize11;
		FrameDef tankRotate12 = new FrameDef();
		tankRotate12.image = 12;
		tankRotate12.frameTimeSecs = 50;
		tankRotate12.size = tankRotateSize12;
		FrameDef tankRotate13 = new FrameDef();
		tankRotate13.image = 13;
		tankRotate13.frameTimeSecs = 50;
		tankRotate13.size = tankRotateSize13;
		FrameDef tankRotate14 = new FrameDef();
		tankRotate14.image = 14;
		tankRotate14.frameTimeSecs = 50;
		tankRotate14.size = tankRotateSize14;
		AnimationDef tankRotate = new AnimationDef();
		tankRotate.frames = new FrameDef[] {tankRotate0, tankRotate1, tankRotate2, tankRotate3, tankRotate4, tankRotate5, tankRotate6, tankRotate7, tankRotate8, tankRotate9, tankRotate10, tankRotate11, tankRotate12, tankRotate13, tankRotate14};
		AnimationData tankRotateAnimation = new AnimationData();
		tankRotateAnimation.def = tankRotate;
		
		FrameDef explosion0 = new FrameDef();
		explosion0.image = 0;
		explosion0.frameTimeSecs = 50;
		FrameDef explosion1 = new FrameDef();
		explosion1.image = 1;
		explosion1.frameTimeSecs = 50;
		FrameDef explosion2 = new FrameDef();
		explosion2.image = 2;
		explosion2.frameTimeSecs = 50;
		FrameDef explosion3 = new FrameDef();
		explosion3.image = 3;
		explosion3.frameTimeSecs = 50;
		FrameDef explosion4 = new FrameDef();
		explosion4.image = 4;
		explosion4.frameTimeSecs = 50;
		FrameDef explosion5 = new FrameDef();
		explosion5.image = 5;
		explosion5.frameTimeSecs = 50;
		FrameDef explosion6 = new FrameDef();
		explosion6.image = 6;
		explosion6.frameTimeSecs = 50;
		FrameDef explosion7 = new FrameDef();
		explosion7.image = 7;
		explosion7.frameTimeSecs = 50;
		FrameDef explosion8 = new FrameDef();
		explosion8.image = 8;
		explosion8.frameTimeSecs = 50;
		FrameDef explosion9 = new FrameDef();
		explosion9.image = 9;
		explosion9.frameTimeSecs = 50;
		AnimationDef explosion = new AnimationDef();
		explosion.frames = new FrameDef[] {explosion0, explosion1, explosion2, explosion3, explosion4, explosion5, explosion6, explosion7, explosion8, explosion9};
		AnimationData explosionAnimation = new AnimationData();
		explosionAnimation.def = explosion;
		
		int[] frogArt = new int[20];
		frogArt[0] = glTexImageTGAFile(gl, "player_up0.tga", spriteSize);
		frogArt[1] = glTexImageTGAFile(gl, "player_up1.tga", spriteSize);
		frogArt[2] = glTexImageTGAFile(gl, "player_up2.tga", spriteSize);
		frogArt[3] = glTexImageTGAFile(gl, "player_up3.tga", spriteSize);
		frogArt[4] = glTexImageTGAFile(gl, "player_down0.tga", spriteSize);
		frogArt[5] = glTexImageTGAFile(gl, "player_down1.tga", spriteSize);
		frogArt[6] = glTexImageTGAFile(gl, "player_down2.tga", spriteSize);
		frogArt[7] = glTexImageTGAFile(gl, "player_down3.tga", spriteSize);
		frogArt[8] = glTexImageTGAFile(gl, "player_left0.tga", spriteSize);
		frogArt[9] = glTexImageTGAFile(gl, "player_left1.tga", spriteSize);
		frogArt[10] = glTexImageTGAFile(gl, "player_left2.tga", spriteSize);
		frogArt[11] = glTexImageTGAFile(gl, "player_left3.tga", spriteSize);
		frogArt[12] = glTexImageTGAFile(gl, "player_right0.tga", spriteSize);
		frogArt[13] = glTexImageTGAFile(gl, "player_right1.tga", spriteSize);
		frogArt[14] = glTexImageTGAFile(gl, "player_right2.tga", spriteSize);
		frogArt[15] = glTexImageTGAFile(gl, "player_right3.tga", spriteSize);
		frogArt[16] = glTexImageTGAFile(gl, "player_shoot_up.tga", spriteSize);
		frogArt[17] = glTexImageTGAFile(gl, "player_shoot_down.tga", spriteSize);
		frogArt[18] = glTexImageTGAFile(gl, "player_shoot_left.tga", spriteSize);
		frogArt[19] = glTexImageTGAFile(gl, "player_shoot_right.tga", spriteSize);
		
		int[] bombArt = new int[4];
		bombArt[0] = glTexImageTGAFile(gl, "bomb0.tga", bombSize);
		bombArt[1] = glTexImageTGAFile(gl, "bomb1.tga", bombSize);
		bombArt[2] = glTexImageTGAFile(gl, "bomb2.tga", bombSize);
		bombArt[3] = glTexImageTGAFile(gl, "bomb3.tga", bombSize);
		
		int[] turretArt = new int[8];
		turretArt[0] = glTexImageTGAFile(gl, "turret_s.tga", turretSize);
		turretArt[1] = glTexImageTGAFile(gl, "turret_sw.tga", turretSize);
		turretArt[2] = glTexImageTGAFile(gl, "turret_w.tga", turretSize);
		turretArt[3] = glTexImageTGAFile(gl, "turret_nw.tga", turretSize);
		turretArt[4] = glTexImageTGAFile(gl, "turret_n.tga", turretSize);
		turretArt[5] = glTexImageTGAFile(gl, "turret_ne.tga", turretSize);
		turretArt[6] = glTexImageTGAFile(gl, "turret_e.tga", turretSize);
		turretArt[7] = glTexImageTGAFile(gl, "turret_se.tga", turretSize);
		
		int[] gunmanArt = new int[15];
		gunmanArt[0] = glTexImageTGAFile(gl, "gunman_top0.tga", gunmanSize);
		gunmanArt[1] = glTexImageTGAFile(gl, "gunman_top1.tga", gunmanSize);
		gunmanArt[2] = glTexImageTGAFile(gl, "gunman_top2.tga", gunmanSize);
		gunmanArt[3] = glTexImageTGAFile(gl, "gunman_top3.tga", gunmanSize);
		gunmanArt[4] = glTexImageTGAFile(gl, "gunman_top_shoot.tga", gunmanSize);
		gunmanArt[5] = glTexImageTGAFile(gl, "gunman_left0.tga", gunmanSize);
		gunmanArt[6] = glTexImageTGAFile(gl, "gunman_left1.tga", gunmanSize);
		gunmanArt[7] = glTexImageTGAFile(gl, "gunman_left2.tga", gunmanSize);
		gunmanArt[8] = glTexImageTGAFile(gl, "gunman_left3.tga", gunmanSize);
		gunmanArt[9] = glTexImageTGAFile(gl, "gunman_left_shoot.tga", gunmanSize);
		gunmanArt[10] = glTexImageTGAFile(gl, "gunman_right0.tga", gunmanSize);
		gunmanArt[11] = glTexImageTGAFile(gl, "gunman_right1.tga", gunmanSize);
		gunmanArt[12] = glTexImageTGAFile(gl, "gunman_right2.tga", gunmanSize);
		gunmanArt[13] = glTexImageTGAFile(gl, "gunman_right3.tga", gunmanSize);
		gunmanArt[14] = glTexImageTGAFile(gl, "gunman_right_shoot.tga", gunmanSize);
		
		int[] tankArt = new int[19];
		tankArt[0] = glTexImageTGAFile(gl, "tank_head_down1.tga", tankRotateSize0);
		tankArt[1] = glTexImageTGAFile(gl, "tank_head_down2.tga", tankRotateSize1);
		tankArt[2] = glTexImageTGAFile(gl, "tank_head_down3.tga", tankRotateSize2);
		tankArt[3] = glTexImageTGAFile(gl, "tank_head_down4.tga", tankRotateSize3);
		tankArt[4] = glTexImageTGAFile(gl, "tank_head_down5.tga", tankRotateSize4);
		tankArt[5] = glTexImageTGAFile(gl, "tank_head_down6.tga", tankRotateSize5);
		tankArt[6] = glTexImageTGAFile(gl, "tank_head_down7.tga", tankRotateSize6);
		tankArt[7] = glTexImageTGAFile(gl, "tank_head_left.tga", tankRotateSize7);
		tankArt[8] = glTexImageTGAFile(gl, "tank_head_up1.tga", tankRotateSize8);
		tankArt[9] = glTexImageTGAFile(gl, "tank_head_up2.tga", tankRotateSize9);
		tankArt[10] = glTexImageTGAFile(gl, "tank_head_up3.tga", tankRotateSize10);
		tankArt[11] = glTexImageTGAFile(gl, "tank_head_up4.tga", tankRotateSize11);
		tankArt[12] = glTexImageTGAFile(gl, "tank_head_up5.tga", tankRotateSize12);
		tankArt[13] = glTexImageTGAFile(gl, "tank_head_up6.tga", tankRotateSize13);
		tankArt[14] = glTexImageTGAFile(gl, "tank_head_up7.tga", tankRotateSize14);
		tankArt[15] = glTexImageTGAFile(gl, "tank_head_up0.tga", tankHeadSize);
		tankArt[16] = glTexImageTGAFile(gl, "tank_head_down0.tga", tankHeadSize);
		tankArt[17] = glTexImageTGAFile(gl, "tank_head_up8.tga", tankHeadSize);
		tankArt[18] = glTexImageTGAFile(gl, "tank_head_down8.tga", tankHeadSize);
		
		int[] explosionArt = new int[10];
		explosionArt[0] = glTexImageTGAFile(gl, "explosion0.tga", explosionSize);
		explosionArt[1] = glTexImageTGAFile(gl, "explosion1.tga", explosionSize);
		explosionArt[2] = glTexImageTGAFile(gl, "explosion2.tga", explosionSize);
		explosionArt[3] = glTexImageTGAFile(gl, "explosion3.tga", explosionSize);
		explosionArt[4] = glTexImageTGAFile(gl, "explosion4.tga", explosionSize);
		explosionArt[5] = glTexImageTGAFile(gl, "explosion5.tga", explosionSize);
		explosionArt[6] = glTexImageTGAFile(gl, "explosion6.tga", explosionSize);
		explosionArt[7] = glTexImageTGAFile(gl, "explosion7.tga", explosionSize);
		explosionArt[8] = glTexImageTGAFile(gl, "explosion8.tga", explosionSize);
		explosionArt[9] = glTexImageTGAFile(gl, "explosion9.tga", explosionSize);
		
		ArrayList<Projectile> bubblesUp = new ArrayList<Projectile>();
		ArrayList<Projectile> bubblesLeft = new ArrayList<Projectile>();
		ArrayList<Projectile> bubblesRight = new ArrayList<Projectile>();
		ArrayList<Projectile> bubblesDown = new ArrayList<Projectile>();
		
		Enemy bomb1 = new Enemy();
		bomb1.type = "bomb";
		bomb1.defaultX = 50;
		bomb1.defaultY = -300;
		bomb1.x = bomb1Pos[0];
		bomb1.y = bomb1Pos[1];
		bomb1.width = bombSize[0];
		bomb1.height = bombSize[1];
		bomb1.image = bombTex;
		bomb1.hp = bombHp;
		bomb1.visible = true;

		Enemy bomb2 = new Enemy();
		bomb2.type = "bomb";
		bomb2.defaultX = 700;
		bomb2.defaultY = -450;
		bomb2.x = bomb2Pos[0];
		bomb2.y = bomb2Pos[1];
		bomb2.width = bombSize[0];
		bomb2.height = bombSize[1];
		bomb2.image = bombTex;
		bomb2.hp = bombHp;
		bomb2.visible = true;
		
		Enemy bomb3 = new Enemy();
		bomb3.type = "bomb";
		bomb3.defaultX = 10;
		bomb3.defaultY = -700;
		bomb3.x = bomb3Pos[0];
		bomb3.y = bomb3Pos[1];
		bomb3.width = bombSize[0];
		bomb3.height = bombSize[1];
		bomb3.image = bombTex;
		bomb3.hp = bombHp;
		bomb3.visible = true;

		Enemy bomb4 = new Enemy();
		bomb4.type = "bomb";
		bomb4.defaultX = 150;
		bomb4.defaultY = -900;
		bomb4.x = bomb4Pos[0];
		bomb4.y = bomb4Pos[1];
		bomb4.width = bombSize[0];
		bomb4.height = bombSize[1];
		bomb4.image = bombTex;
		bomb4.hp = bombHp;
		bomb4.visible = true;
		
		Enemy bomb5 = new Enemy();
		bomb5.type = "bomb";
		bomb5.defaultX = 50;
		bomb5.defaultY = -1100;
		bomb5.x = bomb5Pos[0];
		bomb5.y = bomb5Pos[1];
		bomb5.width = bombSize[0];
		bomb5.height = bombSize[1];
		bomb5.image = bombTex;
		bomb5.hp = bombHp;
		bomb5.visible = true;
		
		Enemy bomb6 = new Enemy();
		bomb6.type = "bomb";
		bomb6.defaultX = 700;
		bomb6.defaultY = -1300;
		bomb6.x = bomb6Pos[0];
		bomb6.y = bomb6Pos[1];
		bomb6.width = bombSize[0];
		bomb6.height = bombSize[1];
		bomb6.image = bombTex;
		bomb6.hp = bombHp;
		bomb6.visible = true;

		Enemy bomb7 = new Enemy();
		bomb7.type = "bomb";
		bomb7.defaultX = 10;
		bomb7.defaultY = -1400;
		bomb7.x = bomb7Pos[0];
		bomb7.y = bomb7Pos[1];
		bomb7.width = bombSize[0];
		bomb7.height = bombSize[1];
		bomb7.image = bombTex;
		bomb7.hp = bombHp;
		bomb7.visible = true;
		
		Enemy bomb8 = new Enemy();
		bomb8.type = "bomb";
		bomb8.defaultX = 770;
		bomb8.defaultY = -800;
		bomb8.x = bomb8Pos[0];
		bomb8.y = bomb8Pos[1];
		bomb8.width = bombSize[0];
		bomb8.height = bombSize[1];
		bomb8.image = bombTex;
		bomb8.hp = bombHp;
		bomb8.visible = true;
	
		Enemy bomb9 = new Enemy();
		bomb9.type = "bomb";
		bomb9.defaultX = 60;
		bomb9.defaultY = -1622;
		bomb9.x = bomb9Pos[0];
		bomb9.y = bomb9Pos[1];
		bomb9.width = bombSize[0];
		bomb9.height = bombSize[1];
		bomb9.image = bombTex;
		bomb9.hp = bombHp;
		bomb9.visible = true;
		
		Enemy bomb10 = new Enemy();
		bomb10.type = "bomb";
		bomb10.defaultX = 699;
		bomb10.defaultY = -1700;
		bomb10.x = bomb10Pos[0];
		bomb10.y = bomb10Pos[1];
		bomb10.width = bombSize[0];
		bomb10.height = bombSize[1];
		bomb10.image = bombTex;
		bomb10.hp = bombHp;
		bomb10.visible = true;
		
		Enemy bomb11 = new Enemy();
		bomb11.type = "bomb";
		bomb11.defaultX = 10;
		bomb11.defaultY = -2000;
		bomb11.x = bomb11Pos[0];
		bomb11.y = bomb11Pos[1];
		bomb11.width = bombSize[0];
		bomb11.height = bombSize[1];
		bomb11.image = bombTex;
		bomb11.hp = bombHp;
		bomb11.visible = true;
		
		Enemy bomb12 = new Enemy();
		bomb12.type = "bomb";
		bomb12.defaultX = 150;
		bomb12.defaultY = -2100;
		bomb12.x = bomb12Pos[0];
		bomb12.y = bomb12Pos[1];
		bomb12.width = bombSize[0];
		bomb12.height = bombSize[1];
		bomb12.image = bombTex;
		bomb12.hp = bombHp;
		bomb12.visible = true;
		
		Enemy turret1 = new Enemy();
		turret1.type = "turret";
		turret1.westShots = new ArrayList<Projectile>();
		turret1.northWestShots = new ArrayList<Projectile>();
		turret1.southWestShots = new ArrayList<Projectile>();
		turret1.eastShots = new ArrayList<Projectile>();
		turret1.northEastShots = new ArrayList<Projectile>();
		turret1.southEastShots = new ArrayList<Projectile>();
		turret1.southShots = new ArrayList<Projectile>();
		turret1.northShots = new ArrayList<Projectile>();
		turret1.defaultX = 50;
		turret1.defaultY = -305;
		turret1.x = turret1Pos[0];
		turret1.y = turret1Pos[1];
		turret1.width = turretSize[0];
		turret1.height = turretSize[1];
		turret1.image = turretTex;
		turret1.hp = turretHp;
		turret1.visible = true;
		
		Enemy turret2 = new Enemy();
		turret2.type = "turret";
		turret2.westShots = new ArrayList<Projectile>();
		turret2.northWestShots = new ArrayList<Projectile>();
		turret2.southWestShots = new ArrayList<Projectile>();
		turret2.eastShots = new ArrayList<Projectile>();
		turret2.northEastShots = new ArrayList<Projectile>();
		turret2.southEastShots = new ArrayList<Projectile>();
		turret2.southShots = new ArrayList<Projectile>();
		turret2.northShots = new ArrayList<Projectile>();
		turret2.defaultX = 700;
		turret2.defaultY = -128;
		turret2.x = turret2Pos[0];
		turret2.y = turret2Pos[1];
		turret2.width = turretSize[0];
		turret2.height = turretSize[1];
		turret2.image = turretTex;
		turret2.hp = turretHp;
		turret2.visible = true;
		
		Enemy turret3 = new Enemy();
		turret3.type = "turret";
		turret3.westShots = new ArrayList<Projectile>();
		turret3.northWestShots = new ArrayList<Projectile>();
		turret3.southWestShots = new ArrayList<Projectile>();
		turret3.eastShots = new ArrayList<Projectile>();
		turret3.northEastShots = new ArrayList<Projectile>();
		turret3.southEastShots = new ArrayList<Projectile>();
		turret3.southShots = new ArrayList<Projectile>();
		turret3.northShots = new ArrayList<Projectile>();
		turret3.defaultX = 50;
		turret3.defaultY = -400;
		turret3.x = turret3Pos[0];
		turret3.y = turret3Pos[1];
		turret3.width = turretSize[0];
		turret3.height = turretSize[1];
		turret3.image = turretTex;
		turret3.hp = turretHp;
		turret3.visible = true;
		
		Enemy turret4 = new Enemy();
		turret4.type = "turret";
		turret4.westShots = new ArrayList<Projectile>();
		turret4.northWestShots = new ArrayList<Projectile>();
		turret4.southWestShots = new ArrayList<Projectile>();
		turret4.eastShots = new ArrayList<Projectile>();
		turret4.northEastShots = new ArrayList<Projectile>();
		turret4.southEastShots = new ArrayList<Projectile>();
		turret4.southShots = new ArrayList<Projectile>();
		turret4.northShots = new ArrayList<Projectile>();
		turret4.defaultX = 50;
		turret4.defaultY = -700;
		turret4.x = turret4Pos[0];
		turret4.y = turret4Pos[1];
		turret4.width = turretSize[0];
		turret4.height = turretSize[1];
		turret4.image = turretTex;
		turret4.hp = turretHp;
		turret4.visible = true;

		Enemy turret5 = new Enemy();
		turret5.type = "turret";
		turret5.westShots = new ArrayList<Projectile>();
		turret5.northWestShots = new ArrayList<Projectile>();
		turret5.southWestShots = new ArrayList<Projectile>();
		turret5.eastShots = new ArrayList<Projectile>();
		turret5.northEastShots = new ArrayList<Projectile>();
		turret5.southEastShots = new ArrayList<Projectile>();
		turret5.southShots = new ArrayList<Projectile>();
		turret5.northShots = new ArrayList<Projectile>();
		turret5.defaultX = 50;
		turret5.defaultY = -900;
		turret5.x = turret5Pos[0];
		turret5.y = turret5Pos[1];
		turret5.width = turretSize[0];
		turret5.height = turretSize[1];
		turret5.image = turretTex;
		turret5.hp = turretHp;
		turret5.visible = true;
		
		Enemy turret6 = new Enemy();
		turret6.type = "turret";
		turret6.westShots = new ArrayList<Projectile>();
		turret6.northWestShots = new ArrayList<Projectile>();
		turret6.southWestShots = new ArrayList<Projectile>();
		turret6.eastShots = new ArrayList<Projectile>();
		turret6.northEastShots = new ArrayList<Projectile>();
		turret6.southEastShots = new ArrayList<Projectile>();
		turret6.southShots = new ArrayList<Projectile>();
		turret6.northShots = new ArrayList<Projectile>();
		turret6.defaultX = 700;
		turret6.defaultY = -700;
		turret6.x = turret6Pos[0];
		turret6.y = turret6Pos[1];
		turret6.width = turretSize[0];
		turret6.height = turretSize[1];
		turret6.image = turretTex;
		turret6.hp = turretHp;
		turret6.visible = true;
		
		Enemy turret7 = new Enemy();
		turret7.type = "turret";
		turret7.westShots = new ArrayList<Projectile>();
		turret7.northWestShots = new ArrayList<Projectile>();
		turret7.southWestShots = new ArrayList<Projectile>();
		turret7.eastShots = new ArrayList<Projectile>();
		turret7.northEastShots = new ArrayList<Projectile>();
		turret7.southEastShots = new ArrayList<Projectile>();
		turret7.southShots = new ArrayList<Projectile>();
		turret7.northShots = new ArrayList<Projectile>();
		turret7.defaultX = 50;
		turret7.defaultY = -800;
		turret7.x = turret7Pos[0];
		turret7.y = turret7Pos[1];
		turret7.width = turretSize[0];
		turret7.height = turretSize[1];
		turret7.image = turretTex;
		turret7.hp = turretHp;
		turret7.visible = true;
		
		Enemy turret8 = new Enemy();
		turret8.type = "turret";
		turret8.westShots = new ArrayList<Projectile>();
		turret8.northWestShots = new ArrayList<Projectile>();
		turret8.southWestShots = new ArrayList<Projectile>();
		turret8.eastShots = new ArrayList<Projectile>();
		turret8.northEastShots = new ArrayList<Projectile>();
		turret8.southEastShots = new ArrayList<Projectile>();
		turret8.southShots = new ArrayList<Projectile>();
		turret8.northShots = new ArrayList<Projectile>();
		turret8.defaultX = 50;
		turret8.defaultY = -2100;
		turret8.x = turret8Pos[0];
		turret8.y = turret8Pos[1];
		turret8.width = turretSize[0];
		turret8.height = turretSize[1];
		turret8.image = turretTex;
		turret8.hp = turretHp;
		turret8.visible = true;
		
		Enemy turret9 = new Enemy();
		turret9.type = "turret";
		turret9.westShots = new ArrayList<Projectile>();
		turret9.northWestShots = new ArrayList<Projectile>();
		turret9.southWestShots = new ArrayList<Projectile>();
		turret9.eastShots = new ArrayList<Projectile>();
		turret9.northEastShots = new ArrayList<Projectile>();
		turret9.southEastShots = new ArrayList<Projectile>();
		turret9.southShots = new ArrayList<Projectile>();
		turret9.northShots = new ArrayList<Projectile>();
		turret9.defaultX = 700;
		turret9.defaultY = -2100;
		turret9.x = turret9Pos[0];
		turret9.y = turret9Pos[1];
		turret9.width = turretSize[0];
		turret9.height = turretSize[1];
		turret9.image = turretTex;
		turret9.hp = turretHp;
		turret9.visible = true;
		
		Enemy turret10 = new Enemy();
		turret10.type = "turret";
		turret10.westShots = new ArrayList<Projectile>();
		turret10.northWestShots = new ArrayList<Projectile>();
		turret10.southWestShots = new ArrayList<Projectile>();
		turret10.eastShots = new ArrayList<Projectile>();
		turret10.northEastShots = new ArrayList<Projectile>();
		turret10.southEastShots = new ArrayList<Projectile>();
		turret10.southShots = new ArrayList<Projectile>();
		turret10.northShots = new ArrayList<Projectile>();
		turret10.defaultX = 50;
		turret10.defaultY = -2050;
		turret10.x = turret10Pos[0];
		turret10.y = turret10Pos[1];
		turret10.width = turretSize[0];
		turret10.height = turretSize[1];
		turret10.image = turretTex;
		turret10.hp = turretHp;
		turret10.visible = true;
		
		Enemy turret11 = new Enemy();
		turret11.type = "turret";
		turret11.westShots = new ArrayList<Projectile>();
		turret11.northWestShots = new ArrayList<Projectile>();
		turret11.southWestShots = new ArrayList<Projectile>();
		turret11.eastShots = new ArrayList<Projectile>();
		turret11.northEastShots = new ArrayList<Projectile>();
		turret11.southEastShots = new ArrayList<Projectile>();
		turret11.southShots = new ArrayList<Projectile>();
		turret11.northShots = new ArrayList<Projectile>();
		turret11.defaultX = 700;
		turret11.defaultY = -2050;
		turret11.x = turret11Pos[0];
		turret11.y = turret11Pos[1];
		turret11.width = turretSize[0];
		turret11.height = turretSize[1];
		turret11.image = turretTex;
		turret11.hp = turretHp;
		turret11.visible = true;
		
		Enemy turret12 = new Enemy();
		turret12.type = "turret";
		turret12.westShots = new ArrayList<Projectile>();
		turret12.northWestShots = new ArrayList<Projectile>();
		turret12.southWestShots = new ArrayList<Projectile>();
		turret12.eastShots = new ArrayList<Projectile>();
		turret12.northEastShots = new ArrayList<Projectile>();
		turret12.southEastShots = new ArrayList<Projectile>();
		turret12.southShots = new ArrayList<Projectile>();
		turret12.northShots = new ArrayList<Projectile>();
		turret12.defaultX = 50;
		turret12.defaultY = -2000;
		turret12.x = turret12Pos[0];
		turret12.y = turret12Pos[1];
		turret12.width = turretSize[0];
		turret12.height = turretSize[1];
		turret12.image = turretTex;
		turret12.hp = turretHp;
		turret12.visible = true;
		
		Enemy turret13 = new Enemy();
		turret13.type = "turret";
		turret13.westShots = new ArrayList<Projectile>();
		turret13.northWestShots = new ArrayList<Projectile>();
		turret13.southWestShots = new ArrayList<Projectile>();
		turret13.eastShots = new ArrayList<Projectile>();
		turret13.northEastShots = new ArrayList<Projectile>();
		turret13.southEastShots = new ArrayList<Projectile>();
		turret13.southShots = new ArrayList<Projectile>();
		turret13.northShots = new ArrayList<Projectile>();
		turret13.defaultX = 700;
		turret13.defaultY = -2000;
		turret13.x = turret13Pos[0];
		turret13.y = turret13Pos[1];
		turret13.width = turretSize[0];
		turret13.height = turretSize[1];
		turret13.image = turretTex;
		turret13.hp = turretHp;
		turret13.visible = true;
		
		Enemy gunman1 = new Enemy();
		gunman1.type = "top";
		gunman1.westShots = new ArrayList<Projectile>();
		gunman1.northWestShots = new ArrayList<Projectile>();
		gunman1.southWestShots = new ArrayList<Projectile>();
		gunman1.eastShots = new ArrayList<Projectile>();
		gunman1.northEastShots = new ArrayList<Projectile>();
		gunman1.southEastShots = new ArrayList<Projectile>();
		gunman1.southShots = new ArrayList<Projectile>();
		gunman1.northShots = new ArrayList<Projectile>();
		gunman1.defaultX = 850;
		gunman1.defaultY = -400;
		gunman1.x = gunman1Pos[0];
		gunman1.y = gunman1Pos[1];
		gunman1.width = gunmanSize[0];
		gunman1.height = gunmanSize[1];
		gunman1.image = gunmanTex1;
		gunman1.hp = gunmanHp;
		gunman1.visible = true;
		
		Enemy gunman2 = new Enemy();
		gunman2.type = "right";
		gunman2.westShots = new ArrayList<Projectile>();
		gunman2.northWestShots = new ArrayList<Projectile>();
		gunman2.southWestShots = new ArrayList<Projectile>();
		gunman2.eastShots = new ArrayList<Projectile>();
		gunman2.northEastShots = new ArrayList<Projectile>();
		gunman2.southEastShots = new ArrayList<Projectile>();
		gunman2.southShots = new ArrayList<Projectile>();
		gunman2.northShots = new ArrayList<Projectile>();
		gunman2.defaultX = 770;
		gunman2.defaultY = -250;
		gunman2.x = gunman2Pos[0];
		gunman2.y = gunman2Pos[1];
		gunman2.width = gunmanSize[0];
		gunman2.height = gunmanSize[1];
		gunman2.image = gunmanTex2;
		gunman2.hp = gunmanHp;
		gunman2.visible = true;
		
		Enemy gunman3 = new Enemy();
		gunman3.type = "left";
		gunman3.westShots = new ArrayList<Projectile>();
		gunman3.northWestShots = new ArrayList<Projectile>();
		gunman3.southWestShots = new ArrayList<Projectile>();
		gunman3.eastShots = new ArrayList<Projectile>();
		gunman3.northEastShots = new ArrayList<Projectile>();
		gunman3.southEastShots = new ArrayList<Projectile>();
		gunman3.southShots = new ArrayList<Projectile>();
		gunman3.northShots = new ArrayList<Projectile>();
		gunman3.defaultX = 10;
		gunman3.defaultY = -250;
		gunman3.x = gunman3Pos[0];
		gunman3.y = gunman3Pos[1];
		gunman3.width = gunmanSize[0];
		gunman3.height = gunmanSize[1];
		gunman3.image = gunmanTex3;
		gunman3.hp = gunmanHp;
		gunman3.visible = true;
		
		Enemy gunman4 = new Enemy();
		gunman4.type = "top";
		gunman4.westShots = new ArrayList<Projectile>();
		gunman4.northWestShots = new ArrayList<Projectile>();
		gunman4.southWestShots = new ArrayList<Projectile>();
		gunman4.eastShots = new ArrayList<Projectile>();
		gunman4.northEastShots = new ArrayList<Projectile>();
		gunman4.southEastShots = new ArrayList<Projectile>();
		gunman4.southShots = new ArrayList<Projectile>();
		gunman4.northShots = new ArrayList<Projectile>();
		gunman4.defaultX = 850;
		gunman4.defaultY = -800;
		gunman4.x = gunman4Pos[0];
		gunman4.y = gunman4Pos[1];
		gunman4.width = gunmanSize[0];
		gunman4.height = gunmanSize[1];
		gunman4.image = gunmanTex1;
		gunman4.hp = gunmanHp;
		gunman4.visible = true;
		
		Enemy gunman5 = new Enemy();
		gunman5.type = "right";
		gunman5.westShots = new ArrayList<Projectile>();
		gunman5.northWestShots = new ArrayList<Projectile>();
		gunman5.southWestShots = new ArrayList<Projectile>();
		gunman5.eastShots = new ArrayList<Projectile>();
		gunman5.northEastShots = new ArrayList<Projectile>();
		gunman5.southEastShots = new ArrayList<Projectile>();
		gunman5.southShots = new ArrayList<Projectile>();
		gunman5.northShots = new ArrayList<Projectile>();
		gunman5.defaultX = 770;
		gunman5.defaultY = -1545;
		gunman5.x = gunman5Pos[0];
		gunman5.y = gunman5Pos[1];
		gunman5.width = gunmanSize[0];
		gunman5.height = gunmanSize[1];
		gunman5.image = gunmanTex1;
		gunman5.hp = gunmanHp;
		gunman5.visible = true;
		
		Enemy gunman6 = new Enemy();
		gunman6.type = "left";
		gunman6.westShots = new ArrayList<Projectile>();
		gunman6.northWestShots = new ArrayList<Projectile>();
		gunman6.southWestShots = new ArrayList<Projectile>();
		gunman6.eastShots = new ArrayList<Projectile>();
		gunman6.northEastShots = new ArrayList<Projectile>();
		gunman6.southEastShots = new ArrayList<Projectile>();
		gunman6.southShots = new ArrayList<Projectile>();
		gunman6.northShots = new ArrayList<Projectile>();
		gunman6.defaultX = 10;
		gunman6.defaultY = -1243;
		gunman6.x = gunman6Pos[0];
		gunman6.y = gunman6Pos[1];
		gunman6.width = gunmanSize[0];
		gunman6.height = gunmanSize[1];
		gunman6.image = gunmanTex1;
		gunman6.hp = gunmanHp;
		gunman6.visible = true;
		
		Enemy gunman7 = new Enemy();
		gunman7.type = "top";
		gunman7.westShots = new ArrayList<Projectile>();
		gunman7.northWestShots = new ArrayList<Projectile>();
		gunman7.southWestShots = new ArrayList<Projectile>();
		gunman7.eastShots = new ArrayList<Projectile>();
		gunman7.northEastShots = new ArrayList<Projectile>();
		gunman7.southEastShots = new ArrayList<Projectile>();
		gunman7.southShots = new ArrayList<Projectile>();
		gunman7.northShots = new ArrayList<Projectile>();
		gunman7.defaultX = 850;
		gunman7.defaultY = -1600;
		gunman7.x = gunman7Pos[0];
		gunman7.y = gunman7Pos[1];
		gunman7.width = gunmanSize[0];
		gunman7.height = gunmanSize[1];
		gunman7.image = gunmanTex1;
		gunman7.hp = gunmanHp;
		gunman7.visible = true;
		
		Enemy gunman8 = new Enemy();
		gunman8.type = "right";
		gunman8.westShots = new ArrayList<Projectile>();
		gunman8.northWestShots = new ArrayList<Projectile>();
		gunman8.southWestShots = new ArrayList<Projectile>();
		gunman8.eastShots = new ArrayList<Projectile>();
		gunman8.northEastShots = new ArrayList<Projectile>();
		gunman8.southEastShots = new ArrayList<Projectile>();
		gunman8.southShots = new ArrayList<Projectile>();
		gunman8.northShots = new ArrayList<Projectile>();
		gunman8.defaultX = 770;
		gunman8.defaultY = -843;
		gunman8.x = gunman8Pos[0];
		gunman8.y = gunman8Pos[1];
		gunman8.width = gunmanSize[0];
		gunman8.height = gunmanSize[1];
		gunman8.image = gunmanTex1;
		gunman8.hp = gunmanHp;
		gunman8.visible = true;
		
		Enemy gunman9 = new Enemy();
		gunman9.type = "left";
		gunman9.westShots = new ArrayList<Projectile>();
		gunman9.northWestShots = new ArrayList<Projectile>();
		gunman9.southWestShots = new ArrayList<Projectile>();
		gunman9.eastShots = new ArrayList<Projectile>();
		gunman9.northEastShots = new ArrayList<Projectile>();
		gunman9.southEastShots = new ArrayList<Projectile>();
		gunman9.southShots = new ArrayList<Projectile>();
		gunman9.northShots = new ArrayList<Projectile>();
		gunman9.defaultX = 10;
		gunman9.defaultY = -743;
		gunman9.x = gunman9Pos[0];
		gunman9.y = gunman9Pos[1];
		gunman9.width = gunmanSize[0];
		gunman9.height = gunmanSize[1];
		gunman9.image = gunmanTex1;
		gunman9.hp = gunmanHp;
		gunman9.visible = true;
		
		Enemy gunman10 = new Enemy();
		gunman10.type = "top";
		gunman10.westShots = new ArrayList<Projectile>();
		gunman10.northWestShots = new ArrayList<Projectile>();
		gunman10.southWestShots = new ArrayList<Projectile>();
		gunman10.eastShots = new ArrayList<Projectile>();
		gunman10.northEastShots = new ArrayList<Projectile>();
		gunman10.southEastShots = new ArrayList<Projectile>();
		gunman10.southShots = new ArrayList<Projectile>();
		gunman10.northShots = new ArrayList<Projectile>();
		gunman10.defaultX = 850;
		gunman10.defaultY = -1800;
		gunman10.x = gunman10Pos[0];
		gunman10.y = gunman10Pos[1];
		gunman10.width = gunmanSize[0];
		gunman10.height = gunmanSize[1];
		gunman10.image = gunmanTex1;
		gunman10.hp = gunmanHp;
		gunman10.visible = true;
		
		Enemy gunman11 = new Enemy();
		gunman11.type = "right";
		gunman11.westShots = new ArrayList<Projectile>();
		gunman11.northWestShots = new ArrayList<Projectile>();
		gunman11.southWestShots = new ArrayList<Projectile>();
		gunman11.eastShots = new ArrayList<Projectile>();
		gunman11.northEastShots = new ArrayList<Projectile>();
		gunman11.southEastShots = new ArrayList<Projectile>();
		gunman11.southShots = new ArrayList<Projectile>();
		gunman11.northShots = new ArrayList<Projectile>();
		gunman11.defaultX = 770;
		gunman11.defaultY = -1243;
		gunman11.x = gunman11Pos[0];
		gunman11.y = gunman11Pos[1];
		gunman11.width = gunmanSize[0];
		gunman11.height = gunmanSize[1];
		gunman11.image = gunmanTex1;
		gunman11.hp = gunmanHp;
		gunman11.visible = true;
		
		Enemy gunman12 = new Enemy();
		gunman12.type = "left";
		gunman12.westShots = new ArrayList<Projectile>();
		gunman12.northWestShots = new ArrayList<Projectile>();
		gunman12.southWestShots = new ArrayList<Projectile>();
		gunman12.eastShots = new ArrayList<Projectile>();
		gunman12.northEastShots = new ArrayList<Projectile>();
		gunman12.southEastShots = new ArrayList<Projectile>();
		gunman12.southShots = new ArrayList<Projectile>();
		gunman12.northShots = new ArrayList<Projectile>();
		gunman12.defaultX = 10;
		gunman12.defaultY = -456;
		gunman12.x = gunman12Pos[0];
		gunman12.y = gunman12Pos[1];
		gunman12.width = gunmanSize[0];
		gunman12.height = gunmanSize[1];
		gunman12.image = gunmanTex1;
		gunman12.hp = gunmanHp;
		gunman12.visible = true;
		
		Enemy gunman13 = new Enemy();
		gunman13.type = "top";
		gunman13.westShots = new ArrayList<Projectile>();
		gunman13.northWestShots = new ArrayList<Projectile>();
		gunman13.southWestShots = new ArrayList<Projectile>();
		gunman13.eastShots = new ArrayList<Projectile>();
		gunman13.northEastShots = new ArrayList<Projectile>();
		gunman13.southEastShots = new ArrayList<Projectile>();
		gunman13.southShots = new ArrayList<Projectile>();
		gunman13.northShots = new ArrayList<Projectile>();
		gunman13.defaultX = 850;
		gunman13.defaultY = -557;
		gunman13.x = gunman13Pos[0];
		gunman13.y = gunman13Pos[1];
		gunman13.width = gunmanSize[0];
		gunman13.height = gunmanSize[1];
		gunman13.image = gunmanTex1;
		gunman13.hp = gunmanHp;
		gunman13.visible = true;
		
		Enemy gunman14 = new Enemy();
		gunman14.type = "right";
		gunman14.westShots = new ArrayList<Projectile>();
		gunman14.northWestShots = new ArrayList<Projectile>();
		gunman14.southWestShots = new ArrayList<Projectile>();
		gunman14.eastShots = new ArrayList<Projectile>();
		gunman14.northEastShots = new ArrayList<Projectile>();
		gunman14.southEastShots = new ArrayList<Projectile>();
		gunman14.southShots = new ArrayList<Projectile>();
		gunman14.northShots = new ArrayList<Projectile>();
		gunman14.defaultX = 770;
		gunman14.defaultY = -1994;
		gunman14.x = gunman14Pos[0];
		gunman14.y = gunman14Pos[1];
		gunman14.width = gunmanSize[0];
		gunman14.height = gunmanSize[1];
		gunman14.image = gunmanTex1;
		gunman14.hp = gunmanHp;
		gunman14.visible = true;
		
		Enemy gunman15 = new Enemy();
		gunman15.type = "left";
		gunman15.westShots = new ArrayList<Projectile>();
		gunman15.northWestShots = new ArrayList<Projectile>();
		gunman15.southWestShots = new ArrayList<Projectile>();
		gunman15.eastShots = new ArrayList<Projectile>();
		gunman15.northEastShots = new ArrayList<Projectile>();
		gunman15.southEastShots = new ArrayList<Projectile>();
		gunman15.southShots = new ArrayList<Projectile>();
		gunman15.northShots = new ArrayList<Projectile>();
		gunman15.defaultX = 10;
		gunman15.defaultY = -1839;
		gunman15.x = gunman15Pos[0];
		gunman15.y = gunman15Pos[1];
		gunman15.width = gunmanSize[0];
		gunman15.height = gunmanSize[1];
		gunman15.image = gunmanTex1;
		gunman15.hp = gunmanHp;
		gunman15.visible = true;
		
		Enemy gunman16 = new Enemy();
		gunman16.type = "right";
		gunman16.westShots = new ArrayList<Projectile>();
		gunman16.northWestShots = new ArrayList<Projectile>();
		gunman16.southWestShots = new ArrayList<Projectile>();
		gunman16.eastShots = new ArrayList<Projectile>();
		gunman16.northEastShots = new ArrayList<Projectile>();
		gunman16.southEastShots = new ArrayList<Projectile>();
		gunman16.southShots = new ArrayList<Projectile>();
		gunman16.northShots = new ArrayList<Projectile>();
		gunman16.defaultX = 770;
		gunman16.defaultY = -1200;
		gunman16.x = gunman16Pos[0];
		gunman16.y = gunman16Pos[1];
		gunman16.width = gunmanSize[0];
		gunman16.height = gunmanSize[1];
		gunman16.image = gunmanTex1;
		gunman16.hp = gunmanHp;
		gunman16.visible = true;
		
		Enemy gunman17 = new Enemy();
		gunman17.type = "left";
		gunman17.westShots = new ArrayList<Projectile>();
		gunman17.northWestShots = new ArrayList<Projectile>();
		gunman17.southWestShots = new ArrayList<Projectile>();
		gunman17.eastShots = new ArrayList<Projectile>();
		gunman17.northEastShots = new ArrayList<Projectile>();
		gunman17.southEastShots = new ArrayList<Projectile>();
		gunman17.southShots = new ArrayList<Projectile>();
		gunman17.northShots = new ArrayList<Projectile>();
		gunman17.defaultX = 10;
		gunman17.defaultY = -1400;
		gunman17.x = gunman17Pos[0];
		gunman17.y = gunman17Pos[1];
		gunman17.width = gunmanSize[0];
		gunman17.height = gunmanSize[1];
		gunman17.image = gunmanTex1;
		gunman17.hp = gunmanHp;
		gunman17.visible = true;
		
		Enemy tank = new Enemy();
		tank.type = "tank";
		tank.westShots = new ArrayList<Projectile>();
		tank.northWestShots = new ArrayList<Projectile>();
		tank.southWestShots = new ArrayList<Projectile>();
		tank.eastShots = new ArrayList<Projectile>();
		tank.northEastShots = new ArrayList<Projectile>();
		tank.southEastShots = new ArrayList<Projectile>();
		tank.southShots = new ArrayList<Projectile>();
		tank.northShots = new ArrayList<Projectile>();
		tank.defaultX = 375;
		tank.defaultY = -2400;
		tank.x = tankBodyPos[0];
		tank.y = tankBodyPos[1];
		tank.headX = tankHeadPos[0];
		tank.headY = tankHeadPos[1];
		tank.leftPanelX = tankLeftPanelPos[0];
		tank.leftPanelY = tankLeftPanelPos[1];
		tank.rightPanelX = tankRightPanelPos[0];
		tank.rightPanelY = tankRightPanelPos[1];
		tank.width = tankBodySize[0];
		tank.height = tankBodySize[1];
		tank.image = tankBodyTex;
		tank.hp = tankHp;
		tank.visible = true;
		
		Enemy[] enemies = new Enemy[43];
		enemies[0] = bomb1;
		enemies[1] = bomb2;
		enemies[2] = bomb3;
		enemies[3] = bomb4;
		enemies[4] = turret1;
		enemies[5] = turret2;
		enemies[6] = turret3;
		enemies[7] = gunman1;
		enemies[8] = gunman2;
		enemies[9] = gunman3;
		enemies[10] = tank;
		enemies[11] = bomb5;
		enemies[12] = bomb6;
		enemies[13] = bomb7;
		enemies[14] = bomb8;
		enemies[15] = bomb9;
		enemies[16] = bomb10;
		enemies[17] = bomb11;
		enemies[18] = bomb12;
		enemies[19] = turret4;
		enemies[20] = turret5;
		enemies[21] = turret6;
		enemies[22] = turret7;
		enemies[23] = turret8;
		enemies[24] = turret9;
		enemies[25] = gunman4;
		enemies[26] = gunman5;
		enemies[27] = gunman6;
		enemies[28] = gunman7;
		enemies[29] = gunman8;
		enemies[30] = gunman9;
		enemies[31] = gunman10;
		enemies[32] = gunman11;
		enemies[33] = gunman12;
		enemies[34] = gunman13;
		enemies[35] = gunman14;
		enemies[36] = gunman15;
		enemies[37] = turret10;
		enemies[38] = turret11;
		enemies[39] = gunman16;
		enemies[40] = gunman17;
		enemies[41] = turret12;
		enemies[42] = turret13;
		
		Sound soundtrack = Sound.load("soundtrack.wav");
		Sound deathScream = Sound.load("scream.wav");
		Sound youWon = Sound.load("youwon.wav");
		Clip backgroundClip = soundtrack.playLooped();
		Clip youWonClip = null;
		
		boolean soundtrackPlaying = false;
		
		int frogOldX = spritePos[0];
		int frogOldY = spritePos[1];
		
		int score = 0;
		boolean bossFight = false;
		boolean dead = false;
		
		FontDef aharoni = new FontDef();
		aharoni.height = 16;
		aharoni.glyphs = new GlyphDef[30];
		GlyphDef aharoni0 = new GlyphDef();
		aharoni0.texName = glTexImageTGAFile(gl, "aharoni_bold_0.tga", fontSize);
		GlyphDef aharoni1 = new GlyphDef();
		aharoni1.texName = glTexImageTGAFile(gl, "aharoni_bold_1.tga", fontSize);
		GlyphDef aharoni2 = new GlyphDef();
		aharoni2.texName = glTexImageTGAFile(gl, "aharoni_bold_2.tga", fontSize);
		GlyphDef aharoni3 = new GlyphDef();
		aharoni3.texName = glTexImageTGAFile(gl, "aharoni_bold_3.tga", fontSize);
		GlyphDef aharoni4 = new GlyphDef();
		aharoni4.texName = glTexImageTGAFile(gl, "aharoni_bold_4.tga", fontSize);
		GlyphDef aharoni5 = new GlyphDef();
		aharoni5.texName = glTexImageTGAFile(gl, "aharoni_bold_5.tga", fontSize);
		GlyphDef aharoni6 = new GlyphDef();
		aharoni6.texName = glTexImageTGAFile(gl, "aharoni_bold_6.tga", fontSize);
		GlyphDef aharoni7 = new GlyphDef();
		aharoni7.texName = glTexImageTGAFile(gl, "aharoni_bold_7.tga", fontSize);
		GlyphDef aharoni8 = new GlyphDef();
		aharoni8.texName = glTexImageTGAFile(gl, "aharoni_bold_8.tga", fontSize);
		GlyphDef aharoni9 = new GlyphDef();
		aharoni9.texName = glTexImageTGAFile(gl, "aharoni_bold_9.tga", fontSize);
		GlyphDef aharoniColon = new GlyphDef();
		aharoniColon.texName = glTexImageTGAFile(gl, "aharoni_bold_colon.tga", fontSize);
		GlyphDef aharoniExclaim = new GlyphDef();
		aharoniExclaim.texName = glTexImageTGAFile(gl, "aharoni_bold_exclaim.tga", fontSize);
		GlyphDef aharoniA = new GlyphDef();
		aharoniA.texName = glTexImageTGAFile(gl, "aharoni_bold_a.tga", fontSize);
		GlyphDef aharoniB = new GlyphDef();
		aharoniB.texName = glTexImageTGAFile(gl, "aharoni_bold_b.tga", fontSize);
		GlyphDef aharoniC = new GlyphDef();
		aharoniC.texName = glTexImageTGAFile(gl, "aharoni_bold_c.tga", fontSize);
		GlyphDef aharoniD = new GlyphDef();
		aharoniD.texName = glTexImageTGAFile(gl, "aharoni_bold_d.tga", fontSize);
		GlyphDef aharoniE = new GlyphDef();
		aharoniE.texName = glTexImageTGAFile(gl, "aharoni_bold_e.tga", fontSize);
		GlyphDef aharoniG = new GlyphDef();
		aharoniG.texName = glTexImageTGAFile(gl, "aharoni_bold_g.tga", fontSize);
		GlyphDef aharoniH = new GlyphDef();
		aharoniH.texName = glTexImageTGAFile(gl, "aharoni_bold_h.tga", fontSize);
		GlyphDef aharoniI = new GlyphDef();
		aharoniI.texName = glTexImageTGAFile(gl, "aharoni_bold_i.tga", fontSize);
		GlyphDef aharoniM = new GlyphDef();
		aharoniM.texName = glTexImageTGAFile(gl, "aharoni_bold_m.tga", fontSize);
		GlyphDef aharoniN = new GlyphDef();
		aharoniN.texName = glTexImageTGAFile(gl, "aharoni_bold_n.tga", fontSize);
		GlyphDef aharoniO = new GlyphDef();
		aharoniO.texName = glTexImageTGAFile(gl, "aharoni_bold_o.tga", fontSize);
		GlyphDef aharoniP = new GlyphDef();
		aharoniP.texName = glTexImageTGAFile(gl, "aharoni_bold_p.tga", fontSize);
		GlyphDef aharoniR = new GlyphDef();
		aharoniR.texName = glTexImageTGAFile(gl, "aharoni_bold_r.tga", fontSize);
		GlyphDef aharoniS = new GlyphDef();
		aharoniS.texName = glTexImageTGAFile(gl, "aharoni_bold_s.tga", fontSize);
		GlyphDef aharoniT = new GlyphDef();
		aharoniT.texName = glTexImageTGAFile(gl, "aharoni_bold_t.tga", fontSize);
		GlyphDef aharoniU = new GlyphDef();
		aharoniU.texName = glTexImageTGAFile(gl, "aharoni_bold_u.tga", fontSize);
		GlyphDef aharoniW = new GlyphDef();
		aharoniW.texName = glTexImageTGAFile(gl, "aharoni_bold_w.tga", fontSize);
		GlyphDef aharoniY = new GlyphDef();
		aharoniY.texName = glTexImageTGAFile(gl, "aharoni_bold_y.tga", fontSize);

		aharoni.glyphs[0] = aharoni0;
		aharoni.glyphs[1] = aharoni1;
		aharoni.glyphs[2] = aharoni2;
		aharoni.glyphs[3] = aharoni3;
		aharoni.glyphs[4] = aharoni4;
		aharoni.glyphs[5] = aharoni5;
		aharoni.glyphs[6] = aharoni6;
		aharoni.glyphs[7] = aharoni7;
		aharoni.glyphs[8] = aharoni8;
		aharoni.glyphs[9] = aharoni9;
		aharoni.glyphs[10] = aharoniColon;
		aharoni.glyphs[11] = aharoniExclaim;
		aharoni.glyphs[12] = aharoniA;
		aharoni.glyphs[13] = aharoniB;
		aharoni.glyphs[14] = aharoniC;
		aharoni.glyphs[15] = aharoniD;
		aharoni.glyphs[16] = aharoniE;
		aharoni.glyphs[17] = aharoniG;
		aharoni.glyphs[18] = aharoniH;
		aharoni.glyphs[19] = aharoniI;
		aharoni.glyphs[20] = aharoniM;
		aharoni.glyphs[21] = aharoniN;
		aharoni.glyphs[22] = aharoniO;
		aharoni.glyphs[23] = aharoniP;
		aharoni.glyphs[24] = aharoniR;
		aharoni.glyphs[25] = aharoniS;
		aharoni.glyphs[26] = aharoniT;
		aharoni.glyphs[27] = aharoniU;
		aharoni.glyphs[28] = aharoniW;
		aharoni.glyphs[29] = aharoniY;
		
		int shotTimer = 0;
		int tankAnimationTimerDown = 0;
		int tankAnimationTimerUp = 0;
		boolean tankRotated = false;
		boolean iFrame = false;
		int iTimer = 0;
		boolean flicker = false;
		int shotOffset = 15;
		int explosionX = 0;
		int explosionY = 0;
		boolean exploding = false;
		boolean start = false;

		// The game loop
		int physicsDeltaMS = 10;
		int lastPhysicsFrameMS = 0;
		long lastFrameNS;
		long curFrameNS = System.nanoTime();
		int distance = (int) (Math.sqrt((Math.pow((refPoint[0] - spritePos[0]), 2)) + (Math.pow((refPoint[1] - spritePos[1]), 2))));
		while (!shouldExit) {
			System.arraycopy(kbState, 0, kbPrevState, 0, kbState.length);
			lastFrameNS = curFrameNS;
			curFrameNS = System.nanoTime();
			long deltaTimeMS = (curFrameNS - lastFrameNS) / 1000000;
			
			// Actually, this runs the entire OS message pump.
			window.display();

			if (!window.isVisible()) {
				shouldExit = true;
				break;
			}
			
			if (tank.hp <= 0){
				if (!soundtrackPlaying){
					backgroundClip.stop();
					youWonClip = youWon.playLooped();
					soundtrackPlaying = true;
				}
				if (kbState[KeyEvent.VK_SPACE]){
					youWonClip.stop();
					backgroundClip.setMicrosecondPosition(0);
					backgroundClip.stop();
					backgroundClip = soundtrack.playLooped();
					spritePos[0] = -1000;
					spritePos[1] = -1000;
					playerHp = 10;
					bossFight = false;
					tankRotated = false;
					score = 0;
					tank.hp = 50;
					tank.x = -100;
					tank.y = -100;
					tank.headX = tank.x + 20;
					tank.headY = tank.y + 35;
					tank.leftPanelX = tank.x;
					tank.leftPanelY = tank.y + 35;
					tank.rightPanelX = tank.x + 65;
					tank.rightPanelY = tank.y + 35;
					for (Enemy e : enemies){
						e.x = -100;
						e.y = -100;
						if (!e.type.equals("bomb")){
							e.eastShots.clear();
							e.southWestShots.clear();
							e.southShots.clear();
							e.southEastShots.clear();
							e.northShots.clear();
							e.northWestShots.clear();
							e.northEastShots.clear();
							e.westShots.clear();
						}
						e.visible = true;
					}
					c.x = 16;
					c.y = 16;
					c.width = 800;
					c.height = 600;
					dead = false;
					if (kbState[KeyEvent.VK_SPACE]){
						spritePos[0] = 375;
						spritePos[1] = 275;
						playerHp = 10;
						score = 0;
						bossFight = false;
						tankRotated = false;
						for (Enemy e : enemies){
							e.x = e.defaultX;
							e.y = e.defaultY;
						}
						tank.headX = tank.x + 20;
						tank.headY = tank.y + 35;
						tank.leftPanelX = tank.x;
						tank.leftPanelY = tank.y + 35;
						tank.rightPanelX = tank.x + 65;
						tank.rightPanelY = tank.y + 35;
						for (Enemy e : enemies){
							if (!e.type.equals("bomb")){
								e.eastShots.clear();
								e.southWestShots.clear();
								e.southShots.clear();
								e.southEastShots.clear();
								e.northShots.clear();
								e.northWestShots.clear();
								e.northEastShots.clear();
								e.westShots.clear();
							}
							e.visible = true;
						}
						c.x = 16;
						c.y = 16;
						c.width = 800;
						c.height = 600;
						dead = false;
						start = true;
					}
				}
			}
			
			if (start == false){
				spritePos[0] = -1000;
				spritePos[1] = -1000;
				playerHp = 10;
				bossFight = false;
				tankRotated = false;
				score = 0;
				tank.hp = 50;
				tank.x = -100;
				tank.y = -100;
				tank.headX = tank.x + 20;
				tank.headY = tank.y + 35;
				tank.leftPanelX = tank.x;
				tank.leftPanelY = tank.y + 35;
				tank.rightPanelX = tank.x + 65;
				tank.rightPanelY = tank.y + 35;
				for (Enemy e : enemies){
					e.x = -100;
					e.y = -100;
					if (!e.type.equals("bomb")){
						e.eastShots.clear();
						e.southWestShots.clear();
						e.southShots.clear();
						e.southEastShots.clear();
						e.northShots.clear();
						e.northWestShots.clear();
						e.northEastShots.clear();
						e.westShots.clear();
					}
					e.visible = true;
				}
				c.x = 16;
				c.y = 16;
				c.width = 800;
				c.height = 600;
				dead = false;
				if (kbState[KeyEvent.VK_SPACE]){
					spritePos[0] = 375;
					spritePos[1] = 275;
					playerHp = 10;
					score = 0;
					bossFight = false;
					tankRotated = false;
					for (Enemy e : enemies){
						e.x = e.defaultX;
						e.y = e.defaultY;
					}
					tank.headX = tank.x + 20;
					tank.headY = tank.y + 35;
					tank.leftPanelX = tank.x;
					tank.leftPanelY = tank.y + 35;
					tank.rightPanelX = tank.x + 65;
					tank.rightPanelY = tank.y + 35;
					for (Enemy e : enemies){
						if (!e.type.equals("bomb")){
							e.eastShots.clear();
							e.southWestShots.clear();
							e.southShots.clear();
							e.southEastShots.clear();
							e.northShots.clear();
							e.northWestShots.clear();
							e.northEastShots.clear();
							e.westShots.clear();
						}
						e.visible = true;
					}
					c.x = 16;
					c.y = 16;
					c.width = 800;
					c.height = 600;
					dead = false;
					start = true;
				}
			}
			
			if (dead == true){
				deathScream.play();
				spritePos[0] = -100;
				spritePos[1] = -100;
				bossFight = false;
				score = 0;
				c.y += ((distance * 1 * deltaTimeMS) / 5000);
				if (kbState[KeyEvent.VK_SPACE]){
					spritePos[0] = 375;
					spritePos[1] = 275;
					playerHp = 10;
					for (Enemy e : enemies){
						e.x = e.defaultX;
						e.y = e.defaultY;
					}
					tank.hp = 50;
					tank.headX = tank.x + 20;
					tank.headY = tank.y + 35;
					tank.leftPanelX = tank.x;
					tank.leftPanelY = tank.y + 35;
					tank.rightPanelX = tank.x + 65;
					tank.rightPanelY = tank.y + 35;
					for (Enemy e : enemies){
						if (!e.type.equals("bomb")){
							e.eastShots.clear();
							e.southWestShots.clear();
							e.southShots.clear();
							e.southEastShots.clear();
							e.northShots.clear();
							e.northWestShots.clear();
							e.northEastShots.clear();
							e.westShots.clear();
						}
						e.visible = true;
					}
					c.x = 16;
					c.y = 16;
					c.width = 800;
					c.height = 600;
					dead = false;
				}
			}
			
			do {
				startX = c.x / 16;
				endX = (c.x + 820) / 16;
				startY = (c.y / 16) - 1;
				endY = (c.y + 620) / 16;
				
				if (bossFight == false){
					c.y -= ((distance * 1 * deltaTimeMS) / 5000);
				}
				if (c.y < -2200){
					bossFight = true;
				}
				
				Camera frogBox = new Camera();
				frogBox.x = spritePos[0];
				frogBox.y = spritePos[1];
				frogBox.width = spriteSize[0];
				frogBox.height = spriteSize[1];
				
				if (iFrame == true){
					flicker = true;
					iTimer++;
					if (iTimer % 50 == 0){
						iFrame = false;
						flicker = false;
					}
				}
				
				for (Enemy e : enemies){
					if (e.type.equals("turret") || e.type.equals("top") || e.type.equals("left") || e.type.equals("right") || e.type.equals("tank") || e.type.equals("bomb")){
						if (e.visible){
							Camera enemyBox = new Camera();
							if (e.type.equals("tank")){
								enemyBox.x = tank.x;
								enemyBox.y = tank.y;
								enemyBox.width = tankBodySize[0];
								enemyBox.height = tankBodySize[1];
							}
							else {
								enemyBox.x = e.x;
								enemyBox.y = e.y;
								enemyBox.width = e.width;
								enemyBox.height = e.height;
							}
							if (AABBIntersect(enemyBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
								if (e.type.equals("bomb")){
									exploding = true;
									explosionX = e.x;
									explosionY = e.y;
									e.visible = false;
									if (iFrame == false) {
										playerHp -= 2;
										iFrame = true;
									}
								}
								else {
									if (iFrame == false){
										playerHp -= 1;
										iFrame = true;
									}
								}
								if (playerHp <= 0){
									dead = true;
								}
							}
							if (e.eastShots != null){
								for (int i = 0; i < e.westShots.size(); i++){
									Projectile shot = e.westShots.get(i);
									shot.x += ((distance * 1 * deltaTimeMS) / 1200);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.westShots.get(i).visible = false;
										e.westShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.northWestShots.size(); i++){
									Projectile shot = e.northWestShots.get(i);
									shot.x += ((distance * 1 * deltaTimeMS) / 1500);
									shot.y -= ((distance * 1 * deltaTimeMS) / 1500);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.northWestShots.get(i).visible = false;
										e.northWestShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.southWestShots.size(); i++){
									Projectile shot = e.southWestShots.get(i);
									shot.x += ((distance * 1 * deltaTimeMS) / 1500);
									shot.y += ((distance * 1 * deltaTimeMS) / 1500);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.southWestShots.get(i).visible = false;
										e.southWestShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.eastShots.size(); i++){
									Projectile shot = e.eastShots.get(i);
									shot.x -= ((distance * 1 * deltaTimeMS) / 1200);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.eastShots.get(i).visible = false;
										e.eastShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.northEastShots.size(); i++){
									Projectile shot = e.northEastShots.get(i);
									shot.x -= ((distance * 1 * deltaTimeMS) / 1500);
									shot.y += ((distance * 1 * deltaTimeMS) / 1500);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.northEastShots.get(i).visible = false;
										e.northEastShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.southEastShots.size(); i++){
									Projectile shot = e.southEastShots.get(i);
									shot.x -= ((distance * 1 * deltaTimeMS) / 1500);
									shot.y -= ((distance * 1 * deltaTimeMS) / 1500);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.southEastShots.get(i).visible = false;
										e.southEastShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.southShots.size(); i++){
									Projectile shot = e.southShots.get(i);
									shot.y += ((distance * 1 * deltaTimeMS) / 1500);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.southShots.get(i).visible = false;
										e.southShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
								for (int i = 0; i < e.northShots.size(); i++){
									Projectile shot = e.northShots.get(i);
									shot.y -= ((distance * 1 * deltaTimeMS) / 1500);
									Camera bubbleBox = new Camera();
									bubbleBox.x = shot.x;
									bubbleBox.y = shot.y;
									bubbleBox.width = shot.width;
									bubbleBox.height = shot.height;
									if (AABBIntersect(bubbleBox, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1]) && e.visible == true){
										e.northShots.get(i).visible = false;
										e.northShots.remove(i);
										if (iFrame == false) {
											playerHp -= 1;
											iFrame = true;
										}
										if (playerHp <= 0){
											dead = true;
										}
									}
								}
							}
						}
					}
				}
				
				for (int i = 0; i < bubblesUp.size(); i++){
					Projectile bubble = bubblesUp.get(i);
					bubble.y -= ((distance * 1 * deltaTimeMS) / 1000);
					Camera bubbleBox = new Camera();
					bubbleBox.x = bubble.x;
					bubbleBox.y = bubble.y;
					bubbleBox.width = bubble.width;
					bubbleBox.height = bubble.height;
					for (Enemy e : enemies){
						if (AABBIntersect(bubbleBox, e.x, e.y, e.width, e.height) && e.visible == true){
							if (bubblesUp.get(i) != null){
								bubblesUp.get(i).visible = false;
								bubblesUp.remove(i);
							}
							e.hp -= 1;
							if (e.hp <= 0){
								e.visible = false;
								if (e.type.equals("bomb")){
									score += 10;
								}
								else if (e.type.equals("top") || e.type.equals("left") || e.type.equals("right")){
									score += 100;
								}
								else if (e.type.equals("turret")){
									score += 50;
									exploding = true;
									explosionX = e.x;
									explosionY = e.y;
								}
								else if (e.type.equals("tank")){
									score += 1000;
								}
							}
						}
					}
				}	
				for (int i = 0; i < bubblesLeft.size(); i++){
					Projectile bubble = bubblesLeft.get(i);
					bubble.x -= ((distance * 1 * deltaTimeMS) / 1000);
					Camera bubbleBox = new Camera();
					bubbleBox.x = bubble.x;
					bubbleBox.y = bubble.y;
					bubbleBox.width = bubble.width;
					bubbleBox.height = bubble.height;
					for (Enemy e : enemies){
						if (AABBIntersect(bubbleBox, e.x, e.y, e.width, e.height) && e.visible == true){
							if (bubblesLeft.get(i) != null){
								bubblesLeft.get(i).visible = false;
								bubblesLeft.remove(i);
							}
							e.hp -= 1;
							if (e.hp <= 0){
								e.visible = false;
								if (e.type.equals("bomb")){
									score += 10;
								}
								else if (e.type.equals("top") || e.type.equals("left") || e.type.equals("right")){
									score += 100;
								}
								else if (e.type.equals("turret")){
									score += 50;
									exploding = true;
									explosionX = e.x;
									explosionY = e.y;
								}
								else if (e.type.equals("tank")){
									score += 1000;
								}
							}
						}
					}
				}		
				for (int i = 0; i < bubblesRight.size(); i++){
					Projectile bubble = bubblesRight.get(i);
					bubble.x += ((distance * 1 * deltaTimeMS) / 1000);
					Camera bubbleBox = new Camera();
					bubbleBox.x = bubble.x;
					bubbleBox.y = bubble.y;
					bubbleBox.width = bubble.width;
					bubbleBox.height = bubble.height;
					for (Enemy e : enemies){
						if (AABBIntersect(bubbleBox, e.x, e.y, e.width, e.height) && e.visible == true){
							if (bubblesRight.get(i) != null){
								bubblesRight.get(i).visible = false;
								bubblesRight.remove(i);
							}
							e.hp -= 1;
							if (e.hp <= 0){
								e.visible = false;
								if (e.type.equals("bomb")){
									score += 10;
								}
								else if (e.type.equals("top") || e.type.equals("left") || e.type.equals("right")){
									score += 100;
								}
								else if (e.type.equals("turret")){
									score += 50;
									exploding = true;
									explosionX = e.x;
									explosionY = e.y;
								}
								else if (e.type.equals("tank")){
									score += 1000;
								}
							}
						}
					}
				}
				for (int i = 0; i < bubblesDown.size(); i++){
					Projectile bubble = bubblesDown.get(i);
					bubble.y += ((distance * 1 * deltaTimeMS) / 1000);
					Camera bubbleBox = new Camera();
					bubbleBox.x = bubble.x;
					bubbleBox.y = bubble.y;
					bubbleBox.width = bubble.width;
					bubbleBox.height = bubble.height;
					for (Enemy e : enemies){
						if (AABBIntersect(bubbleBox, e.x, e.y, e.width, e.height) && e.visible == true){
							if (bubblesDown.get(i) != null){
								bubblesDown.get(i).visible = false;
								bubblesDown.remove(i);
							}
							e.hp -= 1;
							if (e.hp <= 0){
								e.visible = false;
								if (e.type.equals("bomb")){
									score += 10;
								}
								else if (e.type.equals("top") || e.type.equals("left") || e.type.equals("right")){
									score += 100;
								}
								else if (e.type.equals("turret")){
									score += 50;
									exploding = true;
									explosionX = e.x;
									explosionY = e.y;
								}
								else if (e.type.equals("tank")){
									score += 1000;
								}
							}
						}
					}
				}
				lastPhysicsFrameMS += physicsDeltaMS;
			} while (lastPhysicsFrameMS + physicsDeltaMS < deltaTimeMS );
			
			frogOldX = spritePos[0];
			frogOldY = spritePos[1];

			// Game logic goes here.
			if (kbState[KeyEvent.VK_ESCAPE]) {
				shouldExit = true;
			}
			
			shotTimer++;
			
			if (exploding == true){
				explosionAnimation.update(deltaTimeMS);
				explosionTex = explosionArt[explosionAnimation.def.frames[explosionAnimation.curFrame].image];
				if (explosionAnimation.def.frames[explosionAnimation.curFrame].image == 8) {
					exploding = false;
				}
			}
			
			for (Enemy e : enemies){
				if (e.type.equals("bomb")){
					bombSpinAnimation.update(deltaTimeMS);
					bombTex = bombArt[bombSpinAnimation.def.frames[bombSpinAnimation.curFrame].image];
					e.image = bombTex;
					if (spritePos[1] < (e.y + 700)){
						if (spritePos[0] > e.x){
							e.x += ((distance * 1 * deltaTimeMS) / 3000);
						}
						if (spritePos[1] > e.y){
							e.y += ((distance * 1 * deltaTimeMS) / 3000);
						}	
						if (spritePos[0] < e.x){
							e.x -= ((distance * 1 * deltaTimeMS) / 3000);
						}
						if (spritePos[1] < e.y){
							e.y -= ((distance * 1 * deltaTimeMS) / 3000);
						}
					}
				}
				if (e.type.equals("turret")){
					if (spritePos[1] < (e.y + 400)){
						if (e.x < 300){
							if (spritePos[1] < e.y){
								if (shotTimer % 100 == 0){
									Projectile p = new Projectile();
									p.x = e.x;
									p.y = e.y;
									p.width = enemyShotSize[0];
									p.height = enemyShotSize[1];
									p.speed = ((distance * 1 * deltaTimeMS) / 500);
									p.shotTimer = 100;
									e.northWestShots.add(p);
								}
								turretTex = turretArt[5];
								e.image = turretTex;
							}
							if (spritePos[1] > e.y){
								if (shotTimer % 100 == 0){
									Projectile p = new Projectile();
									p.x = e.x;
									p.y = e.y;
									p.width = enemyShotSize[0];
									p.height = enemyShotSize[1];
									p.speed = ((distance * 1 * deltaTimeMS) / 500);
									p.shotTimer = 100;
									e.southWestShots.add(p);
								}
								turretTex = turretArt[7];
								e.image = turretTex;
							}
							if (spritePos[1] >= (e.y - 50) && spritePos[1] <= (e.y + 50)){
								if (shotTimer % 100 == 0){
									Projectile p = new Projectile();
									p.x = e.x;
									p.y = e.y;
									p.width = enemyShotSize[0];
									p.height = enemyShotSize[1];
									p.speed = ((distance * 1 * deltaTimeMS) / 500);
									p.shotTimer = 100;
									e.westShots.add(p);
								}
								turretTex = turretArt[6];
								e.image = turretTex;
							}
						}
						if (e.x > 300){
							if (spritePos[1] < e.y){
								if (shotTimer % 100 == 0){
									Projectile p = new Projectile();
									p.x = e.x;
									p.y = e.y;
									p.width = enemyShotSize[0];
									p.height = enemyShotSize[1];
									p.speed = ((distance * 1 * deltaTimeMS) / 500);
									p.shotTimer = 100;
									e.southEastShots.add(p);
								}
								turretTex = turretArt[3];
								e.image = turretTex;
							}
							if (spritePos[1] > e.y){
								if (shotTimer % 100 == 0){
									Projectile p = new Projectile();
									p.x = e.x;
									p.y = e.y;
									p.width = enemyShotSize[0];
									p.height = enemyShotSize[1];
									p.speed = ((distance * 1 * deltaTimeMS) / 500);
									p.shotTimer = 100;
									e.northEastShots.add(p);
								}
								turretTex = turretArt[1];
								e.image = turretTex;
							}
							if (spritePos[1] >= (e.y - 50) && spritePos[1] <= (e.y + 50)){
								if (shotTimer % 100 == 0){
									Projectile p = new Projectile();
									p.x = e.x;
									p.y = e.y;
									p.width = enemyShotSize[0];
									p.height = enemyShotSize[1];
									p.speed = ((distance * 1 * deltaTimeMS) / 500);
									p.shotTimer = 100;
									e.eastShots.add(p);
								}
								turretTex = turretArt[2];
								e.image = turretTex;
							}
						}
					}
				}
				if (e.type.equals("top")){
					if (spritePos[1] < (e.y + 700) && e.y > c.y){
						e.x -= ((distance * 1 * deltaTimeMS) / 4000);
					}
					gunmanTopAnimation.update(deltaTimeMS);
					gunmanTex1 = gunmanArt[gunmanTopAnimation.def.frames[gunmanTopAnimation.curFrame].image];
					e.image = gunmanTex1;
					if (shotTimer % 25 == 0){
						Projectile p = new Projectile();
						p.x = e.x;
						p.y = e.y;
						p.width = enemyShotSize[0];
						p.height = enemyShotSize[1];
						p.speed = ((distance * 1 * deltaTimeMS) / 500);
						p.shotTimer = 50;
						e.southShots.add(p);
					}
					if (shotTimer % 25 == 1 || shotTimer % 25 == 2 || shotTimer % 25 == 3 || shotTimer % 25 == 4 || shotTimer % 25 == 5 || shotTimer % 25 == 6 || shotTimer % 25 == 7 ){
						gunmanTex1 = gunmanArt[4];
						e.image = gunmanTex1;
					}
				}
				if (e.type.equals("left")){
					if (spritePos[1] < (e.y + 700)){
						e.y += ((distance * 1 * deltaTimeMS) / 2500);
					}
					gunmanLeftAnimation.update(deltaTimeMS);
					gunmanTex2 = gunmanArt[gunmanLeftAnimation.def.frames[gunmanLeftAnimation.curFrame].image];
					e.image = gunmanTex2;
					if (shotTimer % 25 == 0){
						Projectile p = new Projectile();
						p.x = e.x;
						p.y = e.y;
						p.width = enemyShotSize[0];
						p.height = enemyShotSize[1];
						p.speed = ((distance * 1 * deltaTimeMS) / 500);
						p.shotTimer = 50;
						e.westShots.add(p);
					}
					if (shotTimer % 25 == 1 || shotTimer % 25 == 2 || shotTimer % 25 == 3 || shotTimer % 25 == 4 || shotTimer % 25 == 5 || shotTimer % 25 == 6 || shotTimer % 25 == 7 ){
						gunmanTex2 = gunmanArt[9];
						e.image = gunmanTex2;
					}
				}
				if (e.type.equals("right")){
					if (spritePos[1] < (e.y + 700)){
						e.y += ((distance * 1 * deltaTimeMS) / 3500);
					}
					gunmanRightAnimation.update(deltaTimeMS);
					gunmanTex3 = gunmanArt[gunmanRightAnimation.def.frames[gunmanRightAnimation.curFrame].image];
					e.image = gunmanTex3;
					if (shotTimer % 25 == 0){
						Projectile p = new Projectile();
						p.x = e.x;
						p.y = e.y;
						p.width = enemyShotSize[0];
						p.height = enemyShotSize[1];
						p.speed = ((distance * 1 * deltaTimeMS) / 500);
						p.shotTimer = 50;
						e.eastShots.add(p);
					}
					if (shotTimer % 25 == 1 || shotTimer % 25 == 2 || shotTimer % 25 == 3 || shotTimer % 25 == 4 || shotTimer % 25 == 5 || shotTimer % 25 == 6 || shotTimer % 25 == 7 ){
						gunmanTex3 = gunmanArt[14];
						e.image = gunmanTex3;
					}
				}
				if (e.type.equals("tank")){
					if (bossFight == true && tank.hp > 0){
						if (tankAnimationTimerDown >= 180){
							tank.y += ((distance * 1 * deltaTimeMS) / 1000);
							tank.headY += ((distance * 1 * deltaTimeMS) / 1000);
							tank.rightPanelY += ((distance * 1 * deltaTimeMS) / 1000);
							tank.leftPanelY += ((distance * 1 * deltaTimeMS) / 1000);
							if (tank.y > -1750){
								tank.y -= ((distance * 1 * deltaTimeMS) / 1000);
								tank.headY -= ((distance * 1 * deltaTimeMS) / 1000);
								tank.rightPanelY -= ((distance * 1 * deltaTimeMS) / 1000);
								tank.leftPanelY -= ((distance * 1 * deltaTimeMS) / 1000);
								tankRotateAnimation.update(deltaTimeMS);
								tankHeadTex = tankArt[tankRotateAnimation.def.frames[tankRotateAnimation.curFrame].image];
								if (tankRotateAnimation.def.frames[tankRotateAnimation.curFrame].image == 14){
									tankRotated = true;
								}
								if (tankRotated == true){
									tankShootingUpAnimation.update(deltaTimeMS);
									tankHeadTex = tankArt[tankShootingUpAnimation.def.frames[tankShootingUpAnimation.curFrame].image];
									if (tankShootingUpAnimation.def.frames[tankShootingUpAnimation.curFrame].image == 15){
										if (shotTimer % 5 == 0){
											Projectile p = new Projectile();
											p.x = tank.headX + shotOffset;
											p.y = tank.headY;
											p.width = enemyShotSize[0];
											p.height = enemyShotSize[1];
											p.speed = ((distance * 1 * deltaTimeMS) / 500);
											p.shotTimer = 50;
											tank.northShots.add(p);
											Projectile p2 = new Projectile();
											p2.x = tank.headX;
											p2.y = tank.headY;
											p2.width = enemyShotSize[0];
											p2.height = enemyShotSize[1];
											p2.speed = ((distance * 1 * deltaTimeMS) / 500);
											p2.shotTimer = 50;
											tank.southEastShots.add(p2);
											Projectile p3 = new Projectile();
											p3.x = tank.headX + shotOffset + shotOffset;
											p3.y = tank.headY;
											p3.width = enemyShotSize[0];
											p3.height = enemyShotSize[1];
											p3.speed = ((distance * 1 * deltaTimeMS) / 500);
											p3.shotTimer = 50;
											tank.northWestShots.add(p3);
										}
									}
									if (tankShootingUpAnimation.def.frames[tankShootingUpAnimation.curFrame].image == 12){
										if (shotTimer % 15 == 0){
											Projectile p = new Projectile();
											p.x = tank.headX;
											p.y = tank.headY;
											p.width = enemyShotSize[0];
											p.height = enemyShotSize[1];
											p.speed = ((distance * 1 * deltaTimeMS) / 500);
											p.shotTimer = 50;
											tank.northWestShots.add(p);
											Projectile p2 = new Projectile();
											p2.x = tank.headX;
											p2.y = tank.headY;
											p2.width = enemyShotSize[0];
											p2.height = enemyShotSize[1];
											p2.speed = ((distance * 1 * deltaTimeMS) / 500);
											p2.shotTimer = 50;
											tank.southEastShots.add(p2);
											Projectile p3 = new Projectile();
											p3.x = tank.headX;
											p3.y = tank.headY;
											p3.width = enemyShotSize[0];
											p3.height = enemyShotSize[1];
											p3.speed = ((distance * 1 * deltaTimeMS) / 500);
											p3.shotTimer = 50;
											tank.westShots.add(p3);
										}
									}
									if (tankShootingUpAnimation.def.frames[tankShootingUpAnimation.curFrame].image == 17){
										if (shotTimer % 15 == 0){
											Projectile p = new Projectile();
											p.x = tank.headX;
											p.y = tank.headY;
											p.width = enemyShotSize[0];
											p.height = enemyShotSize[1];
											p.speed = ((distance * 1 * deltaTimeMS) / 500);
											p.shotTimer = 50;
											tank.northWestShots.add(p);
											Projectile p2 = new Projectile();
											p2.x = tank.headX;
											p2.y = tank.headY;
											p2.width = enemyShotSize[0];
											p2.height = enemyShotSize[1];
											p2.speed = ((distance * 1 * deltaTimeMS) / 500);
											p2.shotTimer = 50;
											tank.southEastShots.add(p2);
											Projectile p3 = new Projectile();
											p3.x = tank.headX;
											p3.y = tank.headY;
											p3.width = enemyShotSize[0];
											p3.height = enemyShotSize[1];
											p3.speed = ((distance * 1 * deltaTimeMS) / 500);
											p3.shotTimer = 50;
											tank.eastShots.add(p3);
										}
										tankAnimationTimerUp++;
									}
								}
								if (tankAnimationTimerUp >= 180) {
									tankAnimationTimerDown = 0;
								}
							}
						}
						else if (tank.y >= -2185){
							if (tankRotated == true){
								tank.y -= ((distance * 1 * deltaTimeMS) / 1000);
								tank.headY -= ((distance * 1 * deltaTimeMS) / 1000);
								tank.rightPanelY -= ((distance * 1 * deltaTimeMS) / 1000);
								tank.leftPanelY -= ((distance * 1 * deltaTimeMS) / 1000);
								if (tank.y <= -2185){
									tankRotated = false;
									tankAnimationTimerUp = 0;
								}
							}
							else {
								tankShootingDownAnimation.update(deltaTimeMS);
								tankHeadTex = tankArt[tankShootingDownAnimation.def.frames[tankShootingDownAnimation.curFrame].image];
								if (tankShootingDownAnimation.def.frames[tankShootingDownAnimation.curFrame].image == 16){
									if (shotTimer % 5 == 0){
										Projectile p = new Projectile();
										p.x = tank.headX + shotOffset;
										p.y = tank.headY;
										p.width = enemyShotSize[0];
										p.height = enemyShotSize[1];
										p.speed = ((distance * 1 * deltaTimeMS) / 500);
										p.shotTimer = 50;
										tank.southShots.add(p);
										Projectile p2 = new Projectile();
										p2.x = tank.headX + shotOffset;
										p2.y = tank.headY;
										p2.width = enemyShotSize[0];
										p2.height = enemyShotSize[1];
										p2.speed = ((distance * 1 * deltaTimeMS) / 500);
										p2.shotTimer = 50;
										tank.northEastShots.add(p2);
										Projectile p3 = new Projectile();
										p3.x = tank.headX;
										p3.y = tank.headY;
										p3.width = enemyShotSize[0];
										p3.height = enemyShotSize[1];
										p3.speed = ((distance * 1 * deltaTimeMS) / 500);
										p3.shotTimer = 50;
										tank.southWestShots.add(p3);
									}
								}
								if (tankShootingDownAnimation.def.frames[tankShootingDownAnimation.curFrame].image == 4){
									if (shotTimer % 15 == 0){
										Projectile p = new Projectile();
										p.x = tank.headX;
										p.y = tank.headY;
										p.width = enemyShotSize[0];
										p.height = enemyShotSize[1];
										p.speed = ((distance * 1 * deltaTimeMS) / 500);
										p.shotTimer = 50;
										tank.southWestShots.add(p);
										Projectile p2 = new Projectile();
										p2.x = tank.headX;
										p2.y = tank.headY;
										p2.width = enemyShotSize[0];
										p2.height = enemyShotSize[1];
										p2.speed = ((distance * 1 * deltaTimeMS) / 500);
										p2.shotTimer = 50;
										tank.northEastShots.add(p2);
										Projectile p3 = new Projectile();
										p3.x = tank.headX;
										p3.y = tank.headY;
										p3.width = enemyShotSize[0];
										p3.height = enemyShotSize[1];
										p3.speed = ((distance * 1 * deltaTimeMS) / 500);
										p3.shotTimer = 50;
										tank.westShots.add(p3);
									}
								}
								if (tankShootingDownAnimation.def.frames[tankShootingDownAnimation.curFrame].image == 18){
									if (shotTimer % 15 == 0){
										Projectile p = new Projectile();
										p.x = tank.headX;
										p.y = tank.headY;
										p.width = enemyShotSize[0];
										p.height = enemyShotSize[1];
										p.speed = ((distance * 1 * deltaTimeMS) / 500);
										p.shotTimer = 50;
										tank.southWestShots.add(p);
										Projectile p2 = new Projectile();
										p2.x = tank.headX;
										p2.y = tank.headY;
										p2.width = enemyShotSize[0];
										p2.height = enemyShotSize[1];
										p2.speed = ((distance * 1 * deltaTimeMS) / 500);
										p2.shotTimer = 50;
										tank.northEastShots.add(p2);
										Projectile p3 = new Projectile();
										p3.x = tank.headX;
										p3.y = tank.headY;
										p3.width = enemyShotSize[0];
										p3.height = enemyShotSize[1];
										p3.speed = ((distance * 1 * deltaTimeMS) / 500);
										p3.shotTimer = 50;
										tank.eastShots.add(p3);
									}
									tankAnimationTimerDown++;
								}
							}
						}
						else if (tank.y < -2185){
							tank.y += ((distance * 1 * deltaTimeMS) / 5000);
							tank.headY += ((distance * 1 * deltaTimeMS) / 5000);
							tank.rightPanelY += ((distance * 1 * deltaTimeMS) / 5000);
							tank.leftPanelY += ((distance * 1 * deltaTimeMS) / 5000);
						}
					}
				}
			}
			
			if (kbState[KeyEvent.VK_W] == false && kbState[KeyEvent.VK_A] == false && kbState[KeyEvent.VK_S] == false && kbState[KeyEvent.VK_D] == false){
				spriteTex = frogArt[0];
			}

			if (kbState[KeyEvent.VK_W]) {
				spritePos[1] -= ((distance * 1 * deltaTimeMS) / 1000);
				frogWalkingUpAnimation.update(deltaTimeMS);
				spriteTex = frogArt[frogWalkingUpAnimation.def.frames[frogWalkingUpAnimation.curFrame].image];
			}

			if (kbState[KeyEvent.VK_A]) {
				spritePos[0] -= ((distance * 1 * deltaTimeMS) / 1000);
				frogWalkingLeftAnimation.update(deltaTimeMS);
				spriteTex = frogArt[frogWalkingLeftAnimation.def.frames[frogWalkingLeftAnimation.curFrame].image];
				if (spritePos[0] < 15) {
					spritePos[0] += ((distance * 1 * deltaTimeMS) / 1000);
				}
			}

			if (kbState[KeyEvent.VK_S]) {
				spritePos[1] += ((distance * 1 * deltaTimeMS) / 1000);
				frogWalkingDownAnimation.update(deltaTimeMS);
				spriteTex = frogArt[frogWalkingDownAnimation.def.frames[frogWalkingDownAnimation.curFrame].image];
			}

			if (kbState[KeyEvent.VK_D]) {
				spritePos[0] += ((distance * 1 * deltaTimeMS) / 1000);
				frogWalkingRightAnimation.update(deltaTimeMS);
				spriteTex = frogArt[frogWalkingRightAnimation.def.frames[frogWalkingRightAnimation.curFrame].image];
				if (spritePos[0] > 800) {
					spritePos[0] -= ((distance * 1 * deltaTimeMS) / 1000);
				}
			}
			
			if (kbState[KeyEvent.VK_UP] && kbState[KeyEvent.VK_LEFT] == false && kbState[KeyEvent.VK_RIGHT] == false && kbState[KeyEvent.VK_DOWN] == false) {
				if (shotTimer % 15 == 0){
					Projectile p = new Projectile();
					p.x = spritePos[0] + 10;
					p.y = spritePos[1];
					p.width = playerShotSize[0];
					p.height = playerShotSize[1];
					p.speed = ((distance * 1 * deltaTimeMS) / 1000);
					bubblesUp.add(p);
				}
				if (shotTimer % 15 == 1 || shotTimer % 15 == 2 || shotTimer % 15 == 3 || shotTimer % 15 == 4 || shotTimer % 15 == 5 || shotTimer % 15 == 6 || shotTimer % 15 == 7 ){
					spriteTex = frogArt[16];
				}
			}
			
			if (kbState[KeyEvent.VK_LEFT] && kbState[KeyEvent.VK_UP] == false && kbState[KeyEvent.VK_RIGHT] == false && kbState[KeyEvent.VK_DOWN] == false){
				if (shotTimer % 15 == 0){
					Projectile p = new Projectile();
					p.x = spritePos[0];
					p.y = spritePos[1] + 10;
					p.width = playerShotSize[0];
					p.height = playerShotSize[1];
					p.speed = ((distance * 1 * deltaTimeMS) / 1000);
					bubblesLeft.add(p);
				}
				if (shotTimer % 15 == 1 || shotTimer % 15 == 2 || shotTimer % 15 == 3 || shotTimer % 15 == 4 || shotTimer % 15 == 5 || shotTimer % 15 == 6 || shotTimer % 15 == 7 ){
					spriteTex = frogArt[18];
				}
			}
			
			if (kbState[KeyEvent.VK_RIGHT] && kbState[KeyEvent.VK_LEFT] == false && kbState[KeyEvent.VK_UP] == false && kbState[KeyEvent.VK_DOWN] == false){
				if (shotTimer % 15 == 0){
					Projectile p = new Projectile();
					p.x = spritePos[0];
					p.y = spritePos[1] + 10;
					p.width = playerShotSize[0];
					p.height = playerShotSize[1];
					p.speed = ((distance * 1 * deltaTimeMS) / 1000);
					bubblesRight.add(p);
				}
				if (shotTimer % 15 == 1 || shotTimer % 15 == 2 || shotTimer % 15 == 3 || shotTimer % 15 == 4 || shotTimer % 15 == 5 || shotTimer % 15 == 6 || shotTimer % 15 == 7 ){
					spriteTex = frogArt[19];
				}
			}
			
			if (kbState[KeyEvent.VK_DOWN] && kbState[KeyEvent.VK_LEFT] == false && kbState[KeyEvent.VK_RIGHT] == false && kbState[KeyEvent.VK_UP] == false){
				if (shotTimer % 15 == 0){
					Projectile p = new Projectile();
					p.x = spritePos[0] + 10;
					p.y = spritePos[1];
					p.width = playerShotSize[0];
					p.height = playerShotSize[1];
					p.speed = ((distance * 1 * deltaTimeMS) / 1000);
					bubblesDown.add(p);
				}
				if (shotTimer % 15 == 1 || shotTimer % 15 == 2 || shotTimer % 15 == 3 || shotTimer % 15 == 4 || shotTimer % 15 == 5 || shotTimer % 15 == 6 || shotTimer % 15 == 7 ){
					spriteTex = frogArt[17];
				}
			}		
						
			gl.glClearColor(0, 0, 0, 1);
			gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
			
			// Draw the background
			for (int i = startX; i < endX; i++) {
				for (int j = startY; j < endY; j++) {
					glDrawSprite(gl, grass1Tex, i * 16 - c.x, j * 16 - c.y, grass1Size[0], grass1Size[1]);
					if (i < 0){
						if (fieldGrid[(i*-1)][j] == 1) {
							glDrawSprite(gl, grass2Tex, i * 16 - c.x, j * 16 - c.y, grass2Size[0], grass2Size[1]);
						}
					}
					else if (j < 0){
						if (fieldGrid[i][(j*-1)] == 2) {
							glDrawSprite(gl, bushTex, i * 16 - c.x, j * 16 - c.y, bushSize[0], bushSize[1]);
						}
					}
					else if (fieldGrid[i][j] == 1) {
						glDrawSprite(gl, grass2Tex, i * 16 - c.x, j * 16 - c.y, grass2Size[0], grass2Size[1]);
					}
					else if (fieldGrid[i][j] == 2) {
						glDrawSprite(gl, bushTex, i * 16 - c.x, j * 16 - c.y, bushSize[0], bushSize[1]);

					}
				}
			}

			if (exploding == true){
				if (tank.hp <= 0){
					glDrawSprite(gl, explosionTex, tank.headX - c.x, tank.headY - c.y, explosionSize[0] * 12, explosionSize[1] * 8);
				}
				else {
					glDrawSprite(gl, explosionTex, explosionX - c.x, explosionY - c.y, explosionSize[0] * 5, explosionSize[1] * 3);
				}
			}
			
			for (Enemy e : enemies){
				if (e.type.equals("turret") || e.type.equals("top") || e.type.equals("left") || e.type.equals("right") || e.type.equals("tank")){
					if (e.visible){
							for (int i = 0; i < e.westShots.size(); i++){
								Projectile p = e.westShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.northWestShots.size(); i++){
								Projectile p = e.northWestShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.southWestShots.size(); i++){
								Projectile p = e.southWestShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.eastShots.size(); i++){
								Projectile p = e.eastShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.northEastShots.size(); i++){
								Projectile p = e.northEastShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.southEastShots.size(); i++){
								Projectile p = e.southEastShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.southShots.size(); i++){
								Projectile p = e.southShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
							for (int i = 0; i < e.northShots.size(); i++){
								Projectile p = e.northShots.get(i);
								if (p.visible = true) {
									glDrawSprite(gl, enemyShotTex, p.x - c.x, p.y - c.y, enemyShotSize[0], enemyShotSize[1]);
								}
							}
					}
				}
			}
			for (int i = 0; i < bubblesUp.size(); i++){
				Projectile p = bubblesUp.get(i);
				if (p.visible = true) {
					glDrawSprite(gl, playerShotTex, p.x - c.x, p.y - c.y, playerShotSize[0], playerShotSize[1]);
				}
			}
			for (int i = 0; i < bubblesLeft.size(); i++){
				Projectile p = bubblesLeft.get(i);
				if (p.visible = true) {
					glDrawSprite(gl, playerShotTex, p.x - c.x, p.y - c.y, playerShotSize[0], playerShotSize[1]);
				}
			}
			for (int i = 0; i < bubblesRight.size(); i++){
				Projectile p = bubblesRight.get(i);
				if (p.visible = true) {
					glDrawSprite(gl, playerShotTex, p.x - c.x, p.y - c.y, playerShotSize[0], playerShotSize[1]);
				}
			}
			for (int i = 0; i < bubblesDown.size(); i++){
				Projectile p = bubblesDown.get(i);
				if (p.visible = true) {
					glDrawSprite(gl, playerShotTex, p.x - c.x, p.y - c.y, playerShotSize[0], playerShotSize[1]);
				}
			}
			
			if (start == false){
				drawText(gl, aharoni, "my top down", 260, 200);
				drawText(gl, aharoni, "shooter", 320, 225);
				drawText(gl, aharoni, "press space", 260, 400);
				drawText(gl, aharoni, "to start", 310, 425);
			}
			else if (tank.hp <= 0){
				drawText(gl, aharoni, "you won!", 290, 200);
				drawText(gl, aharoni, "your score:", 225, 225);
				drawText(gl, aharoni, Integer.toString(score), 545, 225);
				drawText(gl, aharoni, "press space", 240, 400);
				drawText(gl, aharoni, "to restart", 260, 425);
			}
			else {
				if (dead == true){
					drawText(gl, aharoni, "you died", 290, 200);
				}
				drawText(gl, aharoni, "hp:", 10, 550);
				drawText(gl, aharoni, Integer.toString(playerHp), 90, 550);
				drawText(gl, aharoni, "score:", 450, 550);
				drawText(gl, aharoni, Integer.toString(score), 615, 550);
			}
			
			// Draw the sprite
			if (AABBIntersect(c, spritePos[0], spritePos[1], spriteSize[0], spriteSize[1])){
				if (flicker == true){
					if (shotTimer % 5 == 0){
						glDrawSprite(gl, spriteTex, spritePos[0] - c.x, spritePos[1] - c.y, spriteSize[0], spriteSize[1]);
					}
				}
				else {
					glDrawSprite(gl, spriteTex, spritePos[0] - c.x, spritePos[1] - c.y, spriteSize[0], spriteSize[1]);
				}
			}
			for (int i = 0; i < enemies.length; i++){
				if (AABBIntersect(c, enemies[i].x, enemies[i].y, enemies[i].width, enemies[i].height)){
					if (enemies[i].visible == true) {
						if (bossFight) {
							glDrawSprite(gl, tankBodyTex, tank.x - c.x, tank.y - c.y, tankBodySize[0], tankBodySize[1]);
							glDrawSprite(gl, tankHeadTex, tank.headX - c.x, tank.headY - c.y, tankHeadSize[0], tankHeadSize[1]);
							glDrawSprite(gl, tankLeftPanelTex, tank.leftPanelX - c.x, tank.leftPanelY - c.y, tankLeftPanelSize[0], tankLeftPanelSize[1]);
							glDrawSprite(gl, tankRightPanelTex, tank.rightPanelX - c.x, tank.rightPanelY - c.y, tankRightPanelSize[0], tankRightPanelSize[1]);
						}
						if (!enemies[i].type.equals("tank")){
							glDrawSprite(gl, enemies[i].image, enemies[i].x - c.x, enemies[i].y - c.y, enemies[i].width, enemies[i].height);
						}
					}
					else if (tank.hp <= 0){
						glDrawSprite(gl, tankDeadTex, tank.x - c.x, tank.y - c.y, tankDeadSize[0], tankDeadSize[1]);
						exploding = true;
						if (explosionAnimation.def.frames[explosionAnimation.curFrame].image == 8) {
							exploding = false;
						}
					}
				}
			}
		}
	}
	
	public static boolean AABBIntersect(Camera c, int x, int y, int width, int height){
		if (c.x > x + width) {
			return false;
		}
		if (c.x + c.width < x) {
			return false;
		}
		if (c.y > y + height) {
			return false;
		}
		if (c.y + c.height < y) {
			return false;
		}
		return true;
	}
	
	public static int drawText(GL2 gl, FontDef font, String word, int x, int y){
		int width = x;
		for (int i = 0; i < word.length(); i++){
			GlyphDef g = new GlyphDef();
			if (word.charAt(i) == '0'){
				g = font.glyphs[0];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '1'){
				g = font.glyphs[1];
				glDrawSprite(gl, g.texName, x, y, fontSize[0] - 5, fontSize[1]);
			}
			if (word.charAt(i) == '2'){
				g = font.glyphs[2];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '3'){
				g = font.glyphs[3];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '4'){
				g = font.glyphs[4];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '5'){
				g = font.glyphs[5];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '6'){
				g = font.glyphs[6];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '7'){
				g = font.glyphs[7];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '8'){
				g = font.glyphs[8];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == '9'){
				g = font.glyphs[9];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == ':'){
				g = font.glyphs[10];
				glDrawSprite(gl, g.texName, x, y, fontSize[0] - 15, fontSize[1]);
			}
			if (word.charAt(i) == '!'){
				g = font.glyphs[11];
				glDrawSprite(gl, g.texName, x, y, fontSize[0] - 15, fontSize[1]);
			}
			if (word.charAt(i) == 'a'){
				g = font.glyphs[12];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'b'){
				g = font.glyphs[13];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'c'){
				g = font.glyphs[14];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'd'){
				g = font.glyphs[15];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'e'){
				g = font.glyphs[16];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'g'){
				g = font.glyphs[17];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'h'){
				g = font.glyphs[18];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'i'){
				g = font.glyphs[19];
				glDrawSprite(gl, g.texName, x, y, fontSize[0] - 5, fontSize[1]);
			}
			if (word.charAt(i) == 'm'){
				g = font.glyphs[20];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'n'){
				g = font.glyphs[21];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'o'){
				g = font.glyphs[22];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'p'){
				g = font.glyphs[23];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'r'){
				g = font.glyphs[24];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 's'){
				g = font.glyphs[25];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 't'){
				g = font.glyphs[26];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'u'){
				g = font.glyphs[27];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'w'){
				g = font.glyphs[28];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			if (word.charAt(i) == 'y'){
				g = font.glyphs[29];
				glDrawSprite(gl, g.texName, x, y, fontSize[0], fontSize[1]);
			}
			x += 30;
		}
		return width;
	}

	// Load a file into an OpenGL texture and return that texture.
	public static int glTexImageTGAFile(GL2 gl, String filename, int[] out_size) {
		final int BPP = 4;

		DataInputStream file = null;
		try {
			// Open the file.
			file = new DataInputStream(new FileInputStream(filename));
		} catch (FileNotFoundException ex) {
			System.err.format("File: %s -- Could not open for reading.",
					filename);
			return 0;
		}

		try {
			// Skip first two bytes of data we don't need.
			file.skipBytes(2);

			// Read in the image type. For our purposes the image type
			// should be either a 2 or a 3.
			int imageTypeCode = file.readByte();
			if (imageTypeCode != 2 && imageTypeCode != 3) {
				file.close();
				System.err.format("File: %s -- Unsupported TGA type: %d",
						filename, imageTypeCode);
				return 0;
			}

			// Skip 9 bytes of data we don't need.
			file.skipBytes(9);

			int imageWidth = Short.reverseBytes(file.readShort());
			int imageHeight = Short.reverseBytes(file.readShort());
			int bitCount = file.readByte();
			file.skipBytes(1);

			// Allocate space for the image data and read it in.
			byte[] bytes = new byte[imageWidth * imageHeight * BPP];

			// Read in data.
			if (bitCount == 32) {
				for (int it = 0; it < imageWidth * imageHeight; ++it) {
					bytes[it * BPP + 0] = file.readByte();
					bytes[it * BPP + 1] = file.readByte();
					bytes[it * BPP + 2] = file.readByte();
					bytes[it * BPP + 3] = file.readByte();
				}
			} else {
				for (int it = 0; it < imageWidth * imageHeight; ++it) {
					bytes[it * BPP + 0] = file.readByte();
					bytes[it * BPP + 1] = file.readByte();
					bytes[it * BPP + 2] = file.readByte();
					bytes[it * BPP + 3] = -1;
				}
			}

			file.close();

			// Load into OpenGL
			int[] texArray = new int[1];
			gl.glGenTextures(1, texArray, 0);
			int tex = texArray[0];
			gl.glBindTexture(GL2.GL_TEXTURE_2D, tex);
			gl.glTexImage2D(GL2.GL_TEXTURE_2D, 0, GL2.GL_RGBA, imageWidth,
					imageHeight, 0, GL2.GL_BGRA, GL2.GL_UNSIGNED_BYTE,
					ByteBuffer.wrap(bytes));
			gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MIN_FILTER,
					GL2.GL_NEAREST);
			gl.glTexParameteri(GL2.GL_TEXTURE_2D, GL2.GL_TEXTURE_MAG_FILTER,
					GL2.GL_NEAREST);

			out_size[0] = imageWidth;
			out_size[1] = imageHeight;
			return tex;
		} catch (IOException ex) {
			System.err.format("File: %s -- Unexpected end of file.", filename);
			return 0;
		}
	}

	public static void glDrawSprite(GL2 gl, int tex, int x, int y, int w, int h) {
		gl.glBindTexture(GL2.GL_TEXTURE_2D, tex);
		gl.glBegin(GL2.GL_QUADS);
		{
			gl.glColor3ub((byte) -1, (byte) -1, (byte) -1);
			gl.glTexCoord2f(0, 1);
			gl.glVertex2i(x, y);
			gl.glTexCoord2f(1, 1);
			gl.glVertex2i(x + w, y);
			gl.glTexCoord2f(1, 0);
			gl.glVertex2i(x + w, y + h);
			gl.glTexCoord2f(0, 0);
			gl.glVertex2i(x, y + h);
		}
		gl.glEnd();
	}
}
