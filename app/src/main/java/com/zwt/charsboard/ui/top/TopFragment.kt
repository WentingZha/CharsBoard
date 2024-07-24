package com.zwt.charsboard.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.zwt.charsboard.R
import com.zwt.charsboard.databinding.FragmentTopBinding
import com.zwt.charsboard.viewmodel.TopViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale
@AndroidEntryPoint
class TopFragment : Fragment() {

    private var _binding: FragmentTopBinding? = null
    private val binding get() = _binding!!

    private val CARD_COUNT = 4

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val topViewModel = ViewModelProvider(this)[TopViewModel::class.java]

        val titles = listOf(
            getString(R.string.top_title1),
            getString(R.string.top_title2),
            getString(R.string.top_title3),
            getString(R.string.top_title4))
        val company = listOf(
            getString(R.string.top_company1),
            getString(R.string.top_company2),
            getString(R.string.top_company3),
            getString(R.string.top_company4))
        val intros = listOf(
            getString(R.string.top_intro1),
            getString(R.string.top_intro2),
            getString(R.string.top_intro3),
            getString(R.string.top_intro4))
        for (i in 1 until titles.size) {
            topViewModel.insertAll(titles[i], company[i], intros[i])
        }




//        topViewModel.intro1.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.intro2.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.intro3.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.intro4.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.intro5.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.intro6.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.intro7.observe(viewLifecycleOwner){
//            introList.add(it)
//        }
//        topViewModel.title1.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//        topViewModel.title2.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//        topViewModel.title3.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//        topViewModel.title4.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//        topViewModel.title5.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//        topViewModel.title6.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//
//        topViewModel.title7.observe(viewLifecycleOwner){
//            titleList.add(it)
//        }
//        topViewModel.company1.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }
//        topViewModel.company2.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }
//        topViewModel.company3.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }
//        topViewModel.company4.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }
//        topViewModel.company5.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }
//        topViewModel.company6.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }
//        topViewModel.company7.observe(viewLifecycleOwner){
//            companyList.add(it)
//        }

        _binding = FragmentTopBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.catCardListRecyclerView

        val introList = ArrayList<String>()
        val titleList = ArrayList<String>()
        val companyList = ArrayList<String>()

        lifecycleScope.launch {
            withContext(Dispatchers.Main) {
                topViewModel.getAll().observe(viewLifecycleOwner){
                    for (topEntity in it) {
                        introList.add(topEntity.intro?:"")
                        companyList.add(topEntity.company?:"")
                        titleList.add(topEntity.title?:"")
                    }

                    val cardAdapter = CardAdapter(generateCardNumbers(),introList, titleList,companyList)
                    val itemTouchHelper = ItemTouchHelper(CardItemTouchHelperCallback(cardAdapter))
                    cardAdapter.setItemTouchHelper(itemTouchHelper)
                    recyclerView.layoutManager = LinearLayoutManager(activity)
                    recyclerView.adapter = cardAdapter
                    itemTouchHelper.attachToRecyclerView(recyclerView)
                }

            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun generateCardNumbers(): IntArray {
        val cardNumbers = IntArray(CARD_COUNT)
        for (i in 0 until CARD_COUNT) {
            cardNumbers[i] = i + 1
        }
        return cardNumbers
    }

    private class CardAdapter(val cardNumbers: IntArray, val introList: ArrayList<String>, val titleList:ArrayList<String>, val companyList:ArrayList<String>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private var itemTouchHelper: ItemTouchHelper? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view: View =
                inflater.inflate(R.layout.rich_media_card_item, parent,false)
            return CardViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
            (viewHolder as CardViewHolder).bind(cardNumbers[position], titleList,introList,companyList,itemTouchHelper)
        }

        override fun getItemCount(): Int {
            return 4
        }

        fun setItemTouchHelper(itemTouchHelper: ItemTouchHelper) {
            this.itemTouchHelper = itemTouchHelper
        }

        private class CardViewHolder (itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            private val companyImgView: ImageView
            private val titleView: TextView
            private val secTitleView: TextView
            private val despView: TextView
            private val imgView: ImageView
//            private val dragHandleView: View

            init {
                companyImgView = itemView.findViewById(R.id.rich_media_card_item_company_img)
                titleView = itemView.findViewById(R.id.rich_media_card_item_title)
                secTitleView = itemView.findViewById(R.id.rich_media_card_item_sec_title)
                despView = itemView.findViewById(R.id.rich_media_card_item_desp)
                imgView = itemView.findViewById(R.id.rich_media_card_item_full_img)
//                dragHandleView = itemView.findViewById(R.id.cat_card_list_item_drag_handle)
            }

            fun bind(cardNumber: Int, titleList: ArrayList<String>, introList: ArrayList<String>, companyList: ArrayList<String>, itemTouchHelper: ItemTouchHelper?) {
                titleView.text =
                    String.format(Locale.getDefault(), titleList[cardNumber-1], cardNumber)
                secTitleView.text =
                    String.format(Locale.getDefault(), companyList[cardNumber-1], cardNumber)
                despView.text =
                    String.format(Locale.getDefault(), introList[cardNumber-1], cardNumber)
                when(cardNumber) {
                    1-> imgView.setImageResource(R.mipmap.unlock)
                    2-> imgView.setImageResource(R.mipmap.timestories)
                    3-> imgView.setImageResource(R.mipmap.chronicles_of_crime)
                    4-> imgView.setImageResource(R.mipmap.escape_game)
//                    5-> imgView.setImageResource(R.mipmap.escape_room)
//                    6-> imgView.setImageResource(R.mipmap.arkham_horror)
//                    7-> imgView.setImageResource(R.mipmap.sigularity)
                }
                when(cardNumber) {
                    1-> companyImgView.setImageResource(R.mipmap.unlock)
                    2-> companyImgView.setImageResource(R.mipmap.timestories)
                    3-> companyImgView.setImageResource(R.mipmap.chronicles_of_crime)
                    4-> companyImgView.setImageResource(R.mipmap.escape_game)
//                    5-> companyImgView.setImageResource(R.mipmap.escape_room)
//                    6-> companyImgView.setImageResource(R.mipmap.arkham_horror)
//                    7-> companyImgView.setImageResource(R.mipmap.sigularity)
                }
//                dragHandleView.setOnTouchListener { v: View?, event: MotionEvent ->
//                    if (event.action == MotionEvent.ACTION_DOWN) {
//                        itemTouchHelper!!.startDrag(this@CardViewHolder)
//                        return@setOnTouchListener true
//                    }
//                    false
//                }
            }
        }
    }

    private class CardItemTouchHelperCallback constructor(private val cardAdapter: CardAdapter) :
        ItemTouchHelper.Callback() {
        private var dragCardView: MaterialCardView? = null
        override fun getMovementFlags(
            recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(DRAG_FLAGS, SWIPE_FLAGS)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return true
        }



        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            super.onSelectedChanged(viewHolder, actionState)

        }


        companion object {
            private const val DRAG_FLAGS = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            private const val SWIPE_FLAGS = 0
        }
    }


}