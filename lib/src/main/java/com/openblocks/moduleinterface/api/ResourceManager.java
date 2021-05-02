package com.openblocks.moduleinterface.api;

import android.graphics.Bitmap;
import android.view.View;

import com.openblocks.moduleinterface.OpenBlocksModule;

public interface ResourceManager {
    /**
     * This function gets a in image resource for the specified module
     * @param module The module that is using this function
     * @param filename The filename of the image resource
     * @return The specified resource image bitmap
     */
    Bitmap getImageResource(OpenBlocksModule module, String filename);

    /**
     * This function reads a resource in byte[] for the specified module
     * @param module The module that is using this function
     * @param filename The filename of the file resource
     * @return The contents of the file
     */
    byte[] getRawResource(OpenBlocksModule module, String filename);

    /**
     * This function inflates an xml layout resource into a {@link View}
     * for the specified module
     * @param module The module that is using this function
     * @param xml_filename The filename of the xml layout
     * @return The inflated layout
     */
    View inflateXmlLayout(OpenBlocksModule module, String xml_filename);
}
