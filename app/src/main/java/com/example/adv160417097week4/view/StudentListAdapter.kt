package com.example.adv160417097week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160417097week4.R
import com.example.adv160417097week4.model.Student

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView
.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList[position]
        with(holder.view){
            val txtID = findViewById<TextView>(R.id.txtID)
            val txtName = findViewById<TextView>(R.id.txtName)
            
            txtID.text =student.id
            txtName.text = student.name

            val buttonDetail = findViewById<Button>(R.id.button)
            buttonDetail.setOnClickListener {
                val action = actionStudentDetail(student.id.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }

    }


    override fun getItemCount() = studentList.size

    fun UpdateStudentList(newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}
