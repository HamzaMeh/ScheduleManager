package com.archestro.schedulemanager.ui.subjectdialog

import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.archestro.schedulemanager.R
import com.archestro.schedulemanager.presentation.util.Screen
import com.archestro.schedulemanager.ui.home.CalendarView
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun SubjectDialog(
    navController: NavController
) {
    //val navController = rememberNavController()
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    var subjectValue by remember {
        mutableStateOf("")
    }
    var teacherValue by remember {
        mutableStateOf("")
    }
    var roomValue by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp)
    ) {
        Text(
            text = "Add subject",
            modifier = Modifier.padding(32.dp, 8.dp, 16.dp, 8.dp),
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = Modifier.padding(8.dp))

        TextField(
            value = subjectValue,
            label = {
                Text("Subject")
            },
            onValueChange = {
                subjectValue = it
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        TextField(
            value = teacherValue,
            label = {
                Text("Teacher")
            },
            onValueChange = {
                teacherValue = it
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        /*TextField(
            value = roomValue,
            label = {
                Text("Room")
            },
            onValueChange = {
                roomValue = it
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )*/
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Select day from Calendar:", modifier = Modifier.padding(24.dp, 0.dp))
            Spacer(modifier = Modifier.size(16.dp))
            Button(
                onClick = {
                    //TODO, OPEN CALENDAR AFTER ONCLICK (calendar screen?)
                    navController.navigate("calendar_screen")
                },
                modifier = Modifier
                    .padding(0.dp, 0.dp, 24.dp, 0.dp),

                )
            {
                Icon(painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = "Calendar"
                )
            }

        }
        Spacer(modifier = Modifier.padding(8.dp))

        //TODO THIS TEXT SHOULD APPEAR IF YOU HAVE CHOSEN A DAY OR MORE IN THE CALENDAR
        Text(text = "days selected", color = Color.Gray, fontSize = 12.sp)

        Spacer(modifier = Modifier.padding(8.dp))

        ShowTimePicker(context = context, "From")

        Spacer(modifier = Modifier.padding(8.dp))

        ShowTimePicker(context = context, "To")

        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Subject $subjectValue saved")
            }
        }) {

            Text("Save")
        }

    }
}


@Composable
fun ShowTimePicker(context: Context, title: String) {
    var text by remember { mutableStateOf("00:00") }
    val calendar = Calendar.getInstance()
    val hour = calendar[Calendar.HOUR_OF_DAY]
    val minute = calendar[Calendar.MINUTE]

    val time = remember { mutableStateOf("") }
    val timePickerDialog = TimePickerDialog(
        context,
        { _, hour: Int, minute: Int ->
            time.value = "$hour:$minute"
        }, hour, minute, false
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "$title: ", modifier = Modifier.padding(24.dp, 0.dp))
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {
                timePickerDialog.show()

            },
            modifier = Modifier
                .width(100.dp)
                .padding(0.dp, 0.dp, 24.dp, 0.dp)
        )
        {
            Text(text = "${time.value}")
        }

    }

}

/*

@Preview
@Composable
fun TextPreview() {
    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            SubjectDialog()
        }
    }
}*/
