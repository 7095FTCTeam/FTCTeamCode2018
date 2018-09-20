package org.firstinspires.ftc.teamcode;

/**
 * Created by robo on 1/31/2018.
 */
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;


@TeleOp (name = "BabyBot", group = "Pushbot")
public class BabyBot extends OpMode {

    DcMotor leftDrive1;
    DcMotor rightDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive2;


    private Servo claw;
    private Servo jewel;


    public void init() {

        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        claw = hardwareMap.servo.get("clawServo");
        jewel = hardwareMap.servo.get("jewelArm");


        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);


        claw.setPosition(0);
        Servo claw = null;
        jewel.setPosition(0);

    }

    public void loop() {

        float right = gamepad1.right_stick_y;
        float left = gamepad1.left_stick_y;


        leftDrive1.setPower(.5 * left);
        leftDrive2.setPower(.5 * left);
        rightDrive1.setPower(.5 * right);
        rightDrive2.setPower(.5 * right);

        if (gamepad2.a) {
            claw.setPosition(1);
        } else if (gamepad2.y) {
            claw.setPosition(.75);
        } else if (gamepad2.x) {
            claw.setPosition(.5);
        }

        if (gamepad2.b) {
            jewel.setPosition(1);
        } else if (gamepad2.left_bumper) {
            jewel.setPosition(0);
        }
    }
}
