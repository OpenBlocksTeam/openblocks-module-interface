package com.openbloks.moduleinterface;

import android.content.Context;
import android.view.View;

import com.openbloks.moduleinterface.callbacks.ProgressCallbacks;
import com.openbloks.moduleinterface.callbacks.SaveCallback;
import com.openbloks.moduleinterface.exceptions.CompileException;
import com.openbloks.moduleinterface.exceptions.NotSupportedException;
import com.openbloks.moduleinterface.models.OpenBlocksFile;
import com.openbloks.moduleinterface.models.OpenBlocksRawProject;
import com.openbloks.moduleinterface.models.config.OpenBlocksConfig;
import com.openbloks.moduleinterface.projectfiles.OpenBlocksCode;
import com.openbloks.moduleinterface.projectfiles.OpenBlocksLayout;

import java.util.ArrayList;

// TODO: CREATE A PLACE TO STORE CONFIG FOR THESE MODULES

public interface OpenBlocksModule {

    /**
     * This function is used to indicate what type of module is this?
     * OpenBlocks need at least 1 module for each type for it to work
     *
     * NOTE: Do not return the wrong module type, as it can cause the app to be unstable
     *
     * @return This current module type
     */
    Type             getType();


    /* OpenBlocksConfig is a set of Config Items, where you can create a configuration that can be
       Edited by the user */

    /**
     * This function is called when the user requests this specific module's configuration
     *
     * @return This module's configuration
     */
    OpenBlocksConfig        setupConfig();

    /**
     * This function is used to save / apply configuration that is retrieved from setupConfig()
     * and has been edited / configured by the user itself.
     *
     * @param config The new configuration
     */
    void                    applyConfig(OpenBlocksConfig config);


    /**
     * This enum is used to identify what module is this?
     * one of this enums should be returned on OpenBlockModule.getType()
     */
    enum Type {
        PROJECT_MANAGER,
        PROJECT_PARSER,
        PROJECT_LAYOUT_GUI,
        PROJECT_CODE_GUI,
        PROJECT_COMPILER
    }


    /**
     * Project Manager is used to manage on where the project is, how can it be accessed, how
     * to write to it, and how to list them.
     */
    interface ProjectManager extends OpenBlocksModule {
        /* Self-explanatory */
        void                    saveProject(OpenBlocksRawProject project);
        OpenBlocksRawProject    getProject ();

        /*
         * exportProject() should export the provided project into a single file
         *
         * importProject() should imports the provided input into a project
         */

        /**
         * This function is used to export an OpenBlocksProject into a single file
         *
         * @param project The project
         * @return The exported file
         * @throws NotSupportedException Throw this if you don't support this function
         */
        OpenBlocksFile          exportProject(OpenBlocksRawProject project)     throws NotSupportedException;

        /**
         * This function is used to import a file / data that has been exported on exportProject
         * into OpenBlocksProject
         *
         * @param input The file
         * @return The imported project
         * @throws NotSupportedException Throw this if you don't support this function
         */
        OpenBlocksRawProject    importProject(OpenBlocksFile input)             throws NotSupportedException;

        /**
         * This function is used to list every projects
         * @return A List of OpenBlocksProjects
         */
        ArrayList<OpenBlocksRawProject> listProjects();
    }

    /**
     * Project Parser is used to parse a raw project (that you can get from using the ProjectManager)
     * into OpenBlocksLayout and OpenBlocksCode, that will later be displayed to the user
     */
    interface ProjectParser extends OpenBlocksModule {

        /**
         * This function is used to parse the raw project into a layout
         *
         * @param project The project
         * @return The parsed layout from the provided project
         */
        OpenBlocksLayout    parseLayout (OpenBlocksRawProject project);

        /**
         * This function is used to parse the raw project into a code
         * @param project The project
         * @return The parsed code from the provided project
         */
        OpenBlocksCode      parseCode   (OpenBlocksRawProject project);
    }

    /**
     * ProjectLayoutGUI is used to display / edit the layout, this module should inflate a layout
     * into the provided `View layout`
     */
    interface ProjectLayoutGUI extends OpenBlocksModule {

        /**
         * This function is used to show the layout editor in the provided layout to inflate to.
         *
         * @param context The context
         * @param layout The layout where you should be putting / inflating your views
         * @param layout_data The layout data to be displayed
         * @param saveCallback The callback everytime this has to be saved
         */
        void show(Context context, View layout, OpenBlocksLayout layout_data, SaveCallback<OpenBlocksLayout> saveCallback);
    }

    /**
     * ProjectCodeGUI is used to display / edit the Code, this module should inflate a layout
     * into the provided `View layout`
     */
    interface ProjectCodeGUI extends OpenBlocksModule {

        /**
         * This function is used to show the code / block code editor in the provided layout to inflate to.
         *
         * @param context The context
         * @param layout The layout where you should be putting / inflating your views
         * @param code_data The code data to be displayed
         * @param saveCallback The callback everytime this has to be saved
         */
        void show(Context context, View layout, OpenBlocksCode code_data, SaveCallback<OpenBlocksCode> saveCallback);
    }

    /**
     * ProjectCompiler is used to compile the code and the layout together into an APK at the
     * provided location
     */
    interface ProjectCompiler extends OpenBlocksModule {

        /**
         * This function is used to compile the code and the layout into an APK file at the specified
         * location
         *
         * @param code The code
         * @param layout The layout
         * @param location The location where the APK should be saved
         * @param progress The progress callback where you will need to set when you made a progress / to notify the user on what's happening in the background
         * @throws CompileException Exception when there is something wrong while compiling
         */
        void compile(OpenBlocksCode code, OpenBlocksLayout layout, String location, ProgressCallbacks progress) throws CompileException;
    }
}
