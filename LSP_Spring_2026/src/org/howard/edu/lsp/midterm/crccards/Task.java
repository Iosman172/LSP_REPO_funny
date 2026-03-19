package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a single task in the task management system.
 * A task stores its ID, description, and current status.
 *
 * @author [INPUT NAME]
 */
public class Task {
    private static final String OPEN = "OPEN";
    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String COMPLETE = "COMPLETE";
    private static final String UNKNOWN = "UNKNOWN";

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructs a task with the given ID and description.
     * The default status is OPEN.
     *
     * @param taskId the unique task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = OPEN;
    }

    /**
     * Returns the task ID.
     *
     * @return the task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns the task description.
     *
     * @return the task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the task status.
     *
     * @return the task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the task status.
     * Valid values are OPEN, IN_PROGRESS, and COMPLETE.
     * Any other value sets the status to UNKNOWN.
     *
     * @param status the new status value
     */
    public void setStatus(String status) {
        if (OPEN.equals(status) || IN_PROGRESS.equals(status) || COMPLETE.equals(status)) {
            this.status = status;
        } else {
            this.status = UNKNOWN;
        }
    }

    /**
     * Returns the string representation of the task in the format:
     * taskId description [status]
     *
     * @return the formatted task string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}