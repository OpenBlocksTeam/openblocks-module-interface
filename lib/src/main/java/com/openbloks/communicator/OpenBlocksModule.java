package com.openbloks.communicator;

import com.openbloks.communicator.exceptions.NotSupportedException;

import java.util.ArrayList;

// TODO: CREATE A PLACE TO STORE CONFIG FOR THESE MODULES

public interface OpenBlocksModule {
    ModuleTypes getType();

    interface ProjectManager extends OpenBlocksModule {
        /* Self-explanatory */
        void                saveProject(OpenBlocksProject project);
        OpenBlocksProject   getProject ();

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
        OpenBlocksFile      exportProject(OpenBlocksProject project)    throws NotSupportedException;

        /**
         * This function is used to import a file / data that has been exported on exportProject
         * into OpenBlocksProject
         *
         * @param input The file
         * @return The imported project
         * @throws NotSupportedException Throw this if you don't support this function
         */
        OpenBlocksProject   importProject(OpenBlocksFile input)         throws NotSupportedException;

        /**
         * This function is used to list every projects
         * @return A List of OpenBlocksProjects
         */
        ArrayList<OpenBlocksProject> listProjects();
    }
}
