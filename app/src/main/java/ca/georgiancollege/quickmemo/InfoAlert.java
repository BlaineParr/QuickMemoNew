/*
 * Quick Memo
 * By: Blaine Parr, Richard Estrada and Cody Hutchinson
 * Date Last Edited: April 21, 2016
 * Last Edited By: Blaine Parr
 * Description: This class displays a message to the user letting them know that all of the
 * information required to create a memo has not been entered.
 */
package ca.georgiancollege.quickmemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class InfoAlert extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Please enter all information")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    } //method onClick ends
                });
        // Create the AlertDialog object and return it
        return builder.create();
    } //method onCreateDialog ends
} //class InfoAlert ends