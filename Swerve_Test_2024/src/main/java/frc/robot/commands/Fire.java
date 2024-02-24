package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class Fire extends Command{

    String target;
    ShooterSubsystem Shooter;

    public Fire(ShooterSubsystem Shooter, String target){
        this.target = target;
        this.Shooter = Shooter;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (target == "Speaker") {
            Shooter.ShootSpeaker();
        }
        else if (target == "Amp") {
            Shooter.ShootAmp();
        }
        try {
            wait(1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        end(true);
    }
    
    @Override
    public void end(boolean interrupted) {
        Shooter.StopShooter();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
