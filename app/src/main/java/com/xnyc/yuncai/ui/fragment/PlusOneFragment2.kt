package com.xnyc.yuncai.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.xnyc.yuncai.R

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [PlusOneFragment2.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PlusOneFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlusOneFragment2 : androidx.fragment.app.Fragment() {


    public override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_plus_one_fragment2, container, false)
        return view
    }


}// Required empty public constructor
