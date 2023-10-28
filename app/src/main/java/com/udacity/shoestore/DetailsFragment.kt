package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.Shoe


class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_details,
            container,false)


        binding.saveButton.setOnClickListener {

            binding.apply {
                     //have value from view to set it in args
                    val names = textNameShoe.text.toString()
                    val com = textCompanyShoe.text.toString()
                    val size = textSzShoe.text.toString()
                    val desc = textDescShoe.text.toString()

                 //object that contaion list
                val shoe = Shoe(name = names, company = com, size = size.toDouble(), description = desc)

                findNavController().navigate(
                    DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment().setShoee(shoe))
            }
        }


        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
        }



        return binding.root
    }




}