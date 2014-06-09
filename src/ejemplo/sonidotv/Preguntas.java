package ejemplo.sonidotv;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class Preguntas extends Activity {
	MediaPlayer mepe;
	int pos=0;
	private  EditText et1;
	  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.question_one);
	      et1 = (EditText)findViewById(R.id.et1);
	        
	    }


	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    
	    public void pasar(View view){
	    	if(et1 != null && mepe.isPlaying()==false){
	    		mepe.seekTo(pos);
	    		mepe.start();
        	Intent h = new Intent (this  , MainActivity.class);
        
        	startActivity(h);
        }
}

 
	    
	    
}