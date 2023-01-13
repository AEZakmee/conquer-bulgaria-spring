package com.conquer.bulgaria.dao.sites;

import com.conquer.bulgaria.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("sitesPostgres")
public class SitesRepository implements SitesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SitesRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSite(UUID uuid, Site site) {
        String sql = "" +
                "INSERT INTO sites (" +
                " uuid, " +
                " number, " +
                " lat, " +
                " lng, " +
                " description, " +
                " name, " +
                " town, " +
                " ratingCount, " +
                " ratingTotal)" +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(
                sql,
                uuid,
                site.siteNumber(),
                site.coordinates().lat(),
                site.coordinates().lng(),
                site.information().description(),
                site.information().name(),
                site.information().town(),
                site.rating().count(),
                site.rating().total()
        );
    }

    @Override
    public List<Site> getSites() {
        final String sql = "Select uuid, number, lat, lng, description, name, town, ratingCount, ratingTotal FROM sites";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return siteMapper(resultSet);
        });
    }

    @Override
    public int deleteSiteById(UUID uuid) {
        String sql = "" +
                "DELETE FROM sites " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, uuid);
    }

    //todo: update other properties as well
    @Override
    public int updateSiteById(UUID uuid, Site site) {
        String sql = "" +
                "UPDATE sites " +
                "SET name = ? " +
                "WHERE id = ?";

        return jdbcTemplate.update(sql, site.information().name(), uuid);
    }

    @Override
    public Optional<Site> getSiteById(UUID uuid) {
        final String sql = "Select id, name FROM person WHERE id = ?";
        return Optional.ofNullable((Site) jdbcTemplate.queryForObject(
                sql,
                new Object[]{uuid},
                (resultSet, i) -> {
                    return siteMapper(resultSet);
                }));
    }

    private Site siteMapper(ResultSet resultSet) throws SQLException {
        return new Site(
                UUID.fromString(resultSet.getString("uuid")),
                resultSet.getString("number"),
                new SiteCoordinates(Double.parseDouble(resultSet.getString("lat")),
                        Double.parseDouble(resultSet.getString("lng"))),
                new SiteInformation(resultSet.getString("description"),
                        "някакуж ра",
                        resultSet.getString("town")),
                new SiteRating(Integer.parseInt(resultSet.getString("ratingCount")),
                        Integer.parseInt(resultSet.getString("ratingTotal")))
        );
    }
}
