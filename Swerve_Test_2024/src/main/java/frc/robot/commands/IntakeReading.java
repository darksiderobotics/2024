package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeReading extends Command {

    public IntakeSubsystem intake;
    
    public IntakeReading(IntakeSubsystem intake){
        this.intake = intake;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        intake.getColors();
        try {
            wait(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        end(true);
    }
    
    @Override
    public void end(boolean interrupted) {
        intake.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
