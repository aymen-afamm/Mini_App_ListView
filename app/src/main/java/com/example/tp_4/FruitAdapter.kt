package com.example.tp_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FruitAdapter(context: Context, private val fruits: List<Fruit>) :
    ArrayAdapter<Fruit>(context, 0, fruits) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Récupérer le fruit à la position actuelle
        val fruit = getItem(position)

        // Réutiliser la vue ou en créer une nouvelle
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.fruit_item, parent, false)

        // Récupérer les composants de la vue
        val imageView = view.findViewById<ImageView>(R.id.imageViewFruit)
        val textViewNom = view.findViewById<TextView>(R.id.textViewNom)
        val textViewCalories = view.findViewById<TextView>(R.id.textViewCalories)

        // Remplir les composants avec les données du fruit
        fruit?.let {
            imageView.setImageResource(it.imageResId)
            textViewNom.text = it.intitule
            textViewCalories.text = "Calories: ${it.calories}"
        }

        return view
    }
}