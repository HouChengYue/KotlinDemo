package com.xnyc.yuncai.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.xnyc.yuncai.R
import kotlinx.android.synthetic.main.fragment_plus_one_fragment2.*

class PlusOneFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_plus_one, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_plusOneFragment_to_plusOneFragment2)
        }

    }


}// Required empty public constructor
