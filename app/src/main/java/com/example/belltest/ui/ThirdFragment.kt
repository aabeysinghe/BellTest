package com.example.belltest.ui


import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belltest.R
import com.example.belltest.ui.ui.viewmodels.ThirdViewModel
import com.example.belltest.ui.ui.viewmodels.ThirdViewModelFactory
import com.example.belltest.ui.ui.adapter.ItemClickListner
import com.example.belltest.ui.ui.adapter.ThirdRecyclerAdapter
import com.example.belltest.ui.util.util
import com.example.belltest.ui.util.util.Companion.showAlertDialog

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment(), ItemClickListner {


    private lateinit var viewModel: ThirdViewModel
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var recyclerview: RecyclerView
    private val v: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_third, container, false)
        val nameSpace = arguments?.getString(NAMEESPACE)
        val alias = arguments?.getString(ALIAS)
        val thirdViewModelFactory = ThirdViewModelFactory(nameSpace, alias)

        viewModel =
            ViewModelProviders.of(this, thirdViewModelFactory).get(ThirdViewModel::class.java)
        viewModel.observeMovieData().observe(viewLifecycleOwner, Observer { moviesAndError ->
            if (moviesAndError.error != null) {
                showAlertDialog(requireActivity(), getString(R.string.error), moviesAndError.error)
            } else {
                moviesAndError?.imageList?.let {
                    recyclerview = v.findViewById(R.id.thirdRecyclerView)
                    gridLayoutManager = GridLayoutManager(requireActivity(), 3)
                    recyclerview.adapter = ThirdRecyclerAdapter(it, this)
                    recyclerview.layoutManager = gridLayoutManager

                }
            }
        })

        return v
    }

    override fun onItemClick(summary: String) {
        util.showAlertDialog(requireActivity(), getString(R.string.alert_title), summary)

    }

}
