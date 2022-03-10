package ca.qc.cstj.s05localdatasource.data.repositories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ca.qc.cstj.s05localdatasource.domain.models.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactRepository {

    @Query("SELECT * FROM contacts")
    fun retrieveAll(): Flow<List<Contact>>

    @Insert
    fun create(contacts: List<Contact>)

    @Insert
    suspend fun create(contact: Contact)

}

//https://medium.com/androiddevelopers/room-coroutines-422b786dc4c5
//fun retrieveAll(numContacts: Int): List<Contact> {
//
//    val contacts = mutableListOf<Contact>()
//
//    contacts.add(Contact("Yannick", "Charron", true))
//
//    for (i in 1..numContacts) {
//        contacts.add(Contact("FirstName $i", "LastName $i", i % 2 == 0))
//    }
//
//    return contacts
//}