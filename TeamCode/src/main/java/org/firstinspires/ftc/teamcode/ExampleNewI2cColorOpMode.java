package org.firstinspires.ftc.teamcode;

//import android.util.Log; //

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ModernRoboticsI2cColorSensor2.ModernRoboticsI2cColorSensor2;

public abstract class ExampleNewI2cColorOpMode extends OpMode {
    int color = 0; //Variable for Heading data

    public byte[] color1Cache; //The read will return an array of bytes. They are stored in this variable

    public static final byte COLOR1ADDRESS = 0x3C; //Default I2C address for MR gyro
    public static final int COLOR1_REG_START = 0x04; //Register to start reading
    public static final int COLOR1_READ_LENGTH = 5; //Number of byte to read
    public static final int COLOR_COMMAND_REGISTER = 0x03; //Register to issue commands to the gyro
    public static final byte COLOR_ACTIVE_COMMAND = 0x00;
    public static final byte COLOR_PASSIVE_COMMAND =0x01;
//public static final byte GYRO_CALIBRATE_COMMAND = 0x4E; //Command to calibrate the gyro

    public I2cDevice color1;
    public I2cDeviceSynch color1Reader;
    I2cAddr Color1AddrAddress;


    @Override
    public void init() {
        Color1AddrAddress = I2cAddr.create8bit(COLOR1ADDRESS);
        color1 = hardwareMap.i2cDevice.get("colorSensor");
        color1Reader = new I2cDeviceSynchImpl(color1, Color1AddrAddress, false);
        color1Reader.engage();

    }

    @Override
    public void init_loop() {
//Calibrate the gyro if it is not reading 0
        color1Reader.write8(COLOR_COMMAND_REGISTER, COLOR_PASSIVE_COMMAND);

/*
if (gyro1Reader.read8(4) != 0) {
gyro1Reader.write8(GYRO_COMMAND_REGISTER, GYRO_CALIBRATE_COMMAND);
}
*/
    }

    @Override
    public void loop() {
        color1Reader.write8(COLOR_COMMAND_REGISTER, COLOR_ACTIVE_COMMAND);
        color1Cache = color1Reader.read(COLOR1_REG_START, COLOR1_READ_LENGTH);

        color = (int) color1Cache[0];
//heading = (heading << 8 | (0X000000FF & (int)gyro1Cache[0]));

// send the info back to driver station using telemetry function.

        telemetry.addData("color number byte", color1Cache[0]);
        telemetry.addData("red byte", color1Cache[1]);
        telemetry.addData("color number int", color);
        telemetry.addData("green", color1Cache[2]);
        telemetry.addData("blue", color1Cache[3]);

    }

    @Override
    public void stop() {

    }
/*
I2C Registers
Address Function
0x00 Sensor Firmware Revision
0x01 Manufacturer Code
0x02 Sensor ID Code
0x03 Command
0x04/0x05 Heading Data (lsb:msb)
0x06/0x07 Integrated Z Value (lsb:msb)
0x08/0x09 Raw X Value (lsb:msb)
0x0A/0x0B Raw Y Value (lsb:msb)
0x0C/0x0D Raw Z Value (lsb:msb)
0x0E/0x0F Z Axis Offset (lsb:msb)
0x10/0x11 Z Axis Scaling Coefficient (lsb:msb)

Commands
Command    Operation
0x00    Normal measurement mode
0x4E    Null gyro offset and reset Z axis integrator
0x52    Reset Z axis integrator
0x57    Write EEPROM data
*/
}