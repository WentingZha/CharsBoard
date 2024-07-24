package com.zwt.charsboard.ui.walkthrough

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.zwt.charsboard.R
import com.zwt.charsboard.databinding.FragmentWalkthroughBinding
import com.zwt.charsboard.viewmodel.WalkthroughViewModel
import java.util.Locale

class WalkthroughFragment : Fragment() {

    private var _binding: FragmentWalkthroughBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this)[WalkthroughViewModel::class.java]

        _binding = FragmentWalkthroughBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textSlideshow
//        slideshowViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val introList = ArrayList<String>()
        val titleList = ArrayList<String>()
        slideshowViewModel.intro1.observe(viewLifecycleOwner){
            introList.add(it)
        }
        slideshowViewModel.intro2.observe(viewLifecycleOwner){
            introList.add(it)
        }
        slideshowViewModel.intro3.observe(viewLifecycleOwner){
            introList.add(it)
        }
        slideshowViewModel.intro4.observe(viewLifecycleOwner){
            introList.add(it)
        }
        slideshowViewModel.intro5.observe(viewLifecycleOwner){
            introList.add(it)
        }
        slideshowViewModel.intro6.observe(viewLifecycleOwner){
            introList.add(it)
        }
        slideshowViewModel.intro7.observe(viewLifecycleOwner){
            introList.add(it)
        }

        slideshowViewModel.title1.observe(viewLifecycleOwner){
            titleList.add(it)
        }
        slideshowViewModel.title2.observe(viewLifecycleOwner){
            titleList.add(it)
        }
        slideshowViewModel.title3.observe(viewLifecycleOwner){
            titleList.add(it)
        }
        slideshowViewModel.title4.observe(viewLifecycleOwner){
            titleList.add(it)
        }
        slideshowViewModel.title5.observe(viewLifecycleOwner){
            titleList.add(it)
        }
        slideshowViewModel.title6.observe(viewLifecycleOwner){
            titleList.add(it)
        }
        slideshowViewModel.title7.observe(viewLifecycleOwner){
            titleList.add(it)
        }


        val recyclerView = binding.catCardListRecyclerView
        val cardAdapter = CardAdapter(generateCardNumbers(), introList, titleList)
        val itemTouchHelper = ItemTouchHelper(CardItemTouchHelperCallback(cardAdapter))
        cardAdapter.setItemTouchHelper(itemTouchHelper)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = cardAdapter
        itemTouchHelper.attachToRecyclerView(recyclerView)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun generateCardNumbers(): IntArray {
        val cardNumbers = IntArray(7)
        for (i in 0 until 7) {
            cardNumbers[i] = i + 1
        }
        return cardNumbers
    }

    private class CardAdapter constructor(val cardNumbers: IntArray, val introList: ArrayList<String>, val titleList:ArrayList<String>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        private var itemTouchHelper: ItemTouchHelper? = null
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val view: View =
                inflater.inflate(R.layout.cat_card_list_item, parent,false)
            return CardViewHolder(view)
        }

        override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
            (viewHolder as CardViewHolder).bind(cardNumbers[position], titleList,introList,itemTouchHelper)
        }

        override fun getItemCount(): Int {
            return cardNumbers.size
        }

        fun setItemTouchHelper(itemTouchHelper: ItemTouchHelper) {
            this.itemTouchHelper = itemTouchHelper
        }

        private class CardViewHolder constructor(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            private val titleView: TextView
            private val introView: TextView
            private val imgView: ImageView
            private val textLl: LinearLayout
            private val dragHandleView: View

            init {
                titleView = itemView.findViewById(R.id.cat_card_list_item_title)
                introView = itemView.findViewById(R.id.cat_card_list_item_intro)
                imgView = itemView.findViewById(R.id.cat_card_list_item_image)
                textLl = itemView.findViewById(R.id.text_ll)
                dragHandleView = itemView.findViewById(R.id.cat_card_list_item_drag_handle)
            }


            fun bind(cardNumber: Int, titleList: ArrayList<String>, introList: ArrayList<String>, itemTouchHelper: ItemTouchHelper?) {
                titleView.text =
                    String.format(Locale.getDefault(), titleList.get(cardNumber-1), cardNumber)
                introView.text =
                    String.format(Locale.getDefault(), introList.get(cardNumber-1), cardNumber)
                when(cardNumber) {
                    1-> imgView.setImageResource(R.mipmap.unlock)
                    2-> imgView.setImageResource(R.mipmap.timestories)
                    3-> imgView.setImageResource(R.mipmap.escape_game)
                    4-> imgView.setImageResource(R.mipmap.nightmare_lab)
                    5-> imgView.setImageResource(R.mipmap.escape_room)
                    6-> imgView.setImageResource(R.mipmap.undo)
                    7-> imgView.setImageResource(R.mipmap.black_stroies)
                }

                titleView.setOnTouchListener { view, motionEvent ->
//                    Log.i("WalkthroughFragment", "touch")
                    view.findNavController().navigate(R.id.action_nav_slideshow_to_walkDetailFragment)
                    false
                }

                dragHandleView.setOnTouchListener { v: View?, event: MotionEvent ->
                    if (event.action == MotionEvent.ACTION_DOWN) {
                        itemTouchHelper!!.startDrag(this@CardViewHolder)
                        return@setOnTouchListener true
                    }
                    false
                }
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
            val fromPosition = viewHolder.adapterPosition
            val toPosition = target.adapterPosition
            swapCards(fromPosition, toPosition, cardAdapter)
            return true
        }


        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
            super.onSelectedChanged(viewHolder, actionState)
            if (actionState == ItemTouchHelper.ACTION_STATE_DRAG && viewHolder != null) {
                dragCardView = viewHolder.itemView as MaterialCardView
                dragCardView!!.isDragged = true
            } else if (actionState == ItemTouchHelper.ACTION_STATE_IDLE && dragCardView != null) {
                dragCardView!!.isDragged = false
                dragCardView = null
            }
        }

        private fun swapCards(fromPosition: Int, toPosition: Int, cardAdapter: CardAdapter) {
            val fromNumber = cardAdapter.cardNumbers[fromPosition]
            cardAdapter.cardNumbers[fromPosition] = cardAdapter.cardNumbers[toPosition]
            cardAdapter.cardNumbers[toPosition] = fromNumber
            cardAdapter.notifyItemMoved(fromPosition, toPosition)
        }

        companion object {
            private const val DRAG_FLAGS = ItemTouchHelper.UP or ItemTouchHelper.DOWN
            private const val SWIPE_FLAGS = 0
        }
    }
}