package com.example.primerproyectoandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View

class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //val displayMetrics = DisplayMetrics()
        //val screenWidth: Int  = displayMetrics.widthPixels

        val screenW: Int = canvas?.width!! //ancho de pantalla
        val screenH: Int = canvas?.height!! //alto de pantalla

        //se dibuja una Linea
        val paint: Paint = Paint()
        paint.color = Color.MAGENTA //color
        paint.strokeWidth = 5f //anchura
        canvas?.drawLine(0f,0f, screenW.toFloat(), screenH.toFloat(),paint)

        //se dibuja un Circulo
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f
        canvas?.drawCircle(700f,400f,200f,paint)
        //relleno del Circulo
        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL
        canvas?.drawCircle(700f,400f,200f,paint)

        //se dibuja un Triangulo
        val path: Path = Path()
        path.moveTo((screenW/2).toFloat(),1000f)
        path.lineTo(0f, screenH.toFloat()) //linea izquierda
        path.lineTo(screenW.toFloat(),screenH.toFloat()) //linea derecha
        path.close()

        //color linea
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        canvas?.drawPath(path,paint)

        //color Relleno
        paint.color = Color.GRAY
        paint.style = Paint.Style.FILL
        canvas?.drawPath(path,paint)
    }
}