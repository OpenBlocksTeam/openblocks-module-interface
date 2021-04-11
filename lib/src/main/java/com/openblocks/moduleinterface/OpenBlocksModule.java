package com.openblocks.moduleinterface;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.openblocks.moduleinterface.callbacks.Logger;
import com.openblocks.moduleinterface.callbacks.SaveCallback;
import com.openblocks.moduleinterface.exceptions.CompileException;
import com.openblocks.moduleinterface.exceptions.NotSupportedException;
import com.openblocks.moduleinterface.exceptions.ParseException;
import com.openblocks.moduleinterface.models.OpenBlocksFile;
import com.openblocks.moduleinterface.models.OpenBlocksProjectMetadata;
import com.openblocks.moduleinterface.models.OpenBlocksRawProject;
import com.openblocks.moduleinterface.models.code.ParseBlockTask;
import com.openblocks.moduleinterface.models.code.BlockCode;
import com.openblocks.moduleinterface.models.compiler.IncludedBinary;
import com.openblocks.moduleinterface.models.config.OpenBlocksConfig;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksCode;
import com.openblocks.moduleinterface.projectfiles.OpenBlocksLayout;

import java.util.ArrayList;
import java.util.HashMap;

public interface OpenBlocksModule {

    /**
     * This function is used to indicate what type of module is this?
     * OpenBlocks need at least 1 module for each type for it to work
     *
     * NOTE: Do not return the wrong module type, as it can cause the app to be unstable
     *
     * @return This current module type
     */
    Type                    getType();


