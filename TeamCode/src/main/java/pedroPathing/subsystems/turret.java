package pedroPathing.subsystems;

//import com.arcrobotics.ftclib.controller.PIDController;
//import com.arcrobotics.ftclib.controller.PController;
//import com.arcrobotics.ftclib.controller.PIDFController;

import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.HoldPosition;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition;

public class turret extends Subsystem {
    // BOILERPLATE
    public static final turret INSTANCE = new turret();
    private turret() { }

    public MotorEx turret;
//    public static double kkkP = 0.015;
//    public PIDFController p = new PIDFController(0.01,0.0001 , 0.0002,(pos) -> 0.0);
    public PIDFController p = new PIDFController(0.01,0.0001 , 0.0002,(pos) -> 0.0);


    public Command spinTurret() {
        return new RunToPosition(turret, // MOTOR TO MOVE
                1532.0, // TARGET POSITION, IN TICKS
                p, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command spinTurretAuto() {
        return new RunToPosition(turret, // MOTOR TO MOVE
                1149, // TARGET POSITION, IN TICKS
                p, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command resetTurret() {
        return new RunToPosition(turret, // MOTOR TO MOVE
                0.0, // TARGET POSITION, IN TICKS
                p, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command spinTurretAutoother() {
        return new RunToPosition(turret, // MOTOR TO MOVE
                -1215, // TARGET POSITION, IN TICKS
                p, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command spinTurretThird() {
        return new RunToPosition(turret, // MOTOR TO MOVE
                170, // TARGET POSITION, IN TICKS
                p, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    public Command spinTurretThirdOther() {
        return new RunToPosition(turret, // MOTOR TO MOVE
                -200, // TARGET POSITION, IN TICKS
                p, // CONTROLLER TO IMPLEMENT
                this); // IMPLEMENTED SUBSYSTEM
    }

    @Override
    public Command getDefaultCommand() {
        return new HoldPosition(turret, p, this);
    }

//    @Override
//    public void periodic() {
//        OpModeData.telemetry.addData("turret Position", turret.getCurrentPosition());
//        OpModeData.telemetry.addData("turret Target", p.getTarget());
//    }



    @Override
    public void initialize() {
        turret = new MotorEx("turret").reverse();


//        turret.setDirection(DcMotorSimple.Direction.REVERSE);

//        turret.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        turret.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
