package com.archestro.schedulemanager.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.archestro.schedulemanager.R
import com.archestro.schedulemanager.ui.theme.lakeGreen

@Composable
fun DialogSchedule(){
    val (showDialog, setShowDialog) =  remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                setShowDialog(true)
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = lakeGreen),
            modifier = Modifier.fillMaxWidth().padding(8.dp,0.dp)
            ) {
            Text("Repeat")
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Repeat",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
        DialogShow(showDialog, setShowDialog)
    }
}

@Composable
fun DialogShow(showDialog: Boolean, setShowDialog: (Boolean) -> Unit) {
    if (showDialog) {
        AlertDialog(
            modifier = Modifier.padding(16.dp, 32.dp),
            onDismissRequest = {
            },
            title = {
               RepeatSchedule()
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)

                    },
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        // Change the state to close the dialog
                        setShowDialog(false)
                    },
                ) {
                    Text("Dismiss")
                }
            },

        )
    }
}




@Preview
@Composable
fun previewDialog(){
    DialogSchedule()
}