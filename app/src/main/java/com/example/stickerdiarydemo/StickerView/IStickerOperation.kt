package com.example.stickerdiarydemo.StickerView

interface IStickerOperation {
    fun onSelect(tag: String)
    fun onDelete(tag: String)
}