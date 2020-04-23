package com.example.foodjuju

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var foodName: EditText
    lateinit var foodDescription: EditText
    lateinit var foodIngredients: EditText
    lateinit var mood: EditText
    lateinit var moodComments: EditText
   // lateinit var btn_cancel: Button
   // lateinit var btn_save: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_calendar, R.id.navigation_home, R.id.navigation_report))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val fab: View = findViewById(R.id.fab_newEntry)
        fab.setOnClickListener {

            setContentView(R.layout.fragment_entry)

            saveData()
/*
            Toast.makeText(
                MainActivity.this,
                "Firebase connection success.",
                Toast.LENGTH_LONG
            ).show();

*/

/*
            btn_cancel.setOnClickListener {

            }
         btn_save.setOnClickListener{
                saveData()
            }
*/

        }


    }

    private fun saveData(){

        foodName = findViewById(R.id.foodName)
        foodDescription = findViewById(R.id.foodDescription)
        foodIngredients = findViewById(R.id.foodIngredients)
        mood = findViewById(R.id.mood)
        moodComments = findViewById(R.id.moodComments)

        val food = foodName.text.toString().trim()
        val description = foodDescription.text.toString().trim()
        val ingredients = foodIngredients.text.toString().trim()
        val foodMood = mood.text.toString().trim()
        val comments = moodComments.text.toString().trim()

        // check if fields are empty
        if (food.isEmpty()){
            foodName.error = "Please enter name of food."
            return
        }
        if (description.isEmpty()){
            foodDescription.error = "Please enter description of food."
            return
        }
        if (ingredients.isEmpty()){
            foodIngredients.error = "Please enter ingredients of food."
            return
        }
        if (foodMood.isEmpty()){
            mood.error = "Please enter mood."
            return
        }


        val ref = FirebaseDatabase.getInstance().getReference("foods")
        val foodId = ref.push().key.toString()
        val foods = foodData(foodId, food, description, ingredients, foodMood, comments)

        ref.child(foodId).setValue(foods).addOnCompleteListener {
            Toast.makeText(applicationContext, "Successfully saved to database.", Toast.LENGTH_LONG)
                .show()
        }

    }
}
