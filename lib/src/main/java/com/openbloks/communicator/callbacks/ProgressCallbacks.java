package com.openbloks.communicator.callbacks;

public interface ProgressCallbacks {
    void onStart();
    void setProgress(int max, int progress);
    void setProgressMessage(String message);
    void onFinished();
}
