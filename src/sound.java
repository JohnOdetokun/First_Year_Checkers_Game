import javax.swing.JOptionPane;

public class sound{
   
   public sound()
   {
      
      
   }
   
   public void play(String s)
   {
      
       try{
        sun.audio.AudioStream B;
        
        
            java.io.InputStream test = new java.io.FileInputStream("./" + s + ".wav");
        B = new sun.audio.AudioStream(test);
        sun.audio.AudioPlayer.player.start(B);
        
        
        }
        catch(Exception error)
        {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
       
   
   }


}