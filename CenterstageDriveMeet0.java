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
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this OpMode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@TeleOp


 /**
 * This code lets you control the robot with the d pad
 * 
 *
 */
 public class TeleOp_Driver_Control extends LinearOpMode {
    private DcMotor leftF;
    private DcMotor leftR;
    private DcMotor rightF;
    private DcMotor rightR;
    


    @Override
    public void runOpMode() {
        leftF = hardwareMap.get(DcMotor.class, "leftF"); 
        leftR = hardwareMap.get(DcMotor.class, "leftR");
        rightF = hardwareMap.get(DcMotor.class, "rightF");
        rightR = hardwareMap.get(DcMotor.class, "rightR");
        leftR.setDirection(DcMotor.Direction.REVERSE);
        leftF.setDirection(DcMotor.Direction.REVERSE);
        

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
            
            if(gamepad1.dpad_up){
                 leftF.setPower(0.6);
                 leftR.setPower(0.6);
                 rightF.setPower(0.6);
                 rightR.setPower(0.6);
            }
            else{
                
                 
                 leftF.setPower(0);
                 leftR.setPower(0);
                 rightF.setPower(0);
                 rightR.setPower(0);
            }
            if(gamepad1.dpad_down){
                 leftF.setPower(-0.5);
                 leftR.setPower(-0.5);
                 rightF.setPower(-0.5);
                 rightR.setPower(-0.5);
            }
            else{
                 leftF.setPower(0);
                 leftR.setPower(0);
                 rightF.setPower(0);
                 rightR.setPower(0);
            }
            if(gamepad1.dpad_left){
                 leftF.setPower(-0.6);
                 leftR.setPower(-0.6);
                 rightF.setPower(0.6);
                 rightR.setPower(0.6);
            }
            else{
                 leftF.setPower(0);
                 leftR.setPower(0);
                 rightF.setPower(0);
                 rightR.setPower(0);
            }
            if(gamepad1.dpad_right){
                 leftF.setPower(0.6);
                 leftR.setPower(0.6);
                 rightF.setPower(-0.6);
                 rightR.setPower(-0.6);
            }
            else{
                 leftF.setPower(0);
                 leftR.setPower(0);
                 rightF.setPower(0);
                 rightR.setPower(0);
            }
    }
}
}
