package com.example.lab_week_03

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class DetailFragment : Fragment() {

    companion object {
        private const val ARG_ID = "coffee_id"

        fun newInstance(id: Int): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putInt(ARG_ID, id)
            fragment.arguments = args
            return fragment
        }
    }

    // Tambahkan 2 kopi lagi
    private val titles = arrayOf(
        "AFFOGATO",
        "AMERICANO",
        "CAFFE LATTE",
        "CAPPUCCINO",
        "ESPRESSO"
    )

    private val descriptions = arrayOf(
        "Espresso poured on a vanilla ice cream. Served in a cappuccino cup.",
        "Espresso with added hot water (100-150 ml). Often served in a cappuccino cup.",
        "A tall, mild 'milk coffee' (about 150-300 ml). Espresso with steamed milk and little milk foam.",
        "Espresso with steamed milk foam. Served in a cappuccino cup.",
        "Strong black coffee brewed by forcing hot water under pressure through finely ground coffee beans."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt(ARG_ID) ?: 0

        val titleView: TextView = view.findViewById(R.id.coffee_title)
        val descView: TextView = view.findViewById(R.id.coffee_desc)

        titleView.text = titles.getOrNull(id) ?: "Unknown Coffee"
        descView.text = descriptions.getOrNull(id) ?: "No description available."

        // 🔙 Tombol Back
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack?.setOnClickListener {
            findNavController().navigate(R.id.coffeeList)
        }
    }
}
