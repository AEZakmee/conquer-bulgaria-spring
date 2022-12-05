package com.conquer.bulgaria.dao.sites;

import com.conquer.bulgaria.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("sitesPostgres")
public class SitesDataAccessService implements SitesDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SitesDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSite(UUID uuid, Site site) {
        String sql = "" +
                "INSERT INTO sites (" +
                " id, " +
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
                site.getSiteNumber(),
                site.getCoordinates().getLat(),
                site.getCoordinates().getLng(),
                site.getInformation().getDescription(),
                site.getInformation().getName(),
                site.getInformation().getTown(),
                site.getRating().getCount(),
                site.getRating().getTotal()
        );
    }

    @Override
    public List<Site> getSites() {
        final String sql = "Select id, number, lat, lng, description, name, town, ratingCount, ratingTotal FROM sites";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Site(
                    UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("number"),
                    new SiteCoordinates(Double.parseDouble(resultSet.getString("lat")),
                                        Double.parseDouble(resultSet.getString("lng"))),
                    new SiteInformation(resultSet.getString("description"),
                                        resultSet.getString("name"),
                                        resultSet.getString("town")),
                    new SiteRating(Integer.parseInt(resultSet.getString("ratingCount")),
                                   Integer.parseInt(resultSet.getString("ratingTotal")))
            );
        });
    }

    @Override
    public int deleteSiteById(UUID uuid) {
        return 0;
    }

    @Override
    public int updateSiteById(UUID uuid, Site site) {
        return 0;
    }

    @Override
    public Optional<Site> getSiteById(UUID uuid) {
        return Optional.empty();
    }
}
