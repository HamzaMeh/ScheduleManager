package com.archestro.schedulemanager.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.archestro.schedulemanager.R
import com.archestro.schedulemanager.ui.theme.lakeGreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetRepeat() {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )

    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(600.dp)
                    .background(Color.White)
                    .clip(RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp))
            ) {
                Column(
                    Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                   RepeatSchedule()
                }
            }
        }, sheetPeekHeight = 0.dp
    ) {

        Column(
            Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.size(16.dp))
            Button(onClick = {

                coroutineScope.launch {

                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }

            }) {
                Text(text = "Repeat", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }

    }
}

/*@Composable
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
            ) {
            Text("Repeat")
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Repeat",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }

    }
}*/

/*@Composable
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
}*/




/*
@Preview
@Composable
fun previewDialog(){
    DialogSchedule()
}*/
