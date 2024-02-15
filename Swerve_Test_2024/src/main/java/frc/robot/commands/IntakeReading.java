package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeReading extends Command {

    static IntakeSubsystem intake;
    
    public IntakeReading(IntakeSubsystem intake_in){
        SmartDashboard.putString("Color Sensor: ", "2 Inside Intake Reading");
        intake = intake_in;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intake.getColors();

    }
    
    @Override
    public void end(boolean interrupted) {
        //swerveSubsystem.stopModules();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
