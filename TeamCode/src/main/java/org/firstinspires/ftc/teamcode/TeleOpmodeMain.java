/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;



import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;


/**
 * This file provides basic Telop driving for a Pushbot robot.
 * The code is structured as an Iterative OpMode
 *
 * This OpMode uses the common Pushbot hardware class to define the devices on the robot.
 * All device access is managed through the HardwarePushbot class.
 *
 * This particular OpMode executes a basic Tank Drive Teleop for a PushBot
 * It raises and lowers the claw using the Gampad Y and A buttons respectively.
 * It also opens and closes the claws slowly using the left and right Bumper buttons.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
*/

@TeleOp(name="TeleOp", group="Pushbot")

public class TeleOpmodeMain extends OpMode{

    DcMotor leftDrive1;
    DcMotor rightDrive1;
    DcMotor leftDrive2;
    DcMotor rightDrive2;
    DcMotor armDrive;
    ColorSensor color1;
    private Servo claw;
    private Servo jewel;

    public void init(){

        leftDrive1 = hardwareMap.dcMotor.get("leftDrive1");
        rightDrive1 = hardwareMap.dcMotor.get("rightDrive1");
        leftDrive2 = hardwareMap.dcMotor.get("leftDrive2");
        rightDrive2 = hardwareMap.dcMotor.get("rightDrive2");
        armDrive = hardwareMap.dcMotor.get("armDrive");
        claw = hardwareMap.servo.get("clawServo");
        color1 =  hardwareMap.get(ColorSensor.class, "colorSensor");
        color1.enableLed(true);
        jewel = hardwareMap.servo.get("jewelArm");


        rightDrive1.setDirection(DcMotor.Direction.REVERSE);
        rightDrive2.setDirection(DcMotor.Direction.REVERSE);


        claw.setPosition(0);
        Servo claw = null;
        jewel.setPosition(-.1);

    }

     public void loop(){

         float right = gamepad1.right_stick_y;
         float left = gamepad1.left_stick_y;

         float arm =  gamepad2.right_stick_y;

         armDrive.setPower(.5*arm);

         leftDrive1.setPower(.5*left);
         leftDrive2.setPower(.5*left);
         rightDrive1.setPower(.5*right);
         rightDrive2.setPower(.5*right);

        if (gamepad2.a){
             claw.setPosition(1);
         } else if(gamepad2.y){
             claw.setPosition(.75);
         } else if(gamepad2.x){
             claw.setPosition(.5);
         }

     }

     public void stop(){

     }

}