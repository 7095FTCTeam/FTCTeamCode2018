package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name = "AutoBlue",group = "Auto")
public class Blue extends LinearOpMode {

    ColorSensor colorSensor;

    private DcMotor leftDrive1;
    private DcMotor leftDrive2;
    private DcMotor rightDrive1;
    private DcMotor rightDrive2;
    private DcMotor armDrive;
    Servo claw = null;
    Servo jewel = null;


    public void runOpMode() {

        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        armDrive = hardwareMap.dcMotor.get("armDrive");
        claw = hardwareMap.servo.get("clawServo");
        jewel = hardwareMap.servo.get("jewelArm");


        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);

        // bLedOn represents the state of the LED.
        boolean bLedOn = true;

        // get a reference to our ColorSensor object.
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");

        // Set the LED in the beginning
        colorSensor.enableLed(bLedOn);


        waitForStart();

        telemetry.addData("LED", bLedOn ? "On" : "Off");
        telemetry.addData("Clear", colorSensor.alpha());
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Green", colorSensor.green());
        telemetry.addData("Blue ", colorSensor.blue());
        telemetry.addData("Hue", hsvValues[0]);
//Hello This is demonstrating a change in a local file
        Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValues);
        Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValues);

        leftDrive1.setPower(0);
        leftDrive2.setPower(0);

        rightDrive2.setPower(0);
        rightDrive1.setPower(0);

        armDrive.setPower(0);

        ElapsedTime eTime = new ElapsedTime();

        eTime.reset();

        jewel.setPosition(1);

        if (colorSensor.red() > colorSensor.blue()) {
            while (eTime.time() <= 2 && eTime.time() <= 2.3) {
                leftDrive1.setPower(1);
                leftDrive2.setPower(1);
                rightDrive1.setPower(1);
                rightDrive2.setPower(1);
            }
            while (eTime.time() > 2.5 && eTime.time() <= 2.8) {
                leftDrive2.setPower(0);
                leftDrive1.setPower(0);
                rightDrive1.setPower(0);
                rightDrive2.setPower(0);
            }
            if (eTime.time() >= 2.3) {
                jewel.setPosition(0);
            }
        } else if (colorSensor.blue() > colorSensor.red()) {
            while (eTime.time() <= 1.175) {
                jewel.setPosition(0);
                leftDrive2.setPower(-1);
                leftDrive1.setPower(-1);
                rightDrive1.setPower(-1);
                rightDrive2.setPower(-1);
            }
        }
        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
            }
        });
        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.WHITE);
            }
        });

    }
}

