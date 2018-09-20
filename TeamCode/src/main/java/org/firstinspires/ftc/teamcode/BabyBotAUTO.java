package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.I2cDevice;

import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;


/**
 * Created by robo on 2/6/2018.
 */
public class BabyBotAUTO extends LinearOpMode{
    //Motors used
    DcMotor leftDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive1;
    DcMotor rightDrive2;
    DcMotor armDrive;

    //Servos
    Servo claw = null;
    private Servo jewel;

    ModernRoboticsI2cColorSensor2 colorx;


    public BabyBotAUTO(){}

    @Override
    public void runOpMode()throws InterruptedException {


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
        rightDrive1.setPower(0);
        rightDrive2.setPower(0);

        ElapsedTime eTime = new ElapsedTime();

        eTime.reset();



        jewel.setPosition(1);

        while(getRuntime()<= 1.1){
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
