package com.sagold.cfievent.activities

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sagold.cfievent.R
import kotlinx.android.synthetic.main.fragment_requirement.*
import kotlinx.android.synthetic.main.fragment_sesame.*
import org.jetbrains.anko.imageResource

class SesameActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sesame, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgview_related_requirement.imageResource = R.drawable.ic_vpn_key_black_24dp
        text_requirement.text= getString(R.string.slack_opening_door_directive)
        btn_open_door.setOnClickListener {
            (activity as SesameActivity).sendDoorRequest()
        }
    }
}
