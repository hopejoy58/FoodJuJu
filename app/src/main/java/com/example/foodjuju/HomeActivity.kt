package com.example.foodjuju

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class HomeActivity : AppCompatActivity() {

    private var dataList = ArrayList<FoodData>()

    var databaseReference: DatabaseReference = Firebase.database.reference
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_home)

        databaseReference = FirebaseDatabase.getInstance().getReference("foods")
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val foodId = dataSnapshot.child("foodId").getValue().toString()
                val food = dataSnapshot.child("food").getValue().toString()
                val foodDesc = dataSnapshot.child("foodDesc").getValue().toString()
                val foodIng = dataSnapshot.child("foodIng").getValue().toString()
                val mood = dataSnapshot.child("mood").getValue().toString()
                val moodComment = dataSnapshot.child("moodComment").getValue().toString()
                val data = FoodData(food, foodId, foodDesc, foodIng, mood, moodComment)
                dataList.add(data)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Toast.makeText(applicationContext, "Nope.", Toast.LENGTH_LONG)
                    .show()
            }
        })

        viewManager = LinearLayoutManager(this)
        viewAdapter = RecyclerAdapter(dataList)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
    }

}