package org.techtown.starcraft2

import android.graphics.drawable.Drawable

class Starcraft2Unit {
    var unitName:String?=null
    var info:String?= null
    var img:String? = null
    constructor(){}
    constructor(
        unitName:String,
        info:String,
        img:String
    ){
        this.unitName = unitName
        this.info = info
        this.img = img
    }
}