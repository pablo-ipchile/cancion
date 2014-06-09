package ejemplo.sonidotv;

 
	import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
	 
	public class MainActivity extends Activity {
	 
	    private Button btnplay;
	    private Button btnseguir;
	    private TextView timerValue;
	    private long startTime = 0L;
	    private Handler customHandler = new Handler();
	    long timeInMilliseconds = 0L;
	    long timeSwapBuff = 0L;
	    long updatedTime = 0L;
	    MediaPlayer play;
	    @Override
	    
	    
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.pantalla);
	 
	        timerValue = (TextView) findViewById(R.id.timerValue);
	 
	        btnplay = (Button) findViewById(R.id.button1);
	
	        btnseguir = (Button) findViewById(R.id.button2 );
	    }
        public void playCancion(View v){	
	    	
	    	MediaPlayer play = MediaPlayer.create(this,R.raw.tv);
	    	play.start();
	    	
	    	
	    	startTime = SystemClock.uptimeMillis();
            customHandler.postDelayed(updateTimerThread, 0);
          
        }
	 
	        public void seguir(View view) {
	       	 
                timeSwapBuff += timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
                
                
              }
	        
	        
	        
    private Runnable updateTimerThread = new Runnable() {
	 
	        public void run() {
	 
	            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
	 
	            updatedTime = timeSwapBuff + timeInMilliseconds;
	 
	            int secs = (int) (updatedTime / 1000);
	            int mins = secs / 60;
	            secs = secs % 60;
	           
	            timerValue.setText("" + mins + ":"
	                    + String.format("%02d", secs));
	            customHandler.postDelayed(this, 0);
	            
	           
	        }
	 
	    };
	 
	}
