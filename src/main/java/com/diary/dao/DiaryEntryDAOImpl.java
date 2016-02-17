package com.diary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.diary.model.DiaryEntry;

@Repository
public class DiaryEntryDAOImpl implements DiaryEntryDAO {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public DiaryEntry findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DiaryEntry> findAll() {
		String sql = "SELECT id, title, post FROM diary ORDER BY id";
		List<DiaryEntry> result = namedParameterJdbcTemplate.query(sql, new DiaryEntryMapper());
		if (result == null) {
			result = new ArrayList<DiaryEntry>();
		}
		return result;
	}

	public void save(DiaryEntry diaryEntry) {
	}

	public void update(DiaryEntry diaryEntry) {
	}

	public void delete(Integer id) {
	}

	private static final class DiaryEntryMapper implements RowMapper<DiaryEntry> {

		public DiaryEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
			DiaryEntry diaryEntry = new DiaryEntry();
			diaryEntry.setId(rs.getLong("id"));
			diaryEntry.setPost(rs.getString("post"));
			diaryEntry.setTitle(rs.getString("title"));
			return diaryEntry;
		}
	}
}
