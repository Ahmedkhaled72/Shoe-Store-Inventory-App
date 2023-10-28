package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel


class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeViewModel

    //intializze class saveargs that created
    private val args: ShoeListFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        //inflate ui
        val binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,
        container, false)

         //link between fragment and viewmodel
        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)

        //foating button action to navigate details fragment
        binding.flButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
        }


        if(args.shoee!=null)
        {
            viewModel.addShoeToList(args.shoee!!)
        }
        //val arg = ShoeListFragmentArgs.fromBundle(requireArguments())
        // if(arg!=null)
        // {
        //val shoe: Shoe
        //shoe = arg.shoee!!
        //viewModel.addShoeToList(shoe)
         //}


       viewModel.shoeList.observe(viewLifecycleOwner, Observer{
            shoeList ->
           //updated data to ui lest that taken fro live data
           for(item in shoeList)
           {
               //binding.tesst.text = "the shoe is ${item.name} + ${item.company} + ${item.size} + ${item.description}"
               val txt = TextView(context)
               txt.text = "the shoe is ${item.name} + ${item.company} + ${item.size} + ${item.description}"
               binding.nwlinear.addView(txt)
           }

           //  new ->
           // val show : MutableList<Shoe>
           // show = new
           //val text = TextView(context)
           //text.text = "hi ${viewModel.shoeList.value?.get(0)?.name.toString()};"
           //binding.nwlinear.addView(text)
           //binding.testtext.text = "hi ${viewModel.shoeList.value?.get(0)?.name.toString()};"

       })
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.log, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!,
        view!!.findNavController()) || super.onOptionsItemSelected(item)
    }
}