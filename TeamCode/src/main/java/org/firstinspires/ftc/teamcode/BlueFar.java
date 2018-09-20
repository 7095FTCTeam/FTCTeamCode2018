package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.ExampleNewI2cColorOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;

/**
 * Created by robo on 1/10/2018.
 */
public class BlueFar extends LinearOpMode {

    DcMotor leftDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive1;
    DcMotor rightDrive2;
    DcMotor armDrive;

    Servo claw = null;
    private Servo jewel;

    ModernRoboticsI2cColorSensor2 colorx;

    public BlueFar() {
    }

    @Override
    public void runOpMode() throws InterruptedException {

        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        armDrive = hardwareMap.dcMotor.get("armDrive");
        claw = hardwareMap.servo.get("clawServo");
        jewel = hardwareMap.servo.get("jewelArm");
        I2cDevice colori2c = hardwareMap.i2cDevice.get("colorSensor");
        colorx = new ModernRoboticsI2cColorSensor2(colori2c.getController(), colori2c.getPort());

        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);

        int cnumber = colorx.colorNumber();
        telemetry.addData("Colornumber: ", cnumber);



        waitForStart();

        leftDrive1.setPower(0);
        leftDrive2.setPower(0);

        rightDrive2.setPower(0);
        rightDrive1.setPower(0);

        armDrive.setPower(0);

        ElapsedTime eTime = new ElapsedTime();

        eTime.reset();

        jewel.setPosition(1);

        waitForStart();

        if (getRuntime() <= 1.1) {
            leftDrive1.setPower(1);
            leftDrive2.setPower(1);
            rightDrive1.setPower(1);
            rightDrive2.setPower(1);
        }

        leftDrive1.setPower(0);
        leftDrive2.setPower(0);
        rightDrive1.setPower(0);
        rightDrive2.setPower(0);
    }
}
