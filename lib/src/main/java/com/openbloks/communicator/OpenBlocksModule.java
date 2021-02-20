package com.openbloks.communicator;

import android.view.View;

import com.openbloks.communicator.callbacks.ProgressCallbacks;
import com.openbloks.communicator.callbacks.SaveCallback;
import com.openbloks.communicator.exceptions.CompileException;
import com.openbloks.communicator.exceptions.NotSupportedException;
import com.openbloks.communicator.models.OpenBlocksFile;
import com.openbloks.communicator.models.OpenBlocksRawProject;
import com.openbloks.communicator.projectfiles.OpenBlocksCode;
import com.openbloks.communicator.projectfiles.OpenBlocksLayout;

import java.util.ArrayList;

// TODO: CREATE A PLACE TO STORE CONFIG FOR THESE MODULES

public interface OpenBlocksModule {
    ModuleTypes getType();

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
         * @param layout The layout where you should be putting / inflating your views
         * @param layout_data The layout data to be displayed
         * @param saveCallback The callback everytime this has to be saved
         */
        void show(View layout, OpenBlocksLayout layout_data,    SaveCallback<OpenBlocksLayout>  saveCallback);
    }

    /**
     * ProjectCodeGUI is used to display / edit the Code, this module should inflate a layout
     * into the provided `View layout`
     */
    interface ProjectCodeGUI extends OpenBlocksModule {

        /**
         * This function is used to show the code / block code editor in the provided layout to inflate to.
         *
         * @param layout The layout where you should be putting / inflating your views
         * @param code_data The code data to be displayed
         * @param saveCallback The callback everytime this has to be saved
         */
        void show(View layout, OpenBlocksCode   code_data,      SaveCallback<OpenBlocksCode>    saveCallback);
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