    /**
     * This function will be called everytime the module is loaded
     *
     * @param context The context of where the module is loaded
     * @param logger The logger where you can log stuff
     */
    void                    initialize(Context context, Logger logger);



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
        PROJECT_COMPILER,
        BLOCKS_COLLECTION
    }


    /**
     * Project Manager is used to manage on where the project is, how can it be accessed, how
     * to write to it, and how to list them.
     * <br/>
     * TL;DR This module manages the file access of the project (read, write, delete, etc)
     */
    interface ProjectManager extends OpenBlocksModule {
        /* Self-explanatory */
        void                    saveProject(OpenBlocksRawProject project);
        OpenBlocksRawProject    getProject (String project_id);

        /**
         * This function is used to list every projects
         * @return A List of OpenBlocksProjects
         */
        ArrayList<OpenBlocksRawProject> listProjects();

        /**
         * This function is used to check if a project with
         * the specified id exists
         * @param project_id The project id
         * @return Does the project with the project id exists?
         */
        boolean                 projectExists(String project_id);

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
    }

    /**
     * Project Parser is used to parse a raw project (that you can get from using the ProjectManager)
     * into OpenBlocksLayout and OpenBlocksCode, that will later be displayed to the user
     * <br/>
     * <br/>
     * <h3>TL;DR</h3>
     * This module manages:
     * <ul>
     *     <li>Conversion between serialized data into {@link OpenBlocksCode}, {@link OpenBlocksLayout}, {@link OpenBlocksProjectMetadata} and vice versa.</li>
     *     <li>Project IDs</li>
     * </ul>
     */
    interface ProjectParser extends OpenBlocksModule {

        /**
         * This function is used to generate a Free ID that will be used
         * to create a new project
         * @param existing_ids project IDs that already exists
         * @return The free ID
         */
        String                      generateFreeId  (ArrayList<String> existing_ids);

        /**
         * This function is used to parse the raw project into a layout
         *
         * @param project The project
         * @return The parsed layout from the provided project
         * @throws ParseException When something goes wrong while parsing layout
         */
        @NonNull
        OpenBlocksLayout            parseLayout     (OpenBlocksRawProject project) throws ParseException;

        /**
         * This function is used to parse the raw project into a code
         * @param project The project
         * @return The parsed code from the provided project
         * @throws ParseException When something goes wrong while parsing the code
         */
        @NonNull
        OpenBlocksCode              parseCode       (OpenBlocksRawProject project) throws ParseException;

        /**
         * This function is used to parse the raw project to get it's metadata
         * @param project The project
         * @return The parsed code from the provided project
         * @throws ParseException When something goes wrong while parsing the metadata
         */
        @NonNull
        OpenBlocksProjectMetadata   parseMetadata   (OpenBlocksRawProject project) throws ParseException;

        /**
         * This function is used to save a code, layout, and metadata into one
         * single raw project (list of files)
         * @param metadata The project's metadata
         * @param code The project's code
         * @param layout The project's layout
         * @return The raw project containing files representation of these metadata, code and layout
         */
        @NonNull
        OpenBlocksRawProject        saveProject     (OpenBlocksProjectMetadata metadata,
                                                     OpenBlocksCode code,
                                                     OpenBlocksLayout layout);
    }

    /**
     * ProjectLayoutGUI is used to display / edit the layout, this module should inflate a layout
     * into the provided `View layout`
     * <br/>
     * TL;DR This module manages the layout editor
     */
    interface ProjectLayoutGUI extends OpenBlocksModule {

        /**
         * This function is used to show the layout editor in the provided layout to inflate to.
         *
         * @param context The context
         * @param layout The layout where you should be putting / inflating your views
         * @param code_data The code of this project, used for reference
         * @param layout_data The layout data to be displayed
         * @param saveCallback The callback everytime this has to be saved
         */
        void show(Context context, ViewGroup layout, OpenBlocksCode code_data, OpenBlocksLayout layout_data, OpenBlocksProjectMetadata metadata, SaveCallback<OpenBlocksLayout> saveCallback);

        /**
         * This function is used to initialize a new layout
         * @return An initialized {@link OpenBlocksLayout}
         */
        OpenBlocksLayout initializeNewLayout();
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
         * @param layout_data The layout of this project, used for reference
         * @param saveCallback The callback everytime this has to be saved
         */
        void show(Context context, ViewGroup layout, OpenBlocksCode code_data, OpenBlocksLayout layout_data, OpenBlocksProjectMetadata metadata, SaveCallback<OpenBlocksCode> saveCallback);
    }

    /**
     * Collection of blocks, initialize(), getConfig(), saveConfig() are ignored,
     * see the example module for an easier understanding
     */
    interface BlocksCollection extends OpenBlocksModule {

        /**
         * This function is used to initialize a new OpenBlocks code
         * @param blocks A hashmap of "String: opcode, BlockCode: block" parsed from {@link #getBlocks()}
         * @return An initialized {@link OpenBlocksCode}
         */
        OpenBlocksCode initializeNewCode(HashMap<String, BlockCode> blocks);

        /**
         * This function is used to fetch blocks that will be used and displayed using the {@link ProjectCodeGUI}
         * @return Simply put, this: Object[Object[Class block_type, int color, String opcode, String format, ParseBlockTask]]
         */
        Object[] getBlocks();
    }

    /**
     * ProjectCompiler is used to compile the code and the layout together into an APK at the
     * provided location
     * <br/>
     * TL;DR This project compiles the code and layout into an APK at the specified location
     */
    interface ProjectCompiler extends OpenBlocksModule {

        /**
         * This function initializes the compiler module with included
         * essential build tools' binaries like aapt, aapt2, and zipalign
         * @param includedBinaries A list of binaries included within the app
         * @param blocks A HashMap of opcode and ParseBlockTask, used to parse blocks into java code by the compiler
         */
        void initializeCompiler(ArrayList<IncludedBinary> includedBinaries, HashMap<String, ParseBlockTask> blocks);

        /**
         * This function is used to compile the code and the layout into an APK file at the specified
         * location
         * @param metadata The project metadata, contains app name, app package, etc
         * @param code The code
         * @param layout The layout
         * @param location The location where the APK should be saved
         * @throws CompileException Exception when there is something wrong while compiling
         */
        void compile(OpenBlocksProjectMetadata metadata, OpenBlocksCode code, OpenBlocksLayout layout, String location) throws CompileException;
    }
}
