package paramhans.videostreaming;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.VideoView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private VideoView mainVideo ;
    private ProgressBar buffer;
    private boolean isPlaying;
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
    }
}
