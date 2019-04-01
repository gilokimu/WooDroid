package me.gilo.wc.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_profile.*
import me.gilo.raison.ui.user.onboarding.SignUpActivity
import me.gilo.wc.R
import me.gilo.wc.ui.customer.ProfileActivity
import me.gilo.wc.viewmodels.ProductViewModel


class ProfileFragment : Fragment() {


    lateinit var viewModel: ProductViewModel
    val TAG = "ProfileFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llMyProfile.setOnClickListener{
            if (FirebaseAuth.getInstance().currentUser != null) {
                startActivity(Intent(activity, ProfileActivity::class.java))
            }else{
                startActivity(Intent(activity, SignUpActivity::class.java))
            }
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() =
                ProfileFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }

}
