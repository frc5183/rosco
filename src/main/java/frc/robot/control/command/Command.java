package frc.robot.control.command;

import frc.robot.subsystem.Subsystem;

import java.util.ArrayList;

/**
 * An abstract class for classes that are
 * Commands that should be run Autonomously within
 * the Periodic functions of the robot synchronously
 * based on their needed subsystems.
 * All commands should call require(Subsystem c) for every
 * needed subsystem during its constructor.
 */
public abstract class Command {
    private final ArrayList<Subsystem> subsystemList = new ArrayList<>();

    protected void require(Subsystem c) {
        // Prevent Duplicates for whatever reason they may occur
        if (!subsystemList.contains(c)) {
            subsystemList.add(c);
        }
    }

    /** returns the list of subsystems generated by require() calls
     * @return the list of subsystems generated by require() calls
     */
    public ArrayList<Subsystem> getRequiredSubsystems() {
        return subsystemList;
    }

    /**
     * An implementation method to be run once when the command is started.
     */
    public abstract void start();

    /**
     * An implementation method to be run every periodic cycle while the command is active.
     */
    public abstract void run();

    /**
     * An implementation method to be run once after the command is finished executing its main run() loop.
     */
    public abstract void clean();

    /**
     * An implementation method to be used to check its status when running its run() loop to see if it is finished.
     * @return A boolean representing whether the command is finished executing its main run() loop.
     */
    public abstract boolean isFinished();
}
