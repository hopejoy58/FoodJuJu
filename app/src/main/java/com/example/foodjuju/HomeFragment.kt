package com.example.foodjuju

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_newEntry).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_EntryFragment)
        }
    }
    inner class loadRecycler(view: View) : RecyclerView.ViewHolder(view){
        private var foodName : View = itemView.findViewById(R.id.card_foodName)
        private var foodDesc : View = itemView.findViewById(R.id.card_foodDescription)
        private var foodIng : View = itemView.findViewById(R.id.card_foodIngredients)
        private var mood : View = itemView.findViewById(R.id.card_mood)
        private var moodComments : View = itemView.findViewById(R.id.card_moodComment)




    }
}
