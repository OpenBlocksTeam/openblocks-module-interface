package com.openbloks.communicator;

import android.view.View;

import com.openbloks.communicator.exceptions.CompileException;
import com.openbloks.communicator.exceptions.NotSupportedException;
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
        void                saveProject(OpenBlocksRawProject project);
        OpenBlocksRawProject getProject ();

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
        OpenBlocksFile      exportProject(OpenBlocksRawProject project)    throws NotSupportedException;

        /**
         * This function is used to import a file / data that has been exported on exportProject
         * into OpenBlocksProject
         *
         * @param input The file
         * @return The imported project
         * @throws NotSupportedException Throw this if you don't support this function
         */
        OpenBlocksRawProject importProject(OpenBlocksFile input)         throws NotSupportedException;

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

    interface ProjectLayoutGUI extends OpenBlocksModule {
        void show(View layout, OpenBlocksLayout layout_data);
    }

    interface ProjectCodeGUI extends OpenBlocksModule {
        void show(View layout, OpenBlocksCode   code_data);
    }

    interface ProjectCompiler extends OpenBlocksModule {
        void compile(OpenBlocksCode code, OpenBlocksLayout layout, String location) throws CompileException;
    }
}
