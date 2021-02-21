package com.openblocks.moduleinterface.callbacks;

/**
 * Used for PROJECT_LAYOUT_GUI and PROJECT_CODE_GUI to save it's data
 *
 * Example Usage:
 * <code>
 *     EditGUI edit = new EditGUI(this);
 *     edit.addOnSaveListener(new SaveCallback<\EditGUIData>() {
 *         // When the user saved something on EditGUI
 *     })
 * </code>
 *
 * @param <T> The data type that is going to be saved
 */
public interface SaveCallback<T> {
    void save(T data_to_be_saved);
}
