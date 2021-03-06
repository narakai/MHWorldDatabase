package com.gatheringhallstudios.mhworlddatabase.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.gatheringhallstudios.mhworlddatabase.data.models.*

@Dao
abstract class DecorationDao {
    @Query("""
        SELECT d.id, dt.name, d.slot, d.icon_color
        FROM decoration d
            JOIN decoration_text dt
                ON dt.id = d.id
                AND dt.lang_id = :langId
        ORDER BY dt.name""")
    abstract fun loadDecorations(langId: String): LiveData<List<DecorationBase>>

    @Query("""
        SELECT d.*, dtext.name,
            s.id skill_id, stext.name skill_name, s.max_level skill_max_level, s.icon_color skill_icon_color
        FROM decoration d
            JOIN decoration_text dtext
                ON dtext.id = d.id
            JOIN skilltree s
                ON s.id = d.skilltree_id
            JOIN skilltree_text stext
                ON stext.id = s.id
                AND stext.lang_id = dtext.lang_id
        WHERE d.id = :decorationId
          AND dtext.lang_id = :langId""")
    abstract fun loadDecoration(langId: String, decorationId: Int): LiveData<Decoration>
}
