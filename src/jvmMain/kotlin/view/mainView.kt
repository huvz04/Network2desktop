package view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.website
import service.webService

class mainView {

    @Composable
    fun unifiedModifier() = Modifier
        .fillMaxHeight()
        .width(IntrinsicSize.Min)
        .padding(16.dp)
        //.border(2.dp, Color.Red)
        .shadow(4.dp, shape = RoundedCornerShape(2.dp))
        .padding(16.dp)
    @Composable
    fun DividerModifier() = Modifier.padding(top = 8.dp, bottom = 8.dp)

    val urlList:MutableList<website> = webService.init()

    var colorDe = Color(0,100,0)
    fun Color.updateColor(value: Long) {
        colorDe = when(value){
            //darkgreen
            in 0..99 ->  Color(0,100,0)
            //limegreen
            in 100..200 -> Color(50,205,50)
            //darkorange
            in 201..500 -> Color(255,140,0)
            else -> Color(139,0,0)
        }
    }



    @Composable
    @Preview
    fun mainStart(){

        MaterialTheme{
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Row(modifier = Modifier.height(IntrinsicSize.Min).align(Alignment.CenterHorizontally)){
                    Text(
                        text = "网络连通性检查",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                    )

                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.height(IntrinsicSize.Min).align(Alignment.CenterHorizontally)) {
                    urlList.forEach {
                        Box(
                            modifier = unifiedModifier().weight(1f),
                            contentAlignment = Alignment.Center
                            //.border(1.dp, Color.Black)
                        ){
                            Column {
                                colorDe.updateColor(it.delay)
                                Text(
                                    text = it.name,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black,
                                )
                                Divider(modifier =DividerModifier() )
                                Text(
                                    text = "${it.delay}ms",
                                    fontSize = 13.sp,
                                    color = colorDe
                                )

                                println(colorDe)
                            }

                        }
                    }


                }

                // 间距
                Spacer(modifier = Modifier.height(16.dp))


            }
        }
    }
}