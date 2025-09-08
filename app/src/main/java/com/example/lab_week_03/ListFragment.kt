package com.example.lab_week_03

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

class ListFragment : Fragment() {

    private lateinit var coffeeListener: CoffeeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is CoffeeListener) {
            coffeeListener = context
        } else {
            throw RuntimeException("MainActivity must implement CoffeeListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // mapping kopi -> index
        view.findViewById<View>(R.id.affogato).setOnClickListener {
            coffeeListener.onSelected(0)
        }
        view.findViewById<View>(R.id.americano).setOnClickListener {
            coffeeListener.onSelected(1)
        }
        view.findViewById<View>(R.id.latte).setOnClickListener {
            coffeeListener.onSelected(2)
        }
    }
}
