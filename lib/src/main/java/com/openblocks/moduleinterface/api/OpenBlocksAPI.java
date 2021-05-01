package com.openblocks.moduleinterface.api;

import android.content.Context;

import java.lang.ref.WeakReference;

public class OpenBlocksAPI {

    private static OpenBlocksAPI instance = null;

    private WeakReference<Context> context;

    ////////////////////////////////////////////////////////

    private ResourceManager resourceManager;

    ////////////////////////////////////////////////////////

    private OpenBlocksAPI(Context context, ResourceManager resourceManager) {
        this.context = new WeakReference<>(context);
        this.resourceManager = resourceManager;
    }

    // Just for modules
    public static OpenBlocksAPI getInstance() {
        if (instance == null)
            throw new IllegalStateException("OpenBlocksAPI hasn't been initialized yet");

        return instance;
    }

    // For openblocks-app to initialize
    public static OpenBlocksAPI getInstance(Context context, ResourceManager resourceManager) {
        if (instance == null)
            instance = new OpenBlocksAPI(context, resourceManager);

        return instance;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public Context getContext() {
        return context.get();
    }
}
