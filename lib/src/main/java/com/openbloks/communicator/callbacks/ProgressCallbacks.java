package com.openbloks.communicator.callbacks;

/**
 * ProgressCallbacks are used to indicate what is this doing running in the background while doing progress
 */
public interface ProgressCallbacks {
    /**
     * When the progress is started, Must be called
     */
    void onStart();

    /**
     * Set if the progress will be indeterminate
     * @param indeterminate Is this indeterminate?
     */
    void setIndeterminate(boolean indeterminate);

    /**
     * Sets the progress for the progress indicator
     * @param max The maximum number
     * @param progress The progress
     */
    void setProgress(int max, int progress);

    /**
     * Sets the progress message, this is used to indicate what is this doing in the background.
     * @param message The message that will be displayed
     */
    void setProgressMessage(String message);

    /**
     * When the progress is finished, Must be called
     */
    void onFinished();
}
