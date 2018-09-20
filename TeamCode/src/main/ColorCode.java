import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import org.firstinspires.ftc.teamcode.R;

import static android.R.id.button1;
import static android.R.id.button2;

/**
 * Created by robo on 11/9/2017.
 */

public class ColorCode {
    public ColorCode() {
        super();
    }
}
@Override
public void run0pMode ()
{

    float havVaules [] = [OF, OF, OF];uf
    final float vaules [] = hsvVaules;
    final View relativeLayout = ( (Activity) hardwareMap.appContext).findViewById(R.id.RelativeLayout);


    sensorColor = hardwareMap.colorSensor.get ("sensorColor");
    button1 = hardwareMap.crservo.get ("button1");
    button2 =hardwareMap.creservo.get ("button2");
    telemetry.addData("Initializtion", "Complete");
    button1.setPower(0);
    button2.setPower(0);

    int b = 1;

    waitForStart();
    while (opModeIsActive())
    {

        Color.RGBToHSV(sensorColor.red() * 8, sensorColor.green() * 8, sensorColor.blue() *8, hsvValues);
        telemetry.addData ("Red ", sensorColor.red());
        telemetry.addData ("Green ", sensorColor.blue());
        telemetry.addData ("Blue ", sensorColor.blue());
        telemetary.update();

        button1.setPower(0);
        button2.setPower(0);

                if (sensorColor.red() >= 2 b == 1)
                {   button1.setPower(.25);
                    sleep (1500);
                    button1.setPower(.25)
                    b= 2; )
                else if(sensorCode.red() <2 b == 1)
                {
                    button1.setPower(-.25);
                    sleep(1500);
                    button2.setPower(.25);
                    sleep(1500);
                    b = 2;   }
}
telemetry.update();
idle();
}