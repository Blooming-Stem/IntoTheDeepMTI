package pedroPathing.subsystems;

//import com.arcrobotics.ftclib.controller.PIDController;

import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition;

public class claw extends Subsystem {
    // BOILERPLATE
    public static final claw INSTANCE = new claw();
    private claw() { }
    public Servo finger;

//    public String name = "claw_servo";


    public Command openClaw() {
        return new ServoToPosition(finger,0.32, this);
    }

    public Command closeClaw() {
        return new ServoToPosition(finger,0.7, this);
    }

    public Command openClawTele() {
        return new ServoToPosition(finger,0.4, this);
    }

    public Command closeClawTele() {
        return new ServoToPosition(finger,0.7, this);
    }



    @Override
    public void initialize() {
        finger = OpModeData.INSTANCE.getHardwareMap().get(Servo.class,"claw");
        finger.setPosition(0.62);

    }
}
