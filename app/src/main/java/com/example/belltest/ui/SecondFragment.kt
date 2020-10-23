package com.example.belltest.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belltest.R
import com.example.belltest.ui.ui.viewmodels.SecondViewModelFactory
import com.example.belltest.ui.ui.viewmodels.SecondViewModel
import com.example.belltest.ui.ui.adapter.SecondRecyclerAdapter
import com.example.belltest.ui.util.util.Companion.showAlertDialog

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {
    private lateinit var viewModel: SecondViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerview: RecyclerView
    private lateinit var btnNext: Button
    lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_second, container, false)
        communicator = activity as Communicator
        val title = arguments?.getString(TITLE)
        val screenType = arguments?.getString(SCREEN_TYPE)



        val viewModel = ViewModelProvider(this, SecondViewModelFactory(requireActivity().application, title, screenType)).get(SecondViewModel::class.java)



     /*   val secondViewModelFactory = SecondViewModelFactory(title, screenType)
        viewModel =
            ViewModelProviders.of(this, secondViewModelFactory).get(SecondViewModel::class.java)*/
        viewModel.observeMovieData().observe(viewLifecycleOwner, Observer { movieCollectionandError ->
            if (movieCollectionandError.error != null) {
                showAlertDialog(requireActivity(), getString(R.string.error), movieCollectionandError.error)
            } else {
                movieCollectionandError.scrrenList?.let {
                    recyclerview = v.findViewById(R.id.screenRecyclerView)
                    linearLayoutManager = LinearLayoutManager(requireActivity())
                    val adapter = SecondRecyclerAdapter(it)
                    recyclerview.adapter = adapter
                    recyclerview.layoutManager = linearLayoutManager

                }
            }
        })
        btnNext = v.findViewById(R.id.btnLoadNextScreen)
        btnNext.setOnClickListener {
            val selectedCollection = viewModel.getSelectedColection()?.scrrenList?.firstOrNull()
            communicator.passDataBetweenFrgments(
                selectedCollection?.alias?.namespace,
                selectedCollection?.alias?.alias,
                "ThirdFragment"
            )
        }
        return v
    }


}
