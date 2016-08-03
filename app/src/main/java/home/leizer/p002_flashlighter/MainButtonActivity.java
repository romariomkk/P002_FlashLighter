package home.leizer.p002_flashlighter;

import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class  MainButtonActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView turnOnImage;
    Button lightButton;
    boolean isOn = false;
    Camera camera;
    Parameters params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_button);

        setButton();
    }

    private void setButton(){
        camera = Camera.open();
        turnOnImage = (ImageView)findViewById(R.id.turnOnBut);
        turnOnImage.setImageDrawable(Drawable.createFromPath("but1.png"));
        turnOnImage.setOnClickListener(this);

        lightButton = (Button) findViewById(R.id.button);
        lightButton.setOnClickListener(this);
    }


    private void turnLightON(){
        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_TORCH);

        camera.setParameters(params);
        camera.startPreview();

        isOn = true;
    }

    private void turnLightOFF(){
        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_OFF);

        camera.setParameters(params);
        camera.stopPreview();
        isOn = false;
    }

    @Override
    public void onClick(View view) {
        if (!isOn){
            turnLightON();
        }else{
            turnLightOFF();
        }
    }
}