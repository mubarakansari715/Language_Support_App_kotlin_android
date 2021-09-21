package com.example.language_support_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


class HomeFragment : Fragment() {
    private val languageList = arrayOf("en", "ur", "hi","gu")
    private lateinit var myPreference: MyPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        getData(view)
        return view
    }

    private fun getData(view: View) {
        val buttonOpen = view.findViewById<TextView>(R.id.tv_change_lang)
        buttonOpen.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
                .setTitle(R.string.app_lang)
                .setIcon(R.drawable.ic_baseline_language_24)
                .setMessage(R.string.app_lang_select)
                .setCancelable(false)
            val view: View = layoutInflater.inflate(R.layout.dialogbox_spinnerxml, null)
            val spinner = view.findViewById<Spinner>(R.id.spinner)
            builder.setView(view)

            myPreference = MyPreference(requireContext())
            spinner.adapter =
                ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, languageList)

            val lang = myPreference.getLoginCount()
            val index = languageList.indexOf(lang)
            if (index >= 0) {
                spinner.setSelection(index)
            }
            builder.setPositiveButton("Done") { _, _ ->
                myPreference.setLoginCount(languageList[spinner.selectedItemPosition])
                startActivity(Intent(requireContext(), MainActivity::class.java))

            }
            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }

            builder.show()

        }
    }
}