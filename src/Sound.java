import javax.sound.sampled.*;
import java.io.File;

public class Sound {
    private byte[] bytes;
    private DataLine.Info dlInfo;
    private AudioFormat audioFormat;

    private Sound() {}

    public static Sound load(String filename) {
        try {
            Sound s = new Sound();
            File file = new File(filename);
            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            
            s.audioFormat = ais.getFormat();
            s.dlInfo = new DataLine.Info(Clip.class, ais.getFormat());
            s.bytes = new byte[(int)(s.audioFormat.getFrameSize() * ais.getFrameLength())];
            ais.read(s.bytes);
            
            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void play() {
        try {
            Clip c = (Clip)AudioSystem.getLine(dlInfo);
            c.open(audioFormat, bytes, 0, bytes.length);
            c.start();
            
        } catch (Exception e) {
        }
    }

    public Clip playLooped() {
        try {
            Clip c = (Clip)AudioSystem.getLine(dlInfo);
            c.open(audioFormat, bytes, 0, bytes.length);
            c.loop(Clip.LOOP_CONTINUOUSLY);
            
            return c;
            
        } catch (Exception e) {
            return null;
        }
    }
}