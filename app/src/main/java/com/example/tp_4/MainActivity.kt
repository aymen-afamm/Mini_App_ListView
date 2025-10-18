package com.example.tp_4
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Créer la liste de fruits
        val listeFruits = listOf(
            Fruit("Orange", 47, R.drawable.img1),
            Fruit("Kiwi", 61, R.drawable.img3),
            Fruit("Pomme", 52, R.drawable.img2),
            Fruit("Banane", 89, R.drawable.img4),
            Fruit("Fraise", 33, R.drawable.img5),
            Fruit("Mangue", 60, R.drawable.img6)
        )

        // Récupérer la ListView
        val listView = findViewById<ListView>(R.id.listViewFruits)

        // Créer et attacher l'adapter
        val adapter = FruitAdapter(this, listeFruits)
        listView.adapter = adapter

        // Gérer le clic sur un élément
        listView.setOnItemClickListener { _, _, position, _ ->
            val fruitSelectionne = listeFruits[position]
            Toast.makeText(
                this,
                "Vous avez sélectionné: ${fruitSelectionne.intitule} (${fruitSelectionne.calories} cal)",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}