package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCmd extends Command {

    public ShooterSubsystem shooter;
    
    public IntakeCmd(ShooterSubsystem shooter){
        this.shooter = shooter;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        shooter.runIntake();
        try {
            wait(2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        end(true);
    }
    
    @Override
    public void end(boolean interrupted) {
        shooter.stopIntake();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
