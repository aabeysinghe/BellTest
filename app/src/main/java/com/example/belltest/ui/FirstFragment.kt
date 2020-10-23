package com.example.belltest.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belltest.R
import com.example.belltest.ui.ui.viewmodels.FirstViewModel
import com.example.belltest.ui.ui.adapter.FirstRecyclerAdapter
import com.example.belltest.ui.util.util.Companion.showAlertDialog


/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {


    private lateinit var viewModel: FirstViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerview: RecyclerView
    private lateinit var btnNext: Button
    lateinit var communicator: Communicator


    private val v: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_first, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(FirstViewModel::class.java)
        communicator = activity as Communicator
        viewModel.screens.observe(viewLifecycleOwner, Observer { errorandscreen ->
            if (errorandscreen.error != null) {
                showAlertDialog(requireActivity(), getString(R.string.error), errorandscreen.error)
            } else {
                errorandscreen.scrrenList?.let {
                    recyclerview = v.findViewById(R.id.mobileRecyclerView)
                    linearLayoutManager = LinearLayoutManager(requireActivity())
                    val adapter = FirstRecyclerAdapter(it)
                    recyclerview.adapter = adapter
                    recyclerview.layoutManager = linearLayoutManager

                }
            }

        })
        btnNext = v.findViewById(R.id.btnLoadNextScreen)
        btnNext.setOnClickListener {
            val selectedScreen = viewModel.getSelectedTitleandScreenType()
            if (selectedScreen?.error != null) {
                showAlertDialog(requireActivity(), getString(R.string.error), selectedScreen.error)
            } else {
                communicator.passDataBetweenFrgments(
                    selectedScreen?.screen?.alias?.namespace,
                    selectedScreen?.screen?.alias?.alias,
                    "SecondFragment"
                )
            }
        }
        return v
    }
}
