package com.example.stickerdiarydemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import androidx.core.view.size
import com.example.stickerdiarydemo.StickerView.StickerImageView
import com.example.stickerdiarydemo.databinding.FragmentAddStickerBinding


class AddStickerFragment : Fragment() {
    private val bindingAddStickerFragment by lazy { FragmentAddStickerBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addStickerImage()
        addStickerLockedImage()
        getDataSticker()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return bindingAddStickerFragment.root
    }

    private fun addStickerLockedImage() {
        val canvas: FrameLayout = bindingAddStickerFragment.layoutSticker

        bindingAddStickerFragment.btnAddStickerLocked.setOnClickListener {
            val ivSticker = StickerImageView(requireContext())
            ivSticker.setImageResource(R.drawable.emoji_svg)

            canvas.addView(ivSticker)

            ivSticker.post {
                ivSticker.x = 500f
                ivSticker.y = bindingAddStickerFragment.layoutNote.scrollY + 600f
            }
//            ivSticker.select(false)

        }

        bindingAddStickerFragment.layoutSticker.forEachIndexed { index, view ->
            if(view is StickerImageView){
                Log.d("Get StickerView: ","width: ${view.width}, height: ${view.height}, mX: ${view.x}, mY: ${view.y}, rotate: ${view.rotation} " )
            }
        }
    }

    private fun getDataSticker(){
        bindingAddStickerFragment.btnGetSticker.setOnClickListener{
            bindingAddStickerFragment.layoutSticker.forEachIndexed { index, view ->
                if(view is StickerImageView){
                    Log.d("Get StickerView: ","width: ${view.width}, height: ${view.height}, mX: ${view.x}, mY: ${view.y}, rotate: ${view.rotation} " )
                }
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun addStickerImage() {
        val canvas: FrameLayout = bindingAddStickerFragment.layoutSticker

        bindingAddStickerFragment.btnAddSticker.setOnClickListener {
            val ivSticker = StickerImageView(requireContext())
            ivSticker.setImageResource(R.drawable.emoji_svg)

            canvas.addView(ivSticker)
            // wait for 'canvas.addView(ivSticker)' done

            ivSticker.post {
                ivSticker.x = 400f
                ivSticker.y = bindingAddStickerFragment.layoutNote.scrollY + 500f
            }
//            ivSticker.select(false)

            ivSticker.setOnClickListener {
                // Bỏ "select" tất cả các Sticker khác
                bindingAddStickerFragment.layoutSticker.forEach { view ->
                    if (view is StickerImageView) {
                        view.select(false) // Bỏ chọn các Sticker khác
                    }
                }
                // Chọn Sticker này
                ivSticker.select(true)
//                ivSticker.performClick()
                Log.d("ivSticker.select(true)155: ", "come")
            }
            bindingAddStickerFragment.layoutTextAndImage.setOnClickListener{
                bindingAddStickerFragment.layoutSticker.forEach { view ->
                    if (view is StickerImageView) {
                        view.select(false) // Bỏ chọn các Sticker khác
                    }
                }
            }

            Log.d("takeIndex: ", "onCreate: ${bindingAddStickerFragment.layoutSticker.size}")
        }
        Handler(Looper.getMainLooper()).postDelayed({
            Log.e("takeIndexlayoutSticker: ", "${bindingAddStickerFragment.layoutSticker.size}")
        }, 1000)

        bindingAddStickerFragment.layoutSticker.forEachIndexed { index, view ->
            if(view is StickerImageView){
                Log.d("Get StickerView: ","width: ${view.width}, height: ${view.height}, mX: ${view.x}, mY: ${view.y}, rotate: ${view.rotation} " )
            }
        }
    }

}