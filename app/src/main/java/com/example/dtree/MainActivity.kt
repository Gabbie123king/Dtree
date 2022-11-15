package com.example.dtree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dtree.ui.theme.DtreeTheme

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue

import com.lubnamariyam.retrofitapiinjetpackcompose.model.Group
import com.lubnamariyam.retrofitapiinjetpackcompose.view.GroupItem
import com.lubnamariyam.retrofitapiinjetpackcompose.view.GroupItem
import com.lubnamariyam.retrofitapiinjetpackcompose.viewModel.GroupViewModel


class MainActivity : ComponentActivity() {

    val groupViewModel by viewModels<GroupViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    GroupList(groupList = groupViewModel.groupListResponse)
                    groupViewModel.getgroupList()
                    getData();

                }
        }
    }

    private fun getData() {

    }
}

@Composable
fun GroupList(groupList: List<Group>) {
    LazyColumn {
        itemsIndexed(items = groupList) { index, item ->
            GroupItem(group = item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

        val group = Group(
            "name",
            "surname",
        16,
        "city",

        )

        GroupItem(group = group)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldView(){
    val textState = remember { mutableStateOf(TextFieldValue()) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it }
    )
    Text("Search City " + textState.value.text)
}


