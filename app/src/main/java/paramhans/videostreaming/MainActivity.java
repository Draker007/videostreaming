package paramhans.videostreaming;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private VideoView mainVideo ;
    private ProgressBar buffer;
    private boolean isPlaying = false;
    private int currentState;
    private Uri videoUri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/videostreaming-25f3a.appspot.com/o/happier.mp4?alt=media&token=e4475da6-31ed-4016-bb3e-02d78a951732");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainVideo = findViewById(R.id.mainVideoView);
        buffer = findViewById(R.id.progressBar);

        mainVideo.setVideoURI(videoUri);
        mainVideo.requestFocus();
        mainVideo.start();
        //buffer.setVisibility(View.INVISIBLE);


        mainVideo.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                if( what == mp.MEDIA_INFO_BUFFERING_START){
                    buffer.setVisibility(View.VISIBLE);

                }
                else if (what == mp.MEDIA_INFO_BUFFERING_END)
                {
                    buffer.setVisibility(View.INVISIBLE);
                }
                return false;
            }
        });
    }


}
