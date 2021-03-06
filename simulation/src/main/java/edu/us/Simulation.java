package edu.us;

import com.borsch.OpModeSimulation;
import com.borsch.sim.RobotConfiguration;
import com.borsch.sim.SimulatedVuforiaTrackable;
import com.borsch.sim.VuforiaConfiguration;

public class Simulation {

    public static void main (String[] args) {
        System.out.println("Starting simulation...");

        RobotConfiguration robot = new RobotConfiguration();
        robot.addDcMotor("fr");
        robot.addDcMotor("fl");
        robot.addDcMotor("br");
        robot.addDcMotor("bl");
        robot.addDcMotor("harvester");
        robot.addDcMotor("lft");
        robot.addDcMotor("sr");
        robot.addDcMotor("sl");
        robot.addServo("ls");
        robot.addServo("los");
        robot.addColorSensor("cs");
        robot.addColorSensor("brcs");
        robot.addColorSensor("blcs");
        robot.addDeviceInterfaceModule("dim");

        VuforiaConfiguration vuforiaConfig = new VuforiaConfiguration();
        SimulatedVuforiaTrackable leftPicture = new SimulatedVuforiaTrackable();
        SimulatedVuforiaTrackable rightPicture = new SimulatedVuforiaTrackable();
        SimulatedVuforiaTrackable centerPicture = new SimulatedVuforiaTrackable();
        vuforiaConfig.addAssets("FTC2017-18", leftPicture, rightPicture, centerPicture);

        OpModeSimulation sim = new OpModeSimulation("edu.usrobotics.opmode.compbot.autosimple.CompbotBlueSimple", robot, vuforiaConfig);
        sim.init();
        sim.start();
        sim.loop();

        System.out.println("Simulation ended.");
        System.exit(0);
    }
}
