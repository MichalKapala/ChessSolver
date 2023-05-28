package Move;

public interface Command {
    void execute();
    void undo();
}