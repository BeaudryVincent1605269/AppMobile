package ca.qc.cstj.s05localdatasource.presentation.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ContactDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val contactFullName = arguments?.getString("CONTACT_NAME")


        return AlertDialog.Builder(requireContext()).setTitle("Information")
            .setMessage("Yannick")
            .setPositiveButton("OK") {_, _ ->}.create()
    }

    companion object {
        const val CONTACT_NAME = "CONTACT_NAME"
        const val CONTACT_DIALOG_TAG = "CONTACT_DIALOG_TAG"
    }


}