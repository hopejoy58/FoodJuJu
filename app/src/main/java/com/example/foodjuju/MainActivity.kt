package com.example.foodjuju

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var foodName: EditText
    lateinit var foodDescription: EditText
    lateinit var foodIngredients: EditText
    lateinit var mood: EditText
    lateinit var moodComments: EditText
    lateinit var btn_cancel: Button


    var databaseReference: DatabaseReference = Firebase.database.reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    private fun saveData(){

        databaseReference = FirebaseDatabase.getInstance().getReference("foods")

        foodName = findViewById(R.id.foodName)
        foodDescription = findViewById(R.id.foodDescription)
        foodIngredients = findViewById(R.id.foodIngredients)
        mood = findViewById(R.id.mood)
        moodComments = findViewById(R.id.moodComments)
        var btn_save: Button = findViewById(R.id.button_save)

        val foodId = databaseReference.push().key.toString()
        val food = foodName.text.toString().trim()
        val description = foodDescription.text.toString().trim()
        val ingredients = foodIngredients.text.toString().trim()
        val foodMood = mood.text.toString().trim()
        val comments = moodComments.text.toString().trim()

        val userProvides = FoodData(foodId, food, description, ingredients, foodMood, comments)
        btn_save.apply {
            databaseReference.child(foodId).setValue(userProvides)
        }


        //database.child("foods").child().setValue(userProvides)
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
