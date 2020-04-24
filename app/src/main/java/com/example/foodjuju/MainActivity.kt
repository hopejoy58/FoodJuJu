package com.example.foodjuju

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var foodName: EditText
    lateinit var foodDescription: EditText
    lateinit var foodIngredients: EditText
    lateinit var mood: EditText
    lateinit var moodComments: EditText
    lateinit var btn_cancel: Button
    lateinit var btn_save: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    private fun saveData(){

        Toast.makeText(applicationContext, "Saved (or not lol)", Toast.LENGTH_LONG)
            .show()

       // val db = FirebaseFirestore.getInstance()


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

        /*
        val ref = FirebaseDatabase.getInstance().getReference("foods")
        val foodId = ref.push().key.toString()
        val foods = FoodData(foodId, food, description, ingredients, foodMood, comments)

        ref.child(foodId).setValue(foods).addOnCompleteListener {
            Toast.makeText(applicationContext, "Successfully saved to database.", Toast.LENGTH_LONG)
                .show()
        }
        */


    }

    fun validation(){

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
        else if (description.isEmpty()){
            foodDescription.error = "Please enter description of food."
            return
        }
        else if (ingredients.isEmpty()){
            foodIngredients.error = "Please enter ingredients of food."
            return
        }
        else if (foodMood.isEmpty()){
            mood.error = "Please enter mood."
            return
        }
        else {
            saveData()
        }
    }
}
