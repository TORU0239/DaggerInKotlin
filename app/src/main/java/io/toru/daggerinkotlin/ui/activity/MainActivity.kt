package io.toru.daggerinkotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import io.toru.daggerinkotlin.R
import io.toru.daggerinkotlin.model.ItemTypeModel
import io.toru.daggerinkotlin.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()


        // let() 함수를 호출하게 되면 호출하는 객체를 let 안으로 던져서 연속적인 액션을 진행할 수 있다.
        testReturn().let{
            Log.w("MainActivity", "test!!! " + it)
        }

        "test".let { Toast.makeText(this, it,Toast.LENGTH_SHORT).show() }

        // run() 함수를 호출하게 되면 호출하는 객체를 이어지는 블록으로 던진다. 그리고 그 결과를 리턴할 수 있다.
        val splitResult:List<String> = testReturn().run { split(" ") }
        for(s in splitResult){
            Log.w("MainActivity", "run result!!  " + s)
        }

        // with() 함수를 호출하게 되면
        val testWithMethod = "TestWithMethod"
        Log.w("MainActivity", "length: " + with(testWithMethod){
            testWithMethod.length
        })

        // apply() 함수를 호출하게 되면 호출하는 객체를 블럭의 리시버로 전달하고 객체 자체를 반환함
        val applyList = LinkedList<String>().apply {
            add("야놀자")
            add("배민")
            add("헤이부티")
            add("카카오")
            add("네이버")
            add("직토")
        }

        Log.w("MainActivity", "apply result:: length:  " + applyList.size)
    }

    private fun initView() {
        val list = LinkedList<ItemTypeModel>()

        list.add(ItemTypeModel("Toru"))
        list.add(ItemTypeModel("Pluu"))
        list.add(ItemTypeModel("Kunny"))
        list.add(ItemTypeModel("Taehwan"))
        list.add(ItemTypeModel("Nurinamu"))
        list.add(ItemTypeModel("Nayeon"))
        list.add(ItemTypeModel("Chansuk"))
        list.add(ItemTypeModel("JiHwan"))

        val adapter = MainAdapter(list)
        main_recyclerview.adapter = adapter
        main_recyclerview.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()
    }

    private fun testReturn():String{
        return "Using let method!!"
    }
}