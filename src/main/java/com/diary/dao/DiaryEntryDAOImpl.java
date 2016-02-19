package com.diary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.diary.model.DiaryEntry;

@Repository
public class DiaryEntryDAOImpl implements DiaryEntryDAO {

	private static final String ACTION_INSERT = "insert";
	private static final String ACTION_UPDATE = "update";
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public DiaryEntry findById(Long id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT id, title, post, create_date, last_update_date FROM diary WHERE id = :id";

		DiaryEntry diaryEntry = null;
		try {
			diaryEntry = namedParameterJdbcTemplate.queryForObject(sql, params, new DiaryEntryMapper());
		} catch (EmptyResultDataAccessException e) {
		}

		return diaryEntry;
	}

	public List<DiaryEntry> findAll() {
		String sql = "SELECT id, title, post, create_date, last_update_date FROM diary ORDER BY create_date DESC";
		List<DiaryEntry> result = namedParameterJdbcTemplate.query(sql, new DiaryEntryMapper());

		if (result == null) {
			result = new ArrayList<DiaryEntry>();
		}
		return result;
	}

	public void save(DiaryEntry diaryEntry) {
		String sql = "INSERT INTO diary (title, post, create_date, last_update_date) " +
		" VALUES (:title, :post, :create_date, :last_update_date)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(diaryEntry, ACTION_INSERT));
	}

	public void update(DiaryEntry diaryEntry) {
		String sql = "UPDATE diary "
				+ " SET title = :title, post = :post, last_update_date = :last_update_date "
				+ " WHERE id = :id";

			namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(diaryEntry, ACTION_UPDATE));
	}

	public void delete(Long id) {
		String sql = "DELETE FROM diary WHERE id = :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id", id));
	}

	private static final class DiaryEntryMapper implements RowMapper<DiaryEntry> {

		public DiaryEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
			DiaryEntry diaryEntry = new DiaryEntry();
			diaryEntry.setId(rs.getLong("id"));
			diaryEntry.setPost(rs.getString("post"));
			diaryEntry.setTitle(rs.getString("title"));
			diaryEntry.setCreateDate(rs.getTimestamp("create_date"));
			diaryEntry.setUpdateDate(rs.getTimestamp("last_update_date"));
			
			return diaryEntry;
		}
	}

	private SqlParameterSource getSqlParameterByModel(DiaryEntry diaryEntry, String action) {

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", diaryEntry.getId());
		paramSource.addValue("post", diaryEntry.getPost());
		paramSource.addValue("title", diaryEntry.getTitle());
		
		if (ACTION_INSERT.endsWith(action)) {
			paramSource.addValue("create_date", new java.sql.Timestamp(diaryEntry.getCreateDate().getTime()));
		}
		
		paramSource.addValue("last_update_date", new java.sql.Timestamp(diaryEntry.getUpdateDate().getTime()));

		return paramSource;
	}
}