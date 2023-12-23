/*
Copyright 2023 FIRST Tech Challenge Team 15305

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import java.lang.Math;

@TeleOp

 public class AchaoJoystickMode extends LinearOpMode {
    
    //assigning electronics to the robot
    private DcMotor leftF;
    private DcMotor leftR;
    private DcMotor rightF;
    private DcMotor rightR;
    private DcMotor rSlide;
    private DcMotor lSlide;
    private DcMotor hangerM;
    private Servo launcherS;
    private CRServo leftArmS;

    @Override
    public void runOpMode() {
        
    //hardware mapping each electronic
    leftF = hardwareMap.get(DcMotor.class, "leftF"); 
    leftR = hardwareMap.get(DcMotor.class, "leftR");
    rightF = hardwareMap.get(DcMotor.class, "rightF");
    rightR = hardwareMap.get(DcMotor.class, "rightR");
    rSlide = hardwareMap.get(DcMotor.class, "rSlide");
    lSlide = hardwareMap.get(DcMotor.class, "lSlide");
    hangerM = hardwareMap.get(DcMotor.class, "hangerM");
    launcherS = hardwareMap.get(Servo.class, "launcherS");
    leftArmS = hardwareMap.get(CRServo.class, "leftArmS");
    
    //displaying the init status on the driver hub
    telemetry.addData("Status", "Initialized");
    telemetry.update();
        
    //wait for "play" button to be pressed
    waitForStart();

    
    while (opModeIsActive()) {

    telemetry.addData("Status", "Running");
    telemetry.addLine("Running TeleOp");
    telemetry.addLine("")
             .addData("left x-axis joystick", Math.round(gamepad1.left_stick_x*100.00)/100.00);
    telemetry.addLine("")
             .addData("left y-axis joystick", Math.round(gamepad1.left_stick_y*100.00)/-100.00);
    telemetry.addLine("")
             .addData("right joystick", Math.round(gamepad1.right_stick_x*100.00)/100.00);
    telemetry.update();



        //motors don't have to run on if statements, they can be assigned to changable variables
        double rx = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        double y = -gamepad1.right_stick_x;
        
        //math involved to run each motor based off joystick position
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double leftFPower = (y+x+rx) / denominator;
        double leftRPower = (y-x+rx) / denominator;
        double rightFPower = (y-x-rx) / denominator;
        double rightRPower = (y+x-rx) / denominator;
        
        //set the motors to run on the power based off the math
        leftF.setPower(leftFPower);
        leftR.setPower(leftRPower);
        rightF.setPower(rightFPower);
        rightR.setPower(rightRPower);
     } 

        if(gamepad1.right_bumper) {
            
            launcherS.setPosition(0.85);
            sleep(500);
            launcherS.setPosition(0.6);
            
        }

        while(gamepad1.y) {
            
            leftArmS.setPower(1);
            
        }

            leftArmS.setPower(0);
    }
}

