package com.example.primerproyectoandroid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class DrawingView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    val paint: Paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        dibujandoMapa(canvas!!)
    }

    fun dibujandoMapa(canvas: Canvas){
        val screenW: Int = canvas?.width!! //ancho de pantalla
        val screenH: Int = canvas?.height!! //largo de pantalla
        val blockSize: Int = 100 //tamaño de un bloque

        //listas para lineas en vertical
        val initialCoordListV: List<Array<Double>> = listOf(
           arrayOf(1.0,2.0*blockSize,9.0*blockSize),
           arrayOf(blockSize.toDouble(),3.0*blockSize,5.0*blockSize,(6.5)*blockSize,12.0*blockSize),
           arrayOf(2.0*blockSize,3.0*blockSize,5.0*blockSize,(6.5)*blockSize,11.0*blockSize),
           arrayOf(3.0*blockSize,3.0*blockSize,5.0*blockSize,9.0*blockSize,13.0*blockSize),
           arrayOf(4.0*blockSize,3.0*blockSize,5.0*blockSize,7.5*blockSize,10.0*blockSize),
           arrayOf(5.0*blockSize,2.0*blockSize,11.0*blockSize,13.0*blockSize),
           arrayOf(6.0*blockSize,2.0*blockSize,11.0*blockSize,13.0*blockSize),
           arrayOf(7.0*blockSize,3.0*blockSize,5.0*blockSize,7.5*blockSize,10.0*blockSize),
           arrayOf(8.0*blockSize,3.0*blockSize,5.0*blockSize,9.0*blockSize,13.0*blockSize),
           arrayOf(9.0*blockSize,3.0*blockSize,5.0*blockSize,6.5*blockSize,11.0*blockSize),
           arrayOf(10.0*blockSize,3.0*blockSize,5.0*blockSize,6.5*blockSize,12.0*blockSize),
           arrayOf((screenW-1).toDouble(),2.0*blockSize,9.0*blockSize))

        val finalCoordListV: List<Array<Double>> = listOf(arrayOf(1.0,8.0*blockSize,15.0*blockSize),
            arrayOf(blockSize.toDouble(),4.0*blockSize,(5.5)*blockSize, 7.0*blockSize,13.0*blockSize),
            arrayOf(2.0*blockSize,4.0*blockSize,(5.5)*blockSize,7.0*blockSize,13.0*blockSize),
            arrayOf(3.0*blockSize,4.0*blockSize,8.0*blockSize,10.0*blockSize,14.0*blockSize),
            arrayOf(4.0*blockSize,4.0*blockSize,5.5*blockSize,9.0*blockSize,11.0*blockSize),
            arrayOf(5.0*blockSize,4.0*blockSize,12.0*blockSize,14.0*blockSize),
            arrayOf(6.0*blockSize,4.0*blockSize,12.0*blockSize,14.0*blockSize),
            arrayOf(7.0*blockSize,4.0*blockSize,5.5*blockSize,9.0*blockSize,11.0*blockSize),
            arrayOf(8.0*blockSize,4.0*blockSize,8.0*blockSize,10.0*blockSize,14.0*blockSize),
            arrayOf(9.0*blockSize,4.0*blockSize,5.5*blockSize,7.0*blockSize,13.0*blockSize),
            arrayOf(10.0*blockSize,4.0*blockSize,5.5*blockSize,7.0*blockSize,13.0*blockSize),
            arrayOf((screenW-1).toDouble(),8.0*blockSize,15.0*blockSize))

        //listas para lineas en horizontal
        val initialCoordListH: List<Array<Double>> = listOf(arrayOf(2.0*blockSize,1.0),
            arrayOf(3.0*blockSize,blockSize.toDouble(),3.0*blockSize,7.0*blockSize,9.0*blockSize),
            arrayOf(4.0*blockSize,blockSize.toDouble(),3.0*blockSize,5.0*blockSize,7.0*blockSize,9.0*blockSize),
            arrayOf(5.0*blockSize,blockSize.toDouble(),4.0*blockSize,9.0*blockSize),
            arrayOf(5.5*blockSize,blockSize.toDouble(),4.0*blockSize,9.0*blockSize),
            arrayOf(6.5*blockSize,blockSize.toDouble(),3.0*blockSize,6.0*blockSize,9.0*blockSize),
            arrayOf(7.0*blockSize,blockSize.toDouble(),9.0*blockSize),
            arrayOf(7.5*blockSize,4.0*blockSize),
            arrayOf(8.0*blockSize,1.0,9.0*blockSize),
            arrayOf(9.0*blockSize,1.0,4.0*blockSize,9.0*blockSize),
            arrayOf(10.0*blockSize,blockSize.toDouble(),4.0*blockSize,9.0*blockSize),
            arrayOf(11.0*blockSize,blockSize.toDouble(),4.0*blockSize,6.0*blockSize,9.0*blockSize),
            arrayOf(12.0*blockSize,1.0,3.0*blockSize,5.0*blockSize,7.0*blockSize,10.0*blockSize),
            arrayOf(13.0*blockSize,1.0,4.0*blockSize,10.0*blockSize),
            arrayOf(14.0*blockSize,blockSize.toDouble(),5.0*blockSize,7.0*blockSize),
            arrayOf(15.0*blockSize,1.0))

        val finalCoordListH: List<Array<Double>> = listOf(arrayOf(2.0*blockSize,(screenW-1).toDouble()),
            arrayOf(3.0*blockSize,2.0*blockSize,4.0*blockSize,8.0*blockSize,10.0*blockSize),
            arrayOf(4.0*blockSize,2.0*blockSize,4.0*blockSize,6.0*blockSize,8.0*blockSize,10.0*blockSize),
            arrayOf(5.0*blockSize,2.0*blockSize,7.0*blockSize,10.0*blockSize),
            arrayOf(5.5*blockSize,2.0*blockSize,7.0*blockSize,10.0*blockSize),
            arrayOf(6.5*blockSize,2.0*blockSize,5.0*blockSize,8.0*blockSize,10.0*blockSize),
            arrayOf(7.0*blockSize,2.0*blockSize,10.0*blockSize),
            arrayOf(7.5*blockSize,7.0*blockSize),
            arrayOf(8.0*blockSize,2.0*blockSize,(screenW-1).toDouble()),
            arrayOf(9.0*blockSize,2.0*blockSize,7.0*blockSize,(screenW-1).toDouble()),
            arrayOf(10.0*blockSize,2.0*blockSize,7.0*blockSize,10.0*blockSize),
            arrayOf(11.0*blockSize,2.0*blockSize,5.0*blockSize,7.0*blockSize,10.0*blockSize),
            arrayOf(12.0*blockSize,blockSize.toDouble(),4.0*blockSize,6.0*blockSize,8.0*blockSize,(screenW-1).toDouble()),
            arrayOf(13.0*blockSize,blockSize.toDouble(),7.0*blockSize,(screenW-1).toDouble()),
            arrayOf(14.0*blockSize,4.0*blockSize,6.0*blockSize,10.0*blockSize),
            arrayOf(15.0*blockSize,(screenW-1).toDouble()))

        //color y grosos de las lineas
        paint.color = Color.RED
        paint.strokeWidth = 5f
        var listDim:Int = initialCoordListV.size
        var dim:Int
        var iPosX:Double
        var fPosX:Double
        var iPosY:Double
        var fPosY:Double

        for(i in 0 until listDim){
            var initialArrayVertical: Array<Double> = initialCoordListV[i]
            var finalArrayVertical: Array<Double> = finalCoordListV[i]
            dim = finalArrayVertical.size
            iPosX = initialArrayVertical[0] //vale para posX final
            for(j in 1 until dim){
                iPosY = initialArrayVertical[j]
                fPosY = finalArrayVertical[j]

                canvas.drawLine(iPosX.toFloat(),iPosY.toFloat(),iPosX.toFloat(),fPosY.toFloat(),paint)
            }
        }
        listDim = initialCoordListH.size
        for(i in 0 until listDim){
            var initialArrayHorizontal: Array<Double> = initialCoordListH[i]
            var finalArrayHorizontal: Array<Double> = finalCoordListH[i]
            dim = finalArrayHorizontal.size
            iPosY = initialArrayHorizontal[0] //vale para posY final
            for(j in 1 until  dim){
                iPosX = initialArrayHorizontal[j]
                fPosX = finalArrayHorizontal[j]

                canvas.drawLine(iPosX.toFloat(),iPosY.toFloat(),fPosX.toFloat(),iPosY.toFloat(),paint)
            }
        }
    }
}