package com.berroteran.bmo.akademia.view.utils;

import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

@Service
public class JasperUtil {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ResourceLoader resourceLoader;

    public JasperPrint exportReport(String rptName, Map<String, Object> params) throws SQLException, JRException, IOException {

        if (rptName == null) return null;

        Connection conn = dataSource.getConnection();
        String path = resourceLoader.getResource("/reports/" + rptName).getURI().getPath();
        JasperReport jasperReport = JasperCompileManager.compileReport(path);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, params, conn);
        return print;
    }

}
