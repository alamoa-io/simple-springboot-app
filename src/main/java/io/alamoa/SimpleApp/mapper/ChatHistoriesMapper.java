package io.alamoa.SimpleApp.mapper;

import io.alamoa.SimpleApp.model.ChatHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChatHistoriesMapper {

    @Select("SELECT * FROM chat_histories order by id desc")
    List<ChatHistory> findAll();

    @Insert("INSERT INTO chat_histories(question, answer, memo) VALUES(#{question}, #{answer}, #{memo})")
    void insert(ChatHistory chatHistory);

    @Delete("DELETE FROM chat_histories WHERE id = #{id}")
    void deleteById(Long id);

    @Update("UPDATE chat_histories SET memo = #{memo} WHERE id = #{id}")
    void updateMemo(@Param("id") int id, @Param("memo") String memo);
}
