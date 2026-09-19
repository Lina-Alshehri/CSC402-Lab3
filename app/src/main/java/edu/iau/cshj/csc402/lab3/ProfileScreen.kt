package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

val studentList = listOf(
    Student("Abdulrahman Al-Mutairi", "Computer Science", "3.95", "2210001234@iau.edu.sa", "Jubail"),
    Student("Lina Al-Qahtani", "Computer Science", "3.88", "2210005678@iau.edu.sa", "Dammam"),
    Student("Fahad Al-Dossary", "Cybersecurity", "3.75", "2210009012@iau.edu.sa", "Khobar"),
    Student("Noura Al-Zahrani", "Artificial Intelligence", "3.90", "2210003456@iau.edu.sa", "Jubail"),
    Student("Sultan Al-Ghamdi", "Software Engineering", "3.62", "2210007890@iau.edu.sa", "Dammam")
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("My Profile") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Text(text = "Edit", modifier = Modifier.padding(horizontal = 8.dp))
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Students List",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Total: ${studentList.size}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
            items(studentList) { student ->
                StudentCard(student = student)
            }
        }
    }
}