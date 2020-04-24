package com.example.foodjuju

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class EntryFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entry, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_cancel).setOnClickListener {
            val dialogBuilder = AlertDialog.Builder(activity!!)
            dialogBuilder.setMessage("Close?")
                // if the dialog is cancelable
                .setCancelable(true)
                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                        dialog, id ->
                    dialog.dismiss() })
                .setNegativeButton("No", DialogInterface.OnClickListener {
                        dialog, id ->
                    dialog.dismiss() })

            val alert = dialogBuilder.create()
            //uncomment to restore close? alertbox
            //alert.show()
            findNavController().navigate(R.id.action_EntryFragment_to_HomeFragment)

        }
        view.findViewById<Button>(R.id.button_save).setOnClickListener {
            (activity as MainActivity).validation()
            //findNavController().navigate(R.id.action_EntryFragment_to_HomeFragment)
        }

    }
}
