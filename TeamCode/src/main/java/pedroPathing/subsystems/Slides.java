package pedroPathing.subsystems;

//import com.arcrobotics.ftclib.controller.PIDController;
//import com.arcrobotics.ftclib.controller.PIDFController;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.HoldPosition;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorGroup;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition;

public class Slides extends Subsystem {
    // BOILERPLATE
    public static final Slides INSTANCE = new Slides();
    public static double setPoint = 0;
    private Slides() { }

    public MotorEx slides1;
    public MotorEx slides2;
    public MotorGroup motorGroup;

//    public PIDFController pidf = new PIDFController(0.007,0.0001 , 0.0001,(pos) -> 0.0,150);

public PIDFController pidf = new PIDFController(0.015,0.0001 , 0.0001,(pos) -> 0.0,150);


    public Command extendSlidesToTeleopSpec() {
        setPoint = 1100.0;
        return new RunToPosition(motorGroup, // MOTOR TO MOVE
                1100.0, // TARGET POSITION, IN TICKS
                pidf, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command extendSlidesToLastTeleopSpec() {
        setPoint = 500.0;
        return new RunToPosition(motorGroup, // MOTOR TO MOVE
                500.0, // TARGET POSITION, IN TICKS
                pidf, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }


    public Command resetVert() {
        setPoint = 0.0;
        return new RunToPosition(motorGroup, // MOTOR TO MOVE
                0.0, // TARGET POSITION, IN TICKS
                pidf, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command extendVert() {
        setPoint = 900.0;
        return new RunToPosition(motorGroup, // MOTOR TO MOVE
                900.0, // TARGET POSITION, IN TICKS
                pidf, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }


    public Command autoSpecimenLift() {
        setPoint = 364;
        return new RunToPosition(motorGroup, 364, pidf, this);
    }

    @Override
    public Command getDefaultCommand() {
        return new HoldPosition(motorGroup, pidf, this);
    }

//    @Override
//    public void periodic() {
//        OpModeData.telemetry.addData("slide Position", motorGroup.getCurrentPosition());
//        OpModeData.telemetry.addData("slide Target", pidf.getTarget());
//    }




    @Override
    public void initialize() {
//        slides1 = OpModeData.hardwareMap.get(MotorEx.class, "slides1");
//        slides2 = OpModeData.hardwareMap.get(MotorEx.class,"slides2");
        slides1 = new MotorEx("slidesone").reverse();
        slides2 = new MotorEx("slidestwo");
//        slides1.reverse();
        motorGroup = new MotorGroup(slides1,slides2);
//        slides1.setCurrentPosition(0);
//        slides2.setCurrentPosition(0);

//        slides1.setDirection(DcMotorSimple.Direction.REVERSE);
//        slides1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        slides2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
}

