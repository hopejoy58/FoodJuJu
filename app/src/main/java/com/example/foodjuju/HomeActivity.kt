package com.example.foodjuju

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeActivity : AppCompatActivity() {

    private var dataList = ArrayList<Data>()
    lateinit var foodName: EditText
    lateinit var foodDescription: EditText
    lateinit var foodIngredients: EditText
    lateinit var mood: EditText
    lateinit var moodComments: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        loadData()
        setAdapter()
    }

    private fun loadData() {

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
        dataList.add(Data(food, description, ingredients, foodMood, comments))

    }

    private fun setAdapter() {
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            addItemDecoration(DividerItemDecoration(this@HomeActivity, DividerItemDecoration.VERTICAL))
            //adapter = RecyclerRAdapter(this@HomeActivity, dataList)
        }
    }
}